package appModules;
import org.testng.Assert;

import pageObjects.BaseClass;
import pageObjects.Createjob_page;
import pageObjects.Vehicle_page;
import pageObjects.jobActionList_page;
public class JobActionPerform_Action {

	
	public static void performAction(String operation){
		
		
		if(operation.equalsIgnoreCase("ViewJobDetails_Test")){
		try {
			
			
			jobActionList_page.viewJobDetials();
			
//			jobActionList_page.getJoblist();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		if(operation.equalsIgnoreCase("JobEditAction_Test")){
		 try {
			
			 jobActionList_page.getJoblist();
			 
			 jobActionList_page.editJobDetails().click();
			 
			 Createjob_page.Recipient_name().clear();
			 
			 Createjob_page.Recipient_name().sendKeys("Atul kumar");
			 
			 Thread.sleep(3000);
			 Createjob_page.Add_job().click() ;
			 
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		}
		 
		if(operation.equalsIgnoreCase("JobDeleteAction_Test")){
		 try {
			jobActionList_page.deleteJob();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 String Expmessage = "job deleted successfully" ;
 		 
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
		
		
		if(operation.equalsIgnoreCase("ExportJobList_Test")){
			 try {
				jobActionList_page.getJoblist();
				
				jobActionList_page.createJobRecordFile();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}

		
		
		
		
		
		if(operation.equalsIgnoreCase("FindJobStatus_Test")){
			 try {
				jobActionList_page.getJoblist();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		
		
		
		
	}
	
	
	
	
}
