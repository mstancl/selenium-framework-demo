package com.mstancl;

import driver.DriverFactory;
import driver.DriverManager;
import org.testng.annotations.*;
import properties.PropertiesManager;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseSuite {

    @BeforeSuite
    public void beforeSuite() throws IOException {
        PropertiesManager.readProperties("test.config.properties");
    }

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        DriverManager.setDriver(DriverFactory.createInstance());
    }

    @AfterClass
    public void afterClass() {
        DriverManager.removeDriver();
    }


    @BeforeMethod
    public void beforeMethod() {
        if (DriverManager.getDriver().getWindowHandles().size() > 1) {
            String firstTab = DriverManager.getDriver().getWindowHandles().toArray()[0].toString();
            String adblockPopup = DriverManager.getDriver().getWindowHandles().toArray()[1].toString();
            DriverManager.getDriver().switchTo().window(adblockPopup).close();
            DriverManager.getDriver().switchTo().window(firstTab);
        }
        DriverManager.getDriver().get(PropertiesManager.getProperty("sut.url"));
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {

    }

}
