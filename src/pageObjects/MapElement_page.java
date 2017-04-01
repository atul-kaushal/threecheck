package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Utils;


public class MapElement_page extends BaseClass {

	public MapElement_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	 public static WebElement clickOnJob() throws Exception{
	     
  		
	      return  Utils.FindElement(By.xpath("//ion-card[1]"),"Job Ion card");
	     		
	     	
	  }
	

	 public static WebElement jobCardActionList() throws Exception{
	     
		 
		 return	 Utils.FindElement(By.xpath("//page-job-details//ion-footer//button[1]"),"Action card");
	  		
	      
	     		
	     	
	  }
	 
	 public static WebElement recipientDetails() throws Exception{
		 
		 Thread.sleep(3000);
		            Utils.FindElement(By.xpath("//ion-card//ion-list[2]"),"Action card");	
		 
		            Utils.scrollPage();
	      return  Utils.FindElement(By.xpath("//ion-item[contains(.,'Recipient Name')]//*[@aria-label='text']"),"recipient message");
	     		
	     	
	  }
	 
	 
	 public static WebElement sendSmsPopup(String message) throws Exception{
	     
		 Thread.sleep(3000);
		 Utils.FindElement(By.xpath("//ion-title//div[contains(.,'Send Message')]"),"Action card");
		 
		 Thread.sleep(3000);
		 Utils.FindElement(By.xpath("//textarea[@name='smsText']"),"Action card").sendKeys(message);
		 
	
	return	 Utils.FindElement(By.xpath("//button[contains(.,'Send')]"),"Action card");
		 
	  	
	  }
	 
	 
	
	 

		
	 
	
	
	
	
}
