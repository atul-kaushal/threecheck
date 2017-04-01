package appModules;

import org.testng.Assert;

import pageObjects.BaseClass;

import pageObjects.Home_Page;
import pageObjects.Vehicle_page;
import testCases.CreateVehicle_Test;
import utility.Utils;

public class AddVehicle_Action {

	public static void CreateNewVehicle() throws Exception{
		
		
		Home_Page.ClickMenuIcon().click();
		
		Thread.sleep(3000);
		Home_Page.MenuNavigation.Vehicle_Management();
		
		Thread.sleep(3000);
		Vehicle_page.clickToAddButton().click();
		
		Thread.sleep(2000);
		Vehicle_page.make().sendKeys(CreateVehicle_Test.make);
		Thread.sleep(2000);
		Vehicle_page.model().sendKeys(CreateVehicle_Test.model);
		Thread.sleep(2000);
		Vehicle_page.VINnumber().sendKeys(CreateVehicle_Test.VIN);
		Thread.sleep(2000);
		Vehicle_page.VRNnumber().sendKeys(CreateVehicle_Test.VRN);
		
		
		Vehicle_page.selectFuelType().click() ;
		
		Thread.sleep(2000);
		Vehicle_page.okPopUp().click() ;
		
		Vehicle_page.selectDriver().click() ;
		
		Thread.sleep(2000);
		Vehicle_page.okPopUp().click() ;
		
		Utils.scrollPage();
		
		Thread.sleep(5000);
		Vehicle_page.addButton().click();
		
		
 String Expmessage = "Vehicle created successfully" ;
 		 
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
