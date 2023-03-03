package com.longbai.pojo.vo;

import com.longbai.entity.TUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author Cien
 * @Date 2023/3/3 14:11
 * @Version 1.0
 * @Note
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserVO extends TUser implements Serializable {
    private String verKey;  // 缓存在redis中的验证码的key
    private String code; // 登录时的验证码
}
