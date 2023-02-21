package com.longbai.feign;


import com.longbai.entity.TUser;
import com.longbai.pojo.vo.ResultMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import java.util.List;


@FeignClient(name="longbai")
@RequestMapping("/tUser")
public interface TUserFeign {

    /***
     * 分页+条件搜索TUser表数据
     * @param tUser
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    ResultMessage<PageInfo> findPage(@RequestBody(required = false) TUser tUser, @PathVariable int page, @PathVariable  int size);

    /***
     * 分页搜索TUser表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    ResultMessage<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索TUser表数据
     * @param tUser
     * @return
     */
    @PostMapping(value = "/search" )
    ResultMessage<List<TUser>> findList(@RequestBody(required = false) TUser tUser);

    /***
     * 根据ID删除TUser表数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    ResultMessage delete(@PathVariable Integer id);

    /***
     * 修改TUser表数据
     * @param tUser
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    ResultMessage update(@RequestBody TUser tUser,@PathVariable Integer id);

    /***
     * 新增TUser表数据
     * @param tUser
     * @return
     */
    @PostMapping
    ResultMessage add(@RequestBody TUser tUser);

    /***
     * 根据ID查询TUser表数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    ResultMessage<TUser> findById(@PathVariable Integer id);

    /***
     * 查询TUser表全部数据
     * @return
     */
    @GetMapping
    ResultMessage<List<TUser>> findAll();
}