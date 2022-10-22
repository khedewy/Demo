package Tests;

import Pages.ComparListDetails;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import SuccessfulAssertionsPages.SuccefulSearch;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CompareTest extends TestBase{
    SearchPage search;
    ProductDetailsPage detailsPage;
    ComparListDetails comparListDetails;

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
        detailsPage.setAddToComparePage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        detailsPage.setShowComparePage();
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
        detailsPage.setAddToComparePage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        detailsPage.setShowComparePage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        comparListDetails = new ComparListDetails(driver);
        Assert.assertEquals(comparListDetails.SamsungAssertion(),"Samsung Series 9 NP900X4C Premium Ultrabook");
    }
}
