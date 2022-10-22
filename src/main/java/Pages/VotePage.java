package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VotePage extends PageBase{
    public VotePage(WebDriver driver) {
        super(driver);
    }

    private By backToHomePageBtn = By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img");

    private By voteButton = By.id("pollanswers-1");

    public void clickBackHome(){
        driver.findElement(backToHomePageBtn).click();
    }
    public void clickVoteBtn(){
        js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,1500)");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(voteButton)));
        driver.findElement(voteButton).click();
    }

    private By assertion = By.cssSelector("strong.poll-display-text");
    public String assertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertion)));
        return driver.findElement(assertion).getText();
    }

}
