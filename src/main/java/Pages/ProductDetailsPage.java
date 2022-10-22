package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private By addToCartButton = By.id("add-to-cart-button-4");
    private By showCartPage = By.linkText("shopping cart");
    private By addToCartBtn = By.id("add-to-cart-button-6");

    public void setAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }

    public void setAddToCartBtn(){
        driver.findElement(addToCartBtn).click();
    }
    public void setShowCartPage(){
        driver.findElement(showCartPage).click();
    }
    private By AddAssertMessage = By.linkText("Apple MacBook Pro 13-inch");
    public String addToCartAssertion(){
        return driver.findElement(AddAssertMessage).getText();
    }

    private By addReviewComment = By.linkText("Add your review");

    public ReviewPage setReviewButton(){
        driver.findElement(addReviewComment).click();
        return new ReviewPage(driver);
    }

    private By addToComparePage = By.cssSelector("button.button-2.add-to-compare-list-button");
    public ComparListDetails setAddToComparePage(){
        driver.findElement(addToComparePage).click();
        return new ComparListDetails(driver);
    }

    private By showComparePage = By.linkText("product comparison");
    public void setShowComparePage(){
        driver.findElement(showComparePage).click();
    }

    private By addToWishList = By.id("add-to-wishlist-button-4");
    public void setAddToWishList(){
        driver.findElement(addToWishList).click();
    }

    private By showWishListPage = By.linkText("wishlist");

    public WishlistPage setShowWishList(){
        driver.findElement(showWishListPage).click();
        return new WishlistPage(driver);
    }

    private By emailToFriendBtn = By.cssSelector("button.button-2.email-a-friend-button");

    public EmailToFriendPage setClickEmailToFriendBtn(){
        driver.findElement(emailToFriendBtn).click();
        return new EmailToFriendPage(driver);
    }

}
