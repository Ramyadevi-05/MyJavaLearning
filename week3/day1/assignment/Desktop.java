package week3.day1.assignment;

/*
 * 
 * Assignment 1:
     Interface :HardWare
     Methods   :hardwareResources()

     Interface :Software
     Methods   :softwareResources()

     Class     :Desktop
     Methods   :desktopModel()

Description:
create 2 Interface and archieve multiple inheritance.

 * 
 */
public class Desktop implements HardWare,Software{

	public void softwareResources() {
		System.out.println("Software resources");		
	}
	
	public boolean hardwareResources() {
		return true;
	}
	
	public static void main(String[] args)
	{
		Desktop o=new Desktop();
		o.softwareResources();
		o.hardwareResources();
	}

}
