package com.framework.pages.flightReservation;

import com.framework.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends AbstractPage {

    @FindBy(id="passengers")
    private WebElement passengerSelect;

    @FindBy(id="search-flights")
    private WebElement searchFlightsButton;

    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.passengerSelect));
        return this.passengerSelect.isDisplayed();
    }

    public void selectPassenger(String noOfPassengers){
        Select passenger=new Select(this.passengerSelect);
        passenger.selectByValue(noOfPassengers);
    }

    public void searchFlights(){
        this.searchFlightsButton.click();
    }
}
