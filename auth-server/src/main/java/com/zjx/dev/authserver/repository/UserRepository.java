package com.zjx.dev.authserver.repository;


import com.zjx.dev.authserver.domain.SysUserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<SysUserEntity, Integer> {

    SysUserEntity findUserByUsername(String username);

}
