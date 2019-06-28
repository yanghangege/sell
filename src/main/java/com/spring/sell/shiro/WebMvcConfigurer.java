package com.spring.sell.shiro;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
@EnableWebMvc
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {


    /**
     * 对外暴露的访问路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 注意此路径是要求是页面资源都可访问到的，包括静态资源和jsp或者freemark等模板文件。
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }


}