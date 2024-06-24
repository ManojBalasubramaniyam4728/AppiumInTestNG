package PageFactoryRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class menuPage {

	// Giving life to driver by Constracor
	public menuPage(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
		
//**************************************************************************************************************************************		
		 //Locaters and Storing In Variable
		  	@AndroidFindBy(xpath = "(//android.widget.Button[@text='menu'])[7]/..")
		  	public WebElement editProfileLink;
		  	
}
