package com.ozan.service.impl;

import com.ozan.config.WechatAccountConfig;
import com.ozan.dto.OrderDTO;
import com.ozan.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ozan
 * 2017-07-30 22:09
 *
 * @author Think
 */
@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WechatAccountConfig accountConfig;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        //WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        WxMpTemplateMessage templateMessage= WxMpTemplateMessage.builder().build();
        templateMessage.setTemplateId(accountConfig.getTemplateId().get("orderStatus"));
        templateMessage.setToUser(orderDTO.getBuyerOpenid());

/*        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first", "亲，请记得收货。"),
                new WxMpTemplateData("keyword1", "微信点餐"),
                new WxMpTemplateData("keyword2", "18868812345"),
                new WxMpTemplateData("keyword3", orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4", orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword5", "￥" + orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark", "欢迎再次光临！")
        );
        templateMessage.setData(data);*/

        templateMessage.addWxMpTemplateData(new WxMpTemplateData("first", "亲，请记得收货。"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword1", "微信点餐"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword2", "18868812345"));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword3", orderDTO.getOrderId()));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword4", orderDTO.getOrderStatusEnum().getMessage()));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("keyword5", "￥" + orderDTO.getOrderAmount()));
        templateMessage.addWxMpTemplateData(new WxMpTemplateData("remark", "欢迎再次光临！"));
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模版消息】发送失败, {}", e);
        }
    }
}
