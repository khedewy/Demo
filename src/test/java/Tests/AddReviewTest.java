package Tests;

import Pages.*;
import SuccessfulAssertionsPages.SuccefulSearch;
import SuccessfulAssertionsPages.SuccsefulRegister;
import data.AddReviewData;
import data.RegisterData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddReviewTest extends TestBase{
    RegisterPage register;
    HomePage home;
    SearchPage search;
    ProductDetailsPage detailsPage;
    ReviewPage reviewPage;

    @Test(priority = 0)
    @Severity(SeverityLevel.CRITICAL)
    public void UserCanRegister() throws IOException, ParseException {
        AddReviewData data =new AddReviewData(driver);
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
    public void UserCAnSearch(){
        search = new SearchPage(driver);
        search.setSearchBox("mac");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        search.setMacProductList();
        SuccefulSearch succefulSearch = new SuccefulSearch(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals(succefulSearch.assertionMessage(),"Apple MacBook Pro 13-inch");
    }

    @Test(priority = 2)
    public void UserCanAddReview(){
        detailsPage = new ProductDetailsPage(driver);
        detailsPage.setReviewButton();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        reviewPage = new ReviewPage(driver);
        reviewPage.setTitleTxt("complain");
        reviewPage.setMessageBox("this product is not the product I ordered");
        reviewPage.setRateButton();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        reviewPage.setSubmitReview();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    }
}
