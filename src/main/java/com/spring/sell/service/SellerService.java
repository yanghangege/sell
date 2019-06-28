package com.spring.sell.service;

import com.spring.sell.dataobject.SellerInfo;

/**
 * @Author yanghan
 * @create 2019/6/27 15:27
 */
public interface SellerService {
    /***
     * 通过openid查询
     * @param openid
     * @return
     */
    SellerInfo findSellerByOpenid(String openid);
}
