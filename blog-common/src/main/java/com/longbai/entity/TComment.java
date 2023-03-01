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

@Data
@ApiModel(description = "TComment",value = "TComment")
@TableName("t_comment")
@EqualsAndHashCode(callSuper = false)
public class TComment implements Serializable{

	@ApiModelProperty(value = "评论id",required = false)
	@TableId(value = "comment_id", type = IdType.AUTO)
	private Integer commentId;

	@ApiModelProperty(value = "评论内容",required = false)
    @TableField("comment_content")
	private String commentContent;

	@ApiModelProperty(value = "博文id",required = false)
    @TableField("blog_id")
	private Integer blogId;

	@ApiModelProperty(value = "创建时间",required = false)
    @TableField("create_time")
	private Date createTime;

	@ApiModelProperty(value = "用户id",required = false)
    @TableField("user_id")
	private Integer userId;

	@ApiModelProperty(value = "回复人id",required = false)
    @TableField("reply_id")
	private Integer replyId;

}
