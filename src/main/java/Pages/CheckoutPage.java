package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.osgl.util.Str;

import java.time.Duration;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    private By acceptTerms = By.id("termsofservice");

    private By checkoutButton = By.id("checkout");

    public void clickAcceptTerms(){
        driver.findElement(acceptTerms).click();
    }

    public void setCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }

    private By countryList = By.id("BillingNewAddress_CountryId");
    private By region = By.id("BillingNewAddress_StateProvinceId");
    private By cityTxt = By.id("BillingNewAddress_City");
    private By address1Txt = By.id("BillingNewAddress_Address1");
    private By address2Txt = By.id("BillingNewAddress_Address2");
    private By zipCodeTxt = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumberTxt = By.id("BillingNewAddress_PhoneNumber");
    private By faxNumberTxt = By.id("BillingNewAddress_FaxNumber");
    private By continueBtn = By.cssSelector("button.button-1.new-address-next-step-button");

    public void setCountryList(){
        select = new Select(driver.findElement(countryList));
        select.selectByVisibleText("Egypt");
    }

    public void setRegion(){
        select = new Select(driver.findElement(region));
    }

    public void setCityTxt(String city){
        driver.findElement(cityTxt).sendKeys(city);
    }

    public void setAddress1Txt(String address1){
        driver.findElement(address1Txt).sendKeys(address1);
    }

    public void setAddress2Txt(String address2){
        driver.findElement(address2Txt).sendKeys(address2);
    }

    public void setZipCodeTxt(String zipCode){
        driver.findElement(zipCodeTxt).sendKeys(zipCode);
    }
    public void setPhoneNumberTxt(String phoneNumber){
        driver.findElement(phoneNumberTxt).sendKeys(phoneNumber);
    }

    public void setFaxNumber(String faxNumber){
        driver.findElement(faxNumberTxt).sendKeys(faxNumber);
    }

    public ContinueCheckout setContinueBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(continueBtn)));
        driver.findElement(continueBtn).click();
        return new ContinueCheckout(driver);
    }




}