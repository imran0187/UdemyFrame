package completeProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageElement {

	WebDriver driver;

	By username = By.name("userName");
	By password = By.name("password");
	By loginButton = By.name("login");

	public LoginPageElement(WebDriver driver) {
		this.driver = driver;
	}

	public void generateId(String userId) {
		driver.findElement(username).sendKeys(userId);
	}
	
	public void generatePass(String pass){
		driver.findElement(password).sendKeys(pass);
	}
	
	public void signin() {
		driver.findElement(loginButton).click();
	}
	
}
