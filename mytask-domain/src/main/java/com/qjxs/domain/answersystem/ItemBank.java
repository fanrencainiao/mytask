package com.qjxs.domain.answersystem;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.qjxs.common.vo.BaseBean;

import lombok.Data;
/**
 * 题库
 * @author cf
 *
 */
@Data
@Entity
@Table(name="t_itemBank")
public class ItemBank implements Serializable{

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
	private Integer customs;
	/**
	 * 序号
	 */
	private Long gridSort;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String context;
	/**
	 * 图片
	 */
	private String srcImg;
	/**
	 * 答案
	 */
	private String answer;
	/**
	 * 难度(等于分数)
	 */
	private Integer degree;
	/**
	 * 类型
	 */
	private Integer style;
	/**
	 * 状态
	 */
	private Integer state;
	

}
