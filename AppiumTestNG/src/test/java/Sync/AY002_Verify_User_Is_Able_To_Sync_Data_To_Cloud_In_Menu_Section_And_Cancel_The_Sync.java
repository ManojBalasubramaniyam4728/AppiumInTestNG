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

public class AY002_Verify_User_Is_Able_To_Sync_Data_To_Cloud_In_Menu_Section_And_Cancel_The_Sync extends base{
	public static Logger log=LogManager.getLogger(AY002_Verify_User_Is_Able_To_Sync_Data_To_Cloud_In_Menu_Section_And_Cancel_The_Sync.class.getName());
	
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
		LongWaitUntilvisibilityOf(ldp.cancelButton);
		log.info("Sucessfully Wait Untill cancelButton is visable");
		Tap(ldp.cancelButton, driver);
		log.info("Sucessfully Taped on cancelButton");
		WaitUntilvisibilityOf(ldp.wouldYouLikeToStoptheSyncToasterMessage);
		log.info("Sucessfully Wait Untill wouldYouLikeToStoptheSyncToasterMessage is visable");
		ldp.wouldYouLikeToStoptheSyncToasterMessage.isDisplayed();
		log.info("enterBothUsernameAndPasswordToasterMessage Is Displayed In Appliction");
	}
	
	@AfterTest
	public void closeTheApplication() {
		closingApplication();
		log.info("Sucessfully Closed The App");
	}

}
