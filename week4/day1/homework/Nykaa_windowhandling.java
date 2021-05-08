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
		System.out.println(selection);
		if(selection.contains("Shampoo"))
		{
			System.out.println("Filter matches");
		}else
		{
			System.out.println("Filter didnt match");
		}
		
		//8) Click on L'Oreal Paris Colour Protect Shampoo
		
		driver.findElement(By.xpath("(//div[@class='pull-right filter-options-toggle'])[6]")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='layout inline center-center width-full height-full ']//img)[1]")).click();
		
		//9) GO to the new window and select size as 175ml
		
		allWindowHandles=driver.getWindowHandles();
		System.out.println(allWindowHandles.size());
		lstWindows=new ArrayList<String>(allWindowHandles);
		System.out.println(lstWindows.size());
		
		String Secondwindow=lstWindows.get(1);
		driver.switchTo().window(Secondwindow);
		Thread.sleep(1000);
		System.out.println(driver.getCurrentUrl());
		String titleofPurchasePage = driver.getTitle();
		System.out.println(titleofPurchasePage);
		if(titleofPurchasePage.contains("L'Oreal Paris"))
		{
			System.out.println("Title matches and the page loaded is purchase page");
		}else
		{
			System.out.println("Title differs");
		}
		
		//10) Print the MRP of the product
		
		System.out.println("Price:"+driver.findElement(By.xpath("(//span//span[@class='post-card__content-price-offer'])[1]")).getText().replaceAll("\\D", ""));
		
		allWindowHandles=driver.getWindowHandles();
		System.out.println(allWindowHandles.size());
		lstWindows=new ArrayList<String>(allWindowHandles);
		System.out.println(lstWindows.size());
		
		String Thirdwindow=lstWindows.get(2);
		driver.switchTo().window(Thirdwindow);
		Thread.sleep(1000);
		System.out.println(driver.getCurrentUrl());
		String titleofAddtobagPage = driver.getTitle();
		System.out.println(titleofAddtobagPage);
	
		//11) Click on ADD to BAG
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[@class='mkr-New-Shopping-Bag font-mkr']/preceding::button)[1]")).click();
		
		//12) Go to Shopping Bag 
		driver.findElement(By.xpath("//div[@class='BagItems ']")).click();
		Thread.sleep(1000);


		//13) Print the Grand Total amount
		
		String GrandTotal = driver.findElement(By.xpath("//div[@class='first-col']//div[@class='value']")).getText().replaceAll("\\D", "");

		System.out.println("Grand total:"+GrandTotal);

		
		//14) Click Proceed
		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[@class='second-col']//button[1]")).click();
		
		//15) Click on Continue as Guest
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

		//16) Check if this grand total is the same in step 13
		String FinalGrandTotal = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText().replaceAll("\\D", "");
		System.out.println("Grand total:"+FinalGrandTotal);
		
		if(GrandTotal.equals(FinalGrandTotal))
		{
			System.out.println("Grand Total matches");
		}
		else
		{
			System.out.println("Grand Total differs");

		}

		//17) Close all windows
		driver.quit();
	}

}
