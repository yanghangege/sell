package com.spring.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author yanghan
 * @create 2019/6/22 15:05
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    /**公众号ID*/
    private String mpAppId;
    /**公众号密匙*/
    private String mpAppSecret;
    /**开放平台ID*/
    private String openAppId;
    /**开放平台ID*/
    private String openAppSecret;
    /**商户号*/
    private String mchId;
    /**商户密匙*/
    private String mchKey;
    /**商户证书路径*/
    private String keyPath;
    /**异步通知地址*/
    private String notifyUrl;
    /**微信模板ID*/
    private Map<String,String> templateId;
}
