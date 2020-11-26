package com.selenium.webobject;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="ABCD$#67.88";
		
		String test=str.replaceAll("[A-Za-z$#]", "");
		
		System.out.println(test);

	}

}
