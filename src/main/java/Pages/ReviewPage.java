package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReviewPage extends PageBase{
    public ReviewPage(WebDriver driver) {
        super(driver);
    }

    private By titleTxt = By.id("AddProductReview_Title");

    private By MessageBox = By.id("AddProductReview_ReviewText");

    private By submitReview = By.cssSelector("button.button-1.write-product-review-button");

    private By rateButton = By.id("addproductrating_3");

    public void setTitleTxt(String title){
        driver.findElement(titleTxt).sendKeys(title);
    }

    public void setMessageBox(String message){
        driver.findElement(MessageBox).sendKeys(message);
    }

    public void setRateButton(){
        WebElement radioBtn = driver.findElement(rateButton);

        if (radioBtn.isSelected()){
            System.out.println("this option is selected.");
        }
        else radioBtn.click();
    }

    public void setSubmitReview(){
        driver.findElement(submitReview).click();
    }

}
