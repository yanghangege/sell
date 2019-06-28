package com.spring.sell.enums;

import lombok.Getter;

/**
 * @Author yanghan
 * @create 2019/6/19 10:30
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不正确"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    ORDER_UPDATE_FAIL(15,"订单更新失败"),
    ORDER_DETAIL_EMPTY(16,"订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17,"订单支付状态不正确"),
    PARAM_ERROR(18,"参数不正确"),
    CART_EMPTY(19,"购物车不能为空"),
    ORDER_OWNER_ERROR(20,"订单不属于该用户"),
    WECHAT_MP_ERROR(21,"微信公众账号错误"),
    WXPAY_NOTIFY_MONEY_VERIFY(22,"微信支付异步通知金额校验不通过"),
    SUCCESS(23,"成功"),
    ORDER_CANCEL_SUCCESS(24,"订单取消成功"),
    ORDER_FINISH_SUCCESS(25,"订单完结成功"),
    PRODUCT_STATUS_ERROR(26,"商品状态不正确"),
    LOGIN_FAIL(27,"登陆失败，登陆信息不正确"),
    LOGOUT_SUCCESS(28,"登出成功")

    ;

    private Integer code;
    private String messages;

    ResultEnum(Integer code, String messages) {
        this.code = code;
        this.messages = messages;
    }

}
