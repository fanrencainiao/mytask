package com.qjxs.domain;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
@Data
public class User {

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	private String userName;
	private String passWorld;
	private String email;
	private String phone;
	private String headImg;
	private String wxImg;
	private String openid;
	private String accessToken;
	private Integer sex;
	private Integer userType;
	private Integer state;
	@ManyToMany(targetEntity = Role.class, fetch = FetchType.LAZY)    
	@JoinTable(name = "T_USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))   
	private List<Role> roles;

}
