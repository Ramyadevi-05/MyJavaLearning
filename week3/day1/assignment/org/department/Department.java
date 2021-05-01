package week3.day1.assignment.org.department;

import week3.day1.assignment.org.college.College;

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

public class Department extends College{


public void deptName() {
	System.out.println("deptName from department");
}
}

