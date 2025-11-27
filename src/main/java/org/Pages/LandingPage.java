package org.Pages;

import org.common.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LandingPage extends Common {
    private static final Logger log = LoggerFactory.getLogger(LandingPage.class);
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement login;

    @FindBy(css = "[class*='flyInOut']")
    WebElement errorMessage;

    public ProductCatalogue loginApplication(String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        login.click();
        return new ProductCatalogue(driver);

    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");
    }

    public String errorValidation() {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }
}