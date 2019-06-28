package com.spring.sell.repository;

import com.spring.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductinfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo>findByProductStatus(Integer productStatus);

}
