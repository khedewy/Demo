package Tests;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.validator.Var;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TestBase {
    public static WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void setDriver(@Optional("firefox") String browserName){
        if (browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://demo.nopcommerce.com/");
        }
        else if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://demo.nopcommerce.com/");
        }
    }
    @AfterTest
    public void setCloseDriver(){
        driver.close();
    }
    @AfterMethod
    public void takeScreenshots(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshots = takesScreenshot.getScreenshotAs(OutputType.FILE);
            Files.move(screenshots,new File("resources/Screenshots"+result.getName()+".png"));
        }
    }

}
