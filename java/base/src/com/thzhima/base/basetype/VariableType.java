package com.thzhima.base.basetype;

import java.util.Date;

public class VariableType {

	public static void main(String[] args) {
		// Java 中有8种基本数据类型
		// 数值
		//整数
		byte b = 127; //字节类型 ，占一个字节。
		short s = 32767; // 短整型，占两个字节。
		int i = (int)9999L; //整型，占4字节。32位。
		long l = i; // 长整型，占8字节，64位。
		//小数
		float fl = 3.14F; // 32位
		double d = 3.24;   // 64位
		
		long ll = (long) fl;
		
		
		// 字符,只能存储一个字符。无论中英文。字符类型为单引号括起来表示。双绰号只用于字符串。
		char c = 'A'+1;
		
		// 布尔 ,在Java 中只有两个值，true,false.不能由其它的任何数据类型转换得来。
		boolean f = false;
		boolean t = true;
		
		
		// 
		long max = Long.MAX_VALUE;
		System.out.println(max);
		
		float about = max;
		System.out.println(about);
		
		int aaa = 'c';
		
		System.out.println(c);
		
//		System.out.println("1" ==  1);
		Object o = new Date();
		System.out.println(o instanceof Date);
       		
	}
	
}
