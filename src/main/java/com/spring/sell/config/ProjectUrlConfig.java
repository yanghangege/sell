package com.spring.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author yanghan
 * @create 2019/6/27 16:25
 */
@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProjectUrlConfig {
    /**微信公众平台授权url*/
    public String wechatMpAuthorize;
    /**微信开放平台授权url*/
    public String wechatOpenAuthorize;
    /**点餐系统*/
    public String sell;
}
