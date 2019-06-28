package com.spring.sell.utils;

import com.spring.sell.VO.ResultVo;

import javax.xml.transform.Result;

/**
 * @Author yanghan
 * @create 2019/6/18 16:37
 */
public class ResultVOUtil {
    public static ResultVo success(Object object){
        ResultVo resultVo = new ResultVo();
        resultVo.setData(object);
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return resultVo;
    }
    public static ResultVo success(){
        return success(null);
    }
    public static ResultVo error(Integer code,String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }
}
