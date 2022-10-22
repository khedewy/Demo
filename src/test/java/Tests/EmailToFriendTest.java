package Tests;

import Pages.*;
import SuccessfulAssertionsPages.SuccefulSearch;
import SuccessfulAssertionsPages.SuccsefulRegister;
import data.EmailToFriendData;
import data.RegisterData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EmailToFriendTest extends TestBase{
    RegisterPage register;
    HomePage home;
    SearchPage search;
    ProductDetailsPage detailsPage;
    EmailToFriendPage emailToFriendPage;

    @Test(priority = 0)
    @Severity(SeverityLevel.CRITICAL)
    public void UserCanRegister() throws IOException, ParseException {
        EmailToFriendData data =new EmailToFriendData(driver);
        data.userData();
        home = new HomePage(driver);
        home.clickRegisterLink();
        register = new RegisterPage(driver);
        register.setRegisterBtn();
        register.setFirstNameTxt(data.firstName);
        register.setLastNameTxt(data.LastName);
        register.setEmailTxt(data.email);
        register.setDayList();
        register.setMonthList();
        register.setYearList();
        register.setCompanyTxt(data.company);
        register.setPasswordTxt(data.Password);
        register.setConfirmPassword(data.Password);
        SuccsefulRegister succsefulRegister =  register.setRegisterBtn();
        Assert.assertEquals(succsefulRegister.assertionMessage(),"Your registration completed");
    }
    @Test(priority = 1)
    public void UserCAnSearch() {
        search = new SearchPage(driver);
        search.setSearchBox("mac");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        search.setMacProductList();
        SuccefulSearch succefulSearch = new SuccefulSearch(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals(succefulSearch.assertionMessage(),"Apple MacBook Pro 13-inch");
    }
    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    public void UserCanSendmailToFriend(){
        detailsPage = new ProductDetailsPage(driver);
        emailToFriendPage = new EmailToFriendPage(driver);
        detailsPage.setClickEmailToFriendBtn();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        emailToFriendPage.setFriendEmail("awwe@gmail.com");
        emailToFriendPage.setMessageBox("I recommend this product to u, please review it and call me back");
        emailToFriendPage.clickSendMessage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals(emailToFriendPage.assertionMessage(),"Your message has been sent.");

    }
}


