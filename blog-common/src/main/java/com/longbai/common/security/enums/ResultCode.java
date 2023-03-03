package com.longbai.common.security.enums;

/**
 * @Author Cien
 * @Date 2023/2/20 16:02
 * @Version 1.0
 * @Note 返回状态码
 */
public enum ResultCode {
    /**
     * 成功状态码
     */
    SUCCESS(200, "成功"),
    TOKEN_SUCCESS(201,"token成功生成"),

    /**
     * 失败返回码
     */
    ERROR(400, "服务器繁忙，请稍后重试"),
    TOKEN_ERROR(451,"TOKEN生成异常，请检查用户名密码是否匹配"),

    /**
     * 参数异常
     */
    PARAMS_ERROR(4005, "参数异常"),
    /**
     * 缓存异常
     */


    /**
     * 用户
     */
    USER_EDIT_SUCCESS(20001, "用户修改成功"),
    USER_NOT_EXIST(20002, "用户不存在"),
    USER_NOT_LOGIN(20003, "用户未登录"),
    USER_AUTH_EXPIRED(20004, "用户已退出，请重新登录"),
    USER_AUTHORITY_ERROR(20005, "权限不足"),
    USER_CONNECT_LOGIN_ERROR(20006, "未找到登录信息"),
    ;
    private final Integer code;
    private final String message;


    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
