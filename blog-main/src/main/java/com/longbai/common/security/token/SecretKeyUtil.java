package com.longbai.common.security.token;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.tomcat.util.codec.binary.Base64;


import javax.crypto.SecretKey;

/**
 * <h3>ProcessMiniProgram</h3>
 * <p>验证签名</p>
 *
 * @author : chenjunjie
 * @date : 2021-11-11 16:13
 **/
public class SecretKeyUtil {
    public static SecretKey generalKey() {
        //自定义
        byte[] encodedKey = Base64.decodeBase64("cuAihCz53DZRjZwbsGcZJ2Ai6At+T142uphtJMsk7iQ=");
        SecretKey key = Keys.hmacShaKeyFor(encodedKey);
        return key;
    }

    public static SecretKey generalKeyByDecoders() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode("cuAihCz53DZRjZwbsGcZJ2Ai6At+T142uphtJMsk7iQ="));

    }
}
