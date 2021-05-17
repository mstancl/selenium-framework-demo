package com.mstancl;

import driver.DriverFactory;
import driver.DriverManager;
import org.testng.annotations.*;
import properties.PropertiesManager;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {

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
        DriverManager.getDriver().get(PropertiesManager.getProperty("sut.url"));
    }

    @AfterMethod
    public void afterMethod() {
        DriverManager.getDriver().close();
    }

}
