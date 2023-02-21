package com.longbai.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.longbai.entity.TBlog;
import com.longbai.entity.TUser;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface TUserService extends IService<TUser> {

    /***
     * 多条件分页查询TUser表数据
     * @param tUser
     * @param page
     * @param size
     * @return
     */
    PageInfo<TUser> findPage(TUser tUser, int page, int size);

    /***
     * 分页查询TUser表数据
     * @param page
     * @param size
     * @return
     */
    PageInfo<TUser> findPage(int page, int size);

    /***
     * 多条件搜索TUser表数据
     * @param tUser
     * @return
     */
    List<TUser> findList(TUser tUser);

    /***
     * 根据id删除TUser表数据
     * @param id
     */
    void delete(Integer id);

    /***
     * 根据条件修改TUser表数据
     * @param tUser
     */
    void update(TUser tUser);

    /***
     * 新增TUser表数据
     * @param tUser
     */
    void add(TUser tUser);

    /**
     * 根据ID查询TUser表数据
     * @param id
     * @return
     */
     TUser findById(Integer id);

    /***
     * 查询所有TUser表数据
     * @return
     */
    List<TUser> findAll();
}
