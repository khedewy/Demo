package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComparListDetails extends PageBase{
    public ComparListDetails(WebDriver driver) {
        super(driver);
    }

    private By addMacToCompareListAssertion = By.linkText("Apple MacBook Pro 13-inch");

    private By addSamsungToCompareListAssertion = By.linkText("Samsung Series 9 NP900X4C Premium Ultrabook");

    public String MacAssertion(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addMacToCompareListAssertion)));
        return driver.findElement(addMacToCompareListAssertion).getText();
    }

    public String SamsungAssertion(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addSamsungToCompareListAssertion)));
        return driver.findElement(addSamsungToCompareListAssertion).getText();
    }
}
