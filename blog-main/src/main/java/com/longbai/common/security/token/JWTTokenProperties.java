package com.longbai.common.security.token;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <h3>ProcessMiniProgram</h3>
 * <p>JWT参数</p>
 *
 * @author : chenjunjie
 * @date : 2021-11-11 18:30
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "lili.jwt-setting")
public class JWTTokenProperties {
    /**
     * token默认过期时间
     */
    private long tokenExpireTime =60*24;
}
