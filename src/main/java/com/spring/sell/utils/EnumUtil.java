package com.spring.sell.utils;

import com.spring.sell.enums.CodeEnum;

/**
 * @Author yanghan
 * @create 2019/6/26 14:38
 */
public class EnumUtil {
    public static <T extends CodeEnum>T getByCode(Integer code, Class<T>enumClass){
        for (T each : enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
