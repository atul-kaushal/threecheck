package appModules;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;


import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

    public class SignIn_Action {	
        public static void Execute(int iTestCaseRow) throws Exception{
  
        	try{ 
       
        	String sUserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName);
        	
            LogIn_Page.txtbx_UserName().sendKeys(sUserName);
            // Printing the logs for what we have just performed
            Log.info(sUserName+" is entered in UserName text box" );
            
            String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
            LogIn_Page.txtbx_Password().sendKeys(sPassword);
            Log.info(sPassword+" is entered in Password text box" );
            
            LogIn_Page.btn_LogIn().click();
            Log.info("Click action is performed on login button");
//          String title=  Home_Page.pageTitle().getText() ;
   
            Thread.sleep(5000);
 boolean visible=Utils.isElementVisible(Home_Page.pageTitle(),"Jobs"); 
            
    if(visible==true){
           		// Here I have put a verification check on the Product Name, if it is displayed my verification will pass
           		Reporter.log("Verification Passed for Product Name on Check Out page.");
           	          	}
              else{
           		
           	
           		
           		BaseClass.bResult=false;
           	}
           	  
            
        	}      
catch(Exception e){
              	
              	e.printStackTrace();
              	
              	System.out.println(e.getMessage());
              }
            
       
        }
public static void logOut() throws Exception{
         try{
           Home_Page.ClickMenuIcon().click();
           
            Home_Page.MenuNavigation.lnk_LogOut().click();
            
            WebElement ele=Home_Page.Ok();
         
            ele.click();
            
            boolean visible=Utils.isElementVisible(LogIn_Page.ionicLogo(), "ionic logo"); 
          	
              if(visible==true){
           		// Here I have put a verification check on the Product Name, if it is displayed my verification will pass
//           		Reporter.log("Verification Passed for Product Name on Check Out page.");
           		
           	}
              else{
           		
           		BaseClass.bResult=false;
           	}
           	  
          	}
              catch(Exception e){
              	
              	e.printStackTrace();
              	
              	System.out.println(e.getMessage());
              }
            
        	}
    
    
    
    }
