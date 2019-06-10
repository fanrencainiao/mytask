package com.qjxs.domain.answersystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.qjxs.common.vo.BaseBean;

import lombok.Data;

@Data
@Entity
@Table(name="t_checkpoint")
public class Checkpoint extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	/**
	 * 关卡
	 */
	private Integer passNum;
	private Integer itemId;
	private Integer gistId;

}
