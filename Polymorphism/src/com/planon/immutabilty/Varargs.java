package com.planon.immutabilty;

public class Varargs {

	 static void varArgsDisplay(String studentName, int ...marks)
	{
		int studentMarks = 0;
		for(int i :marks)
		studentMarks = studentMarks +i;
		System.out.println("Marks for student "+studentName+" is "+ studentMarks);
	}
	
	public static void main(String[] args)
	{
		varArgsDisplay("Vineetha",1,2,3);
		varArgsDisplay("Sai",10, 20, 30, 40 ,50);
	}
}
