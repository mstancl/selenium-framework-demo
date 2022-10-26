package com.mstancl.workshop.noFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NoFrameworkDemoClass {


    @Test()
    public void noFrameworkTest() {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://demoqa.com/");
        chromeDriver.findElement(By.xpath(".//h5[text()='Elements']")).click();
        chromeDriver.findElement(By.xpath(".//span[text()='Text Box']")).click();
    }


}
