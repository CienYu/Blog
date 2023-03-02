package com.longbai.blogmain;

import com.github.pagehelper.PageInfo;
import com.longbai.common.mybatisPlus.QueryPageBean;
import com.longbai.common.security.enums.ResultCode;
import com.longbai.common.utils.ResultUtil;
import com.longbai.pojo.vo.BlogVO;
import com.longbai.service.TBlogService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author Cien
 * @Date 2023/3/1 23:15
 * @Version 1.0
 * @Note
 */
@SpringBootTest
public class BlogTest {
    @Resource
    public TBlogService tBlogService;

    @Test
    public void test(){
        QueryPageBean queryPageBean = new QueryPageBean();
        queryPageBean.setPageSize(2);
        queryPageBean.setCurrentPage(0);
        //调用TBlogService实现分页条件查询TBlog
       // PageInfo<BlogVO> pageInfo = tBlogService.findPage(queryPageBean,1);
        //System.out.println(pageInfo);
    }
}
