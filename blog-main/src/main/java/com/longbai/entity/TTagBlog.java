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
import java.lang.Integer;

@Data
@ApiModel(description = "TTagBlog",value = "TTagBlog")
@TableName("t_tag_blog")
@EqualsAndHashCode(callSuper = false)
public class TTagBlog implements Serializable{

	@ApiModelProperty(value = "tagid",required = false)
    @TableId(value = "tag_id", type = IdType.AUTO)
	private Integer tagId;

	@ApiModelProperty(value = "博客id",required = false)
    @TableField("blog_id")
	private Integer blogId;



}
