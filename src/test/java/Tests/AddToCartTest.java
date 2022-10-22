package Tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import SuccessfulAssertionsPages.SuccefulSearch;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddToCartTest extends TestBase{
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
        detailsPage.setAddToCartButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        detailsPage.setShowCartPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals(detailsPage.addToCartAssertion(),"Apple MacBook Pro 13-inch");
    }
}
