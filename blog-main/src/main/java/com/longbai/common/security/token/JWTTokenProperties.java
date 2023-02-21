package com.longbai.common.security.token;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * @Author Cien
 * @Date 2023/2/20 16:02
 * @Version 1.0
 * @Note JWT参数
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "lili.jwt-setting")
public class JWTTokenProperties {
    /**
     * token默认过期时间
     */
    private long tokenExpireTime =60*24;
}
