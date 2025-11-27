package tests;

import org.Pages.CartPage;
import org.Pages.ProductCatalogue;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcomponents.BasicTest;

import java.io.IOException;
import java.util.List;

public class ErrorValidation extends BasicTest {
    @Test
    public void loginErrorValidation() throws IOException {
        landingPage.loginApplication("adsad@gmail.com", "Daeqwewqeq");
        Assert.assertEquals(landingPage.errorValidation(), "Incorrect email or password.");
    }

    @Test
    public void ProductErrorValidation() throws IOException {
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("DemoFNLN@gmail.com", "Hars17hit@");
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.gotoCart();
        Assert.assertFalse(cartPage.verifyProductDisplay("ZARA COAT 33"));
    }
}
