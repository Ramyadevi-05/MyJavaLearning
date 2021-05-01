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

public class College extends University{
	
	public static void main(String[] args)
	{
		College obj=new College();
		obj.pg();
		obj.ug();
	}

	
	@Override
	public void ug() {
		System.out.println("ug method--unimplemented method from university class.. implemented in College class");
	}

}
