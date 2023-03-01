package com.longbai.discard;

import com.longbai.common.security.enums.ResultCode;
import com.longbai.common.utils.ResultUtil;
import com.longbai.entity.TBlog;
import com.longbai.pojo.vo.ResultMessage;
import com.longbai.service.TBlogService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Api(value = "TBlogController")
@RestController
@RequestMapping("/tBlog")
public class TBlogController {

    // 注入业务层对象
    @Resource
    private TBlogService tBlogService;

    /***
     * 分页+条件搜索TBlog表数据
     * @param tBlog
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "TBlog条件分页查询",notes = "分页条件查询TBlog方法详情",tags = {"TBlogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public ResultMessage<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "TBlog对象",value = "传入JSON数据",required = false) TBlog tBlog, @PathVariable  int page, @PathVariable  int size){
        //调用TBlogService实现分页条件查询TBlog
        PageInfo<TBlog> pageInfo = tBlogService.findPage(tBlog, page, size);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, pageInfo);
    }

    /***
     * 分页搜索TBlog表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "TBlog分页查询",notes = "分页查询TBlog方法详情",tags = {"TBlogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public ResultMessage<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        // 调用TBlogService实现分页查询TBlog
        PageInfo<TBlog> pageInfo = tBlogService.findPage(page, size);
        return ResultUtil.resultMessage(true,ResultCode.SUCCESS, pageInfo);
    }

    /***
     * 多条件搜索TBlog表数据
     * @param tBlog
     * @return
     */
    @ApiOperation(value = "TBlog条件查询",notes = "条件查询TBlog方法详情",tags = {"TBlogController"})
    @PostMapping(value = "/search" )
    public ResultMessage<List<TBlog>> findList(@RequestBody(required = false) @ApiParam(name = "TBlog对象",value = "传入JSON数据",required = false) TBlog tBlog){
        //调用TBlogService实现条件查询TBlog
        List<TBlog> list = tBlogService.findList(tBlog);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, list);
    }

    /***
     * 根据ID删除TBlog表数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TBlog根据ID删除",notes = "根据ID删除TBlog方法详情",tags = {"TBlogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public ResultMessage delete(@PathVariable Integer id){
        //调用TBlogService实现根据主键删除
        tBlogService.delete(id);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 修改TBlog表数据
     * @param tBlog
     * @param id
     * @return
     */
    @ApiOperation(value = "TBlog根据ID修改",notes = "根据ID修改TBlog方法详情",tags = {"TBlogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public ResultMessage update(@RequestBody @ApiParam(name = "TBlog对象",value = "传入JSON数据",required = false) TBlog tBlog,@PathVariable Integer id){
        //设置主键值
        tBlog.setBlogId(id);
        //调用TBlogService实现修改TBlog
        tBlogService.update(tBlog);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 新增TBlog表数据
     * @param tBlog
     * @return
     */
    @ApiOperation(value = "TBlog添加",notes = "添加TBlog方法详情",tags = {"TBlogController"})
    @PostMapping
    public ResultMessage add(@RequestBody  @ApiParam(name = "TBlog对象",value = "传入JSON数据",required = true) TBlog tBlog){
        //调用TBlogService实现添加TBlog
        tBlogService.add(tBlog);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 根据ID查询TBlog表数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TBlog根据ID查询",notes = "根据ID查询TBlog方法详情",tags = {"TBlogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public ResultMessage<TBlog> findById(@PathVariable Integer id){
        //调用TBlogService实现根据主键查询TBlog
        TBlog tBlog = tBlogService.findById(id);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, tBlog);
    }

    /***
     * 查询TBlog表全部数据
     * @return
     */
    @ApiOperation(value = "查询所有TBlog",notes = "查询TBlog方法详情",tags = {"TBlogController"})
    @GetMapping
    public ResultMessage<List<TBlog>> findAll(){
        // 调用TBlogService实现查询所有TBlog
        List<TBlog> list = tBlogService.findAll();
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, list);
    }
}
