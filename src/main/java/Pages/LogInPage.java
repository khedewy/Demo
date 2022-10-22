package Pages;

import SuccessfulAssertionsPages.SuccefulLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends PageBase{
    public LogInPage(WebDriver driver) {
        super(driver);
    }
    private By emailTxt = By.id("Email");

    private By passwordTxt = By.id("Password");

    private By logButton = By.cssSelector("button.button-1.login-button");

    public void setEmailTxt(String email){
        driver.findElement(emailTxt).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(passwordTxt).sendKeys(password);
    }
    public SuccefulLog setLogButton(){
        driver.findElement(logButton).click();
        return new SuccefulLog(driver);
    }
}
