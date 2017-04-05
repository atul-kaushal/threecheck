package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
public class Createjob_page extends BaseClass {

	public Createjob_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 private static WebElement element = null;
	  public static WebElement Recipient_name() throws Exception{
      	try{
      		
      		
      		element=driver.findElement(By.xpath("//input[@name='recipientName']"));
      		
      		Thread.sleep(2000) ;
	            Log.info("Password text box is found on the Login page");
      	}catch (Exception e){
      		Log.error("Password text box is not found on the Login Page");
//         		throw(e);
         		}
		return element;

      }
	  public static WebElement Recipient_number() throws Exception{
	      	try{
	      		Thread.sleep(2000) ;
	      		element=driver.findElement(By.xpath("//input[@name='recipientNumber']"));
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			return element;

	      }
	  public static WebElement Destination() throws Exception{
	      	try{
	      		Thread.sleep(3000);
	      		element=driver.findElement(By.xpath("//input[@name='destination']"));
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			return element;

	      }	

	  public static WebElement Recipient_notes() throws Exception{
	      	try{
	      		
	      	Thread.sleep(5000);
	      		element=driver.findElement(By.xpath("//textarea[@name='jobNote']"));
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			return element;

	      }	
	
	  public static WebElement SelectDriverToAssign() throws Exception{
	      	try{
	      		
	      		Thread.sleep(3000) ;
	      		driver.findElement(By.xpath("//*[@placeholder='Select Driver']//button")).click();
	      		
	      		
//	      	element=driver.findElement(By.xpath("//*[@placeholder='Select Driver']//button"));
	      		
	      		driver.findElement(By.xpath("//ion-alert[@role='dialog']/div"));
	      	
	      		
	      		 List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(@id,'alert-input')]"));
//		      		
//		      		for (WebElement ele: allOptions) {
//		      			String option = ele.getText();
////		      			System.out.println("selenium webdriver"+" "+option);
//		      		}
	      		 
	      		Thread.sleep(2000) ; 
	      		
		      		element= allOptions.get(0);
	      	
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			return element;
}	


	  public static WebElement Ok() throws Exception{
	      	try{
	      		
	      		
	      		element=driver.findElement(By.xpath("//button[contains(.,'OK')]"));
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			return element;

	      }	

	  public static void backToHomeScreen() throws Exception{
	      	try{
	      		
	      		
	      		 Thread.sleep(3000);
	      	  	driver.findElement(By.xpath("//page-add-job-pickup//button[@ng-reflect-ng-class='back-button-md']")).click();
	      			

		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			
	      }	
	  
	  public static WebElement Add_job() throws Exception{
	      	try{
	      		
				 JavascriptExecutor jse = (JavascriptExecutor)driver;

//				 jse.executeScript("scroll(250, 0)"); // if the element is on top.

//				 jse.executeScript("arguments[0].scrollIntoView(true);", wEle);
				 jse.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
		
	      		
	      	    Thread.sleep(3000);
	      		element=driver.findElement(By.xpath("//*[contains(text(),'Add Job')] //ancestor::button[1]"));
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			return element;

	      }	

	  public static WebElement card_Header() throws Exception{
	      	try{
	      		
	      		Thread.sleep(5000);
	      	    utility.Utils.scrollPage();
//	      	    utility.Utils.scrollPage();
	      		element=driver.findElement(By.xpath("html/body/ion-app/app-root/ion-nav/page-add-job-pickup/ion-content/div[2]/form/ion-card[4]/ion-card-header/button"));
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			return element;

	      }	
	  
	  
	  public static WebElement Autoselect_address() throws Exception{
	      	try{
	      		element=null ;
//	      		element=driver.findElement(By.xpath(" //*[@class='address-grid']/ion-row[2]/ion-col/p"));
	      		
	      		Thread.sleep(10000);
	      		
	      		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='address-grid']//ion-row"));
	      		
//	      		for (WebElement ele: allOptions) {
//	      			String option = ele.getText();
////	      			System.out.println("selenium webdriver"+" "+option);
//	      		}
//		        
	      		Thread.sleep(2000);
	      		while(element==null){
	      		
	      			System.out.println("element not found");
	      			element= allOptions.get(0);
	      		
	      		}
	      		
	      		
	      		Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			return element;

	      }	

	  public static WebElement AutoAssigned_toggle() throws Exception{
	      	try{
	      		
	      	    utility.Utils.scrollPage();
	      		
	      		element=driver.findElement(By.xpath("//*[@checked='isAutoAssigned']//button"));
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			return element;

	      }
	public static WebElement pageTitle() {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}	

	  
}
