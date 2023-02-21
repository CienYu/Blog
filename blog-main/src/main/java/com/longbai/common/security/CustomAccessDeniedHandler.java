package com.longbai.common.security;

import com.longbai.common.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Cien
 * @Date 2023/2/21 21:54
 * @Version 1.0
 * @Note
 */
@Component
@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) {
        ResponseUtil.output(response, ResponseUtil.resultMap(false, 401, "抱歉，您没有访问权限"));
    }
}

