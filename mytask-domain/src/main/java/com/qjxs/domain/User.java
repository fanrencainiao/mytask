package com.qjxs.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.qjxs.common.vo.BaseBean;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler","roles"})
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class)
public class User extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)    
	@JoinTable(name = "T_USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))   
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private List<Role> roles;
	


}
