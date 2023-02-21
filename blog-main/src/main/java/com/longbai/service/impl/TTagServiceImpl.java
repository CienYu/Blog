package com.longbai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.longbai.entity.TTag;
import com.longbai.mapper.db.TTagMapper;
import com.longbai.service.TTagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TTagServiceImpl extends ServiceImpl<TTagMapper, TTag> implements TTagService {

    // 注入持久层对象
    @Autowired
    private TTagMapper tTagMapper;


    @Override
    public PageInfo<TTag> findPage(TTag tTag, int page, int size) {
        return null;
    }

    @Override
    public PageInfo<TTag> findPage(int page, int size) {
        return null;
    }

    @Override
    public List<TTag> findList(TTag tTag) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(TTag tTag) {

    }

    @Override
    public void add(TTag tTag) {

    }

    @Override
    public TTag findById(Integer id) {
        return null;
    }

    @Override
    public List<TTag> findAll() {
        return null;
    }
}
