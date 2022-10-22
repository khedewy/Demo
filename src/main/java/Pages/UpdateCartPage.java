package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateCartPage extends PageBase{
    public UpdateCartPage(WebDriver driver) {
        super(driver);
    }

    private By quantityBox = By.cssSelector("input.qty-input");

    private By deleteItems = By.cssSelector("button.remove-btn");

    private By updateCartBtn = By.id("updatecart");

    public void setQuantityBox(String quantity){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(quantityBox)));
        driver.findElement(quantityBox).clear();
        driver.findElement(quantityBox).sendKeys(quantity);
    }

    public void setDeleteItems(){
        driver.findElement(deleteItems).click();
    }

    public void clickUpdateCart(){
        driver.findElement(updateCartBtn).click();
    }

    private By assertion = By.cssSelector("span.product-subtotal");

    public String assertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertion)));
        return driver.findElement(assertion).getText();
    }
}
