package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.reporter.configuration.Theme;

import utility.Log;

public class CreateHub_page extends User_management {

	public CreateHub_page(WebDriver driver) {
		super(driver);
	
	}
		 private static WebElement element = null;
		 
		 
		 public static void selectHubTab() throws Exception{
		      	try{
		      		    driver.findElement(By.xpath("//a[contains(.,'Hubs')]")).click();
		      		    
		      		    Thread.sleep(5000) ;
		      		  driver.findElement(By.xpath("//page-tab-hubmngt/button")).click();
		      		
			            
		      	}catch (Exception e){
		      		e.printStackTrace();
		      		System.out.println(e);
		         		}
				

		      }

		 
		 public static WebElement pageTitle() throws Exception{
		      	try{
		      		   element= driver.findElement(By.xpath("//h3[contains(.,'Drivers and Users')]"));
		      		   
			           
		      	}catch (Exception e){
		      		e.printStackTrace();
		      		System.out.println(e);
		         		}
				return element;
				

		      }

		
		 

			public static WebElement hubName() throws Exception{
		      	try{
		      		element=driver.findElement(By.xpath("//input[@name='name']"));
			            Log.info("Password text box is found on the Login page");
		      	}catch (Exception e){
		      		Log.error("Password text box is not found on the Login Page");
		         		throw(e);
		         		}
				return element;

		      }
		
			public static void selectTeam() throws Exception{
		      	try{
		      		driver.findElement(By.xpath("//*[@placeholder='Select Teams']")).click();
		      		
		      		driver.findElement(By.xpath("//ion-alert/div"));
		      		
		      	
		      		
		         List<WebElement> alloptions=driver.findElements(By.xpath("//*[@class='alert-checkbox-group']//button"));
		         
		         
		         for(WebElement wele: alloptions){
		        	 
		        	 System.out.println(wele);
		         }
		         
		         Thread.sleep(3000);
		         alloptions.get(0).click();

		         
			            Log.info("Password text box is found on the Login page");
		      	}catch (Exception e){
		      		Log.error("Password text box is not found on the Login Page");
		         		throw(e);
		         		}
				
		      }

		
			 public static WebElement hubAddress( ) throws Exception{
			      	try{
			      		Thread.sleep(3000) ;
			      	element=	driver.findElement(By.xpath("//input[@name='address']"));
			      		
				            Log.info("Password text box is found on the Login page");
			      	}catch (Exception e){
			      		Log.error("Password text box is not found on the Login Page");
			         		throw(e);
			         		}
					return element;
					
			      }
			 
			  public static WebElement Autoselect_address() throws Exception{
			      	try{
			      		
			      		Thread.sleep(8000);
			      		 List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='address-grid']//ion-row"));
			      		
			      		 System.out.println("Size of alloption"+allOptions.size());
			      		element= allOptions.get(0);
			      		
			      		Log.info("Password text box is found on the Login page");
			      	}catch (Exception e){
			      		Log.error("Password text box is not found on the Login Page");
			         		throw(e);
			         		}
					return element;

			      }	
			 
			 
				public static WebElement oK() throws Exception{
			      	try{
			      		element=driver.findElement(By.xpath("//button[contains(.,'OK')]"));
				            Log.info("Password text box is found on the Login page");
			      	}catch (Exception e){
			      		Log.error("Password text box is not found on the Login Page");
			         		throw(e);
			         		}
					return element;

			      }
			
				public static WebElement addHub() throws Exception{
			      	try{
			      		element=driver.findElement(By.xpath("//button[contains(.,'Add Hub')]"));
				            Log.info("Password text box is found on the Login page");
			      	}catch (Exception e){
			      		Log.error("Password text box is not found on the Login Page");
			         		throw(e);
			         		}
					return element;

			      }
				
				
					public static WebElement successToast(){
					String message ;
					
					try{
			      	 element=driver.findElement(By.xpath("//div[@class='toast-message']"));
			      	 
			      	message= 	 element.getText();
			      	 
			      		
			      		System.out.println("Message is "+message);
				           
			      	}catch (Exception e){
			      		Log.error("Password text box is not found on the Login Page");
			         		throw(e);
			         		}
					
					return element ;
					}

}

