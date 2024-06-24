package login;


import java.io.FileInputStream; 
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactoryRepo.landingPage;
import PageFactoryRepo.loginPage;
import Resources.base;

public class LG001_Verify_User_Is_Able_To_Login_With_Valid_Credential extends base {
	public static Logger log=LogManager.getLogger(LG001_Verify_User_Is_Able_To_Login_With_Valid_Credential.class.getName());
		
	@BeforeTest
	public void openkuzaApplication() throws IOException {
		openKuzaAplicationWithPackageActivityAndNoResetFalse();
		log.info("Sucessfully Opend App And Loged In");
	}
	
	
	@Test
	public void loginToKuzaApplication() throws IOException, InterruptedException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(credientialsFilePath);
		prop.load(fis);
	    String userName=prop.getProperty("Username");
	    String password=prop.getProperty("Password");
		
		loginPage lp=new loginPage(driver);
		landingPage ldp=new landingPage(driver);
		
		WaitUntilvisibilityOf(lp.userNameTextfield);
		log.info("Successfully Waited userNameTextfield is visable");
		//This hard wait because of application issue
		Thread.sleep(5000);
		Tap(lp.userNameTextfield, driver);
		log.info("Sucessfully Taped On userNameTextfield");
		lp.userNameTextfield.sendKeys(userName);
		log.info("Sucessfully Entered userName Into userNameTextfield");
		Tap(lp.passwordTextfield, driver);
		log.info("Sucessfully Taped On passwordTextfield");
		lp.passwordTextfield.sendKeys(password);
		log.info("Sucessfully Entered password Into passwordTextfield");
		Tap(lp.goButton, driver);
		log.info("Sucessfully Taped On goButton");
		LongWaitUntilvisibilityOf(lp.startButton);
		log.info("Sucessfully Waited Till startButton is visable");
		Tap(lp.startButton, driver);
		log.info("Sucessfully Taped On startButton");
		LongWaitUntilvisibilityOf(lp.deviceSetupCompletedSuccessfullyToasterMessage);
		log.info("Sucessfully Waited Till deviceSetupCompletedSuccessfullyToasterMessage is visable");
		Tap(lp.okButton, driver);
		log.info("Sucessfully Taped On okButton");
		WaitUntilvisibilityOf(ldp.kuzaLogo);
		log.info("Sucessfully Waited Till kuzaLogo is visable");
	    ldp.kuzaLogo.isDisplayed();
	    log.info("Kuzalogo Is Displayed In Application");
	}
	
	@AfterTest
	public void closeKuzaApplication() {
		closingApplication();
		log.info("Sucessfully Closed The App");
	}
}
