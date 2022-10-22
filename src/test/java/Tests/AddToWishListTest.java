package Tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.WishlistPage;
import SuccessfulAssertionsPages.SuccefulSearch;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddToWishListTest extends TestBase{
    SearchPage search;
    ProductDetailsPage detailsPage;

    @Test(priority = 0)
    @Severity(SeverityLevel.NORMAL)
    public void UserCAnSearch(){
        search = new SearchPage(driver);
        search.setSearchBox("mac");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        search.setMacProductList();
        SuccefulSearch succefulSearch = new SuccefulSearch(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals(succefulSearch.assertionMessage(),"Apple MacBook Pro 13-inch");
    }

    @Test(priority = 1)
    public void UserCanAddToCart(){
        detailsPage = new ProductDetailsPage(driver);
        detailsPage.setAddToWishList();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WishlistPage wishlistPage = detailsPage.setShowWishList();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals(wishlistPage.assertionMessage(),"Apple MacBook Pro 13-inch");
    }
}
