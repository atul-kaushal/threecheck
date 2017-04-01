package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import appModules.AddVehicle_Action;
import appModules.SignIn_Action;

public class CreateVehicle_Test {


	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
	public static  String VehicleID  ;
	public static String    make ;
	public static String model;
    public static String Mfgyear ;
	public static String VIN ;
	public static String VRN ;
	
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

		//////////////////////////////////////////////////////////////////
		int iTotalVehicles = ExcelUtils.getRowCount(Constant.Sheet_VehicleList);
    	//get number of rows
    	System.out.println(" Total hubs:: "+iTotalVehicles);
		
		for(int n=1;n<iTotalVehicles;n++){
            try{  
            	
            	Thread.sleep(3000) ;
            	VehicleID = ExcelUtils.getCellData(n, Constant.Col_VehicleID); 
			    make = ExcelUtils.getCellData(n, Constant.Col_make); 
			     model = ExcelUtils.getCellData(n, Constant.Col_model); 
			     Mfgyear = ExcelUtils.getCellData(n, Constant.Col_Mfgyear); 
			    VIN= ExcelUtils.getCellData(n, Constant.Col_VIN); 
			    VRN= ExcelUtils.getCellData(n, Constant.Col_VRN); 
			
			
			AddVehicle_Action.CreateNewVehicle();
			
			
			if(BaseClass.bResult==false){
				
				System.out.println("Fail");
				ExcelUtils.setCellData(Constant.KEYWORD_FAIL,n,Constant.Col_IsHubCreated,Constant.Sheet_VehicleList);
				
				break;
				}						
		
		    if(BaseClass.bResult==true){
		ExcelUtils.setCellData(Constant.KEYWORD_PASS,n,Constant.Col_IsHubCreated,Constant.Sheet_VehicleList);
		
		System.out.println("pass");

			}
			
		   }
            catch(Exception e){

            	e.printStackTrace();
            	
            	System.out.println(e.getMessage());
            }
		
		}	
		
		
		if(BaseClass.bResult==true){
			// If the value of boolean variable is True, then your test is complete pass and do this
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result,Constant.Sheet_TestCases);
		}else{
			// If the value of boolean variable is False, then your test is fail, and you like to report it accordingly
			// This is to throw exception in case of fail test, this exception will be caught by catch block below
			throw new Exception("Test Case Failed because of Verification");
		}
		
	  // Below are the steps you may like to perform in case of failed test or any exception faced before ending your test 
	  }catch (Exception e){
		  // If in case you got any exception during the test, it will mark your test as Fail in the test result sheet
		  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result,Constant.Sheet_TestCases);
		  // If the exception is in between the test, bcoz of any element not found or anything, this will take a screen shot
		  Utils.takeScreenshot(driver, sTestCaseName);
		  // This will print the error log message
		  Log.error(e.getMessage());
		  // Again throwing the exception to fail the test completely in the TestNG results
		  throw (e);
	  }
		
  }
  
  // Its time to close the finish the test case		
  @AfterMethod
  public void afterMethod() {
	    // Printing beautiful logs to end the test case
	    Log.endTestCase(sTestCaseName);
	    // Closing the opened driver
//	    driver.close();
  		}

}
