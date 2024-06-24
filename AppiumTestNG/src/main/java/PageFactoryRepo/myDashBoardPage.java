package PageFactoryRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class myDashBoardPage {

	// Giving life to driver by Constracor
	public myDashBoardPage(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
		
//**************************************************************************************************************************************		
	 //Locaters and Storing In Variable
		  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Kenya Dat')]")
		  public WebElement userImage;
		  	
}

