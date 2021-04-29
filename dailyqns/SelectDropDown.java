package dailyqns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		
		driver.findElement(By.xpath("//select[@class='dropdown']")).click();
		// Identify the element and store
		//Thread.sleep(1000);
				WebElement element=driver.findElement(By.xpath("//select[@class='dropdown']"));
				// create an object using Select class for an webelement 
				Select dropdown=new Select(element);
				// get collection of webelement and store it in list
				List<WebElement> options=dropdown.getOptions();
				int size = options.size();
				System.out.println(size);
				
				dropdown.selectByIndex(size-2);
			//	driver.close();
		
	}

}
/*
Exception in thread "main" org.openqa.selenium.support.ui.UnexpectedTagNameException: Element should have been "select" but was "option"
Build info: version: '4.0.0-alpha-6', revision: '5f43a29cfc'
System info: host: 'LAPTOP-ACPEIK89', ip: '192.168.1.101', os.name: 'Windows 10', os.arch: 'amd64', os.version: '10.0', java.version: '1.8.0_271'
Driver info: driver.version: unknown
	at org.openqa.selenium.support.ui.Select.<init>(Select.java:49)
	at dailyqns.SelectDropDown.main(SelectDropDown.java:26)
*/