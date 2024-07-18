package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Comparator;
import java.util.List;

public class ProductsPage {

    private WebDriver driver;


    public ProductsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//span[text()='Products']")
    public WebElement hdrProducts;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> priceOfAllProducts;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement lnkShoppingCart;


    public String customLocForAddToCardBasedOnPrice = "//div[@class='inventory_item_price' and contains(string(),'%price%')]/..//button[text()='Add to cart']";

    public void verifyProductPageLoaded() {
        Assert.assertTrue(hdrProducts.isDisplayed());
    }


    public String getHighestPrice() {
        return String.valueOf(priceOfAllProducts.stream().map(product -> product.getText()).map(price -> price.replace("$", ""))
                .map(val -> Double.valueOf(val))
                .sorted(Comparator.reverseOrder()).findFirst().get());
    }

    public void addProductWithHigherPrice() {
        System.out.println("Are we executing again");
        String highestPrice = getHighestPrice();
        System.out.println("Highest price is "+ highestPrice);
        driver.findElement(By.xpath(customLocForAddToCardBasedOnPrice.replace("%price%", highestPrice))).click();
    }

    public void verifyAddToCartChangesToRemove() {
        String highestPrice = getHighestPrice();
        Assert.assertTrue(driver.findElement(By.xpath(customLocForAddToCardBasedOnPrice.replace("%price%", highestPrice)
                .replace("Add to cart", "Remove"))).isDisplayed());
    }
}
