package com.sys.appstore.utils;

import java.text.SimpleDateFormat;
import java.util.Random;

public class IDGenerator {

    public synchronized static String idGenerator() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.toString() + IDGenerator.getRandom(4);
    }

    public static String getRandom(int strLen) {
        Random rm = new Random();
        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLen);
        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);
        // 返回固定的长度的随机数
        return fixLenthString.substring(1, strLen + 1);
    }

}
