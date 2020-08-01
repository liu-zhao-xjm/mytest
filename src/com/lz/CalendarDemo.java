package com.lz;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    //日历对象
    public static void main(String[] args) {


        Calendar calendar = Calendar.getInstance();//调应calendar类的静态方法
        Date date = calendar.getTime();//通过日历获取一个date对象
        calendar.add(Calendar.YEAR,-1);
        System.out.println(calendar.get(Calendar.YEAR));
/*修改日历时间*/
        Calendar calendar1 = Calendar.getInstance();//调应cale
        calendar1.set(2020,1,22,11,20,10);


    }

}
