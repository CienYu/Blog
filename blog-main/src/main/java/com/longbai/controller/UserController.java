package com.longbai.controller;

import com.longbai.common.cache.RedisCacheImpl;
import com.longbai.common.security.enums.ResultCode;
import com.longbai.common.utils.JWTUtils;
import com.longbai.common.utils.ResultUtil;
import com.longbai.entity.TUser;
import com.longbai.pojo.vo.ResultMessage;
import com.longbai.pojo.vo.UserVO;
import com.longbai.service.TUserService;
import com.wf.captcha.SpecCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.UUID;

import static com.longbai.common.cache.RedisConst.*;

/**
 * @Author Cien
 * @Date 2023/2/22 17:05
 * @Version 1.0
 * @Note
 */
@Slf4j
@RestController
@Api(value = "UserController")
@RequestMapping("/user")
public class UserController {
    @Resource
    private RedisCacheImpl redisCache;

    @Resource
    private TUserService userService;

    @ApiOperation(value = "用户登录接口")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultMessage login(@RequestBody UserVO userVO, HttpServletRequest request){
        TUser user = new TUser();
        BeanUtils.copyProperties(userVO, user);
        //userService.verifyCode(userVO.getVerKey(), userVO.getCode()); // 验证如果不通过，后台直接抛异常
        log.info("用户名:[{}]", user.getUsername());
        request.getSession().setAttribute("username", user.getUsername());   // 给websocket取出
        log.info("密码:[{}]", user.getPassword());
        try {
            //认证成功，生成jwt令牌
            user.setLastIp((String) request.getAttribute("host"));
            TUser userDB = userService.login(user);
            HashMap<String, String> payload = new HashMap<>();
            payload.put("id", String.valueOf(userDB.getUserId()));
            payload.put("lastIp", userDB.getLastIp());
            payload.put("username", userDB.getUsername());
            String token = JWTUtils.createToken(payload);
            // token设置白名单，因此可以管理token的有效期
            redisCache.put(TOKEN_ALLOW_LIST + userDB.getUserId(), token, Long.valueOf(HOUR));
            HashMap<String, Object> userInfo = new HashMap<>();
            userInfo.put("token", token);
            userInfo.put("user", userDB);
            return ResultUtil.resultMessage(ResultCode.SUCCESS, userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error(ResultCode.TOKEN_ERROR);
    }
    @ApiOperation(value = "验证码")
    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    public ResultMessage captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();
        String key = UUID.randomUUID().toString();
        // 存入redis并设置过期时间为10分钟
        redisCache.putByms(USER_CODE_KEY + key, verCode, CODE_EXPIRE_TIME);
        request.getSession().setAttribute("CAPTCHA", verCode);  //存入session
        HashMap<String, Object> code = new HashMap<>();
        code.put("verKey", key);
        code.put("verCode", specCaptcha.toBase64());
        // 将key和base64返回给前端 .ok(MessageConstant.VERIFICATION_CODE_SUCCESS, code);
        return ResultUtil.resultMessage(true,ResultCode.SUCCESS,code);
    }

    @ApiOperation(value = "注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultMessage register(@RequestBody TUser user)  {
        if(userService.add(user)){
            return ResultUtil.success(ResultCode.SUCCESS);
        }
        return ResultUtil.error(ResultCode.USER_ALREADY_EXIST);
    }

}
