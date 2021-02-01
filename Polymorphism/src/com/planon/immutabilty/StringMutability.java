package com.planon.immutabilty;

public class StringMutability {

	 public static void StrConcat(String str1) 
	    { 
	        str1 = str1.concat(" Immutability"); 
	    } 
	   
	    public static void StrBufConcat(StringBuffer str2) 
	    { 
	        str2.append(" Immutability"); 
	    }	   
	    public static void StrBuildConcat(StringBuilder str3) 
	    { 
	        str3.append(" Immutability"); 
	    } 
	    public static void main(String[] args) 
	    { 
	        String str1 = "Testing"; 
	        StrConcat(str1);
	        System.out.println("The final String is " + str1);
	        str1 = str1.concat(str1);
	        System.out.println("The final String is " + str1);
	        
	        StringBuffer str2 = new StringBuffer("Testing"); 
	        StrBufConcat(str2);
	        System.out.println("The final String is " + str2); 
	   
	        StringBuilder str3 = new StringBuilder("Testing"); 
	        StrBuildConcat(str3);
	        System.out.println("The final String is " + str3); 
	    } 
}
