package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

   //global Variables
	public static AndroidDriver driver;
	public static String credientialsFilePath = "C:\\Users\\user\\git\\repository2\\AppiumTestNG\\src\\main\\java\\Resources\\credientials.properties";
	public static String apkFilePath = "C:\\Users\\user\\eclipse-workspace\\AppiumTestNG\\src\\main\\java\\Resources\\Kuza_Academy_2.0.11_DAT.apk";
	public static String screenShootFilePath="C:\\Users\\user\\eclipse-workspace\\AppiumTestNG\\Screenshot\\";
	public static String startServerBatFilePath="D:\\Appium\\appiumStart.bat";
	
//**************************************************************************************************************************************
	//User Defined Method To open kuza application with Package, Activity no reset false
	public static AndroidDriver openKuzaAplicationWithPackageActivityAndNoResetFalse() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(credientialsFilePath);
		prop.load(fis);
		String appPackage = prop.getProperty("appPackage");
		String appActivity = prop.getProperty("appActivity");
		String baseurl = prop.getProperty("url");
		String ExplicitWait = prop.getProperty("ExplicitWait");
		Integer ExplicitWaitTime=Integer.parseInt(ExplicitWait);

		// Creating Capabilities
		DesiredCapabilities cap = new DesiredCapabilities();

		// Setting Capabilities
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android devices");
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		cap.setCapability(MobileCapabilityType.NO_RESET, false);
		cap.setCapability("autoGrantPermissions", true);

		// url To server
		URL url = new URL(baseurl);

		// open the app
		driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

//**************************************************************************************************************************************
	//User Defined Method To open kuza application with Packag,Activity no reset true
	public static AndroidDriver openKuzaAplicationWithPackageActivityAndNoResetTrue() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(credientialsFilePath);
		prop.load(fis);
		String appPackage = prop.getProperty("appPackage");
		String appActivity = prop.getProperty("appActivity");
		String baseurl = prop.getProperty("url");
		String ExplicitWait = prop.getProperty("ExplicitWait");
		Integer ExplicitWaitTime=Integer.parseInt(ExplicitWait);

		// Creating Capabilities
		DesiredCapabilities cap = new DesiredCapabilities();

		// Setting Capabilities
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android devices");
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability("autoGrantPermissions", true);

		// url To server
		URL url = new URL(baseurl);

		// open the app
		driver = new AndroidDriver(url, cap);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ExplicitWaitTime));
		return driver;
	}

//**************************************************************************************************************************************
	//User Defined Method To open kuza application with no reset true
	public static AndroidDriver openKuzaAplicationWithApkAndNoRestTrue() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(credientialsFilePath);
		prop.load(fis);
		String baseurl = prop.getProperty("url");
		String ExplicitWait = prop.getProperty("ExplicitWait");
		Integer ExplicitWaitTime=Integer.parseInt(ExplicitWait);

		// apk path
		File file = new File("apkFilePath");

		// Createing capbilitites to open the app
		DesiredCapabilities cap = new DesiredCapabilities();

		// Setting Capabilities
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android devices");
		cap.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		cap.setCapability("noReset", true);
		cap.setCapability("autoGrantPermissions", true);

		// url to server
		URL url = new URL(baseurl);

		// launch the android app
		driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

//**************************************************************************************************************************************
	//User Defined Method To open kuza application with no reset false
	public static AndroidDriver openKuzaAplicationWithApkAndNoRestFalse() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(credientialsFilePath);
		prop.load(fis);
		String baseurl = prop.getProperty("url");
		String ExplicitWait = prop.getProperty("ExplicitWait");
		Integer ExplicitWaitTime=Integer.parseInt(ExplicitWait);

		// apk path
		File file = new File("apkFilePath");

		// Createing capbilitites to open the app
		DesiredCapabilities cap = new DesiredCapabilities();

		// Setting Capabilities
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android devices");
		cap.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		cap.setCapability("noReset", false);
		cap.setCapability("autoGrantPermissions", true);

		// url to server
		URL url = new URL(baseurl);

		// launch the android app
		driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
