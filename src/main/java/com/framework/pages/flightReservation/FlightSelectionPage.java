package com.framework.pages.flightReservation;

import com.framework.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FlightSelectionPage extends AbstractPage {


    @FindBy(name="departure-flight")
    private List<WebElement> departureFlightsOptions;

    @FindBy(name="arrival-flight")
    private List<WebElement> arrivalFlightsOptions;

    @FindBy(id="confirm-flights")
    private WebElement confirmFlightsButton;

    public FlightSelectionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmFlightsButton));
        return this.confirmFlightsButton.isDisplayed();
    }
}
