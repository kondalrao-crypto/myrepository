package AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonActions {
	
	 WebDriver driver;	
	
	// Common Selenium reusable - like scroll , wait related component, thread
	
	public CommonActions(WebDriver driver2) {
		this.driver=driver2;
		// TODO Auto-generated constructor stub
	}

	public void waitTillCompleteAction(int n) {
		
		try {
			Thread.sleep(n);
		}
		catch(Exception e)
		{
			System.out.println("Error Message: "+e.getMessage());
		}
	}
	
	public void waitTillElementVisible() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(ele));	*/
		
	}
	
	public void scrollToSpecifiedElement(WebElement element) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		try {
			exe.executeScript("arguments[0].scrollIntoView()",element);
		}
		catch(Exception e) {
			System.out.println("Error message: "+e.getMessage());			
		}
	}
	
	public void clickNextButton() {
		driver.findElement(By.xpath("//button[text()='Next']")).click();
	}
	
	public void clickBackButton() {
		driver.findElement(By.xpath("//button[text()='Back']")).click();
	}
	
	public void clickSaveButton() {
		driver.findElement(By.xpath("//button[@id='employee_details_save']")).click();
	}
	
	public void clickSubmitButton() {
		driver.findElement(By.xpath("//button[@id='employee_details_submit']")).click();
	}
	
	public void clickCancelButton() {
		driver.findElement(By.xpath("//button[@id='employee_details_cancel']")).click();
	}
	
	public void clickElement(WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("arguments[0].click()", ele);
	}
}
