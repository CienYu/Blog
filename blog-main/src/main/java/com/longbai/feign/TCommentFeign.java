package com.longbai.feign;

import com.longbai.entity.TComment;
import com.longbai.pojo.vo.ResultMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import java.util.List;


@FeignClient(name="longbai")
@RequestMapping("/tComment")
public interface TCommentFeign {

    /***
     * 分页+条件搜索TComment表数据
     * @param tComment
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    ResultMessage<PageInfo> findPage(@RequestBody(required = false) TComment tComment, @PathVariable int page, @PathVariable  int size);

    /***
     * 分页搜索TComment表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    ResultMessage<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索TComment表数据
     * @param tComment
     * @return
     */
    @PostMapping(value = "/search" )
    ResultMessage<List<TComment>> findList(@RequestBody(required = false) TComment tComment);

    /***
     * 根据ID删除TComment表数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    ResultMessage delete(@PathVariable Integer id);

    /***
     * 修改TComment表数据
     * @param tComment
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    ResultMessage update(@RequestBody TComment tComment,@PathVariable Integer id);

    /***
     * 新增TComment表数据
     * @param tComment
     * @return
     */
    @PostMapping
    ResultMessage add(@RequestBody TComment tComment);

    /***
     * 根据ID查询TComment表数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    ResultMessage<TComment> findById(@PathVariable Integer id);

    /***
     * 查询TComment表全部数据
     * @return
     */
    @GetMapping
    ResultMessage<List<TComment>> findAll();
}