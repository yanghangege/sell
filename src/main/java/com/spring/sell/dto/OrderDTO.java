package com.spring.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spring.sell.dataobject.OrderDetail;
import com.spring.sell.enums.OrderStatusEnum;
import com.spring.sell.enums.PayStatusEnum;
import com.spring.sell.utils.EnumUtil;
import com.spring.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author yanghan
 * @create 2019/6/19 10:16
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL) //如果返回的是null的话就不返回！
public class OrderDTO {

    private String orderId;
    /**买家名字*/
    private String buyerName;
    /**买家手机号码*/
    private String buyerPhone;
    /**买家地址*/
    private String buyerAddress;
    /**买家微信*/
    private String buyerOpenid;
    /**订单总金额*/
    private BigDecimal orderAmount;
    /**订单状态,默认为0新订单*/
    private Integer orderStatus ;
    /**支付状态，默认为0未支付*/
    private Integer payStatus;
    /**创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /**更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    //如果有人用这个类返回Json格式会多出这两个，用注解@jsonIgnore就可以忽略
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }


}
