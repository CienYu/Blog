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
import java.util.Date;
import java.lang.String;
import java.lang.Integer;


@ApiModel(description = "TBlog",value = "TBlog")
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_blog")
public class TBlog implements Serializable{

	@ApiModelProperty(value = "博文id",required = false)
	@TableId(value = "blog_id", type = IdType.AUTO)
	private Integer blogId;

	@ApiModelProperty(value = "博客标题",required = false)
	@TableField("blog_title")
	private String blogTitle;

	@ApiModelProperty(value = "博客内容",required = false)
    @TableField("blog_content")
	private String blogContent;

	@ApiModelProperty(value = "用户id",required = false)
    @TableField("user_id")
	private Integer userId;

	@ApiModelProperty(value = "类型id",required = false)
    @TableField("type_id")
	private Integer typeId;

	@ApiModelProperty(value = "博文状态0为草稿1为发布",required = false)
    @TableField("blog_status")
	private Integer blogStatus;

	@ApiModelProperty(value = "文章中包含的图片url",required = false)
    @TableField("include_image")
	private String includeImage;

	@ApiModelProperty(value = "封面图片url",required = false)
    @TableField("cover_image")
	private String coverImage;

	@ApiModelProperty(value = "创建时间",required = false)
    @TableField("create_time")
	private Date createTime;

	@ApiModelProperty(value = "更新时间",required = false)
    @TableField("update_time")
	private Date updateTime;

}
