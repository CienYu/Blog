package com.longbai.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Cien
 * @since 2023-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_blog")
public class TBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer blogId;

    private String blogTitle;

    private String blogContent;

    private Integer userId;

    private Integer typeId;

    private String blogStatus;

    private String includeImage;

    private String coverImage;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
