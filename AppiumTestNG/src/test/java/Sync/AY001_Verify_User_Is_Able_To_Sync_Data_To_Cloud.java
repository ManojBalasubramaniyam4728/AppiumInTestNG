package Sync;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactoryRepo.landingPage;
import Resources.base;
import Resources.stepGroups;

public class AY001_Verify_User_Is_Able_To_Sync_Data_To_Cloud extends base{
	public static Logger log=LogManager.getLogger(AY001_Verify_User_Is_Able_To_Sync_Data_To_Cloud.class.getName());
	
	@BeforeTest
	public void openkuzaApplication() throws IOException {
        openKuzaAplicationWithPackageActivityAndNoResetFalse();
        log.info("Sucessfully Opend App And Loged In");
	}
	
	@Test
	public void enterInvalidUsernameAndValidPassword() throws IOException, InterruptedException {
		stepGroups sg=new stepGroups();
		
		sg.loginToKuzaApplication();
		
		landingPage ldp=new landingPage(driver);
		
		//This hard wait because of application issue
		Thread.sleep(3000);
		Tap(ldp.syncButton, driver);
		log.info("Sucessfully Taped on syncButton");
		LongWaitUntilvisibilityOf(ldp.syncCompletedSuccessfullyToasterMessage);
		log.info("Sucessfully Waited Untill syncCompletedSuccessfullyToasterMessage is visable");
		ldp.syncCompletedSuccessfullyToasterMessage.isDisplayed();
		log.info("enterBothUsernameAndPasswordToasterMessage Is Displayed In Appliction");
		Tap(ldp.okButton, driver);
		log.info("Sucessfully Taped on okButton");
	}
	
	@AfterTest
	public void closeTheApplication() {
		closingApplication();
		log.info("Sucessfully Closed The App");
	}

}
