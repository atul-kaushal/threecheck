package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class CreateUser_page extends User_management{

	public CreateUser_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 private static WebElement element = null;

	public static WebElement firstName() throws Exception{
      	try{
      		element=driver.findElement(By.xpath("//input[@name='firstName']"));
	            Log.info("Password text box is found on the Login page");
      	}catch (Exception e){
      		Log.error("Password text box is not found on the Login Page");
         		throw(e);
         		}
		return element;

      }
	public static WebElement lastName() throws Exception{
      	try{
      		element=driver.findElement(By.xpath("//input[@name='lastName']"));
	            Log.info("Password text box is found on the Login page");
      	}catch (Exception e){
      		Log.error("Password text box is not found on the Login Page");
         		throw(e);
         		}
		return element;

      }
	
	public static WebElement emailId() throws Exception{
      	try{
      		element=driver.findElement(By.xpath("//input[@name='email']"));
	            Log.info("Password text box is found on the Login page");
      	}catch (Exception e){
      		Log.error("Password text box is not found on the Login Page");
         		throw(e);
         		}
		return element;

      }

	public static WebElement mobileNo() throws Exception{
      	try{
      		element=driver.findElement(By.xpath("//input[@name='mobtelephoneile']"));
	            Log.info("Password text box is found on the Login page");
      	}catch (Exception e){
      		Log.error("Password text box is not found on the Login Page");
         		throw(e);
         		}
		return element;

      }
	
	public static WebElement selectPermission() throws Exception{
      	try{
      		element=driver.findElement(By.xpath("//ion-checkbox[@name='selectAll']//button"));
	            Log.info("Password text box is found on the Login page");
      	}catch (Exception e){
      		Log.error("Password text box is not found on the Login Page");
         		throw(e);
         		}
		return element;

      }
	
	public static WebElement selectTeam() throws Exception{
      	try{
      		
      		
      		driver.findElement(By.xpath("//*[@placeholder='Select teams']//button")).click();
      		
      		Thread.sleep(3000);
        	driver.findElement(By.xpath("//ion-alert/div"));
      		
      		element= driver.findElement(By.xpath("//div[@class='alert-checkbox-group']//button[1]"));
        	
      			
	            Log.info("Password text box is found on the Login page");
      	}catch (Exception e){
      		Log.error("Password text box is not found on the Login Page");
         		throw(e);
         		}
		return element;

      }
	
	public static WebElement selectVehicle() throws Exception{
      	try{
      		
      		
      		driver.findElement(By.xpath("//*[@placeholder='Select Vehicle']//button")).click();
      		
      		Thread.sleep(3000);
        	driver.findElement(By.xpath("//ion-alert/div"));
      		
      		element= driver.findElement(By.xpath("//div[@class='alert-radio-group']//button[1]"));
        	
      			
	            Log.info("Password text box is found on the Login page");
      	}catch (Exception e){
      		Log.error("Password text box is not found on the Login Page");
         		throw(e);
         		}
		return element;

      }
	

	public static void selectRole(String rol) throws Exception{
      	try{
      		            Thread.sleep(3000);
      		        	driver.findElement(By.xpath("//*[@placeholder='Select Roles']//button")).click();
		            	

		          		Thread.sleep(3000);
		            	driver.findElement(By.xpath("//ion-alert/div"));
		            	
		            	 String[] roles= rol.split(",");
		          	   
		          	   for(int count=0 ;count<=roles.length-1;count++){    
		          	  
		          		   System.out.println(roles[count]);
		          		   
		          		   CreateUser_page.clickMultiRole(roles[count]);
		          	  
		          		      
		          		   
		          	   }
		            	
      	}
      	catch(Exception e){
      		
      		
      	}
	}   
      	public static void clickMultiRole(String rol) throws Exception{
		try{
      		if(rol.equalsIgnoreCase("Driver")){
      		
      		
      		Thread.sleep(3000);
          	WebElement option1=driver.findElement(By.xpath("//div[@class='alert-checkbox-group']//button//div[contains(.,'Driver')]"));
         		option1.click();
       
      	
     
      		}
      		if(rol.equalsIgnoreCase("Dispatcher")){
           	
          	Thread.sleep(3000);

          	WebElement option2=driver.findElement(By.xpath("//div[@class='alert-checkbox-group']//button//div[contains(.,'Dispatcher')]"));
         
          	option2.click() ;
     		
         
          		}
      	
	if(rol.equalsIgnoreCase("Organization Admin")){
          		
        	Thread.sleep(5000);
          	WebElement option3=driver.findElement(By.xpath(" //div[@class='alert-checkbox-group']//button//div[contains(.,'Organization Admin')]"));
         option3.click();
          	
         
          		}
      	}
		catch (Exception e){
  			
      		e.printStackTrace();
      	
      		System.out.println(e.getMessage());
         	
      	}	
	
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
	
	public static WebElement addUserButton() throws Exception{
      	try{
      		element=driver.findElement(By.xpath("//button[contains( .,'Add User')]"));
	            Log.info("Password text box is found on the Login page");
      	}catch (Exception e){
      		Log.error("Password text box is not found on the Login Page");
         		throw(e);
         		}
		return element;

      }

	

}

