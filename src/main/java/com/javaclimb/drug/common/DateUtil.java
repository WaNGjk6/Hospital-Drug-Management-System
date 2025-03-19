package com.javaclimb.drug.common;

import java.text.SimpleDateFormat;
import java.util.Date;



public class DateUtil {

    public static String dateConvert(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(date);
        return s;
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.dateConvert(new Date()));
    }
}
