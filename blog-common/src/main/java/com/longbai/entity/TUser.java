package com.longbai.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;



@Data
@ApiModel(description = "TUser",value = "TUser")
@TableName("t_user")
@EqualsAndHashCode(callSuper = false)
public class TUser implements Serializable{

	@ApiModelProperty(value = "用户id",required = false)
    @TableId("user_id")
	private Integer userId;

	@ApiModelProperty(value = "用户名",required = false)
    @TableField("username")
	private String username;

	@ApiModelProperty(value = "密码",required = false)
    @TableField("password")
	private String password;

	@ApiModelProperty(value = "性别",required = false)
    @TableField("gender")
	private String gender;

	@ApiModelProperty(value = "邮箱",required = false)
    @TableField("email")
	private String email;

	@ApiModelProperty(value = "手机号",required = false)
    @TableField("phone")
	private String phone;

	@ApiModelProperty(value = "头像id",required = false)
    @TableField("avatar")
	private String avatar;

	@ApiModelProperty(value = "用户权限",required = false)
    @TableField("role")
	private String role;

	@ApiModelProperty(value = "最后登录时间",required = false)
    @TableField("last_login_time")
	private Date lastLoginTime;

	@ApiModelProperty(value = "用户注册时间",required = false)
    @TableField("user_register_time")
	private Date userRegisterTime;

	@ApiModelProperty(value = "上次登录ip",required = false)
	@TableField("last_ip")
	private String lastIp;



}
