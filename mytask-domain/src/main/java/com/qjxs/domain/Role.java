package com.qjxs.domain;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "t_role")
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler","users"})
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class)
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	private String roleName;
	private Integer state;
	private String parentId;
	private String des;
	
	@ManyToMany(mappedBy="roles")
	@JsonIgnore
	private List<User> users;
	
	@ManyToMany(targetEntity = Permission.class, fetch = FetchType.LAZY)    
	@JoinTable(name = "T_ROLE_PERMISSION", joinColumns = @JoinColumn(name = "ROLE_ID"), inverseJoinColumns = @JoinColumn(name = "PER_ID"))   
	private List<Permission> permissions;
	

}
