package com.longbai.common.security.enums;

/**
 * <h3>ProcessMiniProgram</h3>
 * <p>安全相关常量</p>
 *
 * @author : chenjunjie
 * @date : 2021-11-11 15:58
 **/
public enum SecurityEnum {
    /**
     * 存在与header中的token参数头 名
     */
    HEADER_TOKEN("accessToken"), USER_CONTEXT("userContext"), JWT_SECRET("secret");

    String value;

    SecurityEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
