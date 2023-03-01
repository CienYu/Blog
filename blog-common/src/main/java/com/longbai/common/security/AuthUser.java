package com.longbai.common.security;

import cn.hutool.json.JSONArray;
import com.longbai.common.security.enums.UserEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Cien
 * @Date 2023/2/21 22:14
 * @Version 1.0
 * @Note
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser implements Serializable {
    private static final long serialVersionUID = 582441893336003319L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * id
     */
    private Integer id;

    /**
     * 长期有效（用于手机app登录场景或者信任场景等）
     */
    private Boolean longTerm = false;

    private String phone;

    /**
     * @see UserEnums
     * 角色
     */
    private UserEnums role;

    private JSONArray roles;
    /**
     * 是否是超级管理员
     */
    private Boolean isSuper = false;

    public AuthUser(String username, Integer id, String nickName) {
        this.username = username;
        this.id = id;
        this.nickName = nickName;
    }

    public AuthUser(String username, Integer id, String nickName, Boolean isSuper,UserEnums userEnums,JSONArray roles,String phone) {
        this.username = username;
        this.id = id;
        this.isSuper = isSuper;
        this.nickName = nickName;
        this.role = userEnums;
        this.roles = roles;
        this.phone = phone;
    }

}

