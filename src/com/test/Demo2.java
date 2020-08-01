package com.test;

import java.lang.reflect.Method;

public class Demo2 {
	public static void main(String[] args) {
		String str="bdqn";
		Class strClass=str.getClass();
		//strMethod�洢��strClass�����е����з�����������
		Method [] strMethod= strClass.getMethods();
		System.out.println(strMethod.length);
		for (Method m : strMethod) {
			System.out.println(m.getName());
		}
		//���÷����ȡArrayList���е����з�������
		
	}
}
