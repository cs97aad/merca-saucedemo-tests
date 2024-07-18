package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
    private WebDriver driver;

    public YourCartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//span[text()='Your Cart']")
    public WebElement hdrYourCart;

    public void verifyCartPageLoaded() {
        Assert.assertTrue(hdrYourCart.isDisplayed());
    }
}
