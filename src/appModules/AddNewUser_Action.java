package appModules;

import org.testng.Assert;

import pageObjects.BaseClass;
import pageObjects.CreateUser_page;
import pageObjects.Home_Page;
import pageObjects.User_management;
import pageObjects.Vehicle_page;
import testCases.CreateUser_Test;
import utility.Utils;

public  class AddNewUser_Action {

	
	public static void createUser() throws Exception{

		Home_Page.ClickMenuIcon().click();
		Thread.sleep(5000);
	
		Home_Page.MenuNavigation.userManagement().click();
		Thread.sleep(5000);
		
	   User_management.Users.clickOnAddButton().click();
	   
	   Thread.sleep(3000);
	   
	   CreateUser_page.firstName().sendKeys(CreateUser_Test.firstname);
	   
	   CreateUser_page.lastName().sendKeys(CreateUser_Test.lastname);
	   
	   CreateUser_page.emailId().sendKeys(CreateUser_Test.email);
	   
	   CreateUser_page.mobileNo().sendKeys(CreateUser_Test.mobileNo);
	  
	   System.out.println(CreateUser_Test.role+ " Roles are");
	   String Userrole= CreateUser_Test.role ;
	   
	      CreateUser_page.selectRole(Userrole);
	  
		
	   Thread.sleep(2000);
	   CreateUser_page.oK().click();
	  
	  
	   boolean display=false ;
	   try{
		   
		   Thread.sleep(3000);
	       display  =CreateUser_page.selectPermission().isDisplayed() ;
	   
if(display==true){
		   
	Thread.sleep(3000);
		   CreateUser_page.selectPermission().click();
		   
	   }
	   
	   
	   }
	   catch(Exception e)
	   {
		   
	   }
	   
	   Utils.scrollPage();
	   CreateUser_page.selectTeam().click();
	   
	   Thread.sleep(2000);
	   CreateUser_page.oK().click();
	   
	   Utils.scrollPage();
	   
	   Thread.sleep(3000) ;
	   CreateUser_page.selectVehicle().click();
	   
	   
	   
	   Thread.sleep(2000);
	   CreateUser_page.oK().click();
	   
	   
	   Thread.sleep(2000);
	   CreateUser_page.addUserButton().click();
	   
	   String Expmessage = "User created successfully" ;
		 
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
