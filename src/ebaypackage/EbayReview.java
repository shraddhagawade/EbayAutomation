package ebaypackage;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EbayReview extends EbayCommonMethods{
	String reviewItemName;
	String reviewItemPrice;
	String reviewPage = "Review";
	By reviewName = By.id("com.ebay.mobile:id/item_title");
	By reviewPrice = By.id("com.ebay.mobile:id/textview_item_price");
	By reviewButton = By.id("com.ebay.mobile:id/take_action");

	public void ebayReviewPage() throws Throwable {
		EbayHome home = new EbayHome();
		try {
			//Verify selected Item name on review page
			if(elementExists(reviewName))
			{
				getScreenshot(reviewPage);
				reviewItemName = saveText(reviewName);
				Assert.assertEquals(home.itemName, reviewItemName, "Item Name Matched");				
			}

			//Verify selected Item price on review page
			if(elementExists(reviewPrice))
			{
				reviewItemPrice = saveText(reviewPrice);				
				Assert.assertEquals(home.itemPrice, reviewItemPrice, "Item Price Matched");
			}

			//Click on Review Button
			if(elementExists(reviewButton))
			{
				clickElement(reviewButton);
			}
		}
		catch (Exception e) {
			System.out.println("Exception: "+ e.getMessage());
		}

	}

}

