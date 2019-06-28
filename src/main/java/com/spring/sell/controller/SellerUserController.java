package com.spring.sell.controller;

import com.spring.sell.config.ProjectUrlConfig;
import com.spring.sell.constant.CookieConstant;
import com.spring.sell.constant.RedisConstant;
import com.spring.sell.dataobject.SellerInfo;
import com.spring.sell.enums.ResultEnum;
import com.spring.sell.service.SellerService;
import com.spring.sell.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author yanghan
 * @create 2019/6/27 16:30
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {
    @Autowired
    private SellerService sellerService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private ProjectUrlConfig projectUrlConfig;
    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid")String openid,
                      HttpServletResponse response,
                      Map<String,Object>map){
        //1.openid 去和数据库里面的数据匹配
        SellerInfo sellerInfo = sellerService.findSellerByOpenid(openid);
        if(sellerInfo == null){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessages());
            map.put("url","/sell/seller/order/list");
            return new  ModelAndView("common/error");
        }
        //2.设置token置rides
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openid,expire, TimeUnit.SECONDS);
        //3.设置token置cookie
        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/seller/order/list");
    }
    @GetMapping("/logon")
    public ModelAndView logon(HttpServletRequest request,
                      HttpServletResponse response,
                      Map<String,Object> map){
        //1.从cookie里查询
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if ( cookie != null){
            //2.清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            //3.清除cookie
            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessages());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("/common/success",map);

    }
}
