package com.framework.pages.flightReservation;

import com.framework.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterationPage extends AbstractPage {

    @FindBy(id="firstName")
    private WebElement firstNameInput;

    @FindBy(id="lastName")
    private WebElement lastNameInput;

    @FindBy(id="email")
    private WebElement emailInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(name="street")
    private WebElement streetInput;

    @FindBy(name="city")
    private WebElement cityInput;

    @FindBy(name="zip")
    private WebElement zipInput;

    @FindBy(id="register-btn")
    private WebElement registerButton;

    public RegisterationPage(WebDriver driver){
       super(driver);
    }

    @Override
    public boolean isAt(){
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameInput));
        return this.firstNameInput.isDisplayed();
    }

    public void goToUrl(String url){
        this.driver.get(url);
    }

    public void enterUserDetails(String firstName,String lastName){
        this.firstNameInput.sendKeys(firstName);
        this.lastNameInput.sendKeys(lastName);
    }

    public void enterUserCredentials(String email,String pswd){
        this.emailInput.sendKeys(email);
        this.passwordInput.sendKeys(pswd);
    }

    public void enterAddress(String street,String city,String zip){
        this.streetInput.sendKeys(street);
        this.cityInput.sendKeys(city);
        this.zipInput.sendKeys(zip);
    }

    public void register(){
        this.registerButton.click();
    }

}
