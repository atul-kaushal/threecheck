package appModules;

import pageObjects.LogIn_Page;
import pageObjects.Registration_page;

public class OrgRegistration_Action {

	
	public static void signUpToApplication() throws Exception{
		
		LogIn_Page.btn_Signup().click();
		
		Registration_page.orgnName().sendKeys("ND transport service");
		
		Registration_page.selectcountry("india").click();
		
		Registration_page.selectTimezone().click();
		
		Registration_page.firstName().sendKeys("rohit");
		

		Registration_page.lastName().sendKeys("Arora");
		
		Registration_page.lastName().sendKeys("Arora");
		
		Registration_page.mobileNumber().sendKeys("5677777777");
		
		Registration_page.emailField().sendKeys("rohit@gmail.com");
		
		Registration_page.submitField().click();
		
	}
}
