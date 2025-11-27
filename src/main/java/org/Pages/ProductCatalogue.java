package org.Pages;

import org.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends Common {
    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='card']")
    List<WebElement> products;

    @FindBy(id = "toast-container")
    WebElement toastContainer;


    By productBy = By.xpath("//div[@class='card']");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.id("toast-container");


    public List<WebElement> getProductList() {
        waitForElementToAppear(productBy);
        return products;
    }

    public WebElement getProductByName(String productName) {
        return driver.findElement(By.xpath("//div[@class='card'][.//b[text()='" + productName + "']]"));
    }

    public void addProductToCart(String productName) {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisppear(toastContainer);
    }


}
