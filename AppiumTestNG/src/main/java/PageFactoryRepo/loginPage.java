package PageFactoryRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class loginPage {

	// Giving life to driver by Constracor
	public loginPage(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

//**************************************************************************************************************************************		
	// Locaters and Storing In Variable
	   @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='background-content']/following-sibling::android.view.View//android.widget.EditText)[1]")
	   public WebElement userNameTextfield;

	// Locaters and Storing In Variable
	   @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
	   public WebElement passwordTextfield;

	// Locaters and Storing In Variable
	   @AndroidFindBy(xpath = "//android.widget.Button[@text='GO']")
	   public WebElement goButton;

	// Locaters and Storing In Variable
	   @AndroidFindBy(xpath = "//android.view.View//android.widget.Button[@text='START']")
	   public WebElement startButton;

	// Locaters and Storing In Variable
	   @AndroidFindBy(xpath = "//android.widget.TextView[@text='Device setup completed successfully']")
	   public WebElement deviceSetupCompletedSuccessfullyToasterMessage;

	// Locaters and Storing In Variable
	   @AndroidFindBy(xpath = "//android.widget.TextView[@text='The mobile number or password provided are/is incorrect.  Please try again with correct login credentials']")
	   public WebElement mobileAndPasswordToasterMessage;
	   
	// Locaters and Storing In Variable
	   @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	   public WebElement okButton;
	   
	// Locaters and Storing In Variable
	   @AndroidFindBy(xpath = "//android.widget.TextView[@text='The mobile number or password provided are/is incorrect.  Please try again with correct login credentials']")
	   public WebElement userNameAndPasswordIncorrectToasterMessage;

	// Locaters and Storing In Variable
	   @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter both username and password']")
	   public WebElement enterBothUsernameAndPasswordToasterMessage;


	   

}
