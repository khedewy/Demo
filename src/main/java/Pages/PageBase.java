package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
    protected WebDriver driver;
    Select select;
    Actions actions;
    JavascriptExecutor js;
	public PageBase(WebDriver driver){
        this.driver = driver;
    }
}
