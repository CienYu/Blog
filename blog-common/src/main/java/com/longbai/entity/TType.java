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

/**
 * @Author Cien
 * @Date 2023/2/22 14:52
 * @Version 1.0
 * @Note type实体类
 */

@Data
@ApiModel(description = "博文类型",value = "TType")
@TableName("t_type")
@EqualsAndHashCode(callSuper = false)
public class TType implements Serializable {

    @ApiModelProperty(value = "typeId",required = false)
    @TableId(value = "type_id" ,type = IdType.AUTO)
    private Integer typeId;

    @ApiModelProperty(value = "type名字",required = false)
    @TableField("tag_name")
    private String typeName;

}
