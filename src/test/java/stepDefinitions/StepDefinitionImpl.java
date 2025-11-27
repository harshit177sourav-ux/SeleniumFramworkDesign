package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import testcomponents.BasicTest;

import java.io.IOException;
import java.util.List;

public class StepDefinitionImpl extends BasicTest {
    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public ConfirmationPage confirmationPage;
    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException {
        landingPage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void Logged_in_with_username_and_password(String username, String password){
        productCatalogue  = landingPage.loginApplication(username, password);
    }

    @When("^I add product (.+) to cart$")
    public void I_check_for_the_productName_in_step(String productName){
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
    }

    @When("^Checkout (.+) and submit the order$")
    public void Checkout_productName_and_submit_the_order(String productName){
        CartPage cartPage = productCatalogue.gotoCart();

        //Cart Page --
        Assert.assertTrue(cartPage.verifyProductDisplay(productName));
        CheckOutPage checkOutPage = cartPage.goToCheckOut();

        //CheckOutPage --
        checkOutPage.selectCountry();
        confirmationPage = checkOutPage.submitOrder();
    }

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_is_displayed_on_ConfirmationPage(String string){
        Assert.assertTrue((confirmationPage.confirmationMessage()).equalsIgnoreCase(string));
        driver.close();
    }
}
