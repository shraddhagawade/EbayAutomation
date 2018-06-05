package ebaypackage;

import org.openqa.selenium.By;

public class EbayLogin extends EbayCommonMethods{
	By username = By.xpath("//android.widget.EditText[@password='false']");
	By password = By.xpath("//android.widget.EditText[@password='true']");
	By signIn = By.xpath("//android.widget.Button[@text='SIGN IN']");
	By allowOption = By.id("com.ebay.mobile:id/button_google_deny");

	public void ebayLoginPage() throws Throwable {
		//Enter credentials to Sign IN
		try {		
			//Read Username from excel
			if(elementExists(username))
			{
				enterData(username, readExcel(1, 1));
			}
			//Read Password from excel
			if(elementExists(password))
			{
				enterData(password, readExcel(2, 1));
			}
			//Click on Sign in Button
			if(elementExists(signIn))
			{
				clickElement(signIn);
			}
			//Verify Link account option is displayed
			if(elementExists(allowOption))
			{
				clickElement(allowOption);
			}
		}
		catch (Exception e) {
			System.out.println("Exception: "+ e.getMessage());
		}	
	}

}
