package com.spring.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 *
 * @Author yanghan
 * @create 2019/6/18 15:32
 */
@Data
public class ProductVO implements Serializable {
    private static final long serialVersionUID = 2635060497069980160L;
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
