package org.Pages;

import org.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends Common {
    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement selectCountry;

    @FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
    WebElement indiaCountry;

    @FindBy(css = ".action__submit")
    WebElement submitButton;


    By lovResults = By.xpath("//*[contains(@class,'ta-results')]");

    public void selectCountry() {
        Actions a = new Actions(driver);
        a.sendKeys(selectCountry, "India").build().perform();
        waitForElementToAppear(lovResults);
        indiaCountry.click();
    }

    public ConfirmationPage submitOrder() {
        submitButton.click();
        return new ConfirmationPage(driver);
    }

}
