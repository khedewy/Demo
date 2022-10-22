package Tests;

import Pages.HomePage;
import Pages.RegisterPage;
import SuccessfulAssertionsPages.SuccsefulRegister;
import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterTest extends TestBase {
    RegisterPage register;
    HomePage home;
    @Test
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
}
