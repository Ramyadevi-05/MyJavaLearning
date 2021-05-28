package week6day2.homework.servicenowpages;

import org.openqa.selenium.By;

import week6day2.homework.servicenowhooks.ServiceNowHooks;

public class LoginPage extends ServiceNowHooks{
	
	
	public LoginPage switchToframeforlogin()
	{
		driver.switchTo().frame(0);
		return this;
		
	}
	
	public LoginPage toEnterUserName(String username)
	{
		driver.findElement(By.xpath("//input[@name='user_name']")).clear();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		return this;
	}
	
	public LoginPage toEnterPassword(String password)
	{
		driver.findElement(By.xpath("//input[@name='user_password']")).clear();
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		return this;
	}
	
	public HomePage clickOnLogin()
	{
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		return new HomePage();
		
	}

}
