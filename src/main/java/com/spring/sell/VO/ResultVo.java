package com.spring.sell.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http 请求返回给最外层对象
 */
@Data
public class ResultVo<T> implements Serializable {
    private static final long serialVersionUID = -769667937613555450L;
    /**错误码*/
    private Integer code;
    /**提示信息*/
    private String msg;
    /**返回内容*/
    private T data;
}
