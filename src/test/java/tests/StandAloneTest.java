package tests;

import org.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    public static void main(String[] args) {
        String productName = "ZARA COAT 3";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //login page --
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        ProductCatalogue productCatalogue = landingPage.loginApplication("DemoFNLN@gmail.com", "Hars17hit@");

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
}
