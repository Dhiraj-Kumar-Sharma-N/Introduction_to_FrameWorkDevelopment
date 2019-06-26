package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Hello world!
 *
 */
public class BaseClass 
{
	public static WebDriver driver;
	public Properties propObj;
	
	
 public WebDriver InitializeDriver() throws IOException {
	   
	 propObj = new Properties();
	   
	   FileInputStream FIS= new FileInputStream("C:\\Users\\dsharman2\\Sample-workspace\\Introduction_to_FrameWorkDevelopment\\src\\main\\java\\resources\\data.properties");
 
	   propObj.load(FIS);
	   
	   String BrowserDetails = propObj.getProperty("BrowserName");
	   
	  System.out.println(BrowserDetails);
	  
	  
	  if (BrowserDetails.equalsIgnoreCase("Firefox")) {
			
			
			System.setProperty("webdriver.gecko.driver","C://UDEMY_Selenium//Web Drivers//geckodriver.exe");
			
			driver= new FirefoxDriver();
				
			System.out.println(" Firefox Browser launched Successfully ");
				
		}	
			
		else if (BrowserDetails.equalsIgnoreCase("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\UDEMY_Selenium\\Web Drivers\\chromedriver.exe");
			
			driver= new ChromeDriver();
			
			System.out.println("Chrome Browser launched Successfully ");

		}

		else if (BrowserDetails.equalsIgnoreCase("IE")) {
			

			System.setProperty("webdriver.ie.driver","C:\\UDEMY_Selenium\\Web Drivers\\IEDriverServer.exe");
				
				 driver= new InternetExplorerDriver();
				
				System.out.println("IE Browser launched Successfully ");
							
		}
	  
	  else {
		
		  System.out.println("INVALID BrowserName");
	}
	  
	 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
}
 
 public void getScreenshot(String result) throws IOException {
	 	 
	File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(src, new File("C://UDEMY_Selenium/Screenshots/framework_Screenshots/"+result +"screenshot.png"));
	 
	 
 }
}
