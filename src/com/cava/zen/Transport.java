package com.cava.zen;

public class Transport {
	public static String desc=new String();
	public static String resu=new String(); 
	public static void getPro1(String des){
		desc=des;
	}
	public static String getPro2(){
		return desc;
	}
	public static void getAns1(String res){
		resu=res;
	}
	public static String getAns2(){
		return resu;
	}
	
}
