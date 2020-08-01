package com.test;

import org.omg.CORBA.INTERNAL;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo5 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
       Class c =Class.forName("com.test.Teacher");
       //將Class 轉換成 方法的接口
        Object o=c.newInstance();
        //獲取所有的方法
        Method method1=c.getMethod("say",String.class);
        String say=(String) method1.invoke(o,"劉朝");
        System.out.println(say);
        Method method2=c.getMethod("run", int.class);
        method2.invoke(o,11);
        Method method3=c.getMethod("smile");
        method3.invoke(o);
        Method method4=c.getMethod("pay",int.class);
       int pay=(int) method4.invoke(o,12);
        System.out.println(pay+"金額");

    }

}

class Teacher {
    public String say(String msg)
    {
        return "老师说："+msg;
    }

    public void run(int firstFloor)
    {
        System.out.println("老师说要27班级学员从"+firstFloor+"层开始跑到顶楼");
    }

    public void smile()
    {
        System.out.println("学生跑老师在顶楼笑");
    }

    public int pay(int money)
    {
        return money;
    }
}

