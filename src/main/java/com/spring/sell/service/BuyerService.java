package com.spring.sell.service;

import com.spring.sell.dto.OrderDTO;

/**
 * 买家
 * @Author yanghan
 * @create 2019/6/21 17:12
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消订单
    OrderDTO cancelOrder(String openid ,String orderId);

}
