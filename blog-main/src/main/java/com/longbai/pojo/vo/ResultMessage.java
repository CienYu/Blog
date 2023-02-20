package com.longbai.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Cien
 * @Date 2023/2/20 16:10
 * @Version 1.0
 * @Note
 */
@Data
public class ResultMessage<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 消息
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */
    private T result;
}
