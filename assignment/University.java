package week3.day1.assignment;

/*Assignment 2:
     AbstractClass     :University
     Methods              : pg()(implemented method), ug() (unimplemented method)

     Class        :College extends University
     Methods   :ug()

Description:
ug() is just a templete in University Abstract class and You have to implement the method ug() in College class.
Execute both ug() & pg()
 * 
 * 
 * 
 */
public abstract class University {
	
	public void pg()
	 {
		 System.out.println("Completed method::Implemented method");
	 }

	public abstract void ug();
	
}
