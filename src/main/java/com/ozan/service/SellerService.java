package com.ozan.service;

import com.ozan.dataobject.SellerInfo;

/**
 * @author Ozan
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
