package com.test;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		// ��ȡjvm��Class����ķ�����
		// 1��Object��getClass()
		// 2��Class.forName()

		// ����String���������ո�����Object������Ҳӵ��getClass����
		String str = "bdqn";
		Class strClass = str.getClass();
		System.out.println(strClass.isInterface());
		System.out.println(strClass.getName());
		System.out.println(strClass.getSuperclass().getName());
		System.out.println("----------------------------------");

		Class stringClass = Class.forName("java.lang.String");
		System.out.println(stringClass.isInterface());
		System.out.println(stringClass.getName());
		System.out.println(stringClass.getSuperclass().getName());

	}
}
