package com.spring.sell.dto;

import lombok.Data;

import javax.persistence.Entity;

/**
 * @Author yanghan
 * @create 2019/6/19 14:21
 */
@Data
public class CartDTO {
    //商品id
    private String productId;

    //数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
