package com.longbai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.longbai.common.cache.RedisCacheImpl;
import com.longbai.common.exception.ServiceException;
import com.longbai.entity.TUser;
import com.longbai.mapper.db.TUserMapper;
import com.longbai.service.TUserService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import javax.annotation.Resource;
import java.util.List;

import static com.longbai.common.cache.RedisConst.USER_CODE_KEY;

@Service
@Slf4j
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    // 注入持久层对象
    @Resource
    private TUserMapper tUserMapper;

    @Resource
    private RedisCacheImpl redisCache;

    @Resource
    private PasswordEncoder encoder;


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

    @Override
    public boolean verifyCode(String verKey, String captcha) {
        String realCode = (String) redisCache.get(USER_CODE_KEY + verKey);
        redisCache.del(USER_CODE_KEY + verKey);
        // 验证码是否正确都删除，否则验证错误的验证码会存在redis中无法删除
        if (captcha == null || StringUtils.isEmpty(captcha)) {
            throw new AuthenticationServiceException("请输入验证码！");
        }
        if (realCode == null || StringUtils.isEmpty(realCode) || !captcha.equalsIgnoreCase(realCode)) {
            throw new AuthenticationServiceException("请输入正确的验证码！");
        }
        return true;
    }

    @Override
    public TUser login(TUser tUser) {
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", tUser.getUsername());
        //登录的用户
        TUser login_user = tUserMapper.selectOne(wrapper);
        log.debug("login_user:[{}]", login_user.toString());
        if (!encoder.matches(tUser.getPassword(), login_user.getPassword())) {
            throw new ServiceException("用户名或密码不正确，登录失败");
        }
        /*if (login_user.isStatus() == (MessageConstant.USER_DISABLE)) {
            throw new BizException("用户已被禁用,登录失败");
        }*/
        update(new UpdateWrapper<TUser>()
                .set("last_ip", tUser.getLastIp())
                .eq("username", login_user.getUsername()));

        return login_user;
    }
}
