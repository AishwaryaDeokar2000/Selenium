package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import POM.HomePage;
import POM.LoginPage;

public class ActitimeVerification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		
		WebDriver driver = new ChromeDriver(options);// OBJECT CREATION OF CromeDriver
	
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://demo.actitime.com/login.do");
        
	    LoginPage lp = new LoginPage();// object creation for loginpage
	    //create object of page n pass the values with the help reference variable of object n getter methods.
	    PageFactory.initElements(driver, lp);
	    
	    lp.getUsertext().sendKeys("Aisha");
	    driver.navigate().refresh();

	    lp.getUsertext().sendKeys("admin");
	    lp.getPwdtext().sendKeys("manager");
	    lp.getLoginbutton().click();
	    
	    
	    HomePage hp = new HomePage();
	    PageFactory.initElements(driver, hp);
	    hp.getLogoutbutton().click();    
	}

}
