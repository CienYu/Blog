package com.longbai.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.longbai.entity.TBlog;
import com.longbai.entity.TComment;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface TCommentService extends IService<TComment> {

    /***
     * 多条件分页查询TComment表数据
     * @param tComment
     * @param page
     * @param size
     * @return
     */
    PageInfo<TComment> findPage(TComment tComment, int page, int size);

    /***
     * 分页查询TComment表数据
     * @param page
     * @param size
     * @return
     */
    PageInfo<TComment> findPage(int page, int size);

    /***
     * 多条件搜索TComment表数据
     * @param tComment
     * @return
     */
    List<TComment> findList(TComment tComment);

    /***
     * 根据id删除TComment表数据
     * @param id
     */
    void delete(Integer id);

    /***
     * 根据条件修改TComment表数据
     * @param tComment
     */
    void update(TComment tComment);

    /***
     * 新增TComment表数据
     * @param tComment
     */
    void add(TComment tComment);

    /**
     * 根据ID查询TComment表数据
     * @param id
     * @return
     */
     TComment findById(Integer id);

    /***
     * 查询所有TComment表数据
     * @return
     */
    List<TComment> findAll();
}
