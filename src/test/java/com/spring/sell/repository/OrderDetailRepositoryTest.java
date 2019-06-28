package com.spring.sell.repository;

import com.spring.sell.dataobject.OrderDetail;
import com.spring.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author yanghan
 * @create 2019/6/19 10:01
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;
    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("11111");
        orderDetail.setOrderId("1234567");
        orderDetail.setProductId("111111");
        orderDetail.setProductIcon("hppt://xxxx.jpg");
        orderDetail.setProductName("皮蛋瘦肉粥");
        orderDetail.setProductPrice(new BigDecimal(5.6));
        orderDetail.setProductQuantity(2);
        OrderDetail result =  repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId(){
        List<OrderDetail> result = repository.findByOrderId("1234567");
        Assert.assertNotEquals(0,result.size());

    }

}