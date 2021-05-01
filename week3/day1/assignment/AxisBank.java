package week3.day1.assignment;

/*
 * Assignment3:
============
    Class     :BankInfo
    Methods :saving(),fixed(),deposit()

     Class     :AxisBank
     Methods :deposit()

Description:
You have to override the method deposit in AxisBank.
 * 
 */

public class AxisBank extends BankInfo{
	
	public void deposit()
	{
		System.out.println("deposit from Axis bank-override method");
	
}
	public static void main(String[] args)
	{
		AxisBank obj=new AxisBank();
		obj.deposit();
		obj.saving();
		obj.fixed();
	}
	
}

	
