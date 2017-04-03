package regressiontest;

import org.testng.annotations.Test;

import utility.ClassInitialization;
import utility.Constant;
import utility.ExcelUtils;

import appModules.SignIn_Action;

public class Login_01 extends ClassInitialization{

	public static String userid ;
	
	public static String Username ;
	
	public static String Password ;
	
	public static String userType ;
	
public Login_01() {
      
	super("Login_01");
    }


@Test
  public void main() throws Exception {
	  try{
		  
		  int totalusers = ExcelUtils.getRowCount(Constant.Sheet_LoginCreadential);
		  
		 
		  for(int j=1 ;j<totalusers ;j++){
		
			  System.out.println("into test method For"+ j +"time");
			  userid=ExcelUtils.getCellData(j, Constant.Col_UserID);
			  Username= ExcelUtils.getCellData(j, Constant.Col_Userloginname);
			  Password= ExcelUtils.getCellData(j, Constant.Col_Userpwd);
			  userType = ExcelUtils.getCellData(j,Constant.Col_userType);
	
			  SignIn_Action.Execute(j);
	
			  
			  try{
					if(SignIn_Action.pass==false){
						
						System.out.println("Fail");
						ExcelUtils.setCellData(Constant.KEYWORD_FAIL, j ,Constant.Col_Isloggedin,Constant.Sheet_LoginCreadential);
						
//						BaseClass.bResult=false ;
//						Assert.assertTrue(SignIn_Action.pass==true);
						
					}						
				    if(SignIn_Action.pass==true){
				   ExcelUtils.setCellData(Constant.KEYWORD_PASS,j,Constant.Col_Isloggedin,Constant.Sheet_LoginCreadential);
				
				   SignIn_Action.logOut() ;
				   System.out.println("pass");

					}
					
				   }
			        catch(Exception e){

			        	e.printStackTrace();
			        	
			        	System.out.println(e.getMessage());
			        }
 
			  
		  }
		
   }
catch(Exception e){
	
}
}


}