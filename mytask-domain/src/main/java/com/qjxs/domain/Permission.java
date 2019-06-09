package com.qjxs.domain;

import org.hibernate.annotations.GenericGenerator;

import com.qjxs.common.vo.BaseBean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "t_permission")
@Data
public class Permission extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	private String perName;
	private String perUrl;
	private String parentId;
	private String icon;
	private Integer lev;
	private Integer state;
	/**
	 * 类型   0：目录   1：菜单   2：按钮
	 */
	private Integer type;
	@Transient
	private List<Permission> pers;
	
	@ManyToMany(mappedBy="permissions")
	private List<Role> roles;

}
