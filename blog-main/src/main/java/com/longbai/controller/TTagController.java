package com.longbai.controller;

import com.longbai.common.security.enums.ResultCode;
import com.longbai.common.utils.ResultUtil;
import com.longbai.entity.TTag;
import com.longbai.pojo.vo.ResultMessage;
import com.longbai.service.TTagService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Api(value = "TTagController")
@RestController
@RequestMapping("/tTag")
@CrossOrigin
public class TTagController {

    // 注入业务层对象
    @Autowired
    private TTagService tTagService;

    /***
     * 分页+条件搜索TTag表数据
     * @param tTag
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "TTag条件分页查询",notes = "分页条件查询TTag方法详情",tags = {"TTagController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public ResultMessage<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "TTag对象",value = "传入JSON数据",required = false) TTag tTag, @PathVariable  int page, @PathVariable  int size){
        //调用TTagService实现分页条件查询TTag
        PageInfo<TTag> pageInfo = tTagService.findPage(tTag, page, size);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS,pageInfo);
    }

    /***
     * 分页搜索TTag表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "TTag分页查询",notes = "分页查询TTag方法详情",tags = {"TTagController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public ResultMessage<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        // 调用TTagService实现分页查询TTag
        PageInfo<TTag> pageInfo = tTagService.findPage(page, size);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS,pageInfo);
    }

    /***
     * 多条件搜索TTag表数据
     * @param tTag
     * @return
     */
    @ApiOperation(value = "TTag条件查询",notes = "条件查询TTag方法详情",tags = {"TTagController"})
    @PostMapping(value = "/search" )
    public ResultMessage<List<TTag>> findList(@RequestBody(required = false) @ApiParam(name = "TTag对象",value = "传入JSON数据",required = false) TTag tTag){
        //调用TTagService实现条件查询TTag
        List<TTag> list = tTagService.findList(tTag);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, list);
    }

    /***
     * 根据ID删除TTag表数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TTag根据ID删除",notes = "根据ID删除TTag方法详情",tags = {"TTagController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public ResultMessage delete(@PathVariable Integer id){
        //调用TTagService实现根据主键删除
        tTagService.delete(id);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 修改TTag表数据
     * @param tTag
     * @param id
     * @return
     */
    @ApiOperation(value = "TTag根据ID修改",notes = "根据ID修改TTag方法详情",tags = {"TTagController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public ResultMessage update(@RequestBody @ApiParam(name = "TTag对象",value = "传入JSON数据",required = false) TTag tTag,@PathVariable Integer id){
        //设置主键值
        tTag.setTagId(id);
        //调用TTagService实现修改TTag
        tTagService.update(tTag);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 新增TTag表数据
     * @param tTag
     * @return
     */
    @ApiOperation(value = "TTag添加",notes = "添加TTag方法详情",tags = {"TTagController"})
    @PostMapping
    public ResultMessage add(@RequestBody  @ApiParam(name = "TTag对象",value = "传入JSON数据",required = true) TTag tTag){
        //调用TTagService实现添加TTag
        tTagService.add(tTag);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 根据ID查询TTag表数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TTag根据ID查询",notes = "根据ID查询TTag方法详情",tags = {"TTagController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public ResultMessage<TTag> findById(@PathVariable Integer id){
        //调用TTagService实现根据主键查询TTag
        TTag tTag = tTagService.findById(id);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, tTag);
    }

    /***
     * 查询TTag表全部数据
     * @return
     */
    @ApiOperation(value = "查询所有TTag",notes = "查询TTag方法详情",tags = {"TTagController"})
    @GetMapping
    public ResultMessage<List<TTag>> findAll(){
        // 调用TTagService实现查询所有TTag
        List<TTag> list = tTagService.findAll();
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, list);
    }
}
