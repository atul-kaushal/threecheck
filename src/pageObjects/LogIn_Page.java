package pageObjects;

import java.util.Properties;

import org.openqa.selenium.*;

import property.ObjectMap;

import utility.Log;
    public class LogIn_Page extends BaseClass {
           private static WebElement element = null;
           
           static Properties config=ObjectMap.getInstance().getPropertyObj();
           
        public LogIn_Page(WebDriver driver) throws Exception{
        	
            	super(driver);

   			 System.out.println("Property class loaded");
        }     
        
        
        public static WebElement txtbx_UserName() throws Exception{
        	try{ 
	            element = driver.findElement(By.xpath(config.getProperty("txtbx_UserName")));
	            Log.info("Username text box is found on the Login Page");
        	}catch (Exception e){
           		Log.error("UserName text box is not found on the Login Page");
           		e.printStackTrace();
           		System.out.println(e.getMessage());
           		}
           	return element;
            }
        
        public static WebElement ionicLogo() throws Exception{
        	try{ 
	            element = driver.findElement(By.xpath("//img[contains(@src,'threecheck1.png')]"));
	            Log.info("Username text box is found on the Login Page");
        	}catch (Exception e){
           		Log.error("UserName text box is not found on the Login Page");
           		e.printStackTrace();
           		System.out.println(e.getMessage());
           		}
           	return element;
            }
        
      
        public static WebElement txtbx_Password() throws Exception{
        	
        	try{
	        	element = driver.findElement(By.xpath(config.getProperty("txtbx_Password")));
	            Log.info("Password text box is found on the Login page");
        	}catch (Exception e){
        		Log.error("Password text box is not found on the Login Page");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement btn_LogIn() throws Exception{
        	
        	try{
	        	element = driver.findElement(By.xpath(config.getProperty("btn_LogIn")));
	            Log.info("login button is found on the Login page");
        	}catch (Exception e){
        		Log.error("Submit button is not found on the Login Page");
           		throw(e);
           		}
           	return element;
        
        }
        public static WebElement btn_Signup() throws Exception{
        	try{
	        	element = driver.findElement(By.xpath(config.getProperty("btn_Registration")));
	            Log.info("Submit button is found on the Login page");
        	}catch (Exception e){
        		Log.error("Submit button is not found on the Login Page");
           		throw(e);
           		}
           	return element;
        
        }
    
        public static WebElement btn_ForgotPassword() throws Exception{
        	try{
	        	element = driver.findElement(By.xpath(config.getProperty("btn_Registration")));
	            Log.info("Submit button is found on the Login page");
        	}catch (Exception e){
        		Log.error("Submit button is not found on the Login Page");
           		throw(e);
           		}
           	return element;
        
        }
    
    }
