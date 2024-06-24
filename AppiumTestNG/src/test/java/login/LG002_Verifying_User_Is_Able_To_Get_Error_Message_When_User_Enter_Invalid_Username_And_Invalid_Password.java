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

public class LG002_Verifying_User_Is_Able_To_Get_Error_Message_When_User_Enter_Invalid_Username_And_Invalid_Password extends base{
	public static Logger log=LogManager.getLogger(LG002_Verifying_User_Is_Able_To_Get_Error_Message_When_User_Enter_Invalid_Username_And_Invalid_Password.class.getName());
	
    @BeforeTest
    public void openkuzaApplication() throws IOException {
	openKuzaAplicationWithPackageActivityAndNoResetFalse();
	log.info("Sucessfully Opend App And Loged In");
    }

     @Test
     public void enterInvalidUsernameAndInvalidPassword() throws IOException, InterruptedException {
     Properties prop=new Properties();
     FileInputStream fis=new FileInputStream(credientialsFilePath);
     prop.load(fis);
     String InvalidUserName = prop.getProperty("InvalidUserName");
     String InvalidPassword = prop.getProperty("InvalidPassword");
    
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
     lp.passwordTextfield.sendKeys(InvalidPassword);
     log.info("Sucessfully Entered InvalidPassword Into passwordTextfield");
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
