package com.qjxs.domain.answersystem;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.mongodb.morphia.annotations.Indexed;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *  考生
 * @author cf
 *
 */
@Getter
@Setter
@Entity
@Table(name="t_students")
public class Students implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	/**
	 * 	微信openid
	 */
	private String openid;
	
	/**
	 * 	微信unionid
	 */
	@Indexed(unique = true)
	private String unionid;
	/**
	 * 礼物
	 */
	private String giftId;
	/**
	 * 积分
	 */
	private Long integral;

	/**
	 * 等级
	 */
	private Integer grade;
	
	/**
	 * 加入时间
	 */
	private Long joinDate;
	
	
	

}
