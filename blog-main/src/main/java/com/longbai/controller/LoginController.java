package com.longbai.controller;

import com.longbai.common.security.enums.ResultCode;
import com.longbai.common.utils.ResultUtil;
import com.longbai.entity.TUser;
import com.longbai.pojo.vo.ResultMessage;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Cien
 * @Date 2023/2/22 17:05
 * @Version 1.0
 * @Note
 */
@RestController
@Api(value = "LoginController")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultMessage<TUser> login(@RequestParam("username") String username, @RequestParam("password") String password){
        return ResultUtil.success(ResultCode.SUCCESS);
    }
}
