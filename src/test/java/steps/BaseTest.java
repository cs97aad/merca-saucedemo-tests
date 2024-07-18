package steps;

import BrowserFactory.BrowserUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

public class BaseTest {

    public static WebDriver driver;

    public static LoginPage loginPage;
    public static ProductsPage productsPage;
    public static YourCartPage yourCartPage;



    @Before
    public void setup()
    {
        driver= BrowserUtilities.launchBrowser("Chrome");
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
    }

    @After
    public void tearOff()
    {
        driver.quit();
    }
}
