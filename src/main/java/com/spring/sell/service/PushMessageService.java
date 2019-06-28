package com.spring.sell.service;

import com.spring.sell.dto.OrderDTO;

/**
 * @Author yanghan
 * @create 2019/6/28 10:57
 */
public interface PushMessageService {
    /***
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
