package utility;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BaseClass;

import com.google.common.base.Function;
//This is a class to write methods for open browser ,click, navigate,scroll, take screeshot,wait for element
//, mouse over , get test case name
public class Utils {
		public static WebDriver driver = null;
	
		//This data needs to be written (Object[])
				static Map<String, Object[]> data = new TreeMap<String, Object[]>();
		public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception{
		String sBrowserName;
		try{
		sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
		if(sBrowserName.equals("Mozilla")){
//			driver = new FirefoxDriver();
			  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			   driver = new ChromeDriver();
			driver.manage().window().maximize();
					Log.info("New driver instantiated");
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    Log.info("Implicit wait applied on the driver for 10 seconds");
		    driver.get(Constant.URL);
		    Log.info("Web application launched successfully");
			}
		}catch (Exception e){
			Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
		}
		return driver;
	}
	
	public static String getTestCaseName(String sTestCase)throws Exception{
		String value = sTestCase;
		try{
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");	
			value = value.substring(posi + 1);
			return value;
				}catch (Exception e){
			Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw (e);
					}
			}
	
	 public static void mouseHoverAction(WebElement mainElement, String subElement){
		
		 Actions action = new Actions(driver);
         action.moveToElement(mainElement).perform();
         if(subElement.equals("Accessories")){
        	 action.moveToElement(driver.findElement(By.linkText("Accessories")));
        	 Log.info("Accessories link is found under Product Category");
         }
         if(subElement.equals("iMacs")){
        	 action.moveToElement(driver.findElement(By.linkText("iMacs")));
        	 Log.info("iMacs link is found under Product Category");
         }
         if(subElement.equals("iPads")){
        	 action.moveToElement(driver.findElement(By.linkText("iPads")));
        	 Log.info("iPads link is found under Product Category");
         }
         if(subElement.equals("iPhones")){
        	 action.moveToElement(driver.findElement(By.linkText("iPhones")));
        	 Log.info("iPhones link is found under Product Category");
         }
         action.click();
         action.perform();
         Log.info("Click action is performed on the selected Product Type");
	 }
	 public static void waitForElement(WebElement element){
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	 	}
	 
	 public static void scrollPage( )
     {
//    	 WebElement wEle = ele;
    	 
//    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();" );
//    	ele.click();
//		 WebElement element = driver.findElement(By("element_path"));

//		 Actions actions = new Actions(driver);

//		 actions.moveToElement(ele).click().perform();
		 
		 JavascriptExecutor jse = (JavascriptExecutor)driver;

//		 jse.executeScript("scroll(250, 0)"); // if the element is on top.

//		 jse.executeScript("arguments[0].scrollIntoView(true);", wEle);
//		 jse.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
//		 for(int j=1;j<=str;j++){
		 jse.executeScript("scroll(0, 250)");
//		 }
     }
	 public static void clickElement(WebElement ele,int str)
     {
         
        try {
        	ele.click();
        }catch (Exception e)
        {
        	 System.out.println("ERROR: Element "+str+" is unclickable ");
        }

     }
	
	 
	 public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
			try{
				 TakesScreenshot ts= (TakesScreenshot)driver;
				File scrFile = ts.getScreenshotAs(OutputType.FILE);
				
				if(BaseClass.bResult==false){
				FileUtils.copyFile(scrFile, new File(Constant.PathToTestFail_ScreenShot + sTestCaseName +".jpg"));
				}
				
				else{
					FileUtils.copyFile(scrFile, new File(Constant.PathToTestpass_ScreenShot + sTestCaseName +".jpg"));
				}
				
				
			} catch (Exception e){
				Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
				throw new Exception();
			}
		}
	 
	
		

	
	 
	public static WebElement fluentWait(final By locator) throws Exception{
		
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	        .withTimeout(15, TimeUnit.SECONDS)
	        .pollingEvery(5, TimeUnit.SECONDS)
	        .ignoring(NoSuchElementException.class);

	    WebElement foo = wait.until(
	        new Function<WebDriver, WebElement>() {
	            public WebElement apply(WebDriver driver) {
	            	
	            	WebElement ele = driver.findElement(locator);
	         
	            	return ele ;
	            }    	
	        }
	    );
	    return foo;
	}
	
	public static void writeToExcelFile(){
		
XSSFWorkbook workbook = new XSSFWorkbook(); 
		
		//Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Employee Data");
		
		  Row header = sheet.createRow(0);
		    header.createCell(0).setCellValue("JobID");
		    header.createCell(1).setCellValue("Status");
		    header.createCell(2).setCellValue("Address");
		    header.createCell(3).setCellValue("Timing");
		    header.createCell(4).setCellValue("CustomerName");
		    
			//Iterate over data and write to sheet
			Set<String> keyset = data.keySet();
			int rownum = 1;
			for (String key : keyset)
			{
			    Row row = sheet.createRow(rownum++);
			    Object [] objArr = data.get(key);
			    int cellnum = 0;
			    for (Object obj : objArr)
			    {
			       Cell cell = row.createCell(cellnum++);
			       if(obj instanceof String)
			            cell.setCellValue((String)obj);
			        else if(obj instanceof Integer)
			            cell.setCellValue((Integer)obj);
			    }
			}
			
			try 
			{
				//Write the workbook in file system
			    FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xlsx"));
			    workbook.write(out);
			    out.close();
			    
			    System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
			     
			} 
			catch (Exception e) 
			{
			    e.printStackTrace();
			}
		    
		    
		
	}
	
	
	
	public static void createJobDataMap(int jobnumber, String a ,String b,String c,String d,String customername)
	 {
		String rownumber= jobnumber+" " ;
			   String JobID = a;
		   String	  Jobstatus=b ;
		  String  address =c ;
		  String  jobtiming =d;
		
		  String  customerName =customername;
		
		data.put(rownumber, new Object[] {JobID,Jobstatus, address, jobtiming,customerName});
		
	
	}
	
	
	
	
	/////
	 

	  
	
	///
	
	
	}

