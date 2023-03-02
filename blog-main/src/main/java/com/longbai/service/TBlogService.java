package com.longbai.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.longbai.common.mybatisPlus.QueryPageBean;
import com.longbai.entity.TBlog;
import com.github.pagehelper.PageInfo;
import com.longbai.pojo.vo.BlogVO;

import java.util.List;

public interface TBlogService extends IService<TBlog> {

    /***
     * 多条件分页查询TBlog表数据
     * @param tBlog
     * @param page
     * @param size
     * @return
     */
    PageInfo<TBlog> findPage(TBlog tBlog, int page, int size);

    /***
     * 分页查询TBlog表数据
     * @param queryPageBean
     * @param userId
     * @return
     */
    PageInfo<BlogVO> findPage(QueryPageBean queryPageBean, int userId);

    /***
     * 多条件搜索TBlog表数据
     * @param tBlog
     * @return
     */
    List<TBlog> findList(TBlog tBlog);

    /***
     * 根据id删除TBlog表数据
     * @param id
     */
    void delete(Integer id);

    /***
     * 根据条件修改TBlog表数据
     * @param tBlog
     */
    void update(TBlog tBlog);

    /***
     * 新增TBlog表数据
     * @param tBlog
     */
    void add(TBlog tBlog);

    /**
     * 根据ID查询TBlog表数据
     * @param id
     * @return
     */
     TBlog findById(Integer id);

    /***
     * 查询所有TBlog表数据
     * @return
     */
    List<TBlog> findAll();
}
