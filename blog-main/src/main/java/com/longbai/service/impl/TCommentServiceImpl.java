package com.longbai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.longbai.entity.TComment;
import com.longbai.mapper.db.TCommentMapper;
import com.longbai.service.TCommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TCommentServiceImpl extends ServiceImpl<TCommentMapper, TComment> implements TCommentService {

    // 注入持久层对象
    @Autowired
    private TCommentMapper tCommentMapper;


    @Override
    public PageInfo<TComment> findPage(TComment tComment, int page, int size) {
        return null;
    }

    @Override
    public PageInfo<TComment> findPage(int page, int size) {
        return null;
    }

    @Override
    public List<TComment> findList(TComment tComment) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(TComment tComment) {

    }

    @Override
    public void add(TComment tComment) {

    }

    @Override
    public TComment findById(Integer id) {
        return null;
    }

    @Override
    public List<TComment> findAll() {
        return null;
    }
}
