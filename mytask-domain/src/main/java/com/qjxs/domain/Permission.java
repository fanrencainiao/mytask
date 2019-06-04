package com.qjxs.domain;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "t_permission")
@Data
public class Permission {

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
	@Transient
	private List<Permission> pers;

}
