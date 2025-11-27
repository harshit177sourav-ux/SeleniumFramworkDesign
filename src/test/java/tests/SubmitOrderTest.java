package tests;

import org.Pages.CartPage;
import org.Pages.CheckOutPage;
import org.Pages.ConfirmationPage;
import org.Pages.ProductCatalogue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcomponents.BasicTest;

import java.io.IOException;
import java.util.List;

public class SubmitOrderTest extends BasicTest {
    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(String email,String password, String productName) throws IOException {
        //String productName = "ZARA COAT 3";
        //login page --
        ProductCatalogue productCatalogue = landingPage.loginApplication(email, password);

        //Product Catalogue page --
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.gotoCart();

        //Cart Page --
        Assert.assertTrue(cartPage.verifyProductDisplay(productName));
        CheckOutPage checkOutPage = cartPage.goToCheckOut();

        //CheckOutPage --
        checkOutPage.selectCountry();
        ConfirmationPage confirmationPage = checkOutPage.submitOrder();
        Assert.assertTrue((confirmationPage.confirmationMessage()).equalsIgnoreCase("Thankyou for the order."));

    }

    @DataProvider
    public Object[][] getData(){
        return new Object [][] {{"DemoFNLN@gmail.com","Hars17hit@","ZARA COAT 3"}};
    }

}
