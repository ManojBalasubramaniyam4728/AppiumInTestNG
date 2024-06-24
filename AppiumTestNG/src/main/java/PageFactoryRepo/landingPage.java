package PageFactoryRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class landingPage {
	
	// Giving life to driver by Constracor
	public landingPage(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//**************************************************************************************************************************************		
	// Locaters and Storing In Variable
		 @AndroidFindBy(xpath = "//android.widget.Button[@text='menu']")
		 public WebElement kuzaLogo;

   //Locaters and Storing In Variable
		 @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sync']")
		 public WebElement syncButton;
    
   //Locaters and Storing In Variable
         @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sync completed successfully']")
         public WebElement syncCompletedSuccessfullyToasterMessage;
         
   //Locaters and Storing In Variable
		 @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
		 public WebElement okButton;
		 
   //Locaters and Storing In Variable
		 @AndroidFindBy(xpath = "//android.widget.Button[@text='Cancel']")
		 public WebElement cancelButton;
		 
	//Locaters and Storing In Variable
		 @AndroidFindBy(xpath = "//android.widget.TextView[@text='Would you like to Stop the Sync']")
		 public WebElement wouldYouLikeToStoptheSyncToasterMessage;
		 
	//Locaters and Storing In Variable
		 @AndroidFindBy(xpath = "//android.widget.Button[@text='menu']")
		 public WebElement menuButton;
    
}
    
