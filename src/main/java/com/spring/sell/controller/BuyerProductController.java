package com.spring.sell.controller;

import com.spring.sell.VO.ProductInfoVO;
import com.spring.sell.VO.ProductVO;
import com.spring.sell.VO.ResultVo;
import com.spring.sell.dataobject.ProductCategory;
import com.spring.sell.dataobject.ProductInfo;
import com.spring.sell.service.CategoryService;
import com.spring.sell.service.ProductService;
import com.spring.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
@CacheConfig(cacheNames = "product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    @Cacheable(key ="123" )
    public ResultVo list(){
        //1.查询所有上架商品
        List<ProductInfo> productInfosList =  productService.findUpAll();
        //2.查询类目（一次查询）
//        List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
//        for (ProductInfo productInfo : productInfosList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法（java8,lambda)
        List<Integer> categoryTypeList = productInfosList.stream()
                .map(e ->e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        List<ProductVO>productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfosList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
