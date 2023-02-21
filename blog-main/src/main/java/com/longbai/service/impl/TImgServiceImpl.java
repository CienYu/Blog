package com.longbai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.longbai.entity.TImg;
import com.longbai.mapper.db.TImgMapper;
import com.longbai.service.TImgService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TImgServiceImpl extends ServiceImpl<TImgMapper, TImg> implements TImgService {

    // 注入持久层对象
    @Autowired
    private TImgMapper tImgMapper;


    @Override
    public PageInfo<TImg> findPage(TImg tImg, int page, int size) {
        return null;
    }

    @Override
    public PageInfo<TImg> findPage(int page, int size) {
        return null;
    }

    @Override
    public List<TImg> findList(TImg tImg) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(TImg tImg) {

    }

    @Override
    public void add(TImg tImg) {

    }

    @Override
    public TImg findById(Integer id) {
        return null;
    }

    @Override
    public List<TImg> findAll() {
        return null;
    }
}
