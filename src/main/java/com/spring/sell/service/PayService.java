package com.spring.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.spring.sell.dto.OrderDTO;

/**
 * @Author yanghan
 * @create 2019/6/25 10:13
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notify);

    RefundResponse refund(OrderDTO orderDTO);
}
