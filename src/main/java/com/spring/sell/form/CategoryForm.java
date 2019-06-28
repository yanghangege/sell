package com.spring.sell.form;

import lombok.Data;

/**
 * @Author yanghan
 * @create 2019/6/27 14:41
 */
@Data
public class CategoryForm {
    private Integer categoryId;

    /**类目名字*/
    private String categoryName;

    /**类目编号*/
    private Integer categoryType;
}
