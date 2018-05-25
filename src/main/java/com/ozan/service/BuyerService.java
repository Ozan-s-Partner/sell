package com.ozan.service;


import com.ozan.dto.OrderDTO;

/**
 * 买家
 * Created by Ozan
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
