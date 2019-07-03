package com.qjxs.domain.answersystem;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

/**
 * 考生答题
 * @author cf
 *
 */
@Getter
@Setter
@Entity
@Table(name="t_students_answer")
public class SdudentAnswer implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	/**
	 * 考生id
	 */
	private String sid;
	/**
	 * 坐标（答题序号）
	 */
	private Long gridSort;
	/**
	 * 题库id
	 */
	private String itemId;
	
	/**
	 * 考生答案
	 */
	private String sanswer;
	
	/**
	 * 是否正确(0错1对)
	 */
	private Integer answerFlag;
	
	/**
	 * 答题时间
	 */
	private Long answerTime;
	
	

}
