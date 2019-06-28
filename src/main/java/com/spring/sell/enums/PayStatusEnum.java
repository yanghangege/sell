package com.spring.sell.enums;

import lombok.Getter;

/**
 * @Author yanghan
 * @create 2019/6/18 18:34
 */
@Getter
public enum PayStatusEnum implements CodeEnum{
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功")
    ;
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}
