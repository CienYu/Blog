package com.longbai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.longbai.common.mybatisPlus.QueryPageBean;
import com.longbai.entity.TBlog;
import com.longbai.mapper.db.TBlogMapper;
import com.longbai.pojo.vo.BlogVO;
import com.longbai.service.TBlogService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;


@Service
public class TBlogServiceImpl extends ServiceImpl<TBlogMapper, TBlog> implements TBlogService {

    // 注入持久层对象
    @Resource
    private TBlogMapper tBlogMapper;


    @Override
    public PageInfo<TBlog> findPage(TBlog tBlog, int page, int size) {
        return null;
    }

    @Override
    public PageInfo<BlogVO> findPage(QueryPageBean queryPageBean, int userId) {
        int currentPage = queryPageBean.getCurrentPage();
        int pageSize = queryPageBean.getPageSize();

        int start = (currentPage-1)*pageSize;
        //设置分页条件
        QueryWrapper<TBlog> wrapper = new QueryWrapper<>();
        //wrapper.eq("user_id", userId);
        //List<TBlog> result = this.list(wrapper);
        //PageHelper.startPage(start,pageSize);
        //列表查询
        List<BlogVO> blogVOList = tBlogMapper.getAllBlogs(userId, start, pageSize);
        /*System.err.println(blogVOList);
        for (BlogVO b : blogVOList) {
            System.err.println(b);
        }*/
        //获取result分页信息
        PageInfo pageInfo = new PageInfo(blogVOList);
        System.err.println(pageInfo);
        return pageInfo;
    }


    @Override
    public List<TBlog> findList(TBlog tBlog) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(TBlog tBlog) {

    }

    @Override
    public void add(TBlog tBlog) {

    }

    @Override
    public TBlog findById(Integer id) {
        LambdaQueryWrapper<TBlog> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(TBlog::getBlogId, id);
        return this.getOne(lambdaQueryWrapper);
    }

    @Override
    public List<TBlog> findAll() {
        LambdaQueryWrapper<TBlog> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        return this.list(lambdaQueryWrapper);
    }

    @Override
    public boolean saveBatch(Collection entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection entityList, int batchSize) {
        return false;
    }

}
