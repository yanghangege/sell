package com.spring.sell.converter;

import com.spring.sell.dataobject.OrderMaster;
import com.spring.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yanghan
 * @create 2019/6/20 15:02
 */
public class OrderMaster2OrderDtoConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
       return orderMasterList .stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
