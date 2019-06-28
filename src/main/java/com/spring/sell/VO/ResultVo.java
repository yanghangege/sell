package com.spring.sell.VO;

import lombok.Data;

/**
 * http 请求返回给最外层对象
 */
@Data
public class ResultVo<T> {
    /**错误码*/
    private Integer code;
    /**提示信息*/
    private String msg;
    /**返回内容*/
    private T data;
}
