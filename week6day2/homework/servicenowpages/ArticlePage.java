package week6day2.homework.servicenowpages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import week6day2.homework.servicenowhooks.ServiceNowHooks;

public class ArticlePage extends ServiceNowHooks{

		public ArticlePage toCreateNewArticle()
		{
		driver.switchTo().frame("gsft_main");
		
		String ArticleNumber=driver.findElementById("sys_readonly.kb_knowledge.number").getAttribute("value");
		System.out.println(ArticleNumber);
		System.out.println("Article ID is created"+ArticleNumber);

		driver.findElementByXPath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']").sendKeys("Knowledge");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElementByXPath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']").sendKeys(Keys.TAB);
		driver.findElementById("kb_knowledge.short_description").sendKeys("Creating New Article");	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElementById("sysverb_insert").click();
		System.out.println("Knowledge base article created with value knowledge");
		return this;
	}
}

