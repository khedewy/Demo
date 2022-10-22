package Pages;

import SuccessfulAssertionsPages.ItemPropAssertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComputersPage extends PageBase{
    public ComputersPage(WebDriver driver) {
        super(driver);

    }

    private By ComputerList = By.linkText("Computers");

    private By notebook = By.linkText("Notebooks");

    private By desktops = By.linkText("Desktops");

    private By softwares = By.linkText("Software");

    public void HoverComputer(){
        WebElement computer = driver.findElement(ComputerList);
        actions = new Actions(driver);
        actions.moveToElement(computer).perform();

    }

    public ItemPropAssertion setNotebook(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(notebook)));
        WebElement note = driver.findElement(notebook);
        actions = new Actions(driver);
        actions.moveToElement(note).click().build().perform();
        return new ItemPropAssertion(driver);
    }

    public ItemPropAssertion setDesktops(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(desktops)));
        WebElement desktop = driver.findElement(desktops);
        actions = new Actions(driver);
        actions.moveToElement(desktop).click().build().perform();
        return new ItemPropAssertion(driver);
    }

    public ItemPropAssertion setSoftware(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(softwares)));
        WebElement software = driver.findElement(softwares);
        actions = new Actions(driver);
        actions.moveToElement(software).click().build().perform();
        return new ItemPropAssertion(driver);
    }


}
