package login;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactoryRepo.loginPage;
import Resources.base;

public class LG005_Verifying_User_Is_Able_To_Get_Error_Message_When_User_Does_Not_Enter_Username_And_Password extends base {
	public static Logger log=LogManager.getLogger(LG005_Verifying_User_Is_Able_To_Get_Error_Message_When_User_Does_Not_Enter_Username_And_Password.class.getName());
	
	@BeforeTest
	public void openkuzaApplication() throws IOException {
        openKuzaAplicationWithPackageActivityAndNoResetFalse();
        log.info("Sucessfully Opend App And Loged In");
	}
	
	@Test
	public void enterInvalidUsernameAndValidPassword() throws IOException, InterruptedException {
	    
	    loginPage lp=new loginPage(driver);
	    
	    WaitUntilvisibilityOf(lp.userNameTextfield);
	    log.info("Sucessfully Waited Untill userNameTextfield is visable");
	    //This hard wait because of application issue
	    Thread.sleep(5000);
	    Tap(lp.goButton, driver);
	    log.info("Sucessfully Taped on goButton");
	    WaitUntilvisibilityOf(lp.enterBothUsernameAndPasswordToasterMessage);
	    log.info("Sucessfully Waited Untill enterBothUsernameAndPasswordToasterMessage is visable");
	    lp.enterBothUsernameAndPasswordToasterMessage.isDisplayed();
	    log.info("enterBothUsernameAndPasswordToasterMessage Is Displayed In Appliction");
	}
	
	@AfterTest
	public void closeTheApplication() {
		closingApplication();
		log.info("Sucessfully Closed The App");
	}
}
