package appModules;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.Messaging_page;

public class Messaging_Action  {

	public static boolean status ;
	public static void messageStatus() throws Exception{
    
	
	Home_Page.ClickMenuIcon().click();
	
	Thread.sleep(3000);
	Home_Page.MenuNavigation.Message_Management().click() ;
	
		try {
		status	=Messaging_page.verifyAllEnabledMessages();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status==true){
       		
       		
       		System.out.println("All ok");
       	}
          else{
       		
       		System.out.println("All not ok");
       		
       		BaseClass.bResult=false;
       	}
    
     }

}