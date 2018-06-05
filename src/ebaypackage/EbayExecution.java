package ebaypackage;

import org.testng.annotations.Test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class EbayExecution extends EbayCommonMethods{
	@Test(priority=1)
	public void ebayHome() throws Throwable {
		EbayHome home = new EbayHome();
		home.ebayHomePage();
	}

	@Test(priority=2)
	public void ebayLogin() throws Throwable {
		EbayLogin login = new EbayLogin();
		login.ebayLoginPage();
	}

	@Test(priority=3)
	public void ebayReview() throws Throwable {
		EbayReview review = new EbayReview();
		review.ebayReviewPage();
	}

	@Test(priority=4)
	public void ebaySummary() throws Throwable {
		EbaySummary summary = new EbaySummary();
		summary.ebaySummaryPage();
	}


	@BeforeSuite
	public void beforeSuite() throws Throwable {
		setUp();
	}

	@AfterSuite
	public void afterSuite() {
		closeApplication();
	}
}
