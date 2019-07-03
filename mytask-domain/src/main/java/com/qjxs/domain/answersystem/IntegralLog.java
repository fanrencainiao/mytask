package com.qjxs.domain.answersystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

/**
 * 积分记录
 * @author cf
 *
 */

@Getter
@Setter
@Entity
@Table(name="t_integralLog")
public class IntegralLog {
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	/**
	 *  考生id
	 */
	private String studentId;
	/**
	 *   增加积分数
	 */
	private Integer addNum;
	/**
	 *   扣除积分数
	 */
	private Integer reduceNum;
	/**
	 * 总计分数
	 */
	private Long totalNum;
	/**
	 * 说明
	 */
	private String des;
	/**
	 *    操作时间
	 */
	private Long updateTime;
		
	
	

}
