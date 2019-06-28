package com.spring.sell.controller;

import com.spring.sell.VO.ResultVo;
import com.spring.sell.converter.OrderForm2OrderDTOConverter;
import com.spring.sell.dto.OrderDTO;
import com.spring.sell.enums.ResultEnum;
import com.spring.sell.exception.SellException;
import com.spring.sell.form.OrderForm;
import com.spring.sell.service.BuyerService;
import com.spring.sell.service.OrderService;
import com.spring.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yanghan
 * @create 2019/6/20 17:20
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private OrderService orderService;
    //创建订单
    @PostMapping("create")
    public ResultVo<Map<String,String>>create(@Valid OrderForm orderForm,
                                              BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("[创建订单]参数不正确，orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("[创建订单]购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String,String>map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVOUtil.success(map);
    }
    //订单列表
    @GetMapping("list")
    public ResultVo<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0")Integer page,
                                         @RequestParam(value = "size",defaultValue = "20") Integer size){
        if (StringUtils.isEmpty(openid)){
            log.error("[查询订单列表]openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid,request);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }
    //订单详情
    @GetMapping("detail")
    public ResultVo<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderid") String orderid){
        OrderDTO orderDTO = buyerService.findOrderOne(openid,openid);
        return ResultVOUtil.success(orderDTO);
    }
    //取消订单
    @PostMapping("cancel")
    public ResultVo cancel (@RequestParam("openid") String openid,
                            @RequestParam("orderid") String orderid){
        buyerService.cancelOrder(openid,orderid);
        return ResultVOUtil.success();
    }
}
