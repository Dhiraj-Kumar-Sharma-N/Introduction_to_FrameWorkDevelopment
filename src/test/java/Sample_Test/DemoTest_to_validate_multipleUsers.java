package Sample_Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.QAHomePage;
import Pages.QALoginPage;
import resources.BaseClass;



public class DemoTest_to_validate_multipleUsers extends BaseClass {

	public static Logger log = LogManager.getLogger(DemoTest_to_validate_multipleUsers.class.getName());
	
// ================ SAMPLE TEST WITHOUT DATA DRIVEN/PARAMETERIZATION USING TESTNG ==================================	
	
	/*@Test
	
	public  void LaunchTest () throws IOException {
		
		driver = InitializeDriver();
					
		QAHomePage obj = new QAHomePage(driver);
		
		obj.ClickLoginLink();
		
		QALoginPage obj1 = new QALoginPage(driver);
		
		obj1.EnterUsername();
		
		obj1.EnterPassword();
		
		obj1.ClickGobtn();
		
		String s1="https://qaclickacademy.usefedora.com/";
		
		String s2 = driver.getCurrentUrl();
		
		Assert.assertEquals(s1, s2);
		
		System.out.println("Assertion Passed");
	}
*/

	// ================ SAMPLE TEST WITH DATA DRIVEN/PARAMETERIZATION USING TESTNG ==================================
	
	@BeforeTest	

	public  void LaunchTest () throws IOException {
		
		driver = InitializeDriver();
		
		log.info("Driver is initialized");
				
	}
	
@Test(dataProvider="GetData")
	
	public  void validateLoginforMultipleUsers (String Username , String Password , String Message ) throws IOException {
							
	
		driver.get(propObj.getProperty("URL"));
		
		log.info("URL retrived and navigated successfully");
	
		driver.manage().window().maximize();
		
		log.debug("Window Maximized Successfully ");
	
		QAHomePage obj = new QAHomePage(driver);
		
		obj.ClickLoginLink();
		
		log.info("Home Link Clicked successfully ");
		
		QALoginPage obj1 = new QALoginPage(driver);
		
		obj1.EnterUsername().sendKeys(Username);
		
		obj1.EnterPassword().sendKeys(Password);
		
		
		obj1.ClickGobtn().click();
		
		log.info("Login Suuccessful ");
		
		System.out.println(Message);
		
		String s1="https://qaclickacademy.usefedora.com/";
		
		String s2 = driver.getCurrentUrl();
		
		if(s1 == s2) {
		
		System.out.println("Assertion Passed");
	
	}
		
		else {
			System.out.println("Assertion Failed");
		}

}
@DataProvider

public Object[][] GetData() {
	
	Object[][] MatObj = new Object[2][3];
	
	//1st person data
	
	MatObj[0][0] = "dhirajkumar643@yahoo.in";
	MatObj[0][1] = "9535802575";
	MatObj[0][2] = "Valid User Logged In";
	

	//2nd person data
	
	MatObj[1][0] = "ShivamDubey@gmail.com";
	MatObj[1][1] = "123456789";
	MatObj[1][2] = "InValid User Logged In";
	
	return MatObj;
}

@AfterTest

public void QuitBrowser() {

driver.quit();

driver=null;
}

}
