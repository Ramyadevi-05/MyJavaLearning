package week3.day1.assignment;


/*
 * 
 * 
 * Assignment4:
==============

      Class: Students
      Methods: getStudentInfo()

Description: 
Create multiple getStudentInfo() method by passing id argument alone, by id & name, by email & phoneNumber
 */

public class Students {

	
	public void getStudentInfo(int id) {
		System.out.println("student id"+" "+id);
	}
	
	public void getStudentInfo(int id, String name) {
		System.out.println("student id and name"+" "+id+" "+name);
	}
	
	public void getStudentInfo(String email,long phonenumber) {
		System.out.println("student email and phonenumber"+" "+email+" "+phonenumber);
	}
	
	public static void main(String[] args)
	{
		Students stu=new Students();
		stu.getStudentInfo(1);
		stu.getStudentInfo(1, "Ramya");
		stu.getStudentInfo("test@zzz.com", 1234563444);
		
	}
	
}
