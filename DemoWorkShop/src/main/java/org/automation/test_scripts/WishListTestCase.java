package org.automation.test_scripts;
import org.automation.element.BooksPage;
import org.automation.element.BooksPage;
import org.automation.element.FictionFXPage;
import org.automation.element.WIshlistPage;
import org.testng.Assert;
import org.testng.Reporter;

public class WishListTestCase {
	public void verify_User_Is_Able_To_Add_Product_To_Wishlist()
	{
		home_page.getBooksLink().click();

		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books", "Books page not displayed"); 
		Reporter.log("Books Page Displayed", true);

		BooksPage books_Page = new BooksPage (driver);
	    String actProductName=books_Page.getFictionFX().getText(); 
	    books_Page.getFictionFX().click();

		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Fiction EX", "Fiction Ex Product Page not Displayed");
		Reporter.log("Fiction Ex Product Page Displayed", true);

		FictionFXPage product_Page = new FictionFXPage(driver);
		product_Page.getAddToWishlist().click();

		home_page.getWishListLink().click();

		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Wishlist", "Wish List Page not Displayed");
		Reporter.log("Wish List Page Displayed", true);
		
		driver.navigate().refresh();

		WIshlistPage wishList_Page = new WIshlistPage();
		

		String expProductName=wishList_Page.getFictionFXProduct().getText();
		


		Assert.assertEquals (actProductName, expProductName, "verify_User_Is_Able_To_Add_Product_To_WishList Test Case Fail");
		Reporter.log("verify_User_Is_Able_To_Add_Product_To_WishList Test Case Pass..", true);

		wishList_Page.getRemoveFromCart().click();

		wishList_Page.getUpdateCart().click();

		}
}
