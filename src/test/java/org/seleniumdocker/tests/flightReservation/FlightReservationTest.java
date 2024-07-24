package org.seleniumdocker.tests.flightReservation;

import com.framework.pages.flightReservation.FlightSearchPage;
import com.framework.pages.flightReservation.FlightSelectionPage;
import com.framework.pages.flightReservation.RegisterationConfirmationPage;
import com.framework.pages.flightReservation.RegisterationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumdocker.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import properties.UserConfig;


public class FlightReservationTest {

    private WebDriver driver;
    private String noOfPassengers;

    @BeforeTest
    @Parameters({"noOfPassengers"})
    public void setup(String noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    public void userRegisterationTest() {
        RegisterationPage registerationPage = new RegisterationPage(driver);
        registerationPage.goToUrl(UserConfig.getProperties().UrlToNavigate());
        Assert.assertTrue(registerationPage.isAt());
        registerationPage.enterUserDetails(UserConfig.getProperties().firstName(), UserConfig.getProperties().lastName());
        registerationPage.enterUserCredentials(UserConfig.getProperties().emailID(), UserConfig.getProperties().pswd());
        registerationPage.enterAddress(UserConfig.getProperties().street(), UserConfig.getProperties().city(), UserConfig.getProperties().zip());
        registerationPage.register();
    }

    @Test(dependsOnMethods = "userRegisterationTest")
    public void registrationConfirmationTest() {
        RegisterationConfirmationPage confirmationPage = new RegisterationConfirmationPage(driver);
        Assert.assertTrue(confirmationPage.isAt());
        confirmationPage.goToFlightSearch();
    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightSearchTest() {
        FlightSearchPage searchPage = new FlightSearchPage(driver);
        Assert.assertTrue(searchPage.isAt());
        searchPage.selectPassenger(noOfPassengers);
        searchPage.searchFlights();
    }

    @Test(dependsOnMethods = "flightSearchTest")
    public void flightSelectionTest() {
        FlightSelectionPage selectionPage = new FlightSelectionPage(driver);
        Assert.assertTrue(selectionPage.isAt());
        selectionPage.selectFlights();
        selectionPage.confirmFlights();
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }

}
