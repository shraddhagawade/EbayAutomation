package ebaypackage;

import org.openqa.selenium.By;

public class EbayHome extends EbayCommonMethods{
	String itemName;
	String itemPrice;
	String homePage = "Home";
	By searchBox = By.id("com.ebay.mobile:id/search_box");
	By searchText = By.id("com.ebay.mobile:id/search_src_text");
	By searchList = By.id("com.ebay.mobile:id/text");
	By resultList = By.id("com.ebay.mobile:id/textview_item_title");
	By selectedItemName = By.id("com.ebay.mobile:id/textview_item_title");
	By selectedItemPrice = By.id("com.ebay.mobile:id/textview_item_price");
	By buyNowButton = By.xpath("//android.widget.Button[@text='BUY IT NOW']");

	public void ebayHomePage() throws Throwable {

		try {	 
			//Verify Search Box element is present
			if(elementExists(searchBox))
			{
				getScreenshot(homePage);
				clickElement(searchBox);
			}
			//Enter Search item from Excel Sheet
			if(elementExists(searchText))
			{
				enterData(searchText, readExcel(0, 1));
			}

			//select item from auto populated options
			if(elementExists(searchList))
			{
				elementList(searchList, 0);
			}

			//verify result list
			if(elementExists(resultList))
			{
				elementList(resultList, 1);
			}

			//Verify selected Item name
			if(elementExists(selectedItemName))
			{
				itemName = saveText(selectedItemName);
			}

			//Verify selected Item price
			if(elementExists(selectedItemPrice))
			{
				itemPrice = saveText(selectedItemPrice);
			}

			//Click on Buy Now Button
			if(elementExists(buyNowButton))
			{
				clickElement(buyNowButton);
			}
		}
		catch (Exception e) {
			System.out.println("Exception: "+ e.getMessage());
		}			
	}
}
