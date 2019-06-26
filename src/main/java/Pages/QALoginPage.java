package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QALoginPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//input[@id='user_email']")
	WebElement UserName;
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement GoBtn;
	
	
	public QALoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement EnterUsername() {
		
		return UserName;
	}
	
	public WebElement EnterPassword() {
		
	return Password;
	}
	
	public WebElement ClickGobtn() {
		
		return GoBtn;
		
		}
}


