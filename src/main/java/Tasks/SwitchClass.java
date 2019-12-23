package Tasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchClass {
	
	WebDriver driver;
	
	@Test
	public void getDriver()
	{
		int browser = 2;
		
		switch(browser)
		{
		
		case 1:
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Opened Chrome browser");
			break;
			
        case 2:
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Opened FF browser");
			break;   
			
       case 3:
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			System.out.println("Opened IE browser");
			break;
		
		}
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.close();
		
	}
	
	


}
