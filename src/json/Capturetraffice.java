package json;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Capturetraffice {

public static void main(String arg[]){
	
	WebDriver driver= new FirefoxDriver();
	
	driver.get("http://eveningsamurai.wordpress.com/2013/06/29/capturing-network-traffic-using-selenium-webdriverfirebug/");
	
	     Proxy proxy = new Proxy();
	     // The URL here is the URL that the browsermob proxy is using
	     proxy.setHttpProxy("localhost:9100");

	     DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	     capabilities.setCapability(CapabilityType.PROXY, proxy);

	      driver = new FirefoxDriver(capabilities);
	
	
}

	
	
}
