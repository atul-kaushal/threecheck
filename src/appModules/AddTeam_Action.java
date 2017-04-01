package appModules;

import org.testng.Assert;

import pageObjects.BaseClass;
import pageObjects.CreateTeam_page;
import pageObjects.Home_Page;
import pageObjects.Vehicle_page;

public class AddTeam_Action {

	 public static void createNewTeam( ) throws Exception{
		 
		 
		 Home_Page.ClickMenuIcon().click();
		 
		 Thread.sleep(3000);
		 Home_Page.MenuNavigation.userManagement().click();
		 
		 Thread.sleep(3000);
		 CreateTeam_page.selectTeamTab();
		 
		 CreateTeam_page.teamName().sendKeys("South east team");
		 
		 Thread.sleep(2000);
		 CreateTeam_page.selectHub().click();
		 
		 Thread.sleep(2000);
		 CreateTeam_page.oK().click();
		 
		 Thread.sleep(2000);
		 CreateTeam_page.selectDriver().click();
		 
		 Thread.sleep(2000);
		 CreateTeam_page.oK().click();
		 
		 Thread.sleep(2000);
		 CreateTeam_page.selectDispatcher().click();
		 
		 Thread.sleep(2000);
		 CreateTeam_page.oK().click();
		 
		 Thread.sleep(2000);
		 CreateTeam_page.addTeam().click();
		 
 String Expmessage = "Team added successfully" ;
 		 
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
