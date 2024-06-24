package PageFactoryRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class userProfilePage {
	
	// Giving life to driver by Constracor
	public userProfilePage(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
		
//**************************************************************************************************************************************		
		 //Locaters and Storing In Variable
		  	@AndroidFindBy(xpath = "//android.widget.Button[@text='Choose Picture']")
		  	public WebElement choosePictureImage;
		  	
		 //Locaters and Storing In Variable
		  	@AndroidFindBy(xpath = "//android.widget.Button[@text='Change Password']")
		  	public WebElement changePasswordButton;
		  	
		 //Locaters and Storing In Variable
		  	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Current Password']")
		  	public WebElement currentPasswordTextfield;
		  	
		  //Locaters and Storing In Variable
		  	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Current Password']/..//android.widget.EditText")
		  	public WebElement enterCurrentPasswordTextfield;
		  	
		  //Locaters and Storing In Variable
		  	@AndroidFindBy(xpath = "//android.widget.TextView[@text='New Password']")
		  	public WebElement newPasswordTextfield;
		  	
		  //Locaters and Storing In Variable
		  	@AndroidFindBy(xpath = "//android.widget.TextView[@text='New Password']/..//android.widget.EditText")
		  	public WebElement enterNewPasswordTextfield;
		  	
		  //Locaters and Storing In Variable
		  	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Confirm Password']")
		  	public WebElement confirmPasswordTextfield;
		  	
		  //Locaters and Storing In Variable
		  	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Confirm Password']/..//android.widget.EditText")
		  	public WebElement enterConfirmPasswordTextfield;
		  	
		  //Locaters and Storing In Variable
		  	@AndroidFindBy(xpath = "//android.widget.Button[@text='Save']")
		  	public WebElement saveButton;
		  	
		  //Locaters and Storing In Variable
		  	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Your password has been changed successfully. Now you will have to login with your new password']")
		  	public WebElement yourPasswordHasBeenChangedSuccessfullyToasterMessage;
		  	
		  //Locaters and Storing In Variable
		  	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Current Password and New Password should be different']")
		  	public WebElement currentPasswordAndNewPasswordShouldBeDifferentToasterMessage;
		  	
		  //Locaters and Storing In Variable
		  	@AndroidFindBy(xpath = "//android.widget.TextView[@text='New Password and Confirm Password doesnot match']")
		  	public WebElement newPasswordAndConfirmPasswordDoesnotMatchToasterMessage;
		  	
		  //Locaters and Storing In Variable
		  	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Invalid Current Password. Please check and try again']")
		  	public WebElement invalidCurrentPasswordPleaseCheckAndTryAgain;
		  	
		   //Locaters and Storing In Variable
		  	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
		  	public WebElement okButton;
		  	
}

