package ChangePassword;

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
import PageFactoryRepo.menuPage;
import PageFactoryRepo.myDashBoardPage;
import PageFactoryRepo.userProfilePage;
import Resources.base;
import Resources.stepGroups;

public class CP001_Verify_User_Is_Able_To_Change_The_Password extends base {
	public static Logger log=LogManager.getLogger(CP001_Verify_User_Is_Able_To_Change_The_Password.class.getName());
	
	
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
		String Username=prop.getProperty("Username");
	    String CurrentPassword=prop.getProperty("CurrentPassword");
	    String NewPassword=prop.getProperty("NewPassword");
	    String ConfirmPassword=prop.getProperty("ConfirmPassword");
	    String NewCurrentPassword=prop.getProperty("NewCurrentPassword");
	    String NewNewPassword=prop.getProperty("NewNewPassword");
	    String NewConfirmPassword=prop.getProperty("NewConfirmPassword");
	    
		stepGroups sg=new stepGroups();
		
		sg.loginToKuzaApplication();
		
		loginPage lp=new loginPage(driver);
		landingPage ldp=new landingPage(driver);
		menuPage mp=new menuPage(driver);
		myDashBoardPage mdp=new myDashBoardPage(driver);
		userProfilePage upp=new userProfilePage(driver);
		
