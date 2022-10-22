package Pages;

import SuccessfulAssertionsPages.SuccsefulRegister;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends PageBase{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    private By genderBtn = By.id("gender-male");
    private By firstNameTxt = By.id("FirstName");
    private By lastNameTxt = By.id("LastName");
    private By dayList = By.name("DateOfBirthDay");
    private By monthList = By.name("DateOfBirthMonth");
    private By yearList = By.name("DateOfBirthYear");
    private By emailTxt = By.id("Email");
    private By companyTxt = By.id("Company");
    private By passwordTxt = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");

    private By registerBtn = By.id("register-button");

    public void setGenderBtn(){
        driver.findElement(genderBtn).click();
    }
    public void setFirstNameTxt(String firstName){
        driver.findElement(firstNameTxt).sendKeys(firstName);
    }
    public void setLastNameTxt(String lastName){
        driver.findElement(lastNameTxt).sendKeys(lastName);
    }
    public void setDayList(){
        select = new Select(driver.findElement(dayList));
        select.selectByIndex(22);
    }

    public void setMonthList(){
        select = new Select(driver.findElement(monthList));
        select.selectByIndex(3);
    }

    public void setYearList(){
        select = new Select(driver.findElement(yearList));
        select.selectByIndex(22);
    }

    public void setEmailTxt(String email){
        driver.findElement(emailTxt).sendKeys(email);
    }

    public void setCompanyTxt(String companyName){
        driver.findElement(companyTxt).sendKeys(companyName);
    }

    public void setPasswordTxt(String password){
        driver.findElement(passwordTxt).sendKeys(password);
    }

    public void setConfirmPassword(String password){
        driver.findElement(confirmPassword).sendKeys(password);
    }

    public SuccsefulRegister setRegisterBtn(){
        driver.findElement(registerBtn).click();
        return new SuccsefulRegister(driver);
    }


}
