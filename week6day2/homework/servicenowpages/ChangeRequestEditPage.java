package week6day2.homework.servicenowpages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import week6day2.homework.servicenowhooks.ServiceNowHooks;

public class ChangeRequestEditPage extends ServiceNowHooks{
	
	public ChangeRequestEditPage toSelectAssessGroup()
	{
		//Assess the Change Request
		
		WebElement selectState=driver.findElementById("change_request.state");
		selectState.click();
		Select selectStateValue = new Select(selectState);
		List<WebElement> Statevalues = selectStateValue.getOptions();
		int size = Statevalues.size();
		System.out.println(size);					
		selectStateValue.selectByVisibleText("Assess");
		return this;
	}

	public ChangeRequestEditPage toSelectAssignmentGroup()
	{
		// To Select Assignment Group
					driver.findElementByXPath("//button[@name='lookup.change_request.assignment_group']").click();
					// To get the window handles

					Set<String> allWindowHandles = driver.getWindowHandles();
					System.out.println(allWindowHandles.size());

					// To get the second window handle and switch to it

					List<String> lstWindows = new ArrayList<String>(allWindowHandles);
					System.out.println(lstWindows.size());

					String firstwindow = lstWindows.get(1);

					driver.switchTo().window(firstwindow);

					System.out.println(driver.getCurrentUrl());
					String title = driver.getTitle();
					System.out.println(title);
					if (title.equals("Change Request | ServiceNow")) {
						System.out.println("Title is matched");
					} else {
						System.out.println("Title is not matched");
					}
					driver.findElementByXPath("//a[text()='Software']").click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					driver.switchTo().window(lstWindows.get(0));
					driver.switchTo().frame("gsft_main");
					return this;

	}
	
	public ChangeRequestEditPage toSelectAssignedGroup()	
	{
		// To Select Assigned To Value
		driver.findElementByXPath("//input[@id='sys_display.change_request.assigned_to']").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElementByXPath("//input[@id='sys_display.change_request.assigned_to']").sendKeys("IT");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElementByXPath("//input[@id='sys_display.change_request.assigned_to']").sendKeys(Keys.TAB);
	
	return this;
}
	
	public SearchPage toUpdateCR()
	{
		driver.findElementById("sysverb_update").click();
		return new SearchPage();
	}	
	
	public ChangeRequestEditPage toEnterChangeScheduleStartAndEndDate()
	{
		//Update schedule for the existing Change
		
		driver.findElementByXPath("//span[@class=\"tab_caption_text\" and text()='Schedule']").click();
		
		driver.findElement(By.xpath("//span[@class='icon-calendar icon']")).click();
		
		driver.findElement(By.id("GwtDateTimePicker_ok")).click();
		
		driver.findElement(By.xpath("(//span[@class='icon-calendar icon'])[2]")).click();
		
		driver.findElement(By.id("GwtDateTimePicker_ok")).click();
		
		String PlannedStartDate=driver.findElementById("change_request.start_date").getAttribute("value");
		System.out.println("Selected Planned Start date:"+PlannedStartDate);
		
		String PlannedEndDate=driver.findElementById("change_request.end_date").getAttribute("value");
		System.out.println("Selected Planned End date:"+PlannedEndDate);
		
		return this;
	}
	
	public ChangeRequestEditPage toEnterCABRequired()
	{
		driver.findElementById("label.ni.change_request.cab_required").click();
		return this;
	}
	
	public ChangeRequestEditPage toEnterCABDate()
	{
		driver.findElementById("change_request.cab_date.ui_policy_sensitive").click();
		//To select today's date 
		driver.findElementByXPath("//td[@class='calText calTodayText pointerhand']").click();
		
		String CAB_Date=driver.findElementById("change_request.cab_date").getAttribute("value");
		System.out.println("Selected CAB Date:"+CAB_Date);
		return this;
	}

}




