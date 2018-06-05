package ebaypackage;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;

import jxl.Sheet;
import jxl.Workbook;

public class EbayCommonMethods {
	private static WebDriver driver;

	//Method to setup Appium
	public void setUp() throws Throwable, MalformedURLException{
			File appDir = new File("C:\\Users\\SHRADS\\Downloads");
			File app = new File(appDir, "eBay.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//Set Mandatory Capabilities
			capabilities.setCapability("device","Moto G");
			capabilities.setCapability("deviceName","Moto G");
			capabilities.setCapability("platformName","Android");
			capabilities.setCapability("udid", "ZY223GM339");
			capabilities.setCapability("fullReset","false");
			capabilities.setCapability("app", app.getAbsolutePath());
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		}
		
	//Method to check Element is exists
	public boolean elementExists(By locator) throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try
		{
			if(driver.findElements(locator).size()!=0)
			{
				return true;
			}
			else 
			{
				System.out.println("Element Not Found");
				closeApplication();
			}
		}
		catch(Exception e) {
			System.out.println("Exception: ");		   
		}
		return false;
	}	
	//Method to click element
	public void clickElement(By locator) {
		driver.findElement(locator).click();
	}
	//Method to save text property of element
	public String saveText(By locator) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(driver.findElement(locator).getText());
		return driver.findElement(locator).getText();		
	}
	//Method to create web element List
	public void elementList(By locator, int index)
	{
		List<WebElement> search = driver.findElements(locator);
		if (!search.isEmpty()) {
			System.out.println(search.get(index).getText());
			search.get(index).click();
		}	 
	}
	//Method to send keys to element
	public void enterData(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public String readExcel(int column, int row) {
		try
		{
			FileInputStream file = new FileInputStream("C:\\Users\\SHRADS\\eclipse-workspace\\EbayAppium\\testdata\\Search.xls");
			Workbook book = Workbook.getWorkbook(file);
			Sheet sheet1 = book.getSheet(0);
			return sheet1.getCell(column,row).getContents();
		}
		catch (Exception e) {

			System.out.println("Exception: ");
		}
		return null;
	}

	public void getScreenshot(String snap)
	{
		try
		{
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("C:\\Users\\SHRADS\\eclipse-workspace\\EbayAppium\\screenshots\\"+snap+".png"));
			driver.close();
		}
		catch (Exception e) {
			System.out.println("Exception: "+ e.getMessage());
		}
	}

	public void closeApplication()
	{
		driver.quit();
	}
}
