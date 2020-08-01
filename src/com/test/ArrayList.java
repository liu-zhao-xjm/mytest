package com.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ArrayList {
    /*
    * 、采用反射创建arrayList对象并存储三个值，在输出

*/
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class aClass=Class.forName("java.util.ArrayList");
        //獲取所有的方法
        Object arrayList=aClass.newInstance();
        //設置添加的數據類型
        Method setMethod=aClass.getMethod("add",Object.class);
        setMethod.invoke(arrayList,"1");
        setMethod.invoke(arrayList,"2");
        setMethod.invoke(arrayList,"3");
        //读取储存的值
       Method getMethod=aClass.getMethod("get",int.class);
        System.out.println(getMethod.invoke(arrayList,0));
        System.out.println(getMethod.invoke(arrayList,1));
        System.out.println(getMethod.invoke(arrayList,2));
    }

}
