package com.spring.sell.utils;

import java.util.Random;

/**
 * @Author yanghan
 * @create 2019/6/19 11:29
 */
public class KeyUtil {
    /***
     * 生成唯一主键
     * 格式时间+随机数
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        System.currentTimeMillis();
        Integer number = random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
