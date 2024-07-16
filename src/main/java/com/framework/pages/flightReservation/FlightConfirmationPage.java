package com.framework.pages.flightReservation;

import com.framework.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class FlightConfirmationPage extends AbstractPage {

    //private static final Logger log= (Logger) LoggerFactory.getLogger(FlightConfirmationPage.class);

    @FindBy(xpath="(//div[@class='card']//p[@class='fw-bold'])[1]")
    private WebElement flightConfirmationElement;

    @FindBy(xpath="(//div[@class='card']//p[@class='fw-bold'])[3]")
    private WebElement totalPriceElement;


    public FlightConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationElement));
        return this.flightConfirmationElement.isDisplayed();
    }

    public String getPrice(){
        String price=this.totalPriceElement.getText();
        return price;
    }
}
