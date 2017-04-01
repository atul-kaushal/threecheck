package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class CreateTeam_page extends User_management{

	public CreateTeam_page(WebDriver driver) {
		super(driver);
		
	}
	
	 private static WebElement element = null;

	 
	 
	

	 public static void selectTeamTab() throws Exception{
	      	try{
	      		    driver.findElement(By.xpath("//a[contains(.,'Teams')]")).click();
	      		    
	      		    
	      		    Thread.sleep(3000);
	      		  driver.findElement(By.xpath("//page-tab-teammngt/button")).click();
	      		
		            
	      	}catch (Exception e){
	      		e.printStackTrace();
	      		System.out.println(e);
	         		}
			

	      }

	 
	 public static WebElement teamName() throws Exception{
	      	try{
	      		element=driver.findElement(By.xpath("//*[contains(.,'Team Name')]//input[@name='name']"));
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			return element;

	      }
	
		public static WebElement selectHub() throws Exception{
	      	try{
	      		
	      		Thread.sleep(2000);
	      		driver.findElement(By.xpath("//*[@name='hub']//button")).click();
	      		
	      		driver.findElement(By.xpath("//ion-alert/div")) ;
	      		
	      		Thread.sleep(2000);
	         List<WebElement> alloptions=driver.findElements(By.xpath("//*[@class='alert-radio-group']//button"));
	         
	         
	         for(WebElement wele: alloptions){
	        	 
	        	 System.out.println(wele);
	         }
	         element= alloptions.get(0);
	         
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			return element;

	      }

		public static WebElement selectDriver() throws Exception{
	      	try{
	      		
	      		Thread.sleep(2000);
	      		driver.findElement(By.xpath("//*[@name='driver']//button")).click();
	      		
	      		
	      		driver.findElement(By.xpath("//ion-alert/div")) ;
	      	
	      		Thread.sleep(2000);	
	      		 List<WebElement> alloptions=driver.findElements(By.xpath("//div[@class='alert-checkbox-group']//button"));
		         
		         for(WebElement wele: alloptions){
		        	 
		        	 System.out.println(wele);
		         }
		         element= alloptions.get(0);
	      		
	      		
	      		
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			return element;

	      }
		
		
		public static WebElement selectDispatcher() throws Exception{
	      	try{
	      		Thread.sleep(2000);
	      		
	      		driver.findElement(By.xpath("//*[@name='dispatcher']//button")).click();
	      		
	      		driver.findElement(By.xpath("//ion-alert/div")) ;
	      		
	      		Thread.sleep(2000);
	      		 List<WebElement> alloptions=driver.findElements(By.xpath("//div[@class='alert-checkbox-group']//button"));
		         
		         for(WebElement wele: alloptions){
		        	 
		        	 System.out.println(wele);
		         }
		         element= alloptions.get(0);
	      		
	      		
	      		
		            Log.info("Password text box is found on the Login page");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			return element;

	      }

		public static WebElement addTeam() throws Exception{
	      	try{
	      		
	      		Thread.sleep(5000);
	      		element=driver.findElement(By.xpath("//button[contains(.,'Add Team')]"));
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
