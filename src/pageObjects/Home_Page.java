package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utility.Log;
import utility.Utils;
    public class Home_Page extends BaseClass{
            private static WebElement element = null;
        public Home_Page(WebDriver driver){
            	super(driver);
        }    

        
        
        public static WebElement Ok() throws Exception{
	      	try{
	      		
	      		Thread.sleep(2000) ;
	      		System.out.println("enter into OK press");
	      		
	      		driver.findElement(By.xpath("//div[@class='alert-button-group']")).click() ;
	      		
	      		element=driver.findElement(By.xpath("//button[contains(.,'Ok')]"));
	      	          
	      		    
		            Log.info("Clicked on OK conformation");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			return element;
			

	      }	
        
        
        public static WebElement pageTitle() throws Exception{
	      	try{
	      		
	      		System.out.println("enter into OK press");
	      		
	      		element=driver.findElement(By.xpath("//h3[contains(.,'Jobs')]")) ;
	      	    
		            Log.info("Clicked on OK conformation");
	      	}catch (Exception e){
	      		Log.error("Password text box is not found on the Login Page");
	         		throw(e);
	         		}
			return element;
			

	      }	
        public static WebElement Click_AddJob_Icon() throws Exception{
        	
try{
				
				
    			element = driver.findElement(By.xpath("//button[@class='add-btn fab fab-md fab-md-primary']"));
    			
    			Utils.scrollPage();
    			Log.info("Product category link is found under Top Navigation");
//    			Utils.mouseHoverAction(mainElement, "Accessories");
			}catch (Exception e){
				Log.error("Accessories link is not found under Product Category");
				throw(e);
			}
			return element;
        	
           
        }                
        
        
        public static WebElement Create_job() throws Exception{
			try{
				
				
    			element = driver.findElement(By.xpath("//*[@class='add-btn fab fab-md fab-md-primary']"));
    			
    			Utils.scrollPage();
    			Log.info("Product category link is found under Top Navigation");
//    			Utils.mouseHoverAction(mainElement, "Accessories");
			}catch (Exception e){
				Log.error("Accessories link is not found under Product Category");
				throw(e);
			}
			return element;
           }
       // :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        public static WebElement ClickMenuIcon() throws Exception{
			try{
				
				
    			element = driver.findElement(By.xpath("//ion-nav[ @class='menu-content menu-content-overlay']//button[@menutoggle='']"));
    			
    			Utils.scrollPage();
    			Log.info("Clicked on Menu Navigation");
//    			Utils.mouseHoverAction(mainElement, "Accessories");
			}catch (Exception e){
				Log.error("Accessories link is not found under Product Category");
				throw(e);
			}
			return element;
           }
        
        public static class MenuNavigation{
        	
        			static WebElement mainElement;
      		
        			public static WebElement Edit_profile() throws Exception{
        				try{
        	    			element = driver.findElement(By.xpath(".//*[@id='adminInMenu']/div/ion-header/button"));
        	    			//div[@class='menu-inner']/ion-header/button
        	    			Log.info("menu list");
//        	    			Utils.mouseHoverAction(mainElement, "Accessories");
        				}catch (Exception e){
        					Log.error("Accessories link is not found under Product Category");
        					throw(e);
        				}
        				return element;
        	           }
        	        
        			
        			
        			public static WebElement userManagement() throws Exception{
        			try{
//        				Home_Page.robotClass(6);
	        			mainElement = driver.findElement(By.xpath(".//button[contains(.,'Drivers and Users')]"));
	        			Log.info("Product category link is found under Top Navigation");
//	        			Utils.mouseHoverAction(mainElement, "iMacs");
        			}catch (Exception e){
        				Log.error("Accessories link is not found under Product Category");
        				throw(e);
        			}
					return mainElement;
                   }
        		
        		public static void Job_Management() throws Exception{
        			try{
	        			mainElement = driver.findElement(By.xpath(".//button[contains(.,'Jobs')]"));
	        			Log.info("Product category link is found under Top Navigation");
//	        			Utils.mouseHoverAction(mainElement, "iPads");
        			}catch (Exception e){
        				Log.error("Accessories link is not found under Product Category");
        				throw(e);
        			}
                   }
        		
        		public static void Vehicle_Management() throws Exception{
        			try{
	        			 driver.findElement(By.xpath(".//button[contains(.,'Vehicles')]")).click();
	        			Log.info("Product category link is found under Top Navigation");
//	        			Utils.mouseHoverAction(mainElement, "iPhones");
        			}catch (Exception e){
        				Log.error("Accessories link is not found under Product Category");
        				throw(e);
        			}
					
                   }
        		
        		public static WebElement Message_Management() throws Exception{
        			try{
	        			mainElement = driver.findElement(By.xpath(".//button[contains(.,'Messages')]"));
	        			Log.info("Product category link is found under Top Navigation");
//	        			Utils.mouseHoverAction(mainElement, "iPhones");
        			}catch (Exception e){
        				Log.error("Accessories link is not found under Product Category");
        				throw(e);
        			}
					return mainElement;
                   }
        		public static void Settings() throws Exception{
        			try{
	        			mainElement = driver.findElement(By.xpath(".//button[contains(.,'Settings')]"));
	        			Log.info("Product category link is found under Top Navigation");
//	        			Utils.mouseHoverAction(mainElement, "iPhones");
        			}catch (Exception e){
        				Log.error("Accessories link is not found under Product Category");
        				throw(e);
        			}
                   }	
        

                public static WebElement lnk_LogOut() throws Exception{
                    try{
                    	System.out.println("Its time to logout !!!!!!!!");
                    	
                    System.out.println("finding logout button");
                    Thread.sleep(5000);
        	        	element = driver.findElement(By.xpath(".//button[contains(.,'Log Out')]"));
        	        	
        	            Log.info("Log Out link is found on the Home Page");
                    }catch (Exception e){
                    	Log.error("Log Out link is not found on the Home Page");
                   		throw(e);
                   		}
                   	return element;
                }
            
 
//      
        }
        
    
    }
