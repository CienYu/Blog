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
@ApiModel(description = "TTag",value = "TTag")
@TableName("t_tag")
@EqualsAndHashCode(callSuper = false)
public class TTag implements Serializable{

	@ApiModelProperty(value = "tagid",required = false)
    @TableId(value = "tag_id" ,type = IdType.AUTO)
	private Integer tagId;//tagid

	@ApiModelProperty(value = "tag名字",required = false)
    @TableField("tag_name")
	private String tagName;//tag名字

}
