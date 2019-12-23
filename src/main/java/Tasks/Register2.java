package Tasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register2 {
	
	WebDriver driver;

	@BeforeSuite
	public void getDriver()  throws InterruptedException {
		
		
		/*WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   */
		
			int browser = 3;
			
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
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void  mercuryregister()
	{
		
		WebElement firstname = driver.findElement(By.xpath("//input[@name=\"firstName\"]"));
		firstname.sendKeys("shilpa");
		
		WebElement lastname = driver.findElement(By.xpath("//input[@name=\"lastName\"]"));
		lastname.sendKeys("thada");
		
		WebElement phone = driver.findElement(By.xpath("//input[@name=\"phone\"]"));
		phone.sendKeys("1234567898");
		
		WebElement email = driver.findElement(By.xpath("//input[@id=\"userName\"]"));
		email.sendKeys("shilpa3@mailinator.com");
		
		WebElement addrs = driver.findElement(By.xpath("//input[@name=\"address1\"]"));
		addrs.sendKeys("Vaishali, Jaipur");
		
		WebElement city = driver.findElement(By.xpath("//input[@name=\"city\"]"));
		city.sendKeys("Jaipur");
		
		WebElement state = driver.findElement(By.xpath("//input[@name=\"state\"]"));
		state.sendKeys("rajasthaan");
		
		WebElement postcode = driver.findElement(By.xpath("//input[@name=\"postalCode\"]"));
		postcode.sendKeys("302021");
		
		//Select drpCountry = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		//drpCountry.selectByVisibleText("INDIA ");
		
		WebElement testDropDown = driver.findElement(By.xpath("//select[@name='country']"));  
		Select dropdown = new Select(testDropDown); 
		dropdown.selectByValue("92");
		
		WebElement username = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		username.sendKeys("shilpa3@mailinator.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		password.sendKeys("Shilpa@123");
		
		WebElement confirmPass = driver.findElement(By.xpath("//input[@name=\"confirmPassword\"]"));
		confirmPass.sendKeys("Shilpa@123");

		WebElement submit = driver.findElement(By.xpath("//input[@name=\"register\"]"));
		submit.click();
		
		System.out.println("Successfully registered!!");
		

		
		//WebElement loggedInUsername = driver.findElement(By.xpath("//b[contains(text(),'Note: Your user name is ff@mailinator.com.')]"));
		
		//verify the username is correct or not
			if(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[3]/td[1]/p[3]/a[1]/font[1]/b[1]")).getText().equalsIgnoreCase("shilpa3@mailinator.com"))
			{
			    System.out.println("TestCase pass");
			    
			}else {
				
				System.out.println("Test Case fail");
			}
	
	
		//Login the website for valid credential
			
			driver.findElement(By.xpath("//a[contains(text(),'sign-in')]")).click();
			driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("shilpa3@mailinator.com");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Shilpa@123");
			driver.findElement(By.xpath("//input[@name='login']")).click();
			System.out.println("LoggedIn");
			
			//verify the title
			
			String actualTitle = "Find a Flight: Mercury Tours:";
			String expectedTitle = driver.getTitle();
			System.out.println(expectedTitle);
			
			if(actualTitle.equalsIgnoreCase(expectedTitle))
			{
				System.out.println("Test Case pass");
			}else
			{
				System.out.println("Test Case Fail");
			}
			
			//Thread.sleep(3000);
			
			//driver.quit();
	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		System.out.println("Test Cases closed");
	}

}
