package com.longbai.common.security.enums;

import cn.hutool.json.JSONArray;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @Author Cien
 * @Date 2023/2/20 16:02
 * @Version 1.0
 * @Note 角色枚举类
 */
public enum UserEnums {


    //todo 待修改
    BAN("禁用"),
    USER("普通用户"),
    ADMIN("管理员");

    private final String role;

    UserEnums(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public static UserEnums getUserEnums(String role){
        if(role.equals(UserEnums.ADMIN.toString())){
            return UserEnums.ADMIN;
        }
        if(role.equals(UserEnums.USER.toString())){
            return UserEnums.USER;
        }
        return UserEnums.BAN;
    }

    public static Set<UserEnums> toList(JSONArray jsonArray){
        List<UserEnums> userEnums = jsonArray.toList(UserEnums.class);
        Set<UserEnums> set = new HashSet<>();
        for (UserEnums userEnum : userEnums) {
            set.add(userEnum);
        }
        return set;
    }
}
