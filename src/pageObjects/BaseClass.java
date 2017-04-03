package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class BaseClass {
	
	public static  WebDriver driver;
	public static boolean bResult=true;
	
	
	public  BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		BaseClass.bResult = true;
	}
	
	 public static boolean isElementPresent (WebElement ele,String LocaterName)
		{

			boolean Status=false;
			try
			{

			Status= ele.isDisplayed();
			}
			catch(Exception e)
			{
				System.out.println("ERROR: Element "+LocaterName+" is not Visible");
			    e.printStackTrace();
			    System.out.println(e);
			}
		  
			return Status;
		}
	
	 public static void navigateBack()
     {
         driver.navigate().back();
     
     }
     
	 public static WebElement FindElement(By ele, String LocaterName)
		{
		
			WebElement Welement=null;
			
			try
			{
			
				Welement =driver.findElement(ele);
		
			}
			catch(Exception e)
			{
				
				System.out.println("ERROR: Element "+LocaterName+"Not Found");
			}
			return Welement;
		}
	 
	 public static void errorOccured(WebElement ele, String selector) {
        
    	
    	 System.out.println("ERROR:"+ele +selector);
    	 
    	
    	 
     }
	 
	 public static By FindObject(String Locater)
		{
		By element=null;
				
		        if(Locater.contains("/"))
				{
					element=By.xpath(Locater);
				}

				else
				{

					element=By.id(Locater);
				
				}
				
		        return element;
		}	

//	 public static void scrollPage(By ele, String selector)
//     {
//    	 WebElement wEle = FindObject(ele, selector);
//    	 
//    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wEle);
//     }
//     
    
	 public static void getCurrentURL(){
			
			System.out.println("Reloading browser ");
			driver.get(driver.getCurrentUrl()) ;
			
			
			
		}
	 
}
