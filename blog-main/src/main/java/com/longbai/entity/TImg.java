package com.longbai.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;

@Data
@ApiModel(description = "TImg",value = "TImg")
@TableName("t_img")
@EqualsAndHashCode(callSuper = false)
public class TImg implements Serializable{

	@ApiModelProperty(value = "图片id",required = false)
	@TableId(value = "img_id", type = IdType.AUTO)
	private Integer imgId;//图片id

	@ApiModelProperty(value = "图片url",required = false)
    @TableField("img_url")
	private String imgUrl;//图片url

	@ApiModelProperty(value = "图片上传者",required = false)
    @TableField("img_user")
	private String imgUser;//图片上传者



}
