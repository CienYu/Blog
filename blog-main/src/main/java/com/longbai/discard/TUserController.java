package com.longbai.discard;

import com.longbai.common.security.enums.ResultCode;
import com.longbai.common.utils.ResultUtil;
import com.longbai.entity.TUser;
import com.longbai.pojo.vo.ResultMessage;
import com.longbai.service.TUserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(value = "TUserController")
@RestController
@RequestMapping("/tUser")
@CrossOrigin
public class TUserController {

    // 注入业务层对象
    @Autowired
    private TUserService tUserService;

    /***
     * 分页+条件搜索TUser表数据
     * @param tUser
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "TUser条件分页查询",notes = "分页条件查询TUser方法详情",tags = {"TUserController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public ResultMessage<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "TUser对象",value = "传入JSON数据",required = false) TUser tUser, @PathVariable  int page, @PathVariable  int size){
        //调用TUserService实现分页条件查询TUser
        PageInfo<TUser> pageInfo = tUserService.findPage(tUser, page, size);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, pageInfo);
    }

    /***
     * 分页搜索TUser表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "TUser分页查询",notes = "分页查询TUser方法详情",tags = {"TUserController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public ResultMessage<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        // 调用TUserService实现分页查询TUser
        PageInfo<TUser> pageInfo = tUserService.findPage(page, size);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, pageInfo);
    }

    /***
     * 多条件搜索TUser表数据
     * @param tUser
     * @return
     */
    @ApiOperation(value = "TUser条件查询",notes = "条件查询TUser方法详情",tags = {"TUserController"})
    @PostMapping(value = "/search" )
    public ResultMessage<List<TUser>> findList(@RequestBody(required = false) @ApiParam(name = "TUser对象",value = "传入JSON数据",required = false) TUser tUser){
        //调用TUserService实现条件查询TUser
        List<TUser> list = tUserService.findList(tUser);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, list);
    }

    /***
     * 根据ID删除TUser表数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TUser根据ID删除",notes = "根据ID删除TUser方法详情",tags = {"TUserController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public ResultMessage delete(@PathVariable Integer id){
        //调用TUserService实现根据主键删除
        tUserService.delete(id);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 修改TUser表数据
     * @param tUser
     * @param id
     * @return
     */
    @ApiOperation(value = "TUser根据ID修改",notes = "根据ID修改TUser方法详情",tags = {"TUserController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public ResultMessage update(@RequestBody @ApiParam(name = "TUser对象",value = "传入JSON数据",required = false) TUser tUser,@PathVariable Integer id){
        //设置主键值
        tUser.setUserId(id);
        //调用TUserService实现修改TUser
        tUserService.update(tUser);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 新增TUser表数据
     * @param tUser
     * @return
     */
    @ApiOperation(value = "TUser添加",notes = "添加TUser方法详情",tags = {"TUserController"})
    @PostMapping
    public ResultMessage add(@RequestBody  @ApiParam(name = "TUser对象",value = "传入JSON数据",required = true) TUser tUser){
        //调用TUserService实现添加TUser
        tUserService.add(tUser);
        return ResultUtil.success(ResultCode.SUCCESS);
    }

    /***
     * 根据ID查询TUser表数据
     * @param id
     * @return
     */
    @ApiOperation(value = "TUser根据ID查询",notes = "根据ID查询TUser方法详情",tags = {"TUserController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public ResultMessage<TUser> findById(@PathVariable Integer id){
        //调用TUserService实现根据主键查询TUser
        TUser tUser = tUserService.findById(id);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, tUser);
    }

    /***
     * 查询TUser表全部数据
     * @return
     */
    @ApiOperation(value = "查询所有TUser",notes = "查询TUser方法详情",tags = {"TUserController"})
    @GetMapping
    public ResultMessage<List<TUser>> findAll(){
        // 调用TUserService实现查询所有TUser
        List<TUser> list = tUserService.findAll();
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, list);
    }
}
