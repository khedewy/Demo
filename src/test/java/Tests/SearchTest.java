package Tests;

import Pages.SearchPage;
import SuccessfulAssertionsPages.SuccefulSearch;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class SearchTest extends TestBase {
    SearchPage search;

    @Test
    public void UserCAnSearch(){
        search = new SearchPage(driver);
        search.setSearchBox("mac");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        search.setMacProductList();
        SuccefulSearch succefulSearch = new SuccefulSearch(driver);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        Assert.assertEquals(succefulSearch.assertionMessage(),"Apple MacBook Pro 13-inch");

    }
}
