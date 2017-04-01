package testCases;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import appModules.SignIn_Action;
import pageObjects.BaseClass;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;


public class Logout_Test{
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
	
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  
	  	DOMConfigurator.configure("log4j.xml");
	  	
	
	  	sTestCaseName = this.toString();
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
		Log.startTestCase(sTestCaseName);
						
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
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
		
		SignIn_Action.logOut();
			
            
		if(BaseClass.bResult==true){
			// If the value of boolean variable is True, then your test is complete pass and do this
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result,Constant.Sheet_TestCases);
			
			System.out.println("if true");
			Utils.takeScreenshot(driver, sTestCaseName);
			
		}else{
			
			System.out.println("if false");
			throw new Exception("Test Case Failed because of Verification");
		}
	}catch (Exception e){
		  
		  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result,Constant.Sheet_TestCases);
		  Utils.takeScreenshot(driver, sTestCaseName);
		  
		  Log.error(e.getMessage());
		
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
	    driver.close();
  		}

  
}
