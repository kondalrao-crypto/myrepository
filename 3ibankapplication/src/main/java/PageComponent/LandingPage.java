package PageComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.CommonActions;

public class LandingPage extends CommonActions {
   
public WebDriver driver;
CommonActions commonactions;
    
    public LandingPage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);        
    }    
    
    @FindBy(xpath="//input[@id='username']")
    private WebElement txt_Username;
    
    @FindBy(xpath="//input[@id='password']")
    private WebElement txt_Password;
    
    @FindBy(xpath="//input[@id='card']")
    private WebElement txt_Card;    
    
    @FindBy(xpath="//button[@id='login_btn']")
    private WebElement txt_loginbtn;

    public HomePage landingPage(String Username, String Password, String Card, int n) {
                
        txt_Username.sendKeys(Username);
        txt_Password.sendKeys(Password);
        txt_Card.sendKeys(Card);
        txt_loginbtn.click(); 
        commonactions.waitTillCompleteAction(n);
        HomePage homePage = new HomePage(driver);
        return homePage;
        }
    
    public void launchURL() {    	
    	driver.get("http://14.99.175.107:17656/3iBank/index.html");
    }
}