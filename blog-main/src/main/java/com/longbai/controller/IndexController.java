package com.longbai.controller;

import com.github.pagehelper.PageInfo;
import com.longbai.common.mybatisPlus.QueryPageBean;
import com.longbai.common.security.enums.ResultCode;
import com.longbai.common.utils.ResultUtil;
import com.longbai.entity.TBlog;
import com.longbai.pojo.vo.BlogVO;
import com.longbai.pojo.vo.ResultMessage;
import com.longbai.service.TBlogService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Cien
 * @Date 2023/2/22 16:33
 * @Version 1.0
 * @Note 首页控制层
 */
@RestController
@Api(value = "IndexController")
@RequestMapping("/index")
public class IndexController {

    @Resource
    private TBlogService tBlogService;

    /***
     * 分页+条件搜索TBlog表数据
     * @param queryPageBean
     * @param userId
     * @return
     */
    @ApiOperation(value = "TBlog条件分页查询",notes = "分页条件查询TBlog方法详情",tags = {"TBlogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/findpage", method = RequestMethod.POST)
    //切记RequestBody需要搭配post方法
    public ResultMessage<PageInfo> findPage(@RequestBody @ApiParam(name = "TBlog对象",value = "传入JSON数据") QueryPageBean queryPageBean, Integer userId){
        //调用TBlogService实现分页条件查询TBlog
        PageInfo<BlogVO> pageInfo = tBlogService.findPage(queryPageBean,userId);
        return ResultUtil.resultMessage(true, ResultCode.SUCCESS, pageInfo);
    }



    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "hello world";
    }

}
