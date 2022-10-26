package PageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.CommonActions;

public class EmploymentDetails extends CommonActions{
	
	public WebDriver driver;
	CommonActions commonactions;
	
	public EmploymentDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonactions = new CommonActions(driver);
	}
	
	@FindBy(xpath="(//input[@id='quality-project-name'])[1]")
	private WebElement txt_employerName;
	
	@FindBy(xpath="(//input[@id='quality-project-name'])[2]")
	private WebElement txt_employerPhone;
	
	@FindBy(xpath="(//input[@id='quality-project-name'])[3]")
	private WebElement txt_employementStatus;	
	
	@FindBy(xpath="//input[@id='quality-reportpath']")
	private WebElement txt_lastPayDate;
	
	@FindBy(xpath="//input[@id='quality-username']")
	private WebElement txt_nextPaydate;
	
	@FindBy(xpath="(//input[@id='quality-password'])[1]")
	private WebElement txt_lastTakenHomeChequeAmt;
	
	@FindBy(xpath="(//input[@id='quality-password'])[2]")
	private WebElement txt_takeHomePayforMay;
	
	@FindBy(xpath="//h6[text()=' Successful ']")
	private WebElement lbl_textSuccessful;
	
		
	public WebElement howOftenYouPaid(String frequency) {
		return driver.findElement(By.xpath("//select[@id='quality-source']/option[text()='"+ frequency +"']"));
	}
	
	public void employmentDetails(String employerName, String employerPhone, String employmentStatus, String lastPayDate, String nextPayDate, String chequeAmt, String takeHomeMay) {
		txt_employerName.sendKeys(employerName);
		txt_employerPhone.sendKeys(employerPhone);
		txt_employementStatus.sendKeys(employmentStatus);
		txt_lastPayDate.sendKeys(lastPayDate);
		txt_nextPaydate.sendKeys(nextPayDate);
		txt_lastTakenHomeChequeAmt.sendKeys(chequeAmt);
		txt_takeHomePayforMay.sendKeys(takeHomeMay);
	}	
	
	public String getSuccessfulMessgage() {
		commonactions.waitTillElementVisible(lbl_textSuccessful);
		return lbl_textSuccessful.getText();
	}
	
	

}
