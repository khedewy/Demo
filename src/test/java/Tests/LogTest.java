package Tests;

import Pages.*;
import SuccessfulAssertionsPages.SuccefulLog;
import SuccessfulAssertionsPages.SuccsefulRegister;
import data.LoginData;
import data.RegisterData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogTest extends TestBase {
    RegisterPage register;
    HomePage home;
    LogInPage log;
    @Test(priority = 0)
    @Severity(SeverityLevel.CRITICAL)

    @Description("this is a critical case")
    public void UserCanRegister() throws IOException, ParseException {
        LoginData data =new LoginData(driver);
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
    @Severity(SeverityLevel.CRITICAL)
    public void UserCanLog() throws IOException, ParseException {
        LoginData data =new LoginData(driver);
        data.userData();
        home = new HomePage(driver);
        home.clickLogout();
        home.clickLogin();
        log = new LogInPage(driver);
        log.setEmailTxt(data.email);
        log.setPassword(data.Password);
        SuccefulLog succefulLog = log.setLogButton();
        Assert.assertEquals(succefulLog.assertionMessage(),"Log out");
    }
}
