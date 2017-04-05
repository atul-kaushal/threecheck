package testCases;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BaseClass;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import appModules.Create_job_Action;
import appModules.SignIn_Action;

public class CreateJob_Test {

	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
	
	public static String sJobID;
//	public static String sRunMode;
//	public static String sData;
	
	
	
	public static  int JobID ;	
	public static  String Recipientname ;	
	public static  String MobileNo ;
	public static  String Address ;
	public static  String Discription   ;
	public static  String JObDate  ;
	public static  String StartTime  ;
	public static  String Endtime ;
	public static  String Driver ;
 
	static int i;
             
	int expyear ;
	int expmonth ;
	int expday ;
	

  @BeforeMethod
  public void beforeMethod() throws Exception {
	  	DOMConfigurator.configure("log4j.xml");
	  	
	  	sTestCaseName = this.toString();
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
		Log.startTestCase(sTestCaseName);
						
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Test Cases");

		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		if(iTestCaseRow!=0){
		// Launching the browser, this will take the Browser Type from Test Data Sheet 
		driver = Utils.OpenBrowser(iTestCaseRow);

		    new BaseClass(driver); 
		} 	
  }
  
  @Test
  public void main() throws Exception {
	  try{
		SignIn_Action.Execute(iTestCaseRow);

		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	    	int iTotalJobs = ExcelUtils.getRowCount(Constant.Sheet_Joblist);
	    	//get number of rows
//	    	System.out.println(":::::1 "+iTotalJobs);
			
			for(int jonnumber=1;jonnumber<iTotalJobs;jonnumber++){
                try{  
                	
                	System.out.println("Job number ::::::::::::"+jonnumber );			
                	
				sJobID = ExcelUtils.getCellData(jonnumber, Constant.Col_JobID); 
				Recipientname = ExcelUtils.getCellData(jonnumber, Constant.Col_Recipientname); 
				MobileNo = ExcelUtils.getCellData(jonnumber, Constant.Col_MobileNo); 
				Address = ExcelUtils.getCellData(jonnumber, Constant.Col_Address); 
				Discription = ExcelUtils.getCellData(jonnumber, Constant.Col_Discription); 
				JObDate = ExcelUtils.getCellData(jonnumber, Constant.Col_JObDate); 
				StartTime = ExcelUtils.getCellData(jonnumber, Constant.Col_StartTime); 
				
				
				
				
//String[]  date=JObDate.replace("/", "_").split("_");

            String[]  date=JObDate.split("/");

//				System.out.println(sJobID+ Recipientname +MobileNo+Address+Discription+StartTime);
				
				System.out.println(JObDate );			
	    
	    try{
//	    	System.out.println("date[0]"+date[0]);
        expmonth= Integer.parseInt(date[0]);
	    }
	    catch(Exception e){
	    	
//	    	e.printStackTrace();
//	    	System.out.println(e);
	    }
	    try{
//	    	System.out.println("date[1]"+date[1]);
		    expday= Integer.parseInt(date[1]);
	    }
catch(Exception e){
	    	
//	    	e.printStackTrace();
//	    	System.out.println(e);
	    }
	    
	    try{
//	    	 System.out.println("date[2]"+date[2]);
	 	    expyear=Integer.parseInt(date[2]);
	    }catch(Exception e){
	    	
//	    	e.printStackTrace();
//	    	System.out.println(e);
	    }
	   
	    
		System.out.println(expmonth+":"+expday+":"+expyear);		
		
//		       Thread.sleep(2000) ;
		       
		       try{
				Create_job_Action.Create_Job(expmonth,expday,expyear);
		       }
				catch(Exception e){
					
					
					ExcelUtils.setCellData(Constant.KEYWORD_FAIL,jonnumber,Constant.Col_IsJobCreated,Constant.Sheet_Joblist);
					
				}
				
				if(BaseClass.bResult==false){
					
					System.out.println("Fail");
					ExcelUtils.setCellData(Constant.KEYWORD_FAIL,jonnumber,Constant.Col_IsJobCreated,Constant.Sheet_Joblist);
					
					break;
					}						
			
			    if(BaseClass.bResult==true){
			ExcelUtils.setCellData(Constant.KEYWORD_PASS,jonnumber,Constant.Col_IsJobCreated,Constant.Sheet_Joblist);
			
			System.out.println("pass");
//			Log_messaage.endTestCase(sTestCaseID);	
				}
				
			   }
                catch(Exception e){
                	
                	e.printStackTrace();
                	
                	System.out.println(e.getMessage());
                }
			
			}	

			///////fdfdfdfdf////////////////////
			
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		if(BaseClass.bResult==true){
			
			
			System.out.println("Overall pass");
			// If the value of boolean variable is True, then your test is complete pass and do this
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result,Constant.Sheet_TestCases);
		}else{
			
			System.out.println(" Over all Fail");
			throw new Exception("Test Case Failed because of"+JobID+"Is not executed");
		}
			
	  // Below are the steps you may like to perform in case of failed test or any exception faced before ending your test 
	  }
	  
	  catch (Exception e){
		  // If in case you got any exception during the test, it will mark your test as Fail in the test result sheet
		  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result,Constant.Sheet_TestCases);
		  // If the exception is in between the test, bcoz of any element not found or anything, this will take a screen shot
		  Utils.takeScreenshot(driver, sTestCaseName);
		  // This will print the error log message
		  Log.error(e.getMessage());
		  // Again throwing the exception to fail the test completely in the TestNG results
		  Assert.fail(" Test case terminated");
		  
		 
	  }
	
	  
  }
	
  @AfterMethod
  public void afterMethod() {
	    Log.endTestCase(sTestCaseName);
	    // Closing the opened driver
//	    driver.close();
  		}

  

}
