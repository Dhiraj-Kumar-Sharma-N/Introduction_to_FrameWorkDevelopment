package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAHomePage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	WebElement LoginLink;
	
	//a[contains(text(),'Contact')]
	
	@FindBy(xpath="//a[contains(text(),'Contact')]")
	WebElement ContactLink;
	
	@FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	WebElement Hometitle;
	
	
	@FindBy(xpath="//span[contains(text(),'(+1) 323-744-6780')]")
	WebElement ContactNumber;
	
	
	
	@FindBy(xpath="//a[@type='submit']")
	WebElement SubmitBtn;
	
	
	public QAHomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

public void ClickLoginLink() {
		
		LoginLink.click();
	}
	
public WebElement GetHomeTitle() {
		
		return Hometitle;
	}
	
public boolean contactLink() {
		
	 boolean b= ContactLink.isDisplayed();
	 
	 return b;
}

public WebElement ContactnumText() {
	
	return ContactNumber;
}

public WebElement SubmitBTN() {
	
	return SubmitBtn;
}


}
