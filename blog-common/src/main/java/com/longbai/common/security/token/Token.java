package com.longbai.common.security.token;

import lombok.Data;


/**
 * @Author Cien
 * @Date 2023/2/20 16:02
 * @Version 1.0
 * @Note 实体类
 */
@Data
public class Token {
    /**
     * 访问token
     */
    private String accessToken;

    /**
     * 刷新token
     */
    private String refreshToken;

}
