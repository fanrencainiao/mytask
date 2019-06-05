package com.qjxs.domain;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

import java.security.Permissions;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "t_role")
@Data
public class Role {

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	private String roleName;
	private Integer state;
	private String parentId;
	private String describe;
	
	@ManyToMany(mappedBy="roles")
	private List<User> users;
	
	@ManyToMany(targetEntity = Permissions.class, fetch = FetchType.LAZY)    
	@JoinTable(name = "T_ROLE_PERMISSION", joinColumns = @JoinColumn(name = "ROLE_ID"), inverseJoinColumns = @JoinColumn(name = "PER_ID"))   
	private List<Permission> permissions;
	

}
