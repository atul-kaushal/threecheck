package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.BaseClass;
import pageObjects.MapElement_page;
import pageObjects.Vehicle_page;

import utility.Utils;

public class SendSms_Action {

	public static void SendMessageAction( ) throws Exception{
	
		
		MapElement_page.clickOnJob().click();
		
		Thread.sleep(5000);
		
		MapElement_page.jobCardActionList().click();
		
		Thread.sleep(5000);
		MapElement_page.recipientDetails().click();
	
		Thread.sleep(5000);
		MapElement_page.sendSmsPopup("Hello Atul").click();
		
		
 String Expmessage = "Message sent successfully" ;
		 
		 String Actualmessage = Vehicle_page.successToast().getText() ;
		
	     System.out.println("value of "+Actualmessage);
	       
	      if(Actualmessage.equalsIgnoreCase(Expmessage)){
	             		// Here I have put a verification check on the Product Name, if it is displayed my verification will pass
	             		System.out.println("Success");
	             	          	}
	                else{
	                
	                	BaseClass.bResult=false;
	             		
	             		Assert.fail(" Test case terminated");
	             	}
      
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