		//This hard wait because of application issue
		Thread.sleep(3000);
	    Tap(ldp.menuButton, driver);
	    log.info("Sucessfully Taped On menuButton");
	    WaitUntilvisibilityOf(mp.editProfileLink);
	    log.info("Sucessfully Waited Till editProfileLink is visable");
	    Tap(mp.editProfileLink, driver);
	    log.info("Sucessfully Taped On editProfileLink");
	    WaitUntilvisibilityOf(mdp.userImage);
	    log.info("Sucessfully Waited Till userImage is visable");
	    Tap(mdp.userImage, driver);
	    log.info("Sucessfully Taped On userImage");
	    WaitUntilvisibilityOf(upp.choosePictureImage);
	    log.info("Sucessfully Waited Till userImage is visable");
	    Swipe(upp.changePasswordButton, 5, driver);
	    log.info("Sucessfully Swiped Till changePasswordButton is visable");
	    Tap(upp.changePasswordButton, driver);
	    log.info("Sucessfully Taped On changePasswordButton");
	    WaitUntilvisibilityOf(upp.currentPasswordTextfield);
	    log.info("Sucessfully Waited Till currentPasswordTextfield is visable");
	    Tap(upp.currentPasswordTextfield, driver);
	    log.info("Sucessfully Taped On currentPasswordTextfield");
	    upp.enterCurrentPasswordTextfield.sendKeys(CurrentPassword);
	    log.info("Sucessfully Entred CurrentPassword Into enterCurrentPasswordTextfield");
	    Tap(upp.newPasswordTextfield, driver);
	    log.info("Sucessfully Taped On newPasswordTextfield");
	    upp.enterNewPasswordTextfield.sendKeys(NewPassword);
	    log.info("Sucessfully Entred NewPassword Into enterNewPasswordTextfield");
	    Tap(upp.confirmPasswordTextfield, driver);
	    log.info("Sucessfully Taped On confirmPasswordTextfield");
	    upp.enterConfirmPasswordTextfield.sendKeys(ConfirmPassword);
	    log.info("Sucessfully Entred ConfirmPassword Into enterConfirmPasswordTextfield");
	    Tap(upp.saveButton, driver);
	    log.info("Sucessfully Taped On saveButton");
	    WaitUntilvisibilityOf(upp.yourPasswordHasBeenChangedSuccessfullyToasterMessage);
	    log.info("Sucessfully Waited Till yourPasswordHasBeenChangedSuccessfullyToasterMessage is visable");
	    upp.yourPasswordHasBeenChangedSuccessfullyToasterMessage.isDisplayed();
	    log.info("yourPasswordHasBeenChangedSuccessfullyToasterMessage Is Dispayed In The Application");
	    Tap(upp.okButton, driver);
	    log.info("Sucessfully Taped On okButton");
	    //This hard wait because of application issue
	  	Thread.sleep(5000);
	  	WaitUntilvisibilityOf(lp.userNameTextfield);
	    log.info("Sucessfully Waited Till userNameTextfield is visable");
	    Tap(lp.userNameTextfield, driver);
	    log.info("Sucessfully Taped On userNameTextfield");
	    lp.userNameTextfield.sendKeys(Username);
	    log.info("Sucessfully Entred Username Into userNameTextfield");
	    Tap(lp.passwordTextfield, driver);
	    log.info("Sucessfully Taped On passwordTextfield");
	    lp.passwordTextfield.sendKeys(NewPassword);
	    log.info("Sucessfully Entred NewPassword Into passwordTextfield");
	    Tap(lp.goButton, driver);
	    log.info("Sucessfully Taped On goButton");
	    WaitUntilvisibilityOf(ldp.kuzaLogo);
	    log.info("Sucessfully Waited Till kuzaLogo is visable");
	    Tap(ldp.menuButton, driver);
	    log.info("Sucessfully Taped On menuButton");
	    WaitUntilvisibilityOf(mp.editProfileLink);
	    log.info("Sucessfully Waited Till editProfileLink is visable");
	    Tap(mp.editProfileLink, driver);
	    log.info("Sucessfully Taped On editProfileLink");
	    WaitUntilvisibilityOf(mdp.userImage);
	    log.info("Sucessfully Waited Till userImage is visable");
	    //This hard wait because of application issue
	  	Thread.sleep(3000);
	    Tap(mdp.userImage, driver);
	    log.info("Sucessfully Taped On userImage");
	    WaitUntilvisibilityOf(upp.choosePictureImage);
	    log.info("Sucessfully Waited Till userImage is visable");
        Swipe(upp.changePasswordButton, 5, driver);
        log.info("Sucessfully Swiped Till changePasswordButton is visable");
        Tap(upp.changePasswordButton, driver);
        log.info("Sucessfully Taped On changePasswordButton");
        WaitUntilvisibilityOf(upp.currentPasswordTextfield);
        log.info("Sucessfully Waited Till userImage is visable");
        Tap(upp.currentPasswordTextfield, driver);
        log.info("Sucessfully Taped On changePasswordButton");
        upp.enterCurrentPasswordTextfield.sendKeys(NewCurrentPassword);
        log.info("Sucessfully Entred NewCurrentPassword Into enterCurrentPasswordTextfield");
        Tap(upp.newPasswordTextfield, driver);
        log.info("Sucessfully Taped On newPasswordTextfield");
	    upp.enterNewPasswordTextfield.sendKeys(NewCurrentPassword);
	    log.info("Sucessfully Entred NewCurrentPassword Into enterNewPasswordTextfield");
	    Tap(upp.confirmPasswordTextfield, driver);
	    log.info("Sucessfully Taped On confirmPasswordTextfield");
        upp.enterConfirmPasswordTextfield.sendKeys(NewCurrentPassword);
        log.info("Sucessfully Entred NewCurrentPassword Into enterConfirmPasswordTextfield");
        Tap(upp.saveButton, driver);
        log.info("Sucessfully Taped On saveButton");
        WaitUntilvisibilityOf(upp.currentPasswordAndNewPasswordShouldBeDifferentToasterMessage);
        log.info("Sucessfully Waited Till currentPasswordAndNewPasswordShouldBeDifferentToasterMessage is visable");
        upp.currentPasswordAndNewPasswordShouldBeDifferentToasterMessage.isDisplayed();
        log.info("currentPasswordAndNewPasswordShouldBeDifferentToasterMessage Is Dispayed In The Application");
        Tap(upp.okButton, driver);
        log.info("Sucessfully Taped On changePasswordButton");
        Tap(upp.newPasswordTextfield, driver);
        log.info("Sucessfully Taped On newPasswordTextfield");
        upp.newPasswordTextfield.clear();
        log.info("Sucessfully cleared Text From newPasswordTextfield");
        upp.enterNewPasswordTextfield.sendKeys(NewNewPassword);
        log.info("Sucessfully Entred NewNewPassword Into enterNewPasswordTextfield");
        Tap(upp.saveButton, driver);
        log.info("Sucessfully Taped On saveButton");
        WaitUntilvisibilityOf(upp.newPasswordAndConfirmPasswordDoesnotMatchToasterMessage);
        log.info("Sucessfully Waited Till newPasswordAndConfirmPasswordDoesnotMatchToasterMessage is visable");
        upp.newPasswordAndConfirmPasswordDoesnotMatchToasterMessage.isDisplayed();
        log.info("newPasswordAndConfirmPasswordDoesnotMatchToasterMessage Is Dispayed In The Application");
        Tap(upp.okButton, driver);
        log.info("Sucessfully Taped On okButton");
        Tap(upp.currentPasswordTextfield, driver);
        log.info("Sucessfully Taped On currentPasswordTextfield");
        upp.currentPasswordTextfield.clear();
        log.info("Sucessfully cleared Text From currentPasswordTextfield");
        upp.enterCurrentPasswordTextfield.sendKeys(NewConfirmPassword);
        log.info("Sucessfully Entred NewConfirmPassword Into enterCurrentPasswordTextfield");
        Tap(upp.newPasswordTextfield, driver);
        log.info("Sucessfully Taped On newPasswordTextfield");
        upp.newPasswordTextfield.clear();
        log.info("Sucessfully cleared Text From newPasswordTextfield");
        upp.enterNewPasswordTextfield.sendKeys(NewCurrentPassword);
        log.info("Sucessfully Entred NewCurrentPassword Into enterNewPasswordTextfield");
        Tap(upp.saveButton, driver);
        log.info("Sucessfully Taped On saveButton");
        WaitUntilvisibilityOf(upp.invalidCurrentPasswordPleaseCheckAndTryAgain);
        log.info("Sucessfully Waited Till invalidCurrentPasswordPleaseCheckAndTryAgain is visable");
        upp.invalidCurrentPasswordPleaseCheckAndTryAgain.isDisplayed();
        log.info("invalidCurrentPasswordPleaseCheckAndTryAgain Is Dispayed In The Application");
        Tap(upp.okButton, driver);
        log.info("Sucessfully Taped On okButton");
        Tap(upp.currentPasswordTextfield, driver);
        log.info("Sucessfully Taped On currentPasswordTextfield");
        upp.currentPasswordTextfield.clear();
        log.info("Sucessfully cleared Text From currentPasswordTextfield");
        upp.enterCurrentPasswordTextfield.sendKeys(NewCurrentPassword);
        log.info("Sucessfully Entred NewCurrentPassword Into enterCurrentPasswordTextfield");
        Tap(upp.newPasswordTextfield, driver);
        log.info("Sucessfully Taped On newPasswordTextfield");
        upp.newPasswordTextfield.clear();
        log.info("Sucessfully cleared Text From newPasswordTextfield");
        upp.enterNewPasswordTextfield.sendKeys(NewNewPassword);
        log.info("Sucessfully Entred NewNewPassword Into enterNewPasswordTextfield");
        Tap(upp.confirmPasswordTextfield, driver);
        log.info("Sucessfully Taped On confirmPasswordTextfield");
        upp.confirmPasswordTextfield.clear();
        log.info("Sucessfully cleared Text From confirmPasswordTextfield");
        upp.enterConfirmPasswordTextfield.sendKeys(NewConfirmPassword);
        log.info("Sucessfully Entred NewConfirmPassword Into enterConfirmPasswordTextfield");
        Tap(upp.saveButton, driver);
        log.info("Sucessfully Taped On saveButton");
        WaitUntilvisibilityOf(upp.yourPasswordHasBeenChangedSuccessfullyToasterMessage);
        log.info("Sucessfully Waited Till yourPasswordHasBeenChangedSuccessfullyToasterMessage is visable");
        upp.yourPasswordHasBeenChangedSuccessfullyToasterMessage.isDisplayed();
        log.info("yourPasswordHasBeenChangedSuccessfullyToasterMessage Is Dispayed In The Application");
        Tap(upp.okButton, driver);
        log.info("Sucessfully Taped On okButton");
        //This hard wait because of application issue
	  	Thread.sleep(5000);
        WaitUntilvisibilityOf(lp.userNameTextfield);
        log.info("Sucessfully Waited Till userNameTextfield is visable");
	    Tap(lp.userNameTextfield, driver);
	    log.info("Sucessfully Taped On userNameTextfield");
	    lp.userNameTextfield.sendKeys(Username);
	    log.info("Sucessfully Entred Username Into userNameTextfield");
	    Tap(lp.passwordTextfield, driver);
	    log.info("Sucessfully Taped On passwordTextfield");
	    lp.passwordTextfield.sendKeys(NewNewPassword);
	    log.info("Sucessfully Entred NewNewPassword Into passwordTextfield");
	    Tap(lp.goButton, driver);
	    log.info("Sucessfully Taped On goButton");
	    WaitUntilvisibilityOf(ldp.kuzaLogo);
	    log.info("Sucessfully Waited Till kuzaLogo is visable");
	    ldp.kuzaLogo.isDisplayed();
	    log.info("kuzaLogo Is Dispayed In The Application");
	}
	
	@AfterTest
	public void closeTheApplication() {
		closingApplication();
		log.info("Sucessfully Closed The App");
		   
	}
}