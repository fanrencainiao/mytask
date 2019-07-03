package com.qjxs.domain.answersystem;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.mongodb.morphia.annotations.Indexed;

import lombok.Data;
/**
 * 关卡
 * @author 
 *
 */
@Data
@Entity
@Table(name="t_customs")
public class Customs implements Serializable{

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
	@Indexed(unique = true)
	private Integer customs;
	/**
	 * 礼物id
	 */
	private String giftId;

}
