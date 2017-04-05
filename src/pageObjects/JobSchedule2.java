package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class JobSchedule2 extends BaseClass{


	public JobSchedule2(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static WebElement element =null;


	public static String evaluatCurrentTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
		System.out.println( sdf.format(cal.getTime()) );

		String  currenttime= sdf.format(cal.getTime());

		//	        System.out.println(currenttime+" from method");
		return currenttime;

	}

	public static int syshour ;

	public static int sysmin ;

	public static String sysmeridian ;

	static int  expmonth;
	static  int  expDate ;
	static  int  expYear ;

	static WebElement month ;
	static WebElement today ;
	static WebElement year ;

	static	 int  Displayear ;
	static int  DisplayMonth ; 
	static int  Displayday  ;

	static int endhrs=01 ;
	static  int endmin=00 ;

	//	  static int starthrs=01 ;
	//	  static  int startmin=00 ;
	static int Displayhour;
	static	int Displaymin;
	static String Displaymeridian;

	static  int exphour ;
	static	int expmin ;
	static String expmeridian;

	static  int currentDate ;

	public static WebElement Start_time() throws Exception{
		try{

			utility.Utils.scrollPage();

			element=driver.findElement(By.xpath("//ion-datetime[@name='startTimeBefore']//button"));
			Log.info("Password text box is found on the Login page");
		}catch (Exception e){
			Log.error("Password text box is not found on the Login Page");
			throw(e);
		}
		return element;

	}	
	public static WebElement Jobend_time() throws Exception{
		try{

			utility.Utils.scrollPage();

			element=driver.findElement(By.xpath("//ion-datetime[@name='endTimeBefore']//button"));
			Log.info("Password text box is found on the Login page");
		}catch (Exception e){
			Log.error("Password text box is not found on the Login Page");
			throw(e);
		}
		return element;

	}	

	public static  void Datepicker(int a,int b,int c) throws Exception{

		expmonth=a;
		expDate =b;
		expYear =c;

		try{

			boolean  dateNotFound = true;
			//      	    utility.Utils.scrollPage();

			JavascriptExecutor javascript = (JavascriptExecutor) driver;
			javascript.executeScript("window.scrollBy(0,600)", "");


			Thread.sleep(2000);
			driver.findElement(By.xpath("//ion-card-header[contains(.,'Complete Between')]//button")).click();
			Thread.sleep(2000);
			utility.Utils.scrollPage();

			driver.findElement(By.xpath("//ion-datetime[@name='selectedJobDate1']//button")).click();
			//      		 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='picker-toolbar']"));
	
			month=	driver.findElement(By.xpath("//div[@class='picker-columns']/div[2]//button[@class='picker-opt picker-opt-selected']")) ;

			today=	driver.findElement(By.xpath("//div[@class='picker-columns']/div[3]//button[@class='picker-opt picker-opt-selected']")) ;
			//	        	

			year=	driver.findElement(By.xpath("//div[@class='picker-columns']/div[4]//button[@class='picker-opt picker-opt-selected']")) ;


			DisplayMonth = Integer.parseInt(month.getText());
			//	       
			Displayday = Integer.parseInt(today.getText());

			currentDate= Displayday ; 
			//	       
			Displayear = Integer.parseInt(year.getText());
			//	       
			while(dateNotFound){      
				if(DisplayMonth==expmonth && (Displayday==expDate) && (Displayear==expYear)){
					 	   
					System.out.println("Case 1 ");
					dateNotFound = false;
				}
				else if((expmonth == DisplayMonth) && (expDate>Displayday) && (expYear== Displayear)){

					System.out.println("Case 2");

					Displayday=Integer.parseInt(selectDate(expDate,Displayday).getText());

				}   
				else if((expmonth > DisplayMonth) && (expDate==Displayday) && (expYear== Displayear) ){

					System.out.println("Case 3");
					
					
					DisplayMonth=Integer.parseInt(selectMonth(expmonth).getText());  



				}	   
				//        	
				else if((expmonth > DisplayMonth) && (expDate<Displayday) && (expYear== Displayear) ){

					System.out.println("Case 4");
					
					DisplayMonth=Integer.parseInt(selectMonth(expmonth).getText());  


					Displayday=Integer.parseInt(selectDate(expDate,Displayday,1).getText());

				}
				else if((expmonth > DisplayMonth) && (expDate>Displayday) && (expYear== Displayear) ){

					System.out.println("Case 5");
						  
					DisplayMonth=Integer.parseInt(selectMonth(expmonth).getText());  



					Displayday=Integer.parseInt(selectDate(expDate,Displayday,1).getText());
				} 


			}

			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[contains(.,'Done')]")).click();

		}
		catch (Exception e){
			Log.error("Password text box is not found on the Login Page");
			throw(e);
		}

	}	

	public static WebElement selectDate(int expdate ,int Displayday) throws Exception
	{
		System.out.println("Into select date");
		int n=0 ;

		while(Displayday!=expdate){	  

			n++ ;
			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@class='picker-columns']/div[3]//button[@class='picker-opt']["+n+"]")).click() ;

			//div[@class='picker-columns']/div[3]//button[@class='picker-opt'][1]
			Thread.sleep(1000);
			today=driver.findElement(By.xpath("//div[@class='picker-columns']/div[3]//button[@class='picker-opt picker-opt-selected']")); 

			Displayday = Integer.parseInt(today.getText());

		}
		System.out.println("clicked"+ n);
		return today;

	} 

	//  ::::: overloaded method ::::::::::::::::::::::::::::::::::::::


	public static WebElement selectDate(int expdate ,int Displayday, int v) throws Exception
	{

		System.out.println("Into select date");
		int n=Displayday ;

		if (expdate<Displayday){

			while(expdate!=Displayday){	  

				if(n==31){

					n-- ;
				}

				n-- ;
//				Thread.sleep(1000);

				driver.findElement(By.xpath("//div[@class='picker-columns']/div[3]//button[@class='picker-opt']["+n+"]")).click() ;

				today=driver.findElement(By.xpath("//div[@class='picker-columns']/div[3]//button[@class='picker-opt picker-opt-selected']")); 

				Displayday = Integer.parseInt(today.getText());


			} 

		}
		else{
			while(expdate!=Displayday){	  


//				Thread.sleep(2000);

				System.out.println("New  date :"+n);

				driver.findElement(By.xpath("//div[@class='picker-columns']/div[3]//button[@class='picker-opt']["+n+"]")).click() ;

				today=driver.findElement(By.xpath("//div[@class='picker-columns']/div[3]//button[@class='picker-opt picker-opt-selected']")); 

				Displayday = Integer.parseInt(today.getText());

				System.out.println("New  date :"+n);

				n++ ;

			} 

		}
		return today;
	}

	public static WebElement selectMonth(int expmonth) throws Exception
	{


		System.out.println("Into select month");
		int n=0 ;
		while(DisplayMonth!=expmonth){	  

			n++ ;

			driver.findElement(By.xpath("//div[@class='picker-columns']/div[2]//button[@class='picker-opt']["+n+"]")).click() ;

//			Thread.sleep(1000);
			month=driver.findElement(By.xpath("//div[@class='picker-columns']/div[2]//button[@class='picker-opt picker-opt-selected']")); 

			DisplayMonth = Integer.parseInt(month.getText());

		}
		System.out.println("clicked"+ n);
		return month;

	} 

	public static WebElement selectYear(int expyear) throws Exception
	{
		System.out.println("Into select year");
		int n=5 ;
		while(Displayear!=expyear){	  

			n-- ;

//		Thread.sleep(1000); 
			driver.findElement(By.xpath("//div[@class='picker-columns']/div[4]//button[@class='picker-opt']["+n+"]")).click() ;

			// driver.findElement(By.xpath("//div[@class='picker-columns']/div[3]//button[@class='picker-opt']["+n+"]")).click() ;

			Thread.sleep(2000);
			year= driver.findElement(By.xpath("//div[@class='picker-columns']/div[4]//button[@class='picker-opt picker-opt-selected']")) ;
			Displayear = Integer.parseInt(year.getText());

		}
		System.out.println("clicked"+ n);
		return year;

	} 


	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	static int i;
	
	static int modulus ;

	public static void jobStarttimeFrame(String StartTime ) throws Exception
	{          
		
		System.out.println("Into job start timme frame");
		Thread.sleep(2000);
		try{

			exphour=Integer.parseInt(StartTime.substring(0, 2));
			expmin=Integer.parseInt(StartTime.substring(3, 5));
			expmeridian=(StartTime.substring(6, 8));


			String currenttime=evaluatCurrentTime();
			syshour  =Integer.parseInt(currenttime.substring(0, 2));
			sysmin=Integer.parseInt(currenttime.substring(3, 5));
			sysmeridian=currenttime.substring(6);


			System.out.println("Expected time :"+exphour+" : "+expmin+": "+expmeridian); 

			System.out.println("System time :"+syshour+" : "+sysmin+": "+sysmeridian);  

			utility.Utils.scrollPage();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@name='startTimeBefore']//button")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='picker-toolbar']"));

//			Thread.sleep(3000);


			WebElement	 startThrs=	driver.findElement(By.xpath("//div[@class='picker-columns']/div[2]//button[@class='picker-opt picker-opt-selected']")) ;
			WebElement	 startTminutes=	driver.findElement(By.xpath("//div[@class='picker-columns']/div[3]//button[@class='picker-opt picker-opt-selected']")) ;
			WebElement	 meridian=	driver.findElement(By.xpath("//div[@class='picker-columns']/div[4]//button[@class='picker-opt picker-opt-selected']")) ;

			Displayhour=Integer.parseInt(startThrs.getText());
			Displaymin=Integer.parseInt(startTminutes.getText());
			Displaymeridian= meridian.getText();
			//*[@name='endTimeBefore']//button

			System.out.println("Displayed time"+Displayhour+":"+Displaymin+":"+Displaymeridian);

			
			i= (int)expmin/15 ; 
			
			modulus =expmin% 15;
           
			  
			 
			if(!Displaymeridian.equalsIgnoreCase(expmeridian)){

				driver.findElement(By.xpath("//div[@class='picker-columns']/div[4]//button[@class='picker-opt']")).click();

			}
			
			System.out.println( expDate +":::::::::: "+currentDate);
			
			if((expDate!=currentDate) ){
				
				System.out.println( "Enter 1 :::::::::: ");

				System.out.println("Job Time "+ syshour+":"+sysmin);
						
			
					
				syshour=exphour ;
				
				
				
				if((syshour==Displayhour) && (i!=3 )){

					System.out.println("Enter here 1");

					System.out.println("modulus="+modulus);
					
					if(modulus!=0)
					
					{
					for(int j=1;j<=i+1;j++){

						Displaymin=minuteCalculation(j);

					  }
					}
					else
						
					{
					for(int j=1;j<=i+1;j++){

						Displaymin=minuteCalculation(j);

					  }
					
					
					}
				}
				else if((syshour==Displayhour) && (i==3 )){
					System.out.println("Enter here 2");

					System.out.println("modulus="+modulus);
					if( modulus!=0){
					Displayhour=hourCalculation(0);
					}
					else{
						
						for(int j=1;j<=i;j++){

							Displaymin=minuteCalculation(j);

						}
						
					}
				
				
				}
				else if((syshour!=Displayhour) && (i!=3 )){
					System.out.println("Enter here 3");

					System.out.println("modulus="+modulus);
					
					if(modulus!=0){
					for(int j=1;j<syshour;j++){

						Displayhour=	hourCalculation(j);

//						System.out.println("display hour :"+Displayhour);
					}

					for(int j=1;j<=i+1;j++){

						Displaymin=	minuteCalculation(j);

//						System.out.println("display hour :"+Displaymin);
					}	

				}
					
					else{
					for(int j=1;j<syshour;j++){

						Displayhour=	hourCalculation(j);

//						System.out.println("display hour :"+Displayhour);
					}

					for(int j=1;j<=i;j++){

						Displaymin=	minuteCalculation(j);

//						System.out.println("display hour :"+Displaymin);
					}	

				}					
					
					
				}
				else if((syshour!=Displayhour) && (i==3 )){


					System.out.println("Enter here 4");
			
					System.out.println("modulus="+modulus);
					if(modulus!=0){
					
						for(int j=1;j<=syshour;j++){

							Displayhour=	hourCalculation(j);
     
					}				
					
				}

					else{
						
						for(int j=1;j<=syshour-1;j++){

							Displayhour=	hourCalculation(j);
     
					}
						
					}	       
		}
			
			}	///////////////////////////////////////////////////////////////////////////////////
			
			
			if((expDate==currentDate) ){
				
				System.out.println("::::::::::::::::  2");
				
				if((exphour>= syshour) && (syshour!=12 )){
				
					syshour=exphour ;
				}
				if((exphour< syshour) && (syshour!=12 )){
					
					syshour=exphour ;
				}
				
				if((syshour==Displayhour) && (i!=3 )){

//					System.out.println("Enter here 1");
//					System.out.println("modulus="+modulus);
					
					if(modulus!=0)
					
					{
					for(int j=1;j<=i+1;j++){

						Displaymin=minuteCalculation(j);

					  }
					}
					else
						
					{
					for(int j=1;j<=i+1;j++){

						Displaymin=minuteCalculation(j);

					  }
				
					}
				}
				else if((syshour==Displayhour) && (i==3 )){
					System.out.println("Enter here 2");
					System.out.println("modulus="+modulus);
					
					if( modulus!=0){
					Displayhour=hourCalculation(0);
					}
					else{
						
						for(int j=1;j<=i;j++){

							Displaymin=minuteCalculation(j);

						}
						
					}
				
				
				}
				else if((syshour!=Displayhour) && (i!=3 )){
					System.out.println("Enter here 3");

					System.out.println("modulus="+modulus);
					
					if(modulus!=0){
					for(int j=1;j<syshour;j++){

						Displayhour=	hourCalculation(j);

//						System.out.println("display hour :"+Displayhour);
					}

					for(int j=1;j<=i+1;j++){

						Displaymin=	minuteCalculation(j);

//						System.out.println("display hour :"+Displaymin);
					}	

				}
					
					else{
					for(int j=1;j<syshour;j++){

						Displayhour=	hourCalculation(j);

//						System.out.println("display hour :"+Displayhour);
					}

					for(int j=1;j<=i;j++){

						Displaymin=	minuteCalculation(j);

//						System.out.println("display hour :"+Displaymin);
					}	

				}					
					
					
				}
				else if((syshour!=Displayhour) && (i==3 )){


					System.out.println("Enter here 4");
			
					if(modulus!=0){
					
						for(int j=1;j<=syshour;j++){

							Displayhour=	hourCalculation(j);
     
					}				
					
				}

					else{
						
						for(int j=1;j<=syshour-1;j++){

							Displayhour=	hourCalculation(j);
     
					}
						
					}	
					
				} 
			}	
			System.out.println("Calculated start time");
			System.out.println(Displayhour+":"+Displaymin+":"+Displaymeridian);

			Thread.sleep(3000) ;
			driver.findElement(By.xpath("//button[contains(.,'Done')]")).click();

			}

		catch(Exception e){

			e.printStackTrace();
			
			System.out.println(e);
		}

	} 

	public static void jobEndtimeFrame( ) throws Exception
	{
//System.out.println("Into end time calulation");

System.out.println("end hrs="+endhrs+"and Display hrs="+Displayhour);
		try{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@name='endTimeBefore']//button")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='picker-toolbar']"));       

			int set=(int)Displaymin/15 ;

			if((endhrs==Displayhour) && (set!=3 )){


				System.out.println("Enter here 1");

				for(int j=1;j<=set+1;j++){

					endmin=endMinuteCalculation(j);
				}

			}

			if((endhrs==Displayhour) && (set==3 )){

				System.out.println("Enter here 2");

				endhrs=endHourCalculation(0);
			}

			if((endhrs!=Displayhour) && (set!=3 )){

				System.out.println("Enter here 3");

				for(int j=1;j<Displayhour;j++){

					endhrs=	endHourCalculation(j);
				}

				for(int j=1;j<=set+1;j++){

					endmin=	endMinuteCalculation(j);

				}	


			}

			if((endhrs!=Displayhour) && (set==3 )){

				System.out.println("Enter here 4");

				for(int j=1;j<=Displayhour;j++){

					endhrs=	endHourCalculation(j);
				}


			}

	System.out.println("Calculated end time");
			System.out.println(endhrs+":"+endmin+":"+Displaymeridian);

			Thread.sleep(3000) ;
			driver.findElement(By.xpath("//button[contains(.,'Done')]")).click();
		}
		catch(Exception e){

			e.printStackTrace();
			System.out.println(e);
		}

	}


	public static int hourCalculation(int c) throws InterruptedException{
//		Thread.sleep(1000);
		if(c!=0){
			driver.findElement(By.xpath("//div[@class='picker-columns']/div[2]//button[@class='picker-opt']["+c+"]")).click();

			Displayhour=  Integer.parseInt(driver.findElement(By.xpath("//div[@class='picker-columns']/div[2]//button[@class='picker-opt picker-opt-selected']")).getText()) ;
		}
		//	   Displayhour++ ;

		return Displayhour;

	}	
	public static int minuteCalculation(int c) throws InterruptedException{

//		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='picker-columns']/div[3]//button[@class='picker-opt']["+c+"]")).click() ;

		Displaymin=	Integer.parseInt(driver.findElement(By.xpath("//div[@class='picker-columns']/div[3]//button[@class='picker-opt picker-opt-selected']")).getText());

		//		Displaymin=Displaymin+15 ;

//		System.out.println("loop count"+Displaymin);

		return Displaymin;
	}	

	public static int endHourCalculation(int c) throws InterruptedException{
		//		   endhrs++ ;
//		System.out.println("into end hour calulation");
//		Thread.sleep(1000);

		int  endDisplayhour=endhrs ;
		if(c!=0){
			driver.findElement(By.xpath("//div[@class='picker-columns']/div[2]//button[@class='picker-opt']["+c+"]")).click();

			endDisplayhour=  Integer.parseInt(driver.findElement(By.xpath("//div[@class='picker-columns']/div[2]//button[@class='picker-opt picker-opt-selected']")).getText()) ;

//			System.out.println("loop count :"+endDisplayhour);
		}


		return endDisplayhour;
	}	

	public static int endMinuteCalculation(int c) throws InterruptedException{

		//			endmin=endmin+15 ;
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='picker-columns']/div[3]//button[@class='picker-opt']["+c+"]")).click() ;

		Displaymin=	Integer.parseInt(driver.findElement(By.xpath("//div[@class='picker-columns']/div[3]//button[@class='picker-opt picker-opt-selected']")).getText());

		//			System.out.println(Displaymin);
		return Displaymin;
	}	  

}