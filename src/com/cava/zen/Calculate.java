package com.cava.zen;

import java.awt.*;
import java.awt.List;
import java.util.Scanner;

public class Calculate {
	private static final List list=new List();
	/**
	 * @see
	 *whether change "-" into "+0-"or"0-"(if the first char is a "-",then change it)
	 *if change,change it ,if not,pass it.
	 *这里的list抽风了，只要出现Exception异常并且出现后没有点过Last，它就会无法加载数据。
	 */
	public static String ChangeFir(String desc){
		StringBuilder temp=new StringBuilder("0-"+desc.substring(1, desc.length()));
		desc=temp.toString();
		return desc;
	}
	public static String plus(String[] first){
		double sum=0;
		for(int i=0;i<first.length;i++){
			if(first[i].contains("x")){
				first[i]=Calculate.multiply(first[i].split("x"));
			}else if(first[i].contains("/")){
				first[i]=Calculate.divide(first[i].split("/"));
			}else{}
			sum+=Double.parseDouble(first[i]);
		}
		return String.valueOf(sum);
	}
	public static String multiply(String[] second){
		double product=1;
		for(int i=0;i<second.length;i++){
			if(second[i].contains("/")){
				second[i]=Calculate.divide(second[i].split("/"));
			}
			product*=Double.parseDouble(second[i]);
		}
		return String.valueOf(product);
	}
	public static String divide(String[] third){
		double quotient=Math.pow(Double.parseDouble(third[0]), 2);
		for(int i=0;i<third.length;i++){
			quotient=quotient/Double.parseDouble(third[i]);
		}
		return String.valueOf(quotient);
	}
	public static void play(){
		if(Calculate.list.getItemCount()==100){
			for(int i=0;i<=Calculate.list.getItemCount()-11;i--){
				Calculate.list.remove(i);
			}
		}
		try{
			String desc=Transport.getPro2();
			String result=new String();
			if(desc.contains("-")){
				char firAr=desc.charAt(0);
				if(firAr=='-'){
					desc=Calculate.ChangeFir(desc);
				}
				desc=desc.replaceAll("-",	"\\+-");
			}
			desc=desc.replaceAll("\\*","x");
			if(desc.contains("+"))
				result=Calculate.plus(desc.split("\\+"));
			else if(desc.contains("x")||desc.contains("/"))
				result=Calculate.plus(("0+"+desc).split("\\+"));
			else{result="输入运算符，谢谢";}
			if(!result.equals("输入运算符，谢谢")){
				Calculate.list.add(result);
			}
			Calculate.print(result);
		}catch(Exception e){
			String result="你的问题很神奇！";
			Calculate.print(result);
		}
	}
	public static void print(String result){
		Transport.getAns1(result);
	}
	public static String last(){
		StringBuffer result=new StringBuffer();
		for(int i=Calculate.list.getItemCount()-1;i>=0;i--){
			result.append(Calculate.list.getItem(i)+" ; ");
			if(i>9){
				break;
			}
		}
		return result.toString();
	}
}
