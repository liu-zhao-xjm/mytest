package com.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Demo3 {
	public static void main(String[] args) throws Exception{
		List list=new ArrayList();
		list.add("admin");
		System.out.println(list.get(0));
		//û�д�������
		//���÷�����ʱ����һ��������ǲ�������
		System.out.println("---------------------------");
		Class arrayListClass= Class.forName("java.util.ArrayList");
		//List arrayListObject= (List)arrayListClass.newInstance();
		Object arrayListObject= arrayListClass.newInstance();
		
		Method addMethod= arrayListClass.getMethod("add", Object.class);
		
		addMethod.invoke(arrayListObject, "admin");
		
		Method getMethod=arrayListClass.getMethod("get", int.class);
		
		System.out.println(getMethod.invoke(arrayListObject, 0));
	}
}






