package com.spring.sell.utils;

import com.google.common.math.DoubleMath;
import com.sun.org.apache.xpath.internal.operations.Equals;

/**
 * @Author yanghan
 * @create 2019/6/25 17:12
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;
    /***
     * 比较两个金额是否相等
     * @param d1
     * @param d2
     * @return
     */
    public static boolean equals(Double d1, Double d2)
    {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE){
            return true;
        }else {
            return false;
        }
    }
}
