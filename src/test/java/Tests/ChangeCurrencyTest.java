package Tests;

import Pages.HomePage;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ChangeCurrencyTest extends TestBase {
    HomePage home;

    @Test
    public void UserCanChangeTheCurrency(){
        home = new HomePage(driver);
        home.setCurrency();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
