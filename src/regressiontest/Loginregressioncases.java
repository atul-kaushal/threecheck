package regressiontest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import appModules.SignIn_Action;
import utility.ClassInitialization;
import utility.Constant;
import utility.ExcelUtils;


public class Loginregressioncases extends ClassInitialization {

	public Loginregressioncases( ) {
	
		super("Loginregressioncases");
		// TODO Auto-generated constructor stub
	}

	public static String userid ;

	public static String Username ;

	public static String Password ;
	
	public static String UserType ;
	
	static int DataSet1= 0;	
	
	static int DataSet2= 0;

	@Test (dataProvider="validUserData")
	public void validUser(String id ,String name ,String pwd) throws Exception{

		
		System.out.println("into valid action");
		DataSet1 ++ ;
		
	userid=id ;
	
	Username=name ;
	
	Password=pwd ;

	SignIn_Action.Execute(DataSet1);
	
	
	try{
		if(SignIn_Action.pass==false){
			
			System.out.println("Fail");
			ExcelUtils.setCellData(Constant.KEYWORD_FAIL, DataSet1 ,Constant.Col_Isloggedin,Constant.Sheet_LoginCreadential);
			
//			BaseClass.bResult=false ;
//			Assert.assertTrue(SignIn_Action.pass==true);
			
		}						
	    if(SignIn_Action.pass==true){
	   ExcelUtils.setCellData(Constant.KEYWORD_PASS,DataSet1,Constant.Col_Isloggedin,Constant.Sheet_LoginCreadential);
	
	   SignIn_Action.logOut() ;
	   System.out.println("Pass");

		}
		
	   }
        catch(Exception e){

        	e.printStackTrace();
        	
        	System.out.println(e.getMessage());
        }
	}
	
	
     @Test (dataProvider="InvalidUserData")
 	public void InvalidUser(String id ,String name ,String pwd) throws Exception{
 		
    	 System.out.println("into invalid action");
    	 
    	 DataSet2 ++ ;
    	       userid=id ;
    		
    		Username=name ;
    		
    		Password=pwd ;
    	 
    		SignIn_Action.Execute(DataSet2);
    		
    		
    		try{
    			if(SignIn_Action.pass==false){
    				
    				System.out.println("Pass");
    				ExcelUtils.setCellData(Constant.KEYWORD_PASS, DataSet2 ,Constant.Col_Isloggedin,Constant.Sheet_InvalidCreadential);
    				
//    				BaseClass.bResult=false ;
//    				Assert.assertTrue(SignIn_Action.pass==true);
    				
    			}						
    		    if(SignIn_Action.pass==true){
    		   ExcelUtils.setCellData(Constant.KEYWORD_FAIL,DataSet2,Constant.Col_Isloggedin,Constant.Sheet_InvalidCreadential);
    		
    		   SignIn_Action.logOut() ;
    		   System.out.println("Fail");

    			}
    			
    		   }
    	        catch(Exception e){

    	        	e.printStackTrace();
    	        	
    	        	System.out.println(e.getMessage());
    	        }
   		
 	}
     

     @DataProvider
 	public Object[][] validUserData(){
 		//To retrieve data from Data 1 Column,Data 2 Column,Data 3 Column and Expected Result column of SuiteOneCaseOne data Sheet.
 		//Last two columns (DataToRun and Pass/Fail/Skip) are Ignored programatically when reading test data.
 		return  utility.ExcelUtils.retrieveTestData(Constant.Sheet_LoginCreadential);
 	}	
 	
     @DataProvider
  	public Object[][] InvalidUserData(){
  		//To retrieve data from Data 1 Column,Data 2 Column,Data 3 Column and Expected Result column of SuiteOneCaseOne data Sheet.
  		//Last two columns (DataToRun and Pass/Fail/Skip) are Ignored programatically when reading test data.
  		return  utility.ExcelUtils.retrieveTestData(Constant.Sheet_InvalidCreadential);
  	}	
     
     
}
