package com.longbai.feign;


import com.longbai.entity.TTag;
import com.longbai.pojo.vo.ResultMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import java.util.List;


@FeignClient(name="longbai")
@RequestMapping("/tTag")
public interface TTagFeign {

    /***
     * 分页+条件搜索TTag表数据
     * @param tTag
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    ResultMessage<PageInfo> findPage(@RequestBody(required = false) TTag tTag, @PathVariable int page, @PathVariable  int size);

    /***
     * 分页搜索TTag表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    ResultMessage<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索TTag表数据
     * @param tTag
     * @return
     */
    @PostMapping(value = "/search" )
    ResultMessage<List<TTag>> findList(@RequestBody(required = false) TTag tTag);

    /***
     * 根据ID删除TTag表数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    ResultMessage delete(@PathVariable Integer id);

    /***
     * 修改TTag表数据
     * @param tTag
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    ResultMessage update(@RequestBody TTag tTag,@PathVariable Integer id);

    /***
     * 新增TTag表数据
     * @param tTag
     * @return
     */
    @PostMapping
    ResultMessage add(@RequestBody TTag tTag);

    /***
     * 根据ID查询TTag表数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    ResultMessage<TTag> findById(@PathVariable Integer id);

    /***
     * 查询TTag表全部数据
     * @return
     */
    @GetMapping
    ResultMessage<List<TTag>> findAll();
}