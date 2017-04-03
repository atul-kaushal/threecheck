package testCases;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import appModules.Filter_Action;
import appModules.SignIn_Action;

import pageObjects.BaseClass;

import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;


public class Login_Test{
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
	String sFileName = "D:/SeleniumEasy.har";
  @BeforeMethod
  public void beforeMethod() throws Exception {
	    // Configuring Log4j logs, please see the following posts to learn about Log4j Logging
	    // http://www.toolsqa.com/test-case-with-log4j/
	    // http://www.toolsqa.com/log4j-logging/
	  	DOMConfigurator.configure("log4j.xml");
	  	
	  	sTestCaseName = this.toString();
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
	  	System.out.println("Skipping this test");
		Log.startTestCase(sTestCaseName);
						
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Test Cases");
		
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		if(iTestCaseRow!=0){
		driver = Utils.OpenBrowser(iTestCaseRow);

		    new BaseClass(driver); 
		} 
        }
  
  @Test
  public void main() throws Exception {
	  try{
		  
		SignIn_Action.Execute(iTestCaseRow);
		
		SignIn_Action.logOut() ;
		
		Filter_Action.applyFilterTogetAlljobs() ;
		
		Thread.sleep(3000);
		
	driver.findElement(By.xpath("//page-tab-alljobmngt/ion-content/div[2]")).click() ;
		
		Thread.sleep(3000);
		  JavascriptExecutor javascript = (JavascriptExecutor) driver;
		  javascript.executeScript("window.scrollBy(0,600)", "");
//		  javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");  
		
		
		if(BaseClass.bResult==true){
			// If the value of boolean variable is True, then your test is complete pass and do this
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result,Constant.Sheet_TestCases);
			
			System.out.println("if true");
			Utils.takeScreenshot(driver, sTestCaseName);
			
		}else{
			
			System.out.println("if false");
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
			e.printStackTrace();
			
     		System.out.println(e.getMessage());
     		
     		Assert.fail("Login_Test Failed");
     		
	  }
		
  }  
  @AfterMethod
  public void afterMethod() {
	    // Printing beautiful logs to end the test case
	    Log.endTestCase(sTestCaseName);
	    // Closing the opened driver
//	    driver.close();
  		}

  
}
