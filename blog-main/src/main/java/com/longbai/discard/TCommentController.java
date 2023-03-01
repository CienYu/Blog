package com.longbai.discard;
import com.longbai.common.security.enums.ResultCode;
import com.longbai.common.utils.ResultUtil;
import com.longbai.entity.TComment;
import com.longbai.pojo.vo.ResultMessage;
import com.longbai.service.TCommentService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Api(value = "TCommentController")
@RestController
@RequestMapping("/tComment")
@CrossOrigin
public class TCommentController {

    // 注入业务层对象
    @Autowired
    private TCommentService tCommentService;

    /***
     * 分页+条件搜索TComment表数据
     * @param tComment
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "TComment条件分页查询",notes = "分页条件查询TComment方法详情",tags = {"TCommentController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public ResultMessage<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "TComment对象",value = "传入JSON数据",required = false) TComment tComment, @PathVariable  int page, @PathVariable  int size){
        //调用TCommentService实现分页条件查询TComment
        PageInfo<TComment> pageInfo = tCommentService.findPage(tComment, page, size);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS,pageInfo);
    }

    /***
     * 分页搜索TComment表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "TComment分页查询",notes = "分页查询TComment方法详情",tags = {"TCommentController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public ResultMessage<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        // 调用TCommentService实现分页查询TComment
        PageInfo<TComment> pageInfo = tCommentService.findPage(page, size);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS,pageInfo);
    }

    /***
     * 多条件搜索TComment表数据
     * @param tComment
     * @return
     */
    @ApiOperation(value = "TComment条件查询",notes = "条件查询TComment方法详情",tags = {"TCommentController"})
    @PostMapping(value = "/search" )
    public ResultMessage<List<TComment>> findList(@RequestBody(required = false) @ApiParam(name = "TComment对象",value = "传入JSON数据",required = false) TComment tComment){
        //调用TCommentService实现条件查询TComment
        List<TComment> list = tCommentService.findList(tComment);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS,list);
    }

    /***
     * 根据ID删除TComment表数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TComment根据ID删除",notes = "根据ID删除TComment方法详情",tags = {"TCommentController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public ResultMessage delete(@PathVariable Integer id){
        //调用TCommentService实现根据主键删除
        tCommentService.delete(id);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 修改TComment表数据
     * @param tComment
     * @param id
     * @return
     */
    @ApiOperation(value = "TComment根据ID修改",notes = "根据ID修改TComment方法详情",tags = {"TCommentController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public ResultMessage update(@RequestBody @ApiParam(name = "TComment对象",value = "传入JSON数据",required = false) TComment tComment,@PathVariable Integer id){
        //设置主键值
        tComment.setCommentId(id);
        //调用TCommentService实现修改TComment
        tCommentService.update(tComment);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 新增TComment表数据
     * @param tComment
     * @return
     */
    @ApiOperation(value = "TComment添加",notes = "添加TComment方法详情",tags = {"TCommentController"})
    @PostMapping
    public ResultMessage add(@RequestBody  @ApiParam(name = "TComment对象",value = "传入JSON数据",required = true) TComment tComment){
        //调用TCommentService实现添加TComment
        tCommentService.add(tComment);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 根据ID查询TComment表数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TComment根据ID查询",notes = "根据ID查询TComment方法详情",tags = {"TCommentController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public ResultMessage<TComment> findById(@PathVariable Integer id){
        //调用TCommentService实现根据主键查询TComment
        TComment tComment = tCommentService.findById(id);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS,tComment);
    }

    /***
     * 查询TComment表全部数据
     * @return
     */
    @ApiOperation(value = "查询所有TComment",notes = "查询TComment方法详情",tags = {"TCommentController"})
    @GetMapping
    public ResultMessage<List<TComment>> findAll(){
        // 调用TCommentService实现查询所有TComment
        List<TComment> list = tCommentService.findAll();
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS,list);
    }
}
