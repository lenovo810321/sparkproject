package com.tongling.util;

import java.math.BigDecimal;

/**
 * 数字工具类
 * 可以根据传入的参数得到保留相应位数的小数
 * Created by 张宝玉 on 2018/10/9.
 */

public class NumberUtils {

    /**
     * 格式化小数
     * @param num 数字
     * @param scale 四舍五入的位数
     * @return
     */
    public static double formatDouble(double num, int scale) {
        BigDecimal bd = new BigDecimal(num);
        return bd.setScale(scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
