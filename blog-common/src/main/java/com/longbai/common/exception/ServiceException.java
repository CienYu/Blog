package com.longbai.common.exception;

import com.longbai.common.security.enums.ResultCode;
import lombok.Data;


@Data
public class ServiceException extends RuntimeException {
    public static String DEFAULT_MESSAGE = "网络错误，请稍后重试！";

    /**
     * 异常消息
     */
    private String msg = DEFAULT_MESSAGE;

    /**
     * 错误码
     */
    private ResultCode resultCode;

    public ServiceException(String msg) {
        this.resultCode = ResultCode.ERROR;
        this.msg = msg;
    }

    public ServiceException() {
        super();
    }

    public ServiceException(ResultCode resultCode) {
        this.resultCode = resultCode;

    }

    public ServiceException(ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.msg = message;
    }
}
