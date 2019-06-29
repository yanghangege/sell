package com.spring.sell.dataobject.mapper;

import com.spring.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Author yanghan
 * @create 2019/6/28 15:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ProductCategoryMapperTest {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Test
    public void insertByMap(){
        Map<String,Object>map = new HashMap<>();
        map.put("category_name","active");
        map.put("category_type",1000);
        int result = productCategoryMapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void insertByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("secret");
        productCategory.setCategoryType(102);
        int result = productCategoryMapper.insertByObject(productCategory);
        Assert.assertEquals(1,result);
    }
    @Test
    public void findByCategoryType(){
        ProductCategory productCategory = productCategoryMapper.findByCategoryType(102);
        Assert.assertNotNull(productCategory);
    }
}