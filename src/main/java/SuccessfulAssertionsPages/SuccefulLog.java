package SuccessfulAssertionsPages;

import Pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccefulLog extends PageBase {
    public SuccefulLog(WebDriver driver) {
        super(driver);
    }

    private By AssertionMessage = By.linkText("Log out");

    public String assertionMessage(){
        return driver.findElement(AssertionMessage).getText();
    }
}
