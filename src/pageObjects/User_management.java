package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Utils;

public class User_management extends BaseClass {

	 public User_management(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static WebElement element = null;
	
	public static class Users{
		
		
	 public static WebElement clickOnAddButton() throws Exception{
			try{
				
				
 			element = driver.findElement(By.xpath(".//*[@id='tabpanel-t0-0']/page-tab-usermngt/button"));
 			
 			Utils.scrollPage();
 			Log.info("Product category link is found under Top Navigation");
// 			Utils.mouseHoverAction(mainElement, "Accessories");
			}catch (Exception e){
				Log.error("Accessories link is not found under Product Category");
				throw(e);
			}
			return element;
        }
	
	 public static WebElement ViewUserDetails() throws Exception{
			try{
				
				
			element = driver.findElement(By.xpath("//*[@class='add-btn fab fab-md fab-md-primary']"));
			
			Utils.scrollPage();
			Log.info("Product category link is found under Top Navigation");
//			Utils.mouseHoverAction(mainElement, "Accessories");
			}catch (Exception e){
				Log.error("Accessories link is not found under Product Category");
				throw(e);
			}
			return element;
     }
	 
	 
	 
	}
	 
	public static class Teams{
	
		 public static WebElement clickOnAddButton() throws Exception{
				try{
					
	                     driver.findElement(By.xpath("Path to team tab"));
	                     
	 			element = driver.findElement(By.xpath("//*[@class='add-btn fab fab-md fab-md-primary']"));
	 			
	 			Utils.scrollPage();
	 			Log.info("Product category link is found under Top Navigation");
//	 			Utils.mouseHoverAction(mainElement, "Accessories");
				}catch (Exception e){
					Log.error("Accessories link is not found under Product Category");
					throw(e);
				}
				return element;
	        }
		
		 public static WebElement ViewTeamDetails() throws Exception{
				try{
					
					
				element = driver.findElement(By.xpath("//*[@class='add-btn fab fab-md fab-md-primary']"));
				
				Utils.scrollPage();
				Log.info("Product category link is found under Top Navigation");
//				Utils.mouseHoverAction(mainElement, "Accessories");
				}catch (Exception e){
					Log.error("Accessories link is not found under Product Category");
					throw(e);
				}
				return element;
	     }
		 
		 
		 
		}

	public static class Hubs{
		
		 public static WebElement clickOnAddButton() throws Exception{
				try{
					
					
	 			element = driver.findElement(By.xpath("//*[@class='add-btn fab fab-md fab-md-primary']"));
	 			
	 			Utils.scrollPage();
	 			Log.info("Product category link is found under Top Navigation");
//	 			Utils.mouseHoverAction(mainElement, "Accessories");
				}catch (Exception e){
					Log.error("Accessories link is not found under Product Category");
					throw(e);
				}
				return element;
	        }
		
		 public static WebElement ViewHubDetails() throws Exception{
				try{
					
					
				element = driver.findElement(By.xpath("//*[@class='add-btn fab fab-md fab-md-primary']"));
				
				Utils.scrollPage();
				Log.info("Product category link is found under Top Navigation");
//				Utils.mouseHoverAction(mainElement, "Accessories");
				}catch (Exception e){
					Log.error("Accessories link is not found under Product Category");
					throw(e);
				}
				return element;
	     }
		 
		 
		 
		}


}
