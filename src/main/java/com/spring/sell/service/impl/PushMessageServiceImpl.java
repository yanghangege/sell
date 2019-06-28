package com.spring.sell.service.impl;

import com.spring.sell.config.WechatAccountConfig;
import com.spring.sell.dto.OrderDTO;
import com.spring.sell.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Author yanghan
 * @create 2019/6/28 10:59
 */
@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {
    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private WechatAccountConfig accountConfig;
    @Override
    public void orderStatus(OrderDTO orderDTO){
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();

        templateMessage.setTemplateId(accountConfig.getTemplateId().get("orderStatus"));
        templateMessage.setToUser("oK4k31rwDXXOL3FN5o5P7hn6QITw");
        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first","收货"),
                new WxMpTemplateData("keyword1","微信订餐"),
                new WxMpTemplateData("keyword2","18647854644"),
                new WxMpTemplateData("keyword3",orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4",orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword5","￥" + orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark","欢迎再次！")
        );
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);

        }catch (WxErrorException e){
            log.error("[微信模板信息]发送失败，{}",e);
        }
    }
}
