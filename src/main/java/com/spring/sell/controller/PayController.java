package com.spring.sell.controller;

import com.lly835.bestpay.model.PayResponse;
import com.spring.sell.dto.OrderDTO;
import com.spring.sell.enums.ResultEnum;
import com.spring.sell.exception.SellException;
import com.spring.sell.service.OrderService;
import com.spring.sell.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.POST;
import java.util.Map;

/**
 * @Author yanghan
 * @create 2019/6/25 10:12
 */
public class PayController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;
    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String,Object>map){
        //查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //发起支付
        PayResponse payResponse = payService.create(orderDTO);
        map.put("payResponse",payResponse);

        return new ModelAndView("pay/create");
    }

    /***
     * 微信发布异步通知
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){
        payService.notify(notifyData);
        return new ModelAndView("pay/success");
    }

}
