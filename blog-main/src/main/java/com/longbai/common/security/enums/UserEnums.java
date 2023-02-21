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
    CONSIGNOR("委托商"),
    PROCESSORS("加工户"),
    EMPLOYEE("普通员工");

    private final String role;

    UserEnums(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public static UserEnums getUserEnums(String role){
        if(role.equals(UserEnums.CONSIGNOR.toString())){
            return UserEnums.CONSIGNOR;
        }
        if(role.equals(UserEnums.PROCESSORS.toString())){
            return UserEnums.PROCESSORS;
        }
        return UserEnums.EMPLOYEE;
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
