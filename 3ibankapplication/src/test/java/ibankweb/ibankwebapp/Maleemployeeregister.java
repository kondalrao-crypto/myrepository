package ibankweb.ibankwebapp;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AbstractComponent.CommonActions;
import PageComponent.ApprovalPage;
import PageComponent.EmploymentDetails;
import PageComponent.HomePage;
import PageComponent.LandingPage;
import PageComponent.PersonalDetails;
import jsonutilities.jsonforhashmap;
import testcomponents.ReusableTestComponents;

public class Maleemployeeregister extends jsonforhashmap{
	public WebDriver driver;
	
@Test(dataProvider="getjsondata")
	public void webapplogin(HashMap<String, String> input) throws InterruptedException, IOException {
	//Driver invoke
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().setSize(new Dimension(1440,900));
//		driver.manage().window().maximize();
		//landing page		
//		driver.findElement(By.id("username")).sendKeys(input.get("username"));
//		driver.findElement(By.id("password")).sendKeys(input.get("password"));
//		driver.findElement(By.id("card")).sendKeys(input.get("card"));
//		driver.findElement(By.id("login_btn")).click();
	ReusableTestComponents 	reusableTestComponents=new ReusableTestComponents();
	reusableTestComponents.setUp();
		LandingPage landingPage = new LandingPage(driver);	
		landingPage.launchURL();		
		HomePage homePage=landingPage.landingPage(input.get("username"), input.get("password"), input.get("card"), 3000);
		//System.out.println("Print: "+landingPage.landingPage(input.get("username"), input.get("password"), input.get("card"), 3000));
		
		/*WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("li[data-slide-to='0']"))));*/
		//Home Page
		Thread.sleep(10);
		driver.findElement(By.xpath("//ol[contains(@class,'carousel-indicators')]/li[@data-slide-to='0']")).click();
		ApprovalPage approvalPage=homePage.clickApplyButton();
		//ApprovalPage approvalPage=new ApprovalPage(driver);
		String match=approvalPage.getApprovalText();		
		Assert.assertTrue(match.equalsIgnoreCase("We need your Approval"));
		//Approval Page
		approvalPage.clickAgreeCheckbox();
		PersonalDetails personalDetails = approvalPage.clickAgreeAndContinue();		
		/*JavascriptExecutor exe = (JavascriptExecutor) driver;
		WebElement element=driver.findElement(By.xpath("//input[@id='myCheck']"));	
		exe.executeScript("arguments[0].scrollIntoView()",element);
		element.click();
		driver.findElement(By.id("accept_agree")).click();*/
		
		//Personal Deatils
		personalDetails.selectGeneder(Integer.parseInt(input.get("gender"))).click();
		EmploymentDetails employmentDetails=personalDetails.enterPersonalDetails(input.get("firstname"), input.get("lastname"), input.get("dob"), input.get("pannumber"), input.get("mobile"), input.get("email"));
				
		//Employer Details
		employmentDetails.howOftenYouPaid(input.get("PayFrequency")).click();
		employmentDetails.employmentDetails(input.get("employerName"), input.get("employerPhone"), input.get("employmentStatus"), input.get("lastPayDate"), input.get("nextPayDate"), input.get("chequeAmt"),input.get("takeHomeMay"));
		
		CommonActions commonactions = new CommonActions(driver);
		commonactions.clickSubmitButton();
		
		//Validate successful message
		Assert.assertEquals(employmentDetails.getSuccessfulMessgage().trim(), input.get("SuccessMsg"));	
		
	}
	
	@DataProvider
	public Object[][] getjsondata() throws IOException {
		
		List<HashMap<String, String>> jsondata=getjsondataintofile(System.getProperty("user.dir")+"//src//test//java//jsonutilities//testdata.json");				
		return new Object[][] {{jsondata.get(0)}};
		
	}


}

	
