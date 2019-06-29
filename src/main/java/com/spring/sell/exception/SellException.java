package com.spring.sell.exception;

import com.spring.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @Author yanghan
 * @create 2019/6/19 10:29
 */
@Getter
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessages());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code ,String message) {
        super(message);
        this.code = code;
    }
}
