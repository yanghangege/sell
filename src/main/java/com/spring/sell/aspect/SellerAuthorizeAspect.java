package com.spring.sell.aspect;

import com.spring.sell.constant.CookieConstant;
import com.spring.sell.exception.SellException;
import com.spring.sell.exception.SellerAuthorizeException;
import com.spring.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author yanghan
 * @create 2019/6/28 10:06
 */
//@Aspect
//@Component
//@Slf4j
//public class SellerAuthorizeAspect {
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//    //希望每个登陆都做一个用户信息确认，所以用aop做了一个切面
//    @Pointcut("execution(public * com.spring.sell.controller.Seller*.*(..))" +
//    "&& !execution(public * com.spring.sell.controller.SellerUserController.*(..))")
//    public void verify(){
//
//    }
//    @Before("verify()")
//    public void doVerify(){
//        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        //通过request查询cookie
//        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
//        if (cookie == null){
//            log.warn("[登陆校验]Cookie中查不到token");
//            //查询不通过抛出这个异常，然后再SellExceptionHandler 来捕获这个异常
//            throw new SellerAuthorizeException();
//        }
//        //去redis里面查询
//        String tokenValue = redisTemplate.opsForValue().get(String.format(CookieConstant.TOKEN,cookie.getValue()));
//        if (StringUtils.isEmpty(tokenValue)){
//            log.warn("[登陆校验]Redis 中查不到token");
//            throw new SellerAuthorizeException();
//        }
//    }
//}