//**************************************************************************************************************************************
		//User Defined Method To Explicit Wait
		public void WaitUntilvisibilityOf(WebElement Element) throws IOException {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(credientialsFilePath);
			prop.load(fis);
			String ExplicitWait=prop.getProperty("ExplicitWait");
			Integer ExplicitWaitTime=Integer.parseInt(ExplicitWait);
			//logic gos here
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			 wait.until(ExpectedConditions.visibilityOf(Element));
		}
		
//**************************************************************************************************************************************
				//User Defined Method To Explicit Wait
				public void LongWaitUntilvisibilityOf(WebElement Element) throws IOException {
					Properties prop = new Properties();
					FileInputStream fis = new FileInputStream(credientialsFilePath);
					prop.load(fis);
					String ExplicitWait=prop.getProperty("ExplicitWait1");
					Integer ExplicitWaitTime=Integer.parseInt(ExplicitWait);
					//logic gos here
					WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
					 wait.until(ExpectedConditions.visibilityOf(Element));
				}
		
//**************************************************************************************************************************************
			//User Defined Method To Explicit Wait LocaterValue
			public void WaitUntilvisibilityOfElementLocated(By.ByXPath LocaterValue) throws IOException {
				Properties prop = new Properties();
				FileInputStream fis = new FileInputStream(credientialsFilePath);
				prop.load(fis);
				String ExplicitWait=prop.getProperty("ExplicitWait");
				Integer ExplicitWaitTime=Integer.parseInt(ExplicitWait);
				//logic gos here
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
				 wait.until(ExpectedConditions.visibilityOfElementLocated(LocaterValue));
			}
			
//**************************************************************************************************************************************
			//User Defined Method To Tap on Element
			public void Tap(WebElement element,AndroidDriver driver) throws IOException {
				Point sourceLocation=element.getLocation();
				Dimension sourceSize=element.getSize();
				int centerX = sourceLocation.getX() + sourceSize.getWidth() / 2;
				int centerY = sourceLocation.getY() + sourceSize.getHeight() / 2;
				
				PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "finger");
				Sequence tap=new Sequence(finger, 1);
				tap.addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(), centerX, centerY));
				tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
				tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			    driver.perform(Arrays.asList(tap));
			}	
			
//**************************************************************************************************************************************
			//User Defined Method For Closing The Kuza Application
			public void closingApplication() {
			       driver.quit();
			       driver=null;
			}
			
//**************************************************************************************************************************************
			//User Defined Method To Swipe To The Element
			public void Swipe(WebElement element,int maximumCount,AndroidDriver driver) throws IOException {
				//Taking mobile X and y center of screen
				int centerScreenX=driver.manage().window().getSize().getWidth()/2;
				int centerScreenY=driver.manage().window().getSize().getHeight()/2;
				
				//Frome center of the screen swiping 30% upword
				int endY=(int) (driver.manage().window().getSize().getHeight()*0.02);
				
				int maxCount=maximumCount;
				int count=0;
					for(int i = count; i < maxCount; i++) {
					PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "finger");
				    Sequence swipe=new Sequence(finger, 1);
				    
					try {
					if(element.isDisplayed()) {
						break;
					       }
					    }
					catch(NoSuchElementException e) {
						swipe.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerScreenX, centerScreenY));
						swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
						swipe.addAction(finger.createPointerMove(Duration.ofMillis(600),PointerInput.Origin.viewport(), centerScreenX, endY));
						swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
						driver.perform(Arrays.asList(swipe));
					}
					
					if(count >= maxCount) {
						break;
					} 
				}
			}
			
//**************************************************************************************************************************************
		    //User Defined Method For Taking Screnshot On Failed Steps
			 public void getScreenShot(String result) throws IOException{
		        	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        	FileUtils.copyFile(src, new File(screenShootFilePath+result+"screenshot.png"));
		        }

//**************************************************************************************************************************************
		    
}
