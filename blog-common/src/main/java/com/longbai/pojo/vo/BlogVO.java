package com.longbai.pojo.vo;

import com.longbai.entity.TBlog;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Cien
 * @Date 2023/3/1 21:21
 * @Version 1.0
 * @Note
 */
@Data
public class BlogVO extends TBlog implements Serializable {
    //分类名
    private String typeName;
    //用户名
    private String username;
    //用户头像
    private String avatar;
    //标签集合
    private List<String> tagNameList;

}
