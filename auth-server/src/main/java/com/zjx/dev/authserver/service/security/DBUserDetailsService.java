package com.zjx.dev.authserver.service.security;


import com.zjx.dev.authserver.domain.SysMenuEntity;
import com.zjx.dev.authserver.domain.SysRoleEntity;
import com.zjx.dev.authserver.domain.SysUserEntity;
import com.zjx.dev.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUserEntity user = repository.findUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		List<SysRoleEntity> roleLists = user.getRoleLists();
		for (SysRoleEntity role:roleLists) {
			List<SysMenuEntity> menuLists = role.getMenuLists();
			for(SysMenuEntity menu:menuLists){
				GrantedAuthority authority = new SimpleGrantedAuthority(menu.getPermission());
				grantedAuthorities.add(authority);
			}
		}
		return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
}
