package ebaypackage;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EbaySummary extends EbayCommonMethods {
	String summaryItemName;
	String summaryItemPrice;
	String summaryPage = "Summary";
	By summaryName = By.xpath("//android.view.View[@instance='26']");
	By summaryPrice = By.xpath("//android.view.View[@instance='28']");
	
  public void ebaySummaryPage() throws Throwable {
	  EbayHome home = new EbayHome();
	  try {
		  //Verify selected Item name on summary page
		  getScreenshot(summaryPage);
		  if(elementExists(summaryName))
			{
				summaryItemName = saveText(summaryName);
				Assert.assertEquals(home.itemName, summaryItemName, "Item Name Matched");
			}
	  }
	  catch (Exception e) {
		System.out.println("Exception: "+ e.getMessage());
	}
  }

}
