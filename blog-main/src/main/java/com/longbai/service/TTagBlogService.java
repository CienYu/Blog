package com.longbai.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.longbai.entity.TBlog;
import com.longbai.entity.TTagBlog;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface TTagBlogService extends IService<TTagBlog> {

    /***
     * 多条件分页查询TTagBlog表数据
     * @param tTagBlog
     * @param page
     * @param size
     * @return
     */
    PageInfo<TTagBlog> findPage(TTagBlog tTagBlog, int page, int size);

    /***
     * 分页查询TTagBlog表数据
     * @param page
     * @param size
     * @return
     */
    PageInfo<TTagBlog> findPage(int page, int size);

    /***
     * 多条件搜索TTagBlog表数据
     * @param tTagBlog
     * @return
     */
    List<TTagBlog> findList(TTagBlog tTagBlog);

    /***
     * 根据id删除TTagBlog表数据
     * @param id
     */
    void delete(Integer id);

    /***
     * 根据条件修改TTagBlog表数据
     * @param tTagBlog
     */
    void update(TTagBlog tTagBlog);

    /***
     * 新增TTagBlog表数据
     * @param tTagBlog
     */
    void add(TTagBlog tTagBlog);

    /**
     * 根据ID查询TTagBlog表数据
     * @param id
     * @return
     */
     TTagBlog findById(Integer id);

    /***
     * 查询所有TTagBlog表数据
     * @return
     */
    List<TTagBlog> findAll();
}
