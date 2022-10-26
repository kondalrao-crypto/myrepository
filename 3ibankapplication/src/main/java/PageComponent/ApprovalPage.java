package PageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.CommonActions;

public class ApprovalPage extends CommonActions{
	
	public WebDriver driver;
	CommonActions commonactions;
		
	public ApprovalPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonactions = new CommonActions(driver);
	}
	
	@FindBy(xpath="//h4[contains(text(),' We need your Approval ')]") 
	private WebElement lbl_textApproval;
	
	@FindBy(xpath="//input[@id='myCheck']")
	private WebElement chk_iAgree;
	
	@FindBy(id="accept_agree")
	private WebElement btn_agreeContinue;
	
	public String getApprovalText() {
		return lbl_textApproval.getText();
	}	
	
	public void clickAgreeCheckbox() {
		commonactions.waitTillElementVisible(chk_iAgree);
		chk_iAgree.click();
	}
	
	public PersonalDetails clickAgreeAndContinue() {
		btn_agreeContinue.click();
		PersonalDetails personalDetails = new PersonalDetails(driver);
		return personalDetails;
	}

}
