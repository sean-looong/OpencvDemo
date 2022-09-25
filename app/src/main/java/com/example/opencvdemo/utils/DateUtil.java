package com.example.opencvdemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    /**
     * @return 获取当前日期格式化字符串
     */
    public static String getCurrentDate() {
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        return new SimpleDateFormat(strDateFormat, Locale.CHINA).format(date);
    }
}
