package com.longbai.feign;


import com.github.pagehelper.PageInfo;
import com.longbai.entity.TType;
import com.longbai.pojo.vo.ResultMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name="longbai")
@RequestMapping("/tType")
public interface TTypeFeign {

    /***
     * 分页+条件搜索TType表数据
     * @param tType
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    ResultMessage<PageInfo> findPage(@RequestBody(required = false) TType tType, @PathVariable int page, @PathVariable  int size);

    /***
     * 分页搜索TType表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    ResultMessage<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索TType表数据
     * @param tType
     * @return
     */
    @PostMapping(value = "/search" )
    ResultMessage<List<TType>> findList(@RequestBody(required = false) TType tType);

    /***
     * 根据ID删除TType表数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    ResultMessage delete(@PathVariable Integer id);

    /***
     * 修改TType表数据
     * @param tType
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    ResultMessage update(@RequestBody TType tType,@PathVariable Integer id);

    /***
     * 新增TType表数据
     * @param tType
     * @return
     */
    @PostMapping
    ResultMessage add(@RequestBody TType tType);

    /***
     * 根据ID查询TType表数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    ResultMessage<TType> findById(@PathVariable Integer id);

    /***
     * 查询TType表全部数据
     * @return
     */
    @GetMapping
    ResultMessage<List<TType>> findAll();
}