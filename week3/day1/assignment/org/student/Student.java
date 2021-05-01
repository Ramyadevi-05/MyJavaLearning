package week3.day1.assignment.org.student;

import week3.day1.assignment.org.department.Department;

/*
 * 
 * 
 * Assignment2:
=============
     Package   :org.college
     Class        :College
     Methods   :collegeName(),collegeCode(),collegeRank()

     Package   :org.department
     Class        :Department
     Methods   :deptName()
 
     Package   :org.student
     Class        :Student
     Methods   :studentName(),studentDept(),studentId()
  
Description:
create above 3 class and call all your class methods into the Student using multilevel inheritance.
 */

public class Student extends Department{

public void studentName() {
		
		System.out.println("Inside studentName method of Student Class");

	}
	
	
	public void studentDept()
	{
		System.out.println("Inside studentDept method of Student Class");

	}
	
	public void studentId()
	{
		System.out.println("Inside studentId method of Student Class");
	}
	
	
public static void main(String[] args)
{
	Student ref=new Student();
	ref.collegeCode();
	ref.collegeName();
	ref.collegeRank();
	ref.deptName();
	ref.studentDept();
	ref.studentId();
	ref.studentName();
	
	
}
}
