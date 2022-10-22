package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By registerLink = By.linkText("Register");

    public RegisterPage clickRegisterLink(){
        driver.findElement(registerLink).click();
        return new RegisterPage(driver);
    }

    private By logOut = By.linkText("Log out");

    public HomePage clickLogout(){
        driver.findElement(logOut).click();
        return new HomePage(driver);
    }

    private By login = By.linkText("Log in");

    public HomePage clickLogin(){
        driver.findElement(login).click();
        return new HomePage(driver);
    }

    private By currency = By.id("customerCurrency");

    public void setCurrency(){
        select = new Select(driver.findElement(currency));
        select.selectByIndex(1);
    }
}
