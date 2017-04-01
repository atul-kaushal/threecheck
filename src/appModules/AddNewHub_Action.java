package appModules;


import org.testng.Assert;

import pageObjects.BaseClass;
import pageObjects.CreateHub_page;
import pageObjects.Home_Page;
import testCases.CreateHub_Test;

public class AddNewHub_Action {


	public static void CreateNewHub(int hub) throws Exception{

		if(hub==1){
		Home_Page.ClickMenuIcon().click();
		 
		Thread.sleep(2000);
		 Home_Page.MenuNavigation.userManagement().click();
	
	
		}

		    Thread.sleep(3000);
			CreateHub_page.selectHubTab();
		
		CreateHub_page.hubName().sendKeys(CreateHub_Test.HubName);
		
		CreateHub_page.hubAddress().sendKeys(CreateHub_Test.HubAddress) ;
		
		Thread.sleep(2000);
		CreateHub_page.Autoselect_address().click() ;
		
		CreateHub_page.selectTeam();
		CreateHub_page.oK().click();
		
		Thread.sleep(2000);
		CreateHub_page.addHub().click();
	     
		 String Expmessage = "Hub added successfully" ;
 		 
		 String Actualmessage = CreateHub_page.successToast().getText() ;
		
		 
		 
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
