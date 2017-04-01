package property;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public  class ObjectMap {

	public static Properties prop;
	public static ObjectMap obj;

	public static ObjectMap getInstance(){
		if (obj == null){
			 obj=new ObjectMap();
		}
		return obj;
	}
	
	
	
    public Properties getPropertyObj(){
    	
    	 prop = new Properties();
         
	        try {
	        	File src=new File("C:\\Users\\IST\\workspace\\Threecheck\\src\\property\\Objects.properties");
	   	  	 
	       	 // Create  FileInputStream object
	       	 FileInputStream fis=new FileInputStream(src);
	       	  
	       	 // Create Properties class object to read properties file
	       	  prop=new Properties();
	       	  
	       	 // Load file so we can use into our script
	       	 prop.load(fis) ;
	       	 fis.close();
	        }catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
			return prop;
 
    	
    }

}