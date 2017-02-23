package completeProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Base {

	public WebDriver driver ;
	public  FileInputStream file;
	public Properties pro;
	

	@BeforeMethod 
	public void baseSetup() throws IOException  {

		pro = new Properties();
		 file = new FileInputStream(
				"/Users/imranhossan/git/UdemyFrame/ModelProject/global.Properties");

		pro.load(file);
		System.out.println(pro.getProperty("browser"));

		if (pro.getProperty("browser").contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/imranhossan/Documents/GeckoDriver/geckodriver");
			driver = new FirefoxDriver();
		} else if (pro.getProperty("browser").contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/imranhossan/Documents/GeckoDriver/chromedriver");
			driver = new ChromeDriver();
		}
		System.out.println("imran"); 
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
/*	@BeforeMethod
	@Parameters("browser")
	public void multipleBrowserTest(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/imranhossan/Documents/GeckoDriver/geckodriver");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/imranhossan/Documents/GeckoDriver/chromedriver");
			driver = new ChromeDriver();
		}
	   System.out.println(pro.getProperty("browser"));
		driver.manage().window().maximize();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	

	}   */
	@AfterMethod
	public void QuitBrowser(){
		driver.quit();
	}

}