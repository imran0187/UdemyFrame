package completeProject;

import org.testng.annotations.Test;

public class LoginTest extends Base{
	
	
	@Test
	public void loginTest(){
	LoginPageElement lp = new LoginPageElement(driver);
	lp.generateId("imran1");
	lp.generatePass("1234");
	//lp.signin();
	
	}
	@Test
	public void clckSubmit(){
	LoginPageElement lp = new LoginPageElement(driver);
	lp.signin();
}
}
