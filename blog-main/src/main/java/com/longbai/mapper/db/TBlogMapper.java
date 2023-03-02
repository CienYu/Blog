package com.longbai.mapper.db;

import com.longbai.entity.TBlog;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.longbai.pojo.vo.BlogVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Cien
 * @since 2023-02-20
 */
public interface TBlogMapper extends BaseMapper<TBlog> {

    /**
     * 获取对应用户的博客列表(多表查询)
     *
     * @param
     * @return List
     */
    //todo 修改sql语句
    @Select("SELECT b.blog_id, b.blog_title, b.blog_status, b.cover_image, t.type_name, b.update_time " +
            "FROM t_blog b, t_type t " +
            "WHERE b.type_id = t.type_id AND b.user_id = #{userId} LIMIT #{start},#{pageSize} ")
    List<BlogVO> getAllBlogs(int userId, Integer start, Integer pageSize);

}
