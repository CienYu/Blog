package com.longbai.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.longbai.entity.TBlog;
import com.longbai.entity.TImg;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface TImgService extends IService<TImg> {

    /***
     * 多条件分页查询TImg表数据
     * @param tImg
     * @param page
     * @param size
     * @return
     */
    PageInfo<TImg> findPage(TImg tImg, int page, int size);

    /***
     * 分页查询TImg表数据
     * @param page
     * @param size
     * @return
     */
    PageInfo<TImg> findPage(int page, int size);

    /***
     * 多条件搜索TImg表数据
     * @param tImg
     * @return
     */
    List<TImg> findList(TImg tImg);

    /***
     * 根据id删除TImg表数据
     * @param id
     */
    void delete(Integer id);

    /***
     * 根据条件修改TImg表数据
     * @param tImg
     */
    void update(TImg tImg);

    /***
     * 新增TImg表数据
     * @param tImg
     */
    void add(TImg tImg);

    /**
     * 根据ID查询TImg表数据
     * @param id
     * @return
     */
     TImg findById(Integer id);

    /***
     * 查询所有TImg表数据
     * @return
     */
    List<TImg> findAll();
}
