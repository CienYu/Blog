package com.longbai.feign;


import com.longbai.entity.TBlog;
import com.longbai.pojo.vo.ResultMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import java.util.List;


@FeignClient(name="longbai")
@RequestMapping("/tBlog")
public interface TBlogFeign {

    /***
     * 分页+条件搜索TBlog表数据
     * @param tBlog
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    ResultMessage<PageInfo> findPage(@RequestBody(required = false) TBlog tBlog, @PathVariable int page, @PathVariable  int size);

    /***
     * 分页搜索TBlog表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    ResultMessage<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索TBlog表数据
     * @param tBlog
     * @return
     */
    @PostMapping(value = "/search" )
    ResultMessage<List<TBlog>> findList(@RequestBody(required = false) TBlog tBlog);

    /***
     * 根据ID删除TBlog表数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    ResultMessage delete(@PathVariable Integer id);

    /***
     * 修改TBlog表数据
     * @param tBlog
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    ResultMessage update(@RequestBody TBlog tBlog,@PathVariable Integer id);

    /***
     * 新增TBlog表数据
     * @param tBlog
     * @return
     */
    @PostMapping
    ResultMessage add(@RequestBody TBlog tBlog);

    /***
     * 根据ID查询TBlog表数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    ResultMessage<TBlog> findById(@PathVariable Integer id);

    /***
     * 查询TBlog表全部数据
     * @return
     */
    @GetMapping
    ResultMessage<List<TBlog>> findAll();
}