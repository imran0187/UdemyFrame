package completeProject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CrossBrowserConfig {
	WebDriver driver;

	@BeforeMethod
	@Parameters("bro")
	public void multipleBrowserTest(String browserName) throws Exception {

		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/imranhossan/Documents/GeckoDriver/geckodriver");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/imranhossan/Documents/GeckoDriver/chromedriver");
			driver = new ChromeDriver();
		} else{

            throw new Exception("Browser is not correct");

        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	

	@Test()
	public void loginTest() throws InterruptedException{
		LoginPageElement lp = new LoginPageElement(driver);
		lp.generateId("imran1");

	
	}

	@Test()
	public void clckSubmit() throws InterruptedException{

		LoginPageElement lp = new LoginPageElement(driver);
		lp.signin();
	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();

	}
}
