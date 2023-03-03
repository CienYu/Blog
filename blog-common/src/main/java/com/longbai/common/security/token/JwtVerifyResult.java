package com.longbai.common.security.token;

import java.util.Map;

/**
 * @Author Cien
 * @Date 2023/3/3 22:04
 * @Version 1.0
 * @Note
 */

public class JwtVerifyResult {
    /**
     * 1 是否成功
     **/
    private Boolean success;
    /**
     * 2 返回消息
     **/
    private String msg;
    /**
     * 3 jwt负载
     **/
    private Map<String, String> payload;

    public JwtVerifyResult() {
    }

    public JwtVerifyResult(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "JwtResult{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", payload=" + payload +
                '}';
    }
}