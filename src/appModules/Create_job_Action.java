package appModules;

import org.testng.Assert;

import pageObjects.BaseClass;

import pageObjects.Createjob_page;
import pageObjects.Home_Page;
import pageObjects.JobSchedule;
import pageObjects.JobSchedule2;

import pageObjects.Vehicle_page;
import testCases.CreateJob_Test;

public class Create_job_Action {

	
	
	public static void Create_Job(int m ,int d ,int y) throws Exception{
		
		try {
			
			Home_Page.Click_AddJob_Icon().click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
      Createjob_page.Recipient_name().sendKeys(CreateJob_Test.Recipientname);
      Createjob_page.Recipient_number().sendKeys(CreateJob_Test.MobileNo);
      Createjob_page.Destination().sendKeys(CreateJob_Test.Address);
      
      Createjob_page.Autoselect_address().click();
   
      
      Createjob_page.Recipient_notes().sendKeys(CreateJob_Test.Discription);
      
      JobSchedule2.Datepicker(m,d,y);
      
      JobSchedule2.jobStarttimeFrame(CreateJob_Test.StartTime) ;
      
      JobSchedule2.jobEndtimeFrame();
      
//      Createjob_page.Ok().click() ;   
      
      Createjob_page.SelectDriverToAssign().click();
      
      
      Createjob_page.Ok().click() ;   
      
//      Createjob_page.card_Header();
           
      
      Createjob_page.Add_job().click() ;
      
      String Expmessage = "Job created successfully" ;
		 
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


		
		


