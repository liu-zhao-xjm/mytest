package com.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HasMap {
    /*
    * 3、采用发射创建HashMap对象并存储三个值，在输出
    * */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Map map=new HashMap();
        map.put("1",1);
        map.get("1");
      Class hashMap= Class.forName("java.util.HashMap");
        //获取map所有的方法
        Object o=hashMap.newInstance();
        //指定单个方法
        Method setMethod=hashMap.getMethod("put", Object.class, Object.class);
        setMethod.invoke(o,"lz","123");
        setMethod.invoke(o,"kk","123");
        setMethod.invoke(o,"zz","123");
        //读取
        Method getMethod=hashMap.getMethod("get", Object.class);
        System.out.println(  getMethod.invoke(o,"lz"));
        System.out.println( getMethod.invoke(o,"zz"));
        System.out.println( getMethod.invoke(o,"kk"));
    }
}
