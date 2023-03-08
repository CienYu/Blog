package com.longbai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.longbai.common.cache.RedisCacheImpl;
import com.longbai.common.exception.ServiceException;
import com.longbai.common.security.enums.UserEnums;
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
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Random;

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
    public boolean add(TUser user) {
        log.info("addUser.user.getUsername():[{}]", user.getUsername());
        log.info("addUser.user.getPassword():[{}]", user.getPassword());
        LambdaQueryWrapper<TUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //判断是否已经注册
        lambdaQueryWrapper.eq(TUser::getUsername, user.getUsername());
        if(this.getOne(lambdaQueryWrapper)!=null){
            return false;
        }
        user.setRole(UserEnums.USER);
        user.setPassword(encoder.encode(user.getPassword()));
        // todo 待改
        // user.setAvatar(isImagesTrue(user.getAvatar()));
        this.save(user);
        return true;
    }
    /**
     * 用户提供的图片链接无效就自动生成图片
     *
     * @param postUrl 用户传来的头像url
     * @return url
     */
    public String isImagesTrue(String postUrl) {
        if (postUrl.contains("tcefrep.oss-cn-beijing.aliyuncs.com")) {   //本人的oss地址，就无需检验图片有效性
            return postUrl;
        }
        int max = 1000;
        int min = 1;
        String picUrl = "https://unsplash.it/100/100?image=";
        try {
            URL url = new URL(postUrl);
            HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
            urlCon.setRequestMethod("POST");
            urlCon.setRequestProperty("Content-type",
                    "application/x-www-form-urlencoded");
            if (urlCon.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return postUrl;
            } else {
                Random random = new Random();
                int s = random.nextInt(max) % (max - min + 1) + min;
                return picUrl + s;
            }
        } catch (Exception e) {   // 代表图片链接无效
            Random random = new Random();
            int s = random.nextInt(max) % (max - min + 1) + min;
            return picUrl + s;
        }
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
