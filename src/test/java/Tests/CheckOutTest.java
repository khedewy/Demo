package Tests;

import Pages.*;
import SuccessfulAssertionsPages.SuccefulSearch;
import SuccessfulAssertionsPages.SuccsefulRegister;
import data.RegisterData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CheckOutTest extends TestBase{
    SearchPage search;
    ProductDetailsPage detailsPage;
    CheckoutPage checkoutPage;
    JavascriptExecutor js;
    RegisterPage register;
    HomePage home;
    ContinueCheckout checkout;

    @Test(priority = 0)
    public void UserCanRegister() throws IOException, ParseException {
        RegisterData data =new RegisterData(driver);
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
    @Severity(SeverityLevel.NORMAL)
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
    public void UserCanAddToCart(){
        detailsPage = new ProductDetailsPage(driver);
        detailsPage.setAddToCartButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        detailsPage.setShowCartPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals(detailsPage.addToCartAssertion(),"Apple MacBook Pro 13-inch");

    }
    @Test(priority = 3)
    public void clickCheckOut(){
        checkoutPage = new CheckoutPage(driver);
        js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,300)");
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        checkoutPage.clickAcceptTerms();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        checkoutPage.setCheckoutButton();
    }
    @Test(priority = 4)
    public void CompleteCheckOut(){
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.setCountryList();
        checkoutPage.setRegion();
        checkoutPage.setCityTxt("Sohag");
        checkoutPage.setAddress1Txt("sohag,maragha");
        checkoutPage.setAddress2Txt("sohage,Egypt");
        checkoutPage.setZipCodeTxt("1234");
        checkoutPage.setPhoneNumberTxt("09876543211");
        checkoutPage.setFaxNumber("1231");
        checkoutPage.setContinueBtn();
    }

    @Test(priority = 5)
    public void continueCheckOut(){
        checkout = new ContinueCheckout(driver);
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,300)");
        checkout.setShippingContinueBtn();
        js.executeScript("scrollBy(0,800)");
        checkout.setPaymentMethode();
        js.executeScript("scrollBy(0,900)");
        checkout.setPaymentInformation();
        js.executeScript("scrollBy(0,1000)");
        checkout.setConfirmBtn();
        Assert.assertEquals(checkout.assertionMessage(),"Your order has been successfully processed!");
    }
}
