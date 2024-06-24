package login;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactoryRepo.loginPage;
import Resources.base;

public class LG003_Verifying_User_Is_Able_To_Get_Error_Message_When_User_Enter_Invalid_Username_And_Valid_Password extends base{
	public static Logger log=LogManager.getLogger(LG003_Verifying_User_Is_Able_To_Get_Error_Message_When_User_Enter_Invalid_Username_And_Valid_Password.class.getName());
	
	@BeforeTest
	public void openkuzaApplication() throws IOException {
        openKuzaAplicationWithPackageActivityAndNoResetFalse();
        log.info("Sucessfully Opend App And Loged In");
	}
	
	@Test
	public void enterInvalidUsernameAndValidPassword() throws IOException, InterruptedException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(credientialsFilePath);
		prop.load(fis);
	    String InvalidUserName = prop.getProperty("InvalidUserName");
	    String validPassword = prop.getProperty("Password");
	    
	    loginPage lp=new loginPage(driver);
	    
	    WaitUntilvisibilityOf(lp.userNameTextfield);
	    //This hard wait because of application issue
	    Thread.sleep(5000);
	    Tap(lp.userNameTextfield, driver);
	    log.info("Sucessfully Taped on userNameTextfield");
	    lp.userNameTextfield.sendKeys(InvalidUserName);
	    log.info("Sucessfully Entered InvalidUserName Into userNameTextfield");
	    Tap(lp.passwordTextfield, driver);
	    log.info("Sucessfully Taped on passwordTextfield");
	    lp.passwordTextfield.sendKeys(validPassword);
	    log.info("Sucessfully Entered validPassword Into passwordTextfield");
	    Tap(lp.goButton, driver);
	    log.info("Sucessfully Taped on goButton");
	    WaitUntilvisibilityOf(lp.userNameAndPasswordIncorrectToasterMessage);
	    log.info("Sucessfully Waited Untill userNameAndPasswordIncorrectToasterMessage is visable");
	    lp.userNameAndPasswordIncorrectToasterMessage.isDisplayed();
	    log.info("userNameAndPasswordIncorrectToasterMessage Is Displayed In Appliction");
	}
	
	@AfterTest
	public void closeTheApplication() {
		closingApplication();
		log.info("Sucessfully Closed The App");
	}
}
