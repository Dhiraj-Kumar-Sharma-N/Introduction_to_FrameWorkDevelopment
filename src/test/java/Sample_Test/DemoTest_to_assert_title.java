package Sample_Test;

import java.io.IOException;
import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.QAHomePage;
import resources.BaseClass;

public class DemoTest_to_assert_title extends BaseClass {

	
	public static Logger log = LogManager.getLogger(DemoTest_to_assert_title.class.getName());
			
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
	
	public  void validateFeaturedCoursesText () throws IOException {
		
		QAHomePage obj = new QAHomePage(driver);
		
		Assert.assertEquals(obj.GetHomeTitle().getText(),"FEATURED COURSES");
		
		boolean value = obj.contactLink();
		
		Assert.assertTrue(value);
		
		log.debug(" Title Asserted Successfully ");
	}
	
@AfterTest

	public void QuitBrowser() {
	
	driver.quit();
	
	log.info("Browser closed Successfully ");
	
	driver=null;
}
}


