package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class loginform {
	
	WebDriver driver;
        @BeforeClass
        
	    public void Setup() {
	    	
        	System.setProperty("webdriver.gecko.driver","D:\\Tessting\\geckodriver.exe");
    		driver=new FirefoxDriver();
    		String Url="https://demo.openmrs.org/openmrs/login.htm";
    		driver.get(Url);
	    }
        
        @Test
        public void testLogin() {
        	
        	WebElement username=driver.findElement(By.id("username"));
    		username.sendKeys("Admin");
    		
    		WebElement password=driver.findElement(By.id("password"));
    		password.sendKeys("Admin123");
    		
    		WebElement togglepassword=driver.findElement(By.id("togglePassword"));
    		togglepassword.click();
    		
    		WebElement session=driver.findElement(By.id("Inpatient Ward"));
    		session.click();
    		
    		WebElement login=driver.findElement(By.id("loginButton"));
    		login.click();
    		
    		String Expectedtitle="Home";
    		String Acttualtitle =driver.getTitle();
    		
    		Assert.assertEquals(Acttualtitle,Expectedtitle );
        	
        	
        }
		
        @Test
		
		public void testlogout() {
			
        	WebElement logout=driver.findElement(By.linkText("Logout"));
    		logout.click();
    		String Expectedtitle="Login";
    		String Acttualtitle =driver.getTitle();
    		
    		Assert.assertEquals(Acttualtitle,Expectedtitle );
			
		}
		
		
		
		@AfterClass
		public void clean() {
			
			driver.quit();
			
			
		}
	
	
}
