package Tests;

import Pages.HomePage;
import Pages.RegisterPage;
import Pages.VotePage;
import SuccessfulAssertionsPages.SuccsefulRegister;
import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class VoteTest extends TestBase{
    RegisterPage register;
    HomePage home;
    VotePage vote;

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
    public void voteTest(){
        vote = new VotePage(driver);
        vote.clickBackHome();
        vote.clickVoteBtn();
        Assert.assertEquals(vote.assertionMessage(),"DO YOU LIKE NOPCOMMERCE?");
    }
}
