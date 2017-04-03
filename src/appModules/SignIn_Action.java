package appModules;

import org.openqa.selenium.WebElement;
import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;



    public class SignIn_Action {	
    	
    	
    	public static boolean pass = true ;
    	
        public static void Execute(int iTestCaseRow) throws Exception{
  
        	try{ 
       
        	String sUserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Userloginname);
        	
            LogIn_Page.txtbx_UserName().sendKeys(sUserName);
            // Printing the logs for what we have just performed
            Log.info(sUserName+" is entered in UserName text box" );
            
            String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Userpwd);
            LogIn_Page.txtbx_Password().sendKeys(sPassword);
            Log.info(sPassword+" is entered in Password text box" );
            
            LogIn_Page.btn_LogIn().click();
            Log.info("Click action is performed on login button");
//          String title=  Home_Page.pageTitle().getText() ;
   
            Thread.sleep(5000);
            

//            boolean error =false ;
//           
            try{
//    
//            	error=LogIn_Page.invalidCredentials().isDisplayed();
//            	
//            	
//            }
//            catch(Exception e){
//            	
//            	
//            }
//    	 
//        System.out.println("value of error "+ error);
//        
//        if(error==true){
//       		
//        	 System.out.println(" bad value of error ");
//        	
//        	BaseClass.getCurrentURL() ;
//        
//        	pass =false ;
//        	
////        	error =false ;
//        }
//        else {
//        	
        	
        	 boolean visible =false ;
        	 try{
        	
  visible=BaseClass.isElementPresent(Home_Page.pageTitle(),"Jobs"); 
        	 }
        	 catch(Exception e){
        		 
        	 }
    if(visible==true){
    
    	
    	System.out.println("Home page is displaiyng and login successfull");
    
//    	System.out.println("Login successful");
        
    	pass =true  ;
    
       }    	
    else{
    	
    	System.out.println("into bad value of error ");
     	
    	 try{
    		 
    		visible= LogIn_Page.invalidCredentials().isDisplayed();
    	 }
    	 catch(Exception e){
    		 
    		 
    	 }
    	 if(visible==true){
    	 
     	BaseClass.getCurrentURL() ;
     
     	pass =false ;
     	
    	 }
    
    
    }  
  
            }   
catch(Exception e){
 
	System.out.println("Valid user");
}
    
   
        	}   
    catch(Exception e){
    	
    }
        
        }
     
        	     

        
        
public static void logOut() throws Exception{
         try{
           Home_Page.ClickMenuIcon().click();
           
            Home_Page.MenuNavigation.lnk_LogOut().click();
            
            WebElement ele=Home_Page.Ok();
         
            ele.click();
            
            boolean visible=BaseClass.isElementPresent(LogIn_Page.ionicLogo(), "ionic logo"); 
          	
              if(visible==true){
           		// Here I have put a verification check on the Product Name, if it is displayed my verification will pass
//           		Reporter.log("Verification Passed for Product Name on Check Out page.");
           		
           	}
              else{
           		
//           		BaseClass.bResult=false;

            	  pass=false ;
              }
           	  
          	}
              catch(Exception e){
              	
              	e.printStackTrace();
              	
              	System.out.println(e.getMessage());
              }
            
        	}
    
    
    
    }
