package com.test.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {


    public static String date2String(Date date,String str){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        String s = simpleDateFormat.format(date);
        return s;
    }

    public static Date string2Date(Date date,String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        Date parse = simpleDateFormat.parse(str);
        return parse;
    }
}
