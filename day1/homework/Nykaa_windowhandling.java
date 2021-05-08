package week4.day1.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa_windowhandling {

	public static void main(String[] args) throws InterruptedException {

		//	1) Go to https://www.nykaa.com/
		
		WebDriverManager.chromedriver().setup();
		
		// to disable notifications
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//2) Mouse over on Brands and Mouse over on Popular
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='brands']")))
				.perform();
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Popular']")))
		.perform();
		
		//3) Click L'Oreal Paris
		driver.findElement(By.xpath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']")).click();
		
		//4) Go to the newly opened window and check the title contains L'Oreal Paris
		
		//To get the window handles 
		
		Set<String> allWindowHandles=driver.getWindowHandles();
		System.out.println(allWindowHandles.size());
		
		//  To get the second window handle and switch to it
		
		List<String> lstWindows=new ArrayList<String>(allWindowHandles);
		System.out.println(lstWindows.size());
		
		String firstwindow=lstWindows.get(1);
		driver.switchTo().window(firstwindow);
		Thread.sleep(1000);
		System.out.println(driver.getCurrentUrl());
		String title = driver.getTitle();
		if(title.equals("L'Oreal Paris - Buy L'Oreal Paris Products Online at Best Price | Nykaa"))
		{
			System.out.println("Title is matched");
		}else
		{
			System.out.println("Title is not matched");
		}
		Thread.sleep(1000);
		//5) Click sort By and select customer top rated
		driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		//6) Click Category and click Shampoo
		
		driver.findElement(By.xpath("//div[text()='Category']")).click();	
		driver.findElement(By.xpath("//li[@class='filter-list-header  ']")).click();
		driver.findElement(By.xpath("(//div[@class='filter-options-toggle'])[2]")).click();		
		driver.findElement(By.xpath("//div[@class='control__indicator']")).click();
		//7) check whether the Filter is applied with Shampoo
		
		String selection=driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']//li[text()='Shampoo']")).getText();
		
		if(selection.equalsIgnoreCase("Shampoo"))
		{
			System.out.println("");
		}else
		{
			
		}
		
		//8) Click on L'Oreal Paris Colour Protect Shampoo
		//9) GO to the new window and select size as 175ml
		//10) Print the MRP of the product
		//11) Click on ADD to BAG
		//12) Go to Shopping Bag 
		//13) Print the Grand Total amount
		//14) Click Proceed
		//15) Click on Continue as Guest
		//16) Check if this grand total is the same in step 13
		//17) Close all windows
		
	}

}
