package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(id="user-name")
    public WebElement txtBoxUsername;

    @FindBy(id="password")
    public WebElement txtBoxPassword;

    @FindBy(id="login-button")
    public WebElement btnSubmit;

    public void login(String username, String password) {
        txtBoxUsername.sendKeys(username);
        txtBoxPassword.sendKeys(password);
        btnSubmit.click();
    }
}
