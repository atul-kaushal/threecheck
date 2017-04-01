package appModules;

import pageObjects.Filter_page;

public class Filter_Action {

	
	public static void applyFilterTogetAlljobs(){
		
		try {
			Filter_page.Click_filter_Icon().click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Filter_page.selectAllJobs().click() ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
