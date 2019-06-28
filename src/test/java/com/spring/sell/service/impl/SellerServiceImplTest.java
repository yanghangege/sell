package com.spring.sell.service.impl;

import com.spring.sell.dataobject.SellerInfo;
import com.spring.sell.repository.SellerInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author yanghan
 * @create 2019/6/27 15:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellerServiceImplTest {

    private static final String openid = "abc";
    @Autowired
    private SellerServiceImpl sellerService;
    @Test
    public void findSellerByOpenid() {
        SellerInfo sellerInfo = sellerService.findSellerByOpenid(openid);
        Assert.assertEquals(openid,sellerInfo.getOpenid());
    }
}