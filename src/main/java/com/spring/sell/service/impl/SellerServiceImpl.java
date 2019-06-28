package com.spring.sell.service.impl;

import com.spring.sell.dataobject.SellerInfo;
import com.spring.sell.repository.SellerInfoRepository;
import com.spring.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yanghan
 * @create 2019/6/27 15:30
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRepository repository;
    @Override
    public SellerInfo findSellerByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
