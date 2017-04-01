package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;
import utility.Utils;
public class Filter_page extends BaseClass {

	public Filter_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static WebElement element;
	public static WebElement Click_filter_Icon() throws Exception{
    	
		
		try{
		    
			element = driver.findElement(By.xpath("//div[@class='item-inner']//div[1]//button[contains(@class,'filterBtn button')]"));
		    			
		    			Utils.scrollPage();
		    			Log.info("Product category link is found under Top Navigation");
//		    			Utils.mouseHoverAction(mainElement, "Accessories");
					}catch (Exception e){
						Log.error("Accessories link is not found under Product Category");
						throw(e);
					}
					return element;
		           
		        }     
	
public static WebElement selectAllJobs() throws Exception{
    	try{
    		
			driver.findElement(By.xpath("//div[@class='popover-content']")).click();
    		
    		
			driver.findElement(By.xpath("//ion-toggle[@name='isTodaysJob']")).click();
		    			
			driver.findElement(By.xpath("//ion-toggle[@name='allJob']")).click();
			
			element = driver.findElement(By.xpath("//button[contains(.,'Apply')]"));
			
			
		    			Utils.scrollPage();
		    			Log.info("Product category link is found under Top Navigation");
//		    			Utils.mouseHoverAction(mainElement, "Accessories");
					}catch (Exception e){
						Log.error("Accessories link is not found under Product Category");
						throw(e);
					}
					return element;
		           
		        }     
	
}
