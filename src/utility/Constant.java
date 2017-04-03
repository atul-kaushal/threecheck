package utility;

public class Constant {
//	    public static final String URL = "http://103.231.44.92:38047/threecheck/www/index.html";
	    
	    public static final String URL = "http://ec2-54-218-89-35.us-west-2.compute.amazonaws.com/threecheck/www/index.html";
	    
	    
	    public static final String Username = "testuser_1";
	    public static final String Password ="Test@123";
		public static final String Path_TestData = "C:\\Users\\IST\\workspace\\Threecheck\\src\\testData\\";
		public static final String File_TestData = "TestData.xlsx";
		
		//Test Data Sheet Columns
		public static final int Col_TestCaseName = 0;	
		public static final int Col_UserName =1 ;
		public static final int Col_Password = 2;
		public static final int Col_Browser = 3;
//		public static final int Col_ProductType = 4;
//		public static final int Col_ProductNumber = 5;
//		public static final int Col_FirstName = 6;
//		public static final int Col_LastName = 7;
////		public static final int Col_Address = 8;
//		public static final int Col_City = 9;
//		public static final int Col_Country = 10;
//		public static final int Col_Phone = 11;
//		public static final int Col_Email = 12;
		public static final int Col_Result = 4;
		public static final String PathToTestpass_ScreenShot = "C:\\Users\\IST\\workspace\\Threecheck\\src\\Screenshots\\Pass\\";
		public static final String PathToTestFail_ScreenShot = "C:\\Users\\IST\\workspace\\Threecheck\\src\\Screenshots\\Fail\\";
	
		//
		// Data Engine Excel sheets
		public static final String Sheet_Joblist = "Job Data";
		public static final String Sheet_TestCases = "Test Cases";
		
		public static final String Sheet_userList = "User Data";
		public static final String Sheet_Hublist = "Hub Data";
		
		public static final String Sheet_TeamList = "Team Data";
		
		public static final String Sheet_VehicleList = "Vehicle Data";
		
		public static final String Sheet_LoginCreadential = "LoginUsers";
		
		
		public static final String Sheet_InvalidCreadential = "Sheet2";
		
		//Job Data Excel sheets
		public static final int Col_JobID = 0;	
		public static final int Col_Recipientname = 1;	
		public static final int Col_MobileNo =2 ;
		public static final int Col_Address =3;
		public static final int Col_Discription =4  ;
		public static final int Col_JObDate =5  ;
		public static final int Col_StartTime =6 ;
		public static final int Col_Endtime =7 ;
		public static final int Col_Driver =8 ;
		public static final int Col_IsJobCreated =9;

	//Hub data excel sheets
		
		public static final int Col_HubID =0 ;
		public static final int Col_Hubname =1;
		public static final int Col_HubAddress=2;
		public static final int Col_IsHubCreated =3;

		
	//Team data excel sheets
		
		public static final int Col_TeamID =0 ;
		public static final int Col_Teamname =1;
		public static final int Col_IsTeamCreated =5;

		
		//Vehicle data excel sheets
		
				public static final int Col_VehicleID =0 ;
				public static final int Col_make =1;
				public static final int Col_model =2;
                public static final int Col_Mfgyear =3 ;
				public static final int Col_VIN =4;
				public static final int Col_VRN =5;
				public static final int Col_IsVehicleCreated =8;	
				
	
				//CreateUsers data excel sheets
				
						public static final int Col_Userid =0 ;
						public static final int Col_userfirstname =1;
						public static final int Col_Userlastname =2;
		                public static final int Col_useremail =3 ;
						public static final int Col_UsermobileNo =4;
						public static final int Col_userrole =5;
						public static final int Col_IsuserCreated =8;	
		
						
			// Userlogin data			
						
						public static final int Col_UserID =0;	
						
						public static final int Col_Userloginname =1;	
						public static final int Col_Userpwd =2;	
						
						
						public static final int Col_userType = 3;
						
						public static final int Col_Isloggedin =4;	
						
	// InvalidUserlogin data			
						
						public static final int Col_InUserID =0;	
						
						public static final int Col_InUserloginname =1;	
						public static final int Col_InUserpwd =2;	
							
						
						public static final int Col_InuserType = 3;
						
						public static final int Col_InIsloggedin =4;
						
						
						public static final String KEYWORD_FAIL = "FAIL";
	                  	public static final String KEYWORD_PASS = "PASS";

}
