package PageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.CommonActions;

public class PersonalDetails extends CommonActions{

	public WebDriver driver;
	CommonActions commonactions;
	
	public PersonalDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='firstname']")
	private WebElement txt_firstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	private WebElement txt_lastName;
	
//	@FindBy(xpath="//input[@name='gender'][1]")
//	private WebElement rd_genderMale;
//	
//	@FindBy(xpath="//input[@name='gender'][2]")
//	private WebElement rd_genderFemale;
	
	@FindBy(xpath="//input[@id='dob']")
	private WebElement txt_dateOfBirth;
	
	@FindBy(xpath="//input[@id='pancard']")
	private WebElement txt_panNumber;
	
	@FindBy(xpath="//input[@id='mobileno']")
	private WebElement txt_mobileNumber;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement txt_emailID;
	
	
	public WebElement selectGeneder(int i) {
		return driver.findElement(By.xpath("(//input[@name='gender'])["+i+"]"));
	}
	
	
	public EmploymentDetails enterPersonalDetails(String firstname,String lastname, String dob, String pannumber, String mobnumber, String emailID) {
		txt_firstName.sendKeys(firstname);
		txt_lastName.sendKeys(lastname);
		txt_dateOfBirth.sendKeys(dob);
		txt_panNumber.sendKeys(pannumber);
		txt_mobileNumber.sendKeys(mobnumber);		
		txt_emailID.sendKeys(emailID);
		commonactions.clickNextButton();
		EmploymentDetails employmentDetails = new EmploymentDetails(driver);
		return employmentDetails;		
	}	
	
//	public void clickMaleGender() {
//		rd_genderMale.click();
//	}
//	
//	public void clickFemaleGender() {
//		rd_genderFemale.click();
//	}
	
}
