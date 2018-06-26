package com.zjx.dev.authserver.domain;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sys_user", schema = "microservice")
public class SysUserEntity{
	private int id;
	private String avatar;
	private String username;
	private String password;
	private String salt;
	private String name;
	private Timestamp birthday;
	private Integer sex;
	private String email;
	private String phone;
	private Integer status;
	private Timestamp createTime;
	private Timestamp updateTime;
	private List<SysRoleEntity> roleLists = new ArrayList<>();

	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "avatar")
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Basic
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Basic
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Basic
	@Column(name = "salt")
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Basic
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "birthday")
	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	@Basic
	@Column(name = "sex")
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Basic
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Basic
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Basic
	@Column(name = "create_time")
	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Basic
	@Column(name = "update_time")
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

    @ManyToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinTable(name = "sys_user_role",joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    public List<SysRoleEntity> getRoleLists() {
        return roleLists;
    }

    public void setRoleLists(List<SysRoleEntity> roleLists) {
        this.roleLists = roleLists;
    }

    @Override
	public boolean equals(Object o) {
		if(this == o) { return true; }
		if(o == null || getClass() != o.getClass()) {return false;}
		SysUserEntity that = (SysUserEntity) o;
		return id == that.id &&
				Objects.equals(avatar, that.avatar) &&
				Objects.equals(username, that.username) &&
				Objects.equals(password, that.password) &&
				Objects.equals(salt, that.salt) &&
				Objects.equals(name, that.name) &&
				Objects.equals(birthday, that.birthday) &&
				Objects.equals(sex, that.sex) &&
				Objects.equals(email, that.email) &&
				Objects.equals(phone, that.phone) &&
				Objects.equals(status, that.status) &&
				Objects.equals(createTime, that.createTime) &&
				Objects.equals(updateTime, that.updateTime);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, avatar, username, password, salt, name, birthday, sex, email, phone, status, createTime, updateTime);
	}
}
