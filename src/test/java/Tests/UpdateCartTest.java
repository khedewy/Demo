package Tests;

import Pages.ComparListDetails;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.UpdateCartPage;
import SuccessfulAssertionsPages.SuccefulSearch;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UpdateCartTest extends TestBase{
    SearchPage search;
    ProductDetailsPage detailsPage;
    ComparListDetails comparListDetails;
    UpdateCartPage update;

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
    public void UserCanAddToCompareList(){
        detailsPage = new ProductDetailsPage(driver);
        detailsPage.setAddToCartButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        detailsPage.setShowCartPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        comparListDetails = new ComparListDetails(driver);
        Assert.assertEquals(comparListDetails.MacAssertion(),"Apple MacBook Pro 13-inch");

    }
    @Test(priority = 2)
    public void UserCAnSearchAgain(){
        search = new SearchPage(driver);
        search.setSearchBox("Samsung");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        search.setSamsungResults();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test(priority = 3)
    public void UserCanAddToCompareListAgain(){
        detailsPage = new ProductDetailsPage(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        detailsPage.setAddToCartBtn();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        detailsPage.setShowCartPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        comparListDetails = new ComparListDetails(driver);
        Assert.assertEquals(comparListDetails.SamsungAssertion(),"Samsung Series 9 NP900X4C Premium Ultrabook");
    }
    @Test(priority = 4)
    public void UpdateCart() throws InterruptedException {
        update = new UpdateCartPage(driver);
        update.setQuantityBox("6");
        update.clickUpdateCart();
        Assert.assertEquals(update.assertionMessage(),"$10,800.00");
    }

}
