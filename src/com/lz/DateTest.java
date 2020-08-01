package com.lz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);
        /*将日期装换成字符串*/
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年-MM月-dd日 HH:mm:ss");
        String s=sdf.format(date);
        System.out.println(s);

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
        String s1="2020-06-02";
        Date date1=new Date(s1);
        System.out.println(date1);
    }
}
