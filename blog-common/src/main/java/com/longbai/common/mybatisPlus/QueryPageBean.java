package com.longbai.common.mybatisPlus;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Cien
 * @Date 2023/3/1 15:08
 * @Version 1.0
 * @Note 封装查询条件
 */
@Data
public class QueryPageBean implements Serializable {
    //页码
    private Integer currentPage;
    //每页记录数
    private Integer pageSize;
    //查询条件
    private String queryString;
    //分类id
    private Integer typeId;
    //标签id
    private Integer tagId;
    /**
     * 版权状态
     */
    private Integer copyright;
}