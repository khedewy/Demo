package Pages;

import SuccessfulAssertionsPages.SuccefulSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private By searchBox = By.id("small-searchterms");

    private By MacResults = By.id("ui-id-2");

    private By searchButton = By.id("button.button-1.search-box-button");

    private By SamsungResults = By.id("ui-id-2");

    public void setSearchBox(String productName){
        driver.findElement(searchBox).sendKeys(productName);
    }

    public void setMacProductList(){
        driver.findElement(MacResults).click();
    }
    public void setSamsungResults(){
        driver.findElement(SamsungResults).click();
    }

    public SuccefulSearch setSearchButton(){
        driver.findElement(searchButton).click();
        return new SuccefulSearch(driver);
    }


}
