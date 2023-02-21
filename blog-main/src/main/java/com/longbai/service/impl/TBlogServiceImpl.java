package com.longbai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.longbai.entity.TBlog;
import com.longbai.mapper.db.TBlogMapper;
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
    public PageInfo<TBlog> findPage(int page, int size) {
        return null;
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
        return null;
    }

    @Override
    public List<TBlog> findAll() {
        return null;
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
