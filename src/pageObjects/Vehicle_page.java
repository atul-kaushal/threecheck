package pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Utils;
public class Vehicle_page extends BaseClass{

	public Vehicle_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
public static WebElement element =null; 
 

public static WebElement clickToAddButton() throws Exception{

	
	return element= Utils.FindElement(By.xpath("//page-vehicle-management/button"),"Add button" );
	
}

public static WebElement make() throws Exception{

	
	return element= Utils.FindElement(By.xpath("//input[@name='make']")," Vehicle make" );
	
}

public static WebElement model() throws Exception{

	
	return element= Utils.FindElement(By.xpath("//input[@name='model']")," Vehicle make" );
	
}

public static WebElement VINnumber() throws Exception{

	
	return element= Utils.FindElement(By.xpath("//input[@name='vehicleIdentificationNumber']")," Vehicle make" );
	
}

public static WebElement VRNnumber() throws Exception{

	
	return element= Utils.FindElement(By.xpath("//input[@name='vehicleRegistrationNumber']")," Vehicle make" );
	
}

public static WebElement selectFuelType() throws Exception{

	
	Thread.sleep(2000);
	Utils.FindElement(By.xpath("//*[@placeholder='Select Fuel Type']//button"), "fuel type").click();
		
	
		Thread.sleep(3000);
		Utils.FindElement(By.xpath("//ion-alert/div")," Pop UP");
		

	     Thread.sleep(3000);
	        
List<WebElement> alloptions=driver.findElements(By.xpath("//*[@class='alert-radio-group']//button"));
     
     element= alloptions.get(0);
	
	
	return element ;
	
}

	 public static WebElement selectDriver() throws Exception{
			
	  

	     Thread.sleep(3000);
	        
      	 Utils.FindElement(By.xpath("//*[@placeholder='Select Driver']//button")," Driver Drop down").click();
      	 
      	 

         Thread.sleep(3000);
            
      	Utils.FindElement(By.xpath("//ion-alert/div"),"Pop up");
      	 

        Thread.sleep(3000);
           
      	 List<WebElement> driverlist=driver.findElements(By.xpath("//*[@class='alert-radio-group']//button"));
         
      	 
         Thread.sleep(3000);
         try{
        element= driverlist.get(0);
         
        
  	}catch (Exception e){
  		e.printStackTrace();
  		System.out.println(e);
      	 
		}
		return element;
 
	 }
	 
	 public static WebElement successToast(){
			
		     String message ;
			
	      	 element=Utils.FindElement(By.xpath("//div[@class='toast-message']"),"Toast message");
	      	 
	      	 message= 	 element.getText();
	      	 
//	      	 System.out.println("print message :" + message);
	      	 return element ;
			}
	 
	 
	 public static WebElement addButton(){
			
		 Utils.scrollPage();
		
      	 element=Utils.FindElement(By.xpath("//button[contains(.,'Add Vehicle')]"),"Add button.");
      	
      	 
      	 return element ;
		}
 
	 public static WebElement okPopUp(){
			
		  
			
      	 element=Utils.FindElement(By.xpath("//button[contains(.,'OK')]"),"Ok PopUp.");
      	
      	 
      	 return element ;
		}
 
}
