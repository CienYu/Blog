package com.longbai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.longbai.entity.TUser;
import com.longbai.mapper.db.TUserMapper;
import com.longbai.service.TUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    // 注入持久层对象
    @Autowired
    private TUserMapper tUserMapper;


    @Override
    public PageInfo<TUser> findPage(TUser tUser, int page, int size) {
        return null;
    }

    @Override
    public PageInfo<TUser> findPage(int page, int size) {
        return null;
    }

    @Override
    public List<TUser> findList(TUser tUser) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(TUser tUser) {

    }

    @Override
    public void add(TUser tUser) {

    }

    @Override
    public TUser findById(Integer id) {
        return null;
    }

    @Override
    public List<TUser> findAll() {
        return null;
    }
}
