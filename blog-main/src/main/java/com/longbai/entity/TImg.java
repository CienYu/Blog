package com.longbai.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_img")
public class TImg implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer imgId;

    private String imgUrl;

    private String imgUser;


}
