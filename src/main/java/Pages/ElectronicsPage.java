package Pages;

import SuccessfulAssertionsPages.ItemPropAssertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElectronicsPage extends PageBase{
    public ElectronicsPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    private By electronicsList = By.linkText("Electronics");

    private By camera = By.linkText("Camera & photo");

    private By phones = By.linkText("Cell phones");

    private By others = By.linkText("Others");

    public ItemPropAssertion HoverOverElectronics(){
        WebElement electronic = driver.findElement(electronicsList);
        actions.moveToElement(electronic).perform();
        return new ItemPropAssertion(driver);
    }

    public ItemPropAssertion setCamera(){
        WebElement cameraObj = driver.findElement(camera);
        actions.moveToElement(cameraObj).click().build().perform();
        return new ItemPropAssertion(driver);
    }

    public ItemPropAssertion setPhones(){
        WebElement phoneObj = driver.findElement(phones);
        actions.moveToElement(phoneObj).click().build().perform();
        return new ItemPropAssertion(driver);
    }
    public ItemPropAssertion setOthers(){
        WebElement other = driver.findElement(others);
        actions.moveToElement(other).click().build().perform();
        return new ItemPropAssertion(driver);
    }
}
