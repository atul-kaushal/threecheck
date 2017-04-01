package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Utils;

public class Registration_page extends BaseClass {

	public Registration_page(WebDriver driver) {
		super(driver);
	}
	 private static WebElement element = null;
	 
	 public static WebElement orgnName() throws Exception{
	      	try{
	      		element=Utils.fluentWait(By.xpath("//input[@name='organizationName']"));
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		e.printStackTrace();
	         		System.out.println(e.getMessage());
	         		}
			return element;

	      }
	 
	 public static WebElement selectcountry(String country) throws Exception{
	      	try{
	      		Utils.fluentWait(By.xpath("//input[@name='country']")).sendKeys(country);
	      		
//	      		Thread.sleep(3000);
	      	          Utils.fluentWait(By.xpath("//ion-grid//ion-row"));
	      		
	      		
	      		  element= Utils.fluentWait(By.xpath("//ion-grid//ion-row[1]"));
	      		  
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	      		e.printStackTrace();
         		System.out.println(e.getMessage());
	         		}
			return element;
	      }
	 
	 public static WebElement selectTimezone() throws Exception{
	      	try{
	      		WebElement timezone= Utils.fluentWait(By.xpath("//*[@name='timeZone']//button"));
                timezone.click();

        		Utils.fluentWait(By.xpath("html/body/ion-app/ion-alert/div"));
        		
        		Thread.sleep(3000);
        		             Utils.fluentWait(By.xpath("//*[@class='alert-radio-group']//button[1]")).click();
        		
        		
        		element = Utils.fluentWait(By.xpath("//button[contains(.,'OK')]"));
                
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	      		e.printStackTrace();
         		System.out.println(e.getMessage());
	         		}
			return element;

	      }
	 
	 public static WebElement okDone() throws Exception{
	      	try{
	      		element	= Utils.fluentWait(By.xpath("//button[contains(.,'OK')]"));

		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	      		e.printStackTrace();
         		System.out.println(e.getMessage());
	         		}
			return element;

	      }
	 
	 public static WebElement firstName() throws Exception{
	      	try{
	      		element	=  Utils.fluentWait(By.xpath("//input[@name='firstName']"));

		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	      		e.printStackTrace();
         		System.out.println(e.getMessage());
	         		}
			return element;

	      }

	 public static WebElement lastName() throws Exception{
	      	try{
	      		element	= Utils.fluentWait(By.xpath("//input[@name='lastName']"));

		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	      		e.printStackTrace();
         		System.out.println(e.getMessage());
	         		}
			return element;

	      }
	 public static WebElement mobileNumber() throws Exception{
	      	try{
	      		element	= Utils.fluentWait(By.xpath("//input[contains(@name,'telephone')]"));

		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	      		e.printStackTrace();
         		System.out.println(e.getMessage());
	         		}
			return element;

	      }

	 public static WebElement emailField() throws Exception{
	      	try{
	      		element	= Utils.fluentWait(By.xpath("//input[@name='email']"));
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	      		e.printStackTrace();
         		System.out.println(e.getMessage());
	         		}
			return element;

	      }

	 public static WebElement submitField() throws Exception{
	      	try{
	      		element	= Utils.fluentWait(By.xpath("//button[contains(.,'Submit')]"));
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	      		e.printStackTrace();
         		System.out.println(e.getMessage());
	         		}
			return element;

	      }
	
      }
