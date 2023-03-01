package com.longbai.discard;
import com.longbai.common.security.enums.ResultCode;
import com.longbai.common.utils.ResultUtil;
import com.longbai.entity.TTagBlog;
import com.longbai.pojo.vo.ResultMessage;
import com.longbai.service.TTagBlogService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Api(value = "TTagBlogController")
@RestController
@RequestMapping("/tTagBlog")
@CrossOrigin
public class TTagBlogController {

    // 注入业务层对象
    @Autowired
    private TTagBlogService tTagBlogService;

    /***
     * 分页+条件搜索TTagBlog表数据
     * @param tTagBlog
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "TTagBlog条件分页查询",notes = "分页条件查询TTagBlog方法详情",tags = {"TTagBlogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public ResultMessage<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "TTagBlog对象",value = "传入JSON数据",required = false) TTagBlog tTagBlog, @PathVariable  int page, @PathVariable  int size){
        //调用TTagBlogService实现分页条件查询TTagBlog
        PageInfo<TTagBlog> pageInfo = tTagBlogService.findPage(tTagBlog, page, size);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS,pageInfo);
    }

    /***
     * 分页搜索TTagBlog表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "TTagBlog分页查询",notes = "分页查询TTagBlog方法详情",tags = {"TTagBlogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public ResultMessage<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        // 调用TTagBlogService实现分页查询TTagBlog
        PageInfo<TTagBlog> pageInfo = tTagBlogService.findPage(page, size);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS,pageInfo);
    }

    /***
     * 多条件搜索TTagBlog表数据
     * @param tTagBlog
     * @return
     */
    @ApiOperation(value = "TTagBlog条件查询",notes = "条件查询TTagBlog方法详情",tags = {"TTagBlogController"})
    @PostMapping(value = "/search" )
    public ResultMessage<List<TTagBlog>> findList(@RequestBody(required = false) @ApiParam(name = "TTagBlog对象",value = "传入JSON数据",required = false) TTagBlog tTagBlog){
        //调用TTagBlogService实现条件查询TTagBlog
        List<TTagBlog> list = tTagBlogService.findList(tTagBlog);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS,list);
    }

    /***
     * 根据ID删除TTagBlog表数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TTagBlog根据ID删除",notes = "根据ID删除TTagBlog方法详情",tags = {"TTagBlogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public ResultMessage delete(@PathVariable Integer id){
        //调用TTagBlogService实现根据主键删除
        tTagBlogService.delete(id);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 修改TTagBlog表数据
     * @param tTagBlog
     * @param id
     * @return
     */
    @ApiOperation(value = "TTagBlog根据ID修改",notes = "根据ID修改TTagBlog方法详情",tags = {"TTagBlogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public ResultMessage update(@RequestBody @ApiParam(name = "TTagBlog对象",value = "传入JSON数据",required = false) TTagBlog tTagBlog,@PathVariable Integer id){
        //设置主键值
        tTagBlog.setTagId(id);
        //调用TTagBlogService实现修改TTagBlog
        tTagBlogService.update(tTagBlog);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 新增TTagBlog表数据
     * @param tTagBlog
     * @return
     */
    @ApiOperation(value = "TTagBlog添加",notes = "添加TTagBlog方法详情",tags = {"TTagBlogController"})
    @PostMapping
    public ResultMessage add(@RequestBody  @ApiParam(name = "TTagBlog对象",value = "传入JSON数据",required = true) TTagBlog tTagBlog){
        //调用TTagBlogService实现添加TTagBlog
        tTagBlogService.add(tTagBlog);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 根据ID查询TTagBlog表数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TTagBlog根据ID查询",notes = "根据ID查询TTagBlog方法详情",tags = {"TTagBlogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public ResultMessage<TTagBlog> findById(@PathVariable Integer id){
        //调用TTagBlogService实现根据主键查询TTagBlog
        TTagBlog tTagBlog = tTagBlogService.findById(id);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS,tTagBlog);
    }

    /***
     * 查询TTagBlog表全部数据
     * @return
     */
    @ApiOperation(value = "查询所有TTagBlog",notes = "查询TTagBlog方法详情",tags = {"TTagBlogController"})
    @GetMapping
    public ResultMessage<List<TTagBlog>> findAll(){
        // 调用TTagBlogService实现查询所有TTagBlog
        List<TTagBlog> list = tTagBlogService.findAll();
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, list);
    }
}
