package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import PageFactoryRepo.landingPage;
import PageFactoryRepo.loginPage;

public class stepGroups extends base {

	
	//StepGroup Of Login
	public void loginToKuzaApplication() throws IOException, InterruptedException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(credientialsFilePath);
		prop.load(fis);
	    String userName=prop.getProperty("Username");
	    String password=prop.getProperty("Password");
		
		loginPage lp=new loginPage(driver);
		landingPage ldp=new landingPage(driver);
		
		WaitUntilvisibilityOf(lp.userNameTextfield);
		Thread.sleep(5000);
		Tap(lp.userNameTextfield, driver);
		lp.userNameTextfield.sendKeys(userName);
		Tap(lp.passwordTextfield, driver);
		lp.passwordTextfield.sendKeys(password);
		Tap(lp.goButton, driver);
		LongWaitUntilvisibilityOf(lp.startButton);
		Tap(lp.startButton, driver);
		LongWaitUntilvisibilityOf(lp.deviceSetupCompletedSuccessfullyToasterMessage);
		Tap(lp.okButton, driver);
		WaitUntilvisibilityOf(ldp.kuzaLogo);
	    ldp.kuzaLogo.isDisplayed();
	}
	
//**************************************************************************************************************************************

}
