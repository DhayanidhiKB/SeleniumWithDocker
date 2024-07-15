package com.framework.pages.flightReservation;

import com.framework.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterationConfirmationPage extends AbstractPage {

    @FindBy(id="go-to-flights-search")
    private WebElement flightSearch;

    public RegisterationConfirmationPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt(){
        this.wait.until(ExpectedConditions.visibilityOf(this.flightSearch));
        return this.flightSearch.isDisplayed();
    }

    public void goToFlightSearch(){
        this.flightSearch.click();
    }
}
