package com.spring.sell.handler;

import com.spring.sell.VO.ResultVo;
import com.spring.sell.config.ProjectUrlConfig;
import com.spring.sell.exception.ResponseBankException;
import com.spring.sell.exception.SellException;
import com.spring.sell.exception.SellerAuthorizeException;
import com.spring.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author yanghan
 * @create 2019/6/28 10:20
 */
@ControllerAdvice
public class SellExceptionHandler {
    @Autowired
    private ProjectUrlConfig projectUrlConfig;
    //登陆拦截异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        //拼接地址，如果查询不到token 或者cookie 就会跳转到下面的扫码界面
        return new ModelAndView("redirect:"
        .concat(projectUrlConfig.getWechatOpenAuthorize())
        .concat("/sell/wechat/qrAuthorize")
        .concat("?returnUrl=")
        .concat(projectUrlConfig.getSell())
        .concat("/sell/seller/login"));
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVo handlerSellException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }
    //捕获的异常类
    @ExceptionHandler(value = ResponseBankException.class)
    //定义上面捕获的异常类所提示的错误码
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleResponseBankException(){

    }
}
