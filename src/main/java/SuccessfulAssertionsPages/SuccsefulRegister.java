package SuccessfulAssertionsPages;

import Pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccsefulRegister extends PageBase {
    public SuccsefulRegister(WebDriver driver) {
        super(driver);
    }

    private By AssertionMessage = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]");

    public String assertionMessage(){
        return driver.findElement(AssertionMessage).getText();
    }
}
