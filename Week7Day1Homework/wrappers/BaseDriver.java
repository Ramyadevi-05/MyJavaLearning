package wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver implements Browser, Element, Select, TargetLocator {

	public static RemoteWebDriver driver;
	
	@Override
	public boolean startApp(String browser, String url) {

		try {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			} else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			} else {
				System.err.println("This browser "+browser+" is not supported");
				return false;
			}

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("The browser "+browser+" launched successfully");
			return true;

		} catch (Exception e) {
			System.err.println("The browser "+browser+" could not be launched");
			return false;
		}

	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			System.out.println(allWindowHandles.size());
			// To get the second window handle and switch to it
			List<String> lstWindows = new ArrayList<String>(allWindowHandles);
			System.out.println(lstWindows.size());
			String requiredWindow = lstWindows.get(index);
			driver.switchTo().window(requiredWindow);
			System.out.println("Switched to Window"+" : "+index);
		} catch (NoSuchWindowException e) {
			
			System.err.println("Switched to Window failed"+" : "+index);
		}
	}

	@Override
	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			System.out.println("Switched to frame using WebElement : "+ele+" "+" is successful"+ele);
		} catch (NoSuchFrameException e) {
			System.err.println("Switched to frame using WebElement : "+ele+" "+" is failed"+ele);
		}
		
	}

	@Override
	public void acceptAlert() {
		
		try {
			driver.switchTo().alert().accept();
			System.out.println("Alert Accepted Successfully");
		} catch (NoAlertPresentException e) {
			System.err.println("No Alert was foud");
		}
		catch(UnhandledAlertException e)
		{
			System.err.println("Alert is not handled");
		}
	}

	@Override
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("Alert is dismissed");
		} catch(NoAlertPresentException e) {
			System.err.println("No Alert was foud");
		}
		catch(UnhandledAlertException e)
		{
			System.err.println("Alert is not handled");
		}
	}

	@Override
	public String getAlertText() {
		 String AlertText=" ";
		try {
			AlertText = driver.switchTo().alert().getText();			
		} 
		catch(NoAlertPresentException e) {
			System.err.println("No Alert was foud");
		}
		catch(UnhandledAlertException e)
		{
			System.err.println("Alert is not handled");
		}
		return AlertText;
	}

	@Override
	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		try {
			selectDropDownUsingVisibleText(ele,value);
			System.out.println("Selected the required text value: "+ value);
		} catch (NoSuchElementException e) {
			System.err.println("Not Selected the required text value: "+ value);
		}
		
		
	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			selectDropDownUsingValue(ele,value);
			System.out.println("Selected the required value: "+ value);
		} catch (NoSuchElementException e) {
			System.err.println("Not Selected the required value: "+ value);
		}
		
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			selectDropDownUsingIndex(ele,index);
			System.out.println("Selected the required index: "+ index);
		} catch (NoSuchElementException e) {
			System.err.println("Not Selected the required index: "+ index);
		}
	}

	@Override
	public void type(WebElement ele, String data) {
		
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The element "+ele+" is typed with the value "+ele);
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be typed with the value "+ele);
		}

	}

	public void typeAndEnter(WebElement ele, String data) {
		
		try {
			ele.clear();
			ele.sendKeys(data);
			ele.sendKeys(Keys.ENTER);
			System.out.println("The element "+ele+" is typed with the value "+ele+"Pressed ENTER Key");
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be typed with the value "+ele+"Issue with Pressing ENTER Key");
		}

	}

	@Override
	public void click(WebElement ele) {	
		try {
			ele.click();
			System.out.println("The element "+ele+" is clicked");
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be clicked");
		}

	}

	@Override
	public String getText(WebElement ele) {
		String text =" ";
		try {
			text = ele.getText();
			System.out.println("Text value:"+text);
		} 
		
		catch (NoSuchElementException e) {
			System.err.println("Text value not retrived");
			
		}
		return text;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			String actualText=ele.getText();
			System.out.println(actualText);
			if(actualText.equals(expectedText))
				System.out.println("Exact Text is matched");
			else
				System.out.println("Exact Text is not matched");
		} catch (NoSuchElementException e) {

			System.err.println("Exact text match is not verified");
		}
	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			String actualText=ele.getText();
			System.out.println(actualText);
			if(actualText.contains(expectedText))
				System.out.println("Partial Text is matched");
			else
				System.out.println("Partial Text is not matched");
		} catch (NoSuchElementException e) {

			System.err.println("Partial text match is not verified");
		}
	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			String text=ele.getAttribute("value");
			System.out.println(text);
			if(text.equalsIgnoreCase(value))
				System.out.println("Exact Attribute value validation success");
		} catch (NoSuchElementException e) {
			System.err.println("Exact Attribute value validation failed");
		}
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			String text=ele.getAttribute("value");
			System.out.println(text);
			if(text.contains(value))
				System.out.println("Partial Attribute value validation success");
		} catch (NoSuchElementException e) {
			System.err.println("Partial Attribute value validation failed");
		}
	}

	@Override
	public void verifySelected(WebElement ele) {
		try {
			boolean selected = ele.isSelected();
			if(selected)
			{
				System.out.println("Element is Selected");
			}
		}catch(NoSuchElementException e)
		{
			System.err.println("Element is not Selected");
		}
	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		try 
		{
		boolean displayed = ele.isDisplayed();
		if(displayed)
		{
			System.out.println("Element is displayed");
		}
		}
	catch(NoSuchElementException e)
	{
		System.err.println("Element is not displayed");
	}
	}

	@Override
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator.toLowerCase()) {
			case "id": return driver.findElement(By.id(locValue));
			case "name": return driver.findElement(By.name(locValue));
			case "link": return driver.findElement(By.linkText(locValue));
			case "class": return driver.findElement(By.className(locValue));
			case "tag": return driver.findElement(By.tagName(locValue));
			case "xpath": return driver.findElement(By.xpath(locValue));
			case "css": return driver.findElement(By.cssSelector(locValue));
			case "partial": return driver.findElement(By.partialLinkText(locValue));
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element could not be found for the locator "+locator+" with value "+locValue);
		}
		return null;

	}

	@Override
	public boolean verifyExactTitle(String expectedTitle) {
		try {
			String title = driver.getTitle();
			System.out.println(title);
			if(title.equalsIgnoreCase(expectedTitle))
			System.out.println("Title is matched exactly");
		} 
		
		catch (NoSuchWindowException e) {
			System.err.println("Exact Title Verification failed");
		}
		return true;
	}

	@Override
	public boolean verifyPartialTitle(String expectedTitle) {
		try {
			String title = driver.getTitle();
			System.out.println(title);
			if(title.contains(expectedTitle))
			System.out.println("Title is matched partially");
		} 
		
		catch (NoSuchWindowException e) {
			System.err.println("partial Title Verification failed");
		}
		return true;
	}

	@Override
	public void closeActiveBrowser() {
		try {
			driver.close();
			System.out.println("Closed Active window");
		} catch (Exception e) {
			System.err.println("Failed to close all active windows");
		}
	}

	@Override
	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("Closed All Browser Windows");
		} catch (Exception e) {
			System.err.println("Failed to close All Browser Windows");
		}
	}

}
