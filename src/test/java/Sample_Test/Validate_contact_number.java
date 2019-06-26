package Sample_Test;

import java.io.IOException;
import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.QAHomePage;
import resources.BaseClass;

public class Validate_contact_number extends BaseClass {

	
	public static Logger log = LogManager.getLogger(Validate_contact_number.class.getName());
			
@BeforeTest	

public  void LaunchTest () throws IOException {
	
	driver = InitializeDriver();
	
	log.info("Driver is initialized");
	
	log.error("Error Message Displayed");
	
	driver.get(propObj.getProperty("URL"));
	
	log.info("URL retrived and navigated successfully");
	
	driver.manage().window().maximize();
	
	log.debug("Window Maximized Successfully ");
}
	
	@Test
	
	public  void ValidateContactNumber () throws IOException {
		
		QAHomePage obj = new QAHomePage(driver);
		
		Boolean b = obj.ContactnumText().isDisplayed();
		
		Assert.assertTrue(b);
		
		log.debug(" Contact displayed  Successfully ");
		
		Assert.assertEquals(obj.ContactnumText().getText(), "(+1) 323-744-6780");
		
		System.out.println("Assertion Passed");
	}
	
@AfterTest

	public void QuitBrowser() {
	
	driver.quit();
	
	log.info("Browser closed Successfully ");
	
	driver=null;
}
}


