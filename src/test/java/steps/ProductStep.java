package steps;

import BrowserFactory.BrowserUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStep {

    @Given("I am on the landing page")
    public void iAmOnTheLandingPage() throws InterruptedException {
        BrowserUtilities.loadURL("https://www.saucedemo.com/");
        Assert.assertEquals("Swag Labs", BaseTest.driver.getTitle());
    }

    @When("I login using details username {string} and password {string}")
    public void iLoginUsingDetailsUsernameAndPassword(String userName, String passWord) {
        BaseTest.loginPage.login(userName, passWord);
    }

    @Then("product page is displayed")
    public void productPageIsDisplayed() {
        BaseTest.productsPage.verifyProductPageLoaded();

    }

    @And("I add the highest price item to the cart by clicking its Add to Cart button")
    public void iAddTheHighestPriceItemToTheCartByClickingItsAddToCartButton() {
        BaseTest.productsPage.addProductWithHigherPrice();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("the Add to Cart button changes to Remove button")
    public void theAddToCartButtonChangesToRemoveButton() {
        BaseTest.productsPage.verifyAddToCartChangesToRemove();
    }

    @And("I navigate to the cart page")
    public void iNavigateToTheCartPage() {
        BaseTest.productsPage.lnkShoppingCart.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BaseTest.yourCartPage.verifyCartPageLoaded();
    }
}
