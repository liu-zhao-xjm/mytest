package com.test;

import java.lang.reflect.Method;

public class Demo4 {
	public static void main(String[] args) throws Exception {
		//�Ȼ�ȡStus��jvm�е�Class����
		Class stusClass= Class.forName("reflect.Stus");
		//ʹ��Stus��Class�����newInsta..()��ȡ�����
		Object stusObject= stusClass.newInstance();
		//ʹ��Stus��Class�����getMethod�������õ��÷��������ƺͲ�������
		Method detailsStusMethod= stusClass.getMethod("detailsStus");
		detailsStusMethod.invoke(stusObject);
		//
		System.out.println("============================");
		Method getAgeByNameMethod= stusClass.getMethod("getAgeByName", String.class);
		int age=(int) getAgeByNameMethod.invoke(stusObject, "admin");
		System.out.println(age);
	}
}

class Stus{
	public void detailsStus(){
		System.out.println("bdqn....");
	}
	
	public int getAgeByName(String name){
		return 123;
	}
}
