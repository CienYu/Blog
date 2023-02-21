package com.longbai.feign;

import com.longbai.entity.TTagBlog;
import com.longbai.pojo.vo.ResultMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import java.util.List;


@FeignClient(name="longbai")
@RequestMapping("/tTagBlog")
public interface TTagBlogFeign {

    /***
     * 分页+条件搜索TTagBlog表数据
     * @param tTagBlog
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    ResultMessage<PageInfo> findPage(@RequestBody(required = false) TTagBlog tTagBlog, @PathVariable int page, @PathVariable  int size);

    /***
     * 分页搜索TTagBlog表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    ResultMessage<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索TTagBlog表数据
     * @param tTagBlog
     * @return
     */
    @PostMapping(value = "/search" )
    ResultMessage<List<TTagBlog>> findList(@RequestBody(required = false) TTagBlog tTagBlog);

    /***
     * 根据ID删除TTagBlog表数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    ResultMessage delete(@PathVariable Integer id);

    /***
     * 修改TTagBlog表数据
     * @param tTagBlog
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    ResultMessage update(@RequestBody TTagBlog tTagBlog,@PathVariable Integer id);

    /***
     * 新增TTagBlog表数据
     * @param tTagBlog
     * @return
     */
    @PostMapping
    ResultMessage add(@RequestBody TTagBlog tTagBlog);

    /***
     * 根据ID查询TTagBlog表数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    ResultMessage<TTagBlog> findById(@PathVariable Integer id);

    /***
     * 查询TTagBlog表全部数据
     * @return
     */
    @GetMapping
    ResultMessage<List<TTagBlog>> findAll();
}