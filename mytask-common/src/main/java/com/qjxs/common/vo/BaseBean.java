package com.qjxs.common.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class BaseBean implements Serializable {


	@Version
	private Integer version;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createTime;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date updateTime;

	private Long creatorId;

	private Long editorId;

	@Deprecated
	private String creatorName;// 用于排序

	@Deprecated
	private String editorName;

	
	

}
