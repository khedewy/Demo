package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailToFriendPage extends PageBase{
    public EmailToFriendPage(WebDriver driver) {
        super(driver);
    }

    private By friendEmail = By.id("FriendEmail");

    private By messageBox = By.id("PersonalMessage");

    private By sendMessage = By.name("send-email");

    public void setFriendEmail(String email){
        driver.findElement(friendEmail).sendKeys(email);
    }
    public void setMessageBox(String message){
        driver.findElement(messageBox).sendKeys(message);
    }
    public void clickSendMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(sendMessage)));
        driver.findElement(sendMessage).click();
    }

    private By assertionMessage = By.cssSelector("div.result");
    public String assertionMessage(){
       return driver.findElement(assertionMessage).getText();
    }
}
