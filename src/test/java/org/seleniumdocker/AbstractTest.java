package org.seleniumdocker;


import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import properties.UserConfig;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public abstract class AbstractTest {

    public WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void setup(String browser) throws MalformedURLException {
        if (Boolean.getBoolean("selenium.grid.enabled")) {
            this.driver = getRemoteDriver(browser);
        } else {
            this.driver = getLocalDriver();
            this.driver.manage().window().maximize();
        }

    }

    private WebDriver getRemoteDriver(String browser) throws MalformedURLException {
        Capabilities capabilities;
        if (browser.equalsIgnoreCase("chrome")) {
            capabilities = new ChromeOptions();
        } else {
            capabilities = new FirefoxOptions();
        }
        return new RemoteWebDriver(new URL(UserConfig.getProperties().remoteURL()), capabilities);
    }

    private WebDriver getLocalDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @AfterMethod
    public void timeout() {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

}
