package com.springboot.common.util;

import java.util.UUID;

/**
 * @Author: chenkai
 * @Date: 2018/8/8 17:24
 * @Description:
 */
public class UUIDGenerator {
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str;
    }

    public static String getUUIDSlip() {
        StringBuilder buffer = new StringBuilder();
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        buffer.append(str.substring(0, 8))
                .append(str.substring(9, 13))
                .append(str.substring(14, 18))
                .append(str.substring(19, 23))
                .append(str.substring(24));
        return buffer.toString();
    }

    //获得指定数量的UUID
    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }
}
