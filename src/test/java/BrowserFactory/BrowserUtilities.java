package BrowserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserUtilities {
    static WebDriver driver;

    public static WebDriver launchBrowser(String browserName)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // Setting implicit wait to sync test with application
        return driver;
    }


    public static boolean loadURL(String url)
    {
        System.out.println("url load");
        driver.get(url);
        return true;
    }

    public static void verifyTitle(String title)
    {
        Assert.assertEquals(title, driver.getTitle());
    }
}
