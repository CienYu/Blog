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
@TableName("t_comment")
public class TComment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer commentId;

    private String commentContent;

    private Integer blogId;

    private LocalDateTime createTime;

    private Integer userid;

    /**
     * 回复人id
     */
    private Integer replyid;


}
