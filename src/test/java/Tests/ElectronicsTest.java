package Tests;

import Pages.ElectronicsPage;
import SuccessfulAssertionsPages.ItemPropAssertion;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ElectronicsTest extends TestBase{
    ElectronicsPage electronic;

    @Test(priority = 0)
    public void UserCanSeeCameraItems(){
        electronic = new ElectronicsPage(driver);
        electronic.HoverOverElectronics();
        electronic.setCamera();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ItemPropAssertion itemPropAssertion = new ItemPropAssertion(driver);
        Assert.assertEquals(itemPropAssertion.assertionMessageText(),"Camera & photo");
    }

    @Test(priority = 1)
    public void UserCanSeePhoneItems(){
        electronic = new ElectronicsPage(driver);
        electronic.HoverOverElectronics();
        electronic.setPhones();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ItemPropAssertion itemPropAssertion = new ItemPropAssertion(driver);
        Assert.assertEquals(itemPropAssertion.assertionMessageText(),"Cell phones");
    }

    @Test(priority = 2)
    public void UserCanSeeOtherItems(){
        electronic = new ElectronicsPage(driver);
        electronic.HoverOverElectronics();
        electronic.setOthers();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ItemPropAssertion itemPropAssertion = new ItemPropAssertion(driver);
        Assert.assertEquals(itemPropAssertion.assertionMessageText(),"Others");
    }
}
