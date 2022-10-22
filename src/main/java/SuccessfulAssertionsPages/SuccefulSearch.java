package SuccessfulAssertionsPages;

import Pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccefulSearch extends PageBase {
    public SuccefulSearch(WebDriver driver) {
        super(driver);
    }

    private By AssertionMessage = By.cssSelector("strong.current-item");

    public String assertionMessage(){
        return driver.findElement(AssertionMessage).getText();

    }
}
