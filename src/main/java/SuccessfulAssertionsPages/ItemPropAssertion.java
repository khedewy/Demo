package SuccessfulAssertionsPages;

import Pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPropAssertion extends PageBase {
    public ItemPropAssertion(WebDriver driver) {
        super(driver);
    }

    private By assertionMessage = By.cssSelector("strong.current-item");

    public String assertionMessageText(){
        return driver.findElement(assertionMessage).getText();
    }
}
