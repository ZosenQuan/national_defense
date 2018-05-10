package com.zosen.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "tb_moment")
@Data
public class Moment implements Serializable {

	private static final long serialVersionUID = 1743464446944566647L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty("记录id")
	private Integer id;

	@ApiModelProperty("用户id")
	private Integer userId;

	@ApiModelProperty("图片")
	private String image;

	@ApiModelProperty("内容")
	private String content;

}
