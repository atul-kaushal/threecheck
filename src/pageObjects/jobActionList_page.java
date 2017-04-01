package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Utils;



public class jobActionList_page extends BaseClass {

	public jobActionList_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	
	}

	 private static WebElement element = null;
	 
	 public JavascriptExecutor js ;
	  public static WebElement editJobDetails() throws Exception{
	     	try{
	     		
	     		driver.findElement(By.xpath("//ion-card[1]//ion-icon[@aria-label='more']")).click();
	     		
	     		Thread.sleep(4000);
	     		driver.findElement(By.xpath("//page-popover/ion-content/div[2]"));
	     		
	     	element= driver.findElement(By.xpath("//button[contains(.,'Edit')]"));
	     	
	     		
//	     		element.click() ;
	     	}
            catch(Exception e){
            	
            }
			return element;	  
	  
	  }
    
	  public static WebElement jobUpdateButton() throws Exception{
	     	try{
	     		
	     	element=	driver.findElement(By.xpath("//button[contains(.,'Update')]"));
	     		
	     	}
          catch(Exception e){
          	
        	  e.printStackTrace();
          }
			return element;	  
	 
	  }
	  public static void viewJobDetials() throws Exception{
	     	try{
	     		
	     		driver.findElement(By.xpath("//ion-card[1]//ion-icon[@aria-label='more']")).click();
	     		
	     		Thread.sleep(4000);
	     		driver.findElement(By.xpath("//page-popover/ion-content/div[2]"));
	     		
	     		
	     	driver.findElement(By.xpath("//button[contains(.,'View')]")).click();
	     	
           

	     	Thread.sleep(3000);
	     	driver.findElement(By.xpath("//page-add-job-pickup//button[@ng-reflect-ng-class='back-button-md']")).click();
     		
	   
	     		
//	     		element.click() ;
	     	}
          catch(Exception e){
          	
          }
			
	  
	  }
	  
	  public static void deleteJob() throws Exception{
	     	try{
	     		
	     		driver.findElement(By.xpath("//ion-card[3]//ion-icon[@aria-label='more']")).click();
	     		
	     		
	     		Thread.sleep(4000);
	     		driver.findElement(By.xpath("//page-popover/ion-content/div[2]"));
	     		
	     	driver.findElement(By.xpath("//button[contains(.,'Delete')]")).click();
	     	
	     	
     		driver.findElement(By.xpath("//div[@class='alert-button-group']"));

     		Thread.sleep(3000);

     		driver.findElement(By.xpath("//button[contains(.,'Ok')]")).click();
     		
//     		Thread.sleep(8000);
//     		driver.findElement(By.xpath("//page-add-job-pickup//button[@ng-reflect-ng-class='back-button-md']")).click();
//     		Thread.sleep(3000);
	     	}
          catch(Exception e){
          	
          }
			 
	  
	  }
	  
	  
	  public static void getJobDetails(int jobnumber) throws Exception{
          
     	 try{
     	
          List<WebElement> jobcarddetails= driver.findElements(By.xpath("//ion-card["+jobnumber+"]//div[@class='item-inner']//p"));
         
          String Jobstatus=driver.findElement(By.xpath("//ion-card["+jobnumber+"]//ion-avatar//p")).getText();
     	 
          String address =jobcarddetails.get(0).getText() ;
     
          
          element= driver.findElement(By.xpath("//ion-list/ion-card["+jobnumber+"]/ion-item//p[4]"));  
        
          String JobID=element.getText() ;
   
          String script = "return arguments[0].innerHTML";
          JobID = (String) ((JavascriptExecutor) driver).executeScript(script, element);
          
          
     String jobtiming =jobcarddetails.get(1).getText() ;
   
   String customerName =jobcarddetails.get(2).getText() ;
   
   Thread.sleep(5000);  	 
   
   System.out.println("Details of job :"+jobnumber+":::::::"  );
 
   System.out.println("Job ID :"+JobID );
   System.out.println("Status :"+Jobstatus );
   System.out.println("Address :"+address );
   System.out.println("time frame :"+jobtiming);
   System.out.println("Customer name : "+customerName );
      
//   if(jobnumber==10){
//	  JavascriptExecutor javascript = (JavascriptExecutor) driver;
////	  javascript.executeScript("window.scrollBy(0,600)", "");
//	  javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");  
//   }
   
   Utils.createJobDataMap(jobnumber,JobID, Jobstatus, address, jobtiming, customerName);
     	 
     	 }
     	 catch(Exception e){
         	
     		 e.printStackTrace();
     		 System.out.println(e.getMessage());
          }  	 
}

public static void createJobRecordFile(){
	
	try{
	
		Utils.writeToExcelFile() ;
	   }
   catch(Exception e){
	
	 e.printStackTrace();
	 System.out.println(e.getMessage());
 }
	
}
	  
	  public static void getJoblist() throws Exception{

     	 
       List<WebElement> user= driver.findElements(By.xpath("//*[contains(@class,'list')]//ion-card"));
 
       int Jobcount=user.size();
       
//       Map<String, Object[]> data = new TreeMap<String, Object[]>();
      
       for(int j=1 ;j<=Jobcount ;j++){
       
    	   
    	   getJobDetails(j) ;
      
       }
      
       Thread.sleep(6000); 

      }
	  
	  
	  
}
   
