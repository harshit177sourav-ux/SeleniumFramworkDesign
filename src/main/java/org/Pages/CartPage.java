package org.Pages;

import org.common.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends Common {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /*
        List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cart']//h3"));
        boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);
        driver.findElement(By.xpath("//*[@class='totalRow']//button")).click();
     */

    @FindBy(xpath = "//div[@class='cart']//h3")
    List<WebElement> cartProducts;

    @FindBy(xpath = "//*[@class='totalRow']//button")
    WebElement checkOutButton;

    public Boolean verifyProductDisplay(String productName) {
        return cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
    }

    public CheckOutPage goToCheckOut() {
        checkOutButton.click();
        return new CheckOutPage(driver);
    }

}
