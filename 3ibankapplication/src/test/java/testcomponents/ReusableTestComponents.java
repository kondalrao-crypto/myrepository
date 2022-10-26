package testcomponents;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import PageComponent.LandingPage;
import Resources.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableTestComponents {
	//Driver related
	public  WebDriver driver;
	public LandingPage landingPage;
	
	@BeforeMethod(alwaysRun=true)
	public   void  setUp() throws IOException {	

		
		Properties properties =new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Config.properties");
		
		properties.load(fis);		
		
		String browserInstance = properties.getProperty("browser");
		
		
		if(browserInstance.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserInstance.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserInstance.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else
		{
			System.out.println("You have chosen incorrect browser....");
		}
		
		
		driver.manage().window().maximize();
		
		
			
	}
	
//	public void lauchingLandingPage() throws IOException {
//		ReusableTestComponents reusabletestcomponent = new ReusableTestComponents();
//		driver = reusabletestcomponent.setUp();		
//		
//	}
	
	
@AfterMethod	
	public void tearDown() {
		driver.close();
	}
}
