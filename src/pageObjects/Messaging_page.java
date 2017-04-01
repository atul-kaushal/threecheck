package pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Utils;

public class Messaging_page  extends BaseClass{

	
	
	  public Messaging_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	  public static WebElement element;
	  
	 
	public static boolean verifyAllEnabledMessages() throws Exception{
		     
		           boolean finalstatus=true ;
		  try{
		  				
			  int j=0 ;
		  				Thread.sleep(3000);
		      			 driver.findElement(By.xpath("//*[contains(.,'Delivery')]/div/button")).click();
		      			 
		      			
		      			List<WebElement> Deliverytitles = driver.findElements(By.xpath("//*[contains(.,'Delivery')]/div/div/ion-card"));
		      
		       			System.out.println("Checking delivery message status");
		      			int count =0 ;
		    for(WebElement header1 :Deliverytitles){  			
		      	
		    	         count++ ;   
		    			element = driver.findElement(By.xpath("//ion-card["+count+"]//ion-card-title//span"));
		      			
		      			String title1= element.getText() ;
		      			
		      				element = driver.findElement(By.xpath("//ion-card["+count+"]//ion-card-title//ion-toggle//button"));
		      			
		      			String status1=element.getAttribute("aria-checked");
		      	
		      			
		      			if(!status1.equals("true")){
		      				
		      				
		      				
		      				if(enableSms(element)==true) {
		      					
		      					
		      				}
		      				else{
		      				
		      					j++ ;
		      				}
		      				
		      				Utils.takeScreenshot(driver, title1) ;
		      				System.out.println(title1+" : is not Enabled ");
		      			}
		      			else{
		      				
		      				System.out.println(title1+": is Enabled ");
		      			}
		      			
		    }
		      			
		    Thread.sleep(3000);
 			 driver.findElement(By.xpath("//*[contains(.,'Delivery')]/div/button")).click();
		      			
		      			
		      			Thread.sleep(3000);
		      			driver.findElement(By.xpath("//*[contains(.,'Pickup')]/div/button")).click();
		      			
//		      		  JavascriptExecutor javascript = (JavascriptExecutor) driver;
//		      		  javascript.executeScript("window.scrollBy(0,600)", "");
//		      		  javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
		      			
		      			Thread.sleep(3000);
		      			List<WebElement> Pickuptitles = driver.findElements(By.xpath("//*[contains(.,'Pickup')]/div/div/ion-card"));

		   
		  ////////////////iterating pickup messages    			
		      			
		    System.out.println("Checking pickup message status");
		                         int position =0 ;
		      			for(WebElement header2 :Pickuptitles){  			
		    		      	
//		      				String title2=	header2.getAttribute("ion-card-title") ;
		      				position++ ;
		      				
			    			element = driver.findElement(By.xpath("//ion-card["+position+"]//ion-card-title//span"));
			      			
			      			String title2= element.getText() ;
			      			
			      				element = driver.findElement(By.xpath("//ion-card["+position+"]//ion-card-title//ion-toggle//button"));
			      			
			      			String status2=element.getAttribute("aria-checked");
			      	
			      		
			      			
			      			if(!status2.equals("true")){
			      				
			      				if(enableSms(element)==true) {
			      					
			      					
			      				}
			      				else{
			      				
			      					j++ ;
			      				}
			      				
			      				
			      			}
			      			else{
			      				
			      				System.out.println(title2+" : is Enabled ");
			      			}
			}

		      			
		   		     if(j!=0){
		   		    	 
		   		    	 finalstatus=false ;
		   		    	 
		   		             }
		   		     else 
		   		    
		   		    	 finalstatus=true ;
		  }
          catch(Exception e){

	
	
	}
		return finalstatus;	  
	}		   		    	

	         static boolean success =true ;
    public static boolean enableSms(WebElement disable) throws Exception{
		
    	Thread.sleep(3000);
    	
    	disable.click();
    	
    	
    	driver.findElement(By.xpath("html/body/ion-app/ion-alert/div/div[3]"));
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//button[contains(.,'Ok')]")).click();
		try{
    	
			success =driver.findElement(By.xpath("//div[contains(.,'Trigger enabled successfully')]")).isDisplayed();
    	
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
    	return success;
    	
    }  

}
	