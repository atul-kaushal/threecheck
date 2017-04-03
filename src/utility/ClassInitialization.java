package utility;

import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pageObjects.BaseClass;
public class ClassInitialization {

	public WebDriver driver;
	public static String sTestCaseName;
	public static int iTestCaseRow;
	

private final String className;
	
    protected ClassInitialization(String className) {
         this.className = className;
         
         System.out.println(this.className);
    
    }
	
    @BeforeMethod
    public void Startup(){
    
    	System.out.println("Into before method");
    
    }
	
	@BeforeClass
	public  void setupApplication() throws Exception
	{
	           
		System.out.println("into before class");
		
 	DOMConfigurator.configure("log4j.xml");
	  	
	  	sTestCaseName = this.className ;
//	  	sTestCaseName = Utils.getTestCaseName(this.className);
	  	
	  
		Log.startTestCase(sTestCaseName);
						
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Test Cases");
		
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		if(iTestCaseRow!=0){
		driver = Utils.OpenBrowser(iTestCaseRow);

		    new BaseClass(driver); 
		}
	}
	
	
	@AfterClass
	public void closeApplication() throws Exception{
		try{
		
			System.out.println("Into after Class");
	
			if(BaseClass.bResult==true){
			// If the value of boolean variable is True, then your test is complete pass and do this
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result,Constant.Sheet_TestCases);
			
			System.out.println("find  true");
			Utils.takeScreenshot(driver, sTestCaseName);
			
		}else{
			
			System.out.println("find  false");
			throw new Exception("Test Case Failed because of Verification");
		}
		
	  // Below are the steps you may like to perform in case of failed test or any exception faced before ending your test 
	  }catch (Exception e){
		  // If in case you got any exception during the test, it will mark your test as Fail in the test result sheet
		  
		  
		  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result,Constant.Sheet_TestCases);
		  
		  // If the exception is in between the test, bcoz of any element not found or anything, this will take a screen shot
		  Utils.takeScreenshot(driver, sTestCaseName);
		  // This will print the error log message
		  
		
			e.printStackTrace();
			
     		System.out.println(e.getMessage());
     		
     		Assert.fail("Login_Test Failed");
     		
	  }
		
		
		System.out.println("into after class");
		driver.quit();
		Reporter.log("=====Browser Session End=====", true);
		
    }

}