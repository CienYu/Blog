package com.longbai.controller;
import com.longbai.common.security.enums.ResultCode;
import com.longbai.common.utils.ResultUtil;
import com.longbai.entity.TImg;
import com.longbai.pojo.vo.ResultMessage;
import com.longbai.service.TImgService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Api(value = "TImgController")
@RestController
@RequestMapping("/tImg")
@CrossOrigin
public class TImgController {

    // 注入业务层对象
    @Autowired
    private TImgService tImgService;

    /***
     * 分页+条件搜索TImg表数据
     * @param tImg
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "TImg条件分页查询",notes = "分页条件查询TImg方法详情",tags = {"TImgController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public ResultMessage<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "TImg对象",value = "传入JSON数据",required = false) TImg tImg, @PathVariable  int page, @PathVariable  int size){
        //调用TImgService实现分页条件查询TImg
        PageInfo<TImg> pageInfo = tImgService.findPage(tImg, page, size);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS,pageInfo);
    }

    /***
     * 分页搜索TImg表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "TImg分页查询",notes = "分页查询TImg方法详情",tags = {"TImgController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public ResultMessage<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        // 调用TImgService实现分页查询TImg
        PageInfo<TImg> pageInfo = tImgService.findPage(page, size);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS,pageInfo);
    }

    /***
     * 多条件搜索TImg表数据
     * @param tImg
     * @return
     */
    @ApiOperation(value = "TImg条件查询",notes = "条件查询TImg方法详情",tags = {"TImgController"})
    @PostMapping(value = "/search" )
    public ResultMessage<List<TImg>> findList(@RequestBody(required = false) @ApiParam(name = "TImg对象",value = "传入JSON数据",required = false) TImg tImg){
        //调用TImgService实现条件查询TImg
        List<TImg> list = tImgService.findList(tImg);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS,list);
    }

    /***
     * 根据ID删除TImg表数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TImg根据ID删除",notes = "根据ID删除TImg方法详情",tags = {"TImgController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public ResultMessage delete(@PathVariable Integer id){
        //调用TImgService实现根据主键删除
        tImgService.delete(id);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 修改TImg表数据
     * @param tImg
     * @param id
     * @return
     */
    @ApiOperation(value = "TImg根据ID修改",notes = "根据ID修改TImg方法详情",tags = {"TImgController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public ResultMessage update(@RequestBody @ApiParam(name = "TImg对象",value = "传入JSON数据",required = false) TImg tImg,@PathVariable Integer id){
        //设置主键值
        tImg.setImgId(id);
        //调用TImgService实现修改TImg
        tImgService.update(tImg);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 新增TImg表数据
     * @param tImg
     * @return
     */
    @ApiOperation(value = "TImg添加",notes = "添加TImg方法详情",tags = {"TImgController"})
    @PostMapping
    public ResultMessage add(@RequestBody  @ApiParam(name = "TImg对象",value = "传入JSON数据",required = true) TImg tImg){
        //调用TImgService实现添加TImg
        tImgService.add(tImg);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 根据ID查询TImg表数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TImg根据ID查询",notes = "根据ID查询TImg方法详情",tags = {"TImgController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public ResultMessage<TImg> findById(@PathVariable Integer id){
        //调用TImgService实现根据主键查询TImg
        TImg tImg = tImgService.findById(id);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, tImg);
    }

    /***
     * 查询TImg表全部数据
     * @return
     */
    @ApiOperation(value = "查询所有TImg",notes = "查询TImg方法详情",tags = {"TImgController"})
    @GetMapping
    public ResultMessage<List<TImg>> findAll(){
        // 调用TImgService实现查询所有TImg
        List<TImg> list = tImgService.findAll();
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, list);
    }
}
