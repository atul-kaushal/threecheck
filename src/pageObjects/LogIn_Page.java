package pageObjects;

import java.util.Properties;

import org.openqa.selenium.*;

import com.aventstack.extentreports.model.ExceptionInfo;

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
        
        
        public static WebElement invalidCredentials() throws Exception{
        	try{ 
        		        boolean visible =false ;
        		   
        		element =null ;
//        		while( visible==true){
        		
        			try{
        			visible= isElementPresent(driver.findElement(By.xpath("//ion-alert/div/div[1]")),"Bad credential pop up ");
//        			       System.out.println("From 1"+visible);
        			    } 
        			
        			catch(Exception e){
        			
        				System.out.println("Exception in  1");
        			}
        			
        			
        			if(visible==true){
        				
        				System.out.println(" From 1 "+ visible);
        			return driver.findElement(By.xpath("//ion-alert/div/div[1]")) ;
        			   
        			}
        		
        			System.out.println("pop up crossed");
        			try{
            			visible= isElementPresent(usernameValidation(),"Username error ");
            			       
            		   } 
            			
            			catch(Exception e){
            				
            				System.out.println("Exception in  2");
            			}
            			
            			if(visible==true){
            				
            				System.out.println(" From 2 "+ visible);
            			return usernameValidation() ;
            			}
            			try{
                			visible= isElementPresent(passwordValidation()," password error ");
                			       
                		   } 
                			
                			catch(Exception e){
                				
                				System.out.println("Exception in  3");
                			}
                			
                			if(visible==true){
                		
                				System.out.println(" From 3 "+ visible);
                				return passwordValidation() ;
                			}
                		
 
        	}catch (Exception e){
           		Log.error("UserName text box is not found on the Login Page");
//           		e.printStackTrace();
//           		System.out.println(e.getMessage());
           		}
           	return element;
            }
        
        public static WebElement ionicLogo() throws Exception{
        	try{ 
	            element = driver.findElement(By.xpath("//page-login//img[contains(@src, 'logo')]"));
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
        
        public static WebElement passwordValidation() throws Exception{
        	try{
	        	element = driver.findElement(By.xpath("//p[contains(.,'Password is required')]"));
	            Log.info("Submit button is found on the Login page");
        	}catch (Exception e){
        		Log.error("Submit button is not found on the Login Page");
           		throw(e);
           		}
           	return element;
        
        }
        
        public static WebElement usernameValidation() throws Exception{
        	try{
	        	element = driver.findElement(By.xpath("//p[contains(.,'Username or Email is required')]"));
	            Log.info("Submit button is found on the Login page");
        	}catch (Exception e){
        		Log.error("Submit button is not found on the Login Page");
           		throw(e);
           		}
           	return element;
        
        }
        
        
    ///////////////////////////////////////////////Validation message//////////////////////////////////////////////
    
    	public static boolean isUserNamePresent() throws Exception{
    	return isElementPresent(LogIn_Page.txtbx_UserName(), "Username Feild");
    	
    	}
    	
    	public static boolean isPasswordFeildPresent() throws Exception{
    		return isElementPresent(LogIn_Page.txtbx_Password(), "Password Feild");
    		
    	}
    	
    	public static boolean isLoginInButtonPresent() throws Exception{
    		return isElementPresent(LogIn_Page.btn_LogIn(), "LogIn Button");
    		
    	}
    	
    	public static boolean isCreateAccountLinkPresent() throws Exception{
    		return isElementPresent(LogIn_Page.btn_Signup(), "Create Account link");
    		
    	}
    	
    	public static boolean isForgotPasswordLinkPresent() throws Exception{
    		return isElementPresent(LogIn_Page.btn_ForgotPassword(), "Forgot password link");
    		
    	}
    	
    	
    	public static boolean isInvalidCredentialValidationPresent() throws Exception{
    		return isElementPresent(LogIn_Page.invalidCredentials(), "Invalid Credentials Validation");
    		
    	}
    	
    	public static boolean isuserNameValidationPresent() throws Exception{
    		return isElementPresent(LogIn_Page.usernameValidation(), "Blank Password Validation");
    		
    	}
    	public static boolean isPasswordValidationPresent() throws Exception{
    		return isElementPresent(LogIn_Page.passwordValidation(), "Blank Password Validation");
    		
    	}
        
        
        
    }
