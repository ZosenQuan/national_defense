package com.zosen.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "tb_user")
@Data
public class User implements Serializable {

	private static final long serialVersionUID = -7108462934267007046L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty("用户id")
	private Integer id;

	@ApiModelProperty("用户名")
	private String userName;

	@JsonIgnore
	@ApiModelProperty("用户密码")
	private String password;

	@ApiModelProperty("手机号")
	private String phoneNumber;

	@ApiModelProperty("年龄")
	private Integer age;

	@ApiModelProperty("喜好")
	private String hobby;

}
