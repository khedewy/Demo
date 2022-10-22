package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContinueCheckout extends PageBase{
    public ContinueCheckout(WebDriver driver) {
        super(driver);
    }

    private By shippingContinueBtn = By.cssSelector("button.button-1.shipping-method-next-step-button");

    private By paymentMethode = By.cssSelector("button.button-1.payment-method-next-step-button");

    private By paymentInformation = By.cssSelector("button.button-1.payment-info-next-step-button");

    private By confirmBtn = By.cssSelector("button.button-1.confirm-order-next-step-button");


    public void setShippingContinueBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(shippingContinueBtn)));
        driver.findElement(shippingContinueBtn).click();
    }

    public void setPaymentMethode(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(paymentMethode)));
        driver.findElement(paymentMethode).click();
    }

    public void setPaymentInformation(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(paymentInformation)));
        driver.findElement(paymentInformation).click();
    }

    public void setConfirmBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(confirmBtn)));
        driver.findElement(confirmBtn).click();
    }

    private By assertion = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong");

    public String assertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertion)));
        return driver.findElement(assertion).getText();
    }
}
