package PageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.CommonActions;

public class HomePage extends CommonActions {
	public WebDriver driver;
	CommonActions commonactions;
	ApprovalPage approvalPage;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ol[contains(@class,'carousel-indicators')]/li[@data-slide-to='0']") 
	private WebElement btn_sliderDot;
	
	@FindBy(xpath="//h5[contains(text(),'Let us finance the entrepreneur in you')]/following-sibling::p/following-sibling::button")
	private WebElement btn_ApplyNow;	
	
	public ApprovalPage clickApplyButton() {
		
		
		//approvalPage.waitTillElementVisible(btn_sliderDot);
		
		//commonactions.waitTillElementVisible(btn_sliderDot);
		//approvalPage.waitTillElementVisible();;
		//btn_sliderDot.click();
		
		btn_ApplyNow.click();		
//		commonactions.clickElement(btn_sliderDot);
//		commonactions.clickElement(btn_ApplyNow);
		ApprovalPage approvalPage=new ApprovalPage(driver);
		return approvalPage;
	}

}
