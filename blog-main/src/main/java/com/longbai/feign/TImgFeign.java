package com.longbai.feign;


import com.longbai.entity.TImg;
import com.longbai.pojo.vo.ResultMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import java.util.List;

/****
 * @Author: https://blog.csdn.net/pkxwyf
 *****/
@FeignClient(name="longbai")
@RequestMapping("/tImg")
public interface TImgFeign {

    /***
     * 分页+条件搜索TImg表数据
     * @param tImg
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    ResultMessage<PageInfo> findPage(@RequestBody(required = false) TImg tImg, @PathVariable int page, @PathVariable  int size);

    /***
     * 分页搜索TImg表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    ResultMessage<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索TImg表数据
     * @param tImg
     * @return
     */
    @PostMapping(value = "/search" )
    ResultMessage<List<TImg>> findList(@RequestBody(required = false) TImg tImg);

    /***
     * 根据ID删除TImg表数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    ResultMessage delete(@PathVariable Integer id);

    /***
     * 修改TImg表数据
     * @param tImg
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    ResultMessage update(@RequestBody TImg tImg,@PathVariable Integer id);

    /***
     * 新增TImg表数据
     * @param tImg
     * @return
     */
    @PostMapping
    ResultMessage add(@RequestBody TImg tImg);

    /***
     * 根据ID查询TImg表数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    ResultMessage<TImg> findById(@PathVariable Integer id);

    /***
     * 查询TImg表全部数据
     * @return
     */
    @GetMapping
    ResultMessage<List<TImg>> findAll();
}