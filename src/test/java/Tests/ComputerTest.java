package Tests;

import Pages.ComputersPage;
import SuccessfulAssertionsPages.ItemPropAssertion;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ComputerTest extends TestBase{
    ComputersPage computer;

    @Test(priority = 0)
    public void UserCanSeeNotebooksProducts(){
        computer = new ComputersPage(driver);
        computer.HoverComputer();
        computer.setNotebook();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ItemPropAssertion assertions = new ItemPropAssertion(driver);
        Assert.assertEquals(assertions.assertionMessageText(),"Notebooks");
    }

    @Test(priority = 1)
    public void UserCanSeeDesktopsItems(){
        computer = new ComputersPage(driver);
        computer.HoverComputer();
        computer.setDesktops();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ItemPropAssertion assertions = new ItemPropAssertion(driver);
        Assert.assertEquals(assertions.assertionMessageText(),"Desktops");
    }

    @Test(priority = 2)
    public void UserCanSeeSoftwareItems(){
        computer = new ComputersPage(driver);
        computer.HoverComputer();
        computer.setSoftware();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ItemPropAssertion assertions = new ItemPropAssertion(driver);
        Assert.assertEquals(assertions.assertionMessageText(),"Software");
    }
}
