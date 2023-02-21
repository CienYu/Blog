package com.longbai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.longbai.entity.TTagBlog;
import com.longbai.mapper.db.TTagBlogMapper;
import com.longbai.service.TTagBlogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TTagBlogServiceImpl extends ServiceImpl<TTagBlogMapper, TTagBlog> implements TTagBlogService {

    // 注入持久层对象
    @Autowired
    private TTagBlogMapper tTagBlogMapper;


    @Override
    public PageInfo<TTagBlog> findPage(TTagBlog tTagBlog, int page, int size) {
        return null;
    }

    @Override
    public PageInfo<TTagBlog> findPage(int page, int size) {
        return null;
    }

    @Override
    public List<TTagBlog> findList(TTagBlog tTagBlog) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(TTagBlog tTagBlog) {

    }

    @Override
    public void add(TTagBlog tTagBlog) {

    }

    @Override
    public TTagBlog findById(Integer id) {
        return null;
    }

    @Override
    public List<TTagBlog> findAll() {
        return null;
    }
}
