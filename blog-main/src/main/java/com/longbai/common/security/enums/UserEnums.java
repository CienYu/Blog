package com.longbai.common.security.enums;

import cn.hutool.json.JSONArray;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h3>ProcessMiniProgram</h3>
 * <p>角色枚举类</p>
 *
 * @author : chenjunjie
 * @date : 2021-11-11 16:01
 **/
public enum UserEnums {


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
