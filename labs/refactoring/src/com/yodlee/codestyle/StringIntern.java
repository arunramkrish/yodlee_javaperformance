package com.yodlee.codestyle;

public class StringIntern {

	public static void main(String[] args) {
		String str1 = "string intern";
		String str2 = new String("string intern");
		
		System.out.println(str1 == str2.intern());

	}

}