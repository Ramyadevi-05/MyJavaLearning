package week3.day1.assignment;

/*
 * 
 * POLYMORPHISM
Assignment 1:
Create class Calculator with below methods
- 2 methods for add, 1 method with 2 int args , 1 method with 3 int args
- 2 methods for multiply, 1 method with 2 int args, 1method with 1 int and 1 double args
- 2 methods for subtract, 1 method with 2 int args , 1 method with 2 double args
- 2 methods to divide , 1 method with 2 int args, one to divide one double number with one int
create object for the Calculator class and execute all the methods
 * 
 * 
 */

public class Calculator {

	public void add(int a,int b)
	{
		int c= a+b;	
		System.out.println(c);
	}
	
	public void add(int a,int b, int c)
	{
		int d= a+b+c;
		System.out.println(d);
	}
	
	public void multiply(int a, int b)
	{
		int c= a*b;
		System.out.println(c);
	}
	
	public void multiply(int a, double b)
	{
		double c= a*b;
		System.out.println(c);
	}
	public void subtract(int a,int b)
	{	
		if(a>b)
		{
		int c= a-b;
		System.out.println(c);
	}else
	{
		int c= b-a;
		System.out.println(c);
	}
	}
	
	public void subtract(double a,double b)
	{	
		if(a>b)
		{
		double c=a-b;
		System.out.println(c);
	}else
	{
		double c=a-b;
		System.out.println(c);
	}
	}
	
	public void divide(int a,int b)
	{
		int c= a/b;
		System.out.println(c);
	}
	
	public void divide(int a, double b)
	{
		System.out.println("Divide");
		double c=a/b;
		System.out.println(c);
	}
	
public static void main(String[] args)
{
	Calculator c=new  Calculator();
	System.out.println("Inside main");
	c.add(1, 2);
	c.add(1, 2, 3);
	c.divide(344442, 34444);
	c.divide(40, 20);
	c.multiply(10, 223232);
	c.multiply(4, 4);
	c.subtract(2323212, 12);
	c.subtract(99, 9);
	
}


}
