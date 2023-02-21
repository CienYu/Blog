package com.longbai.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.longbai.entity.TBlog;
import com.longbai.entity.TTag;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface TTagService extends IService<TTag> {

    /***
     * 多条件分页查询TTag表数据
     * @param tTag
     * @param page
     * @param size
     * @return
     */
    PageInfo<TTag> findPage(TTag tTag, int page, int size);

    /***
     * 分页查询TTag表数据
     * @param page
     * @param size
     * @return
     */
    PageInfo<TTag> findPage(int page, int size);

    /***
     * 多条件搜索TTag表数据
     * @param tTag
     * @return
     */
    List<TTag> findList(TTag tTag);

    /***
     * 根据id删除TTag表数据
     * @param id
     */
    void delete(Integer id);

    /***
     * 根据条件修改TTag表数据
     * @param tTag
     */
    void update(TTag tTag);

    /***
     * 新增TTag表数据
     * @param tTag
     */
    void add(TTag tTag);

    /**
     * 根据ID查询TTag表数据
     * @param id
     * @return
     */
     TTag findById(Integer id);

    /***
     * 查询所有TTag表数据
     * @return
     */
    List<TTag> findAll();
}
