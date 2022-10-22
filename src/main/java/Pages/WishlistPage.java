package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends PageBase{
    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    private By WishListAssertion = By.linkText("Apple MacBook Pro 13-inch");

    public String assertionMessage(){
        return driver.findElement(WishListAssertion).getText();
    }
}
