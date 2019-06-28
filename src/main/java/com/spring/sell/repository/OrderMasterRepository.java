package com.spring.sell.repository;

import com.spring.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author yanghan
 * @create 2019/6/18 18:42
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String >{

    Page<OrderMaster> findByBuyerOpenid (String buyerOpenid, Pageable pageable);

}
