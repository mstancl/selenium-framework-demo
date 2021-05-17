package utils;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.PropertiesManager;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class PageWait {


    public static void waitForWebElementToLoad(WebElement... elements) {
        for (WebElement element : elements) {
            new WebDriverWait(DriverManager.getDriver(), Integer.parseInt(PropertiesManager.getProperty("element.wait.timeout"))).until(elementToBeClickable(element));
        }
    }

    public static void waitForWebElementToLoad(int seconds, WebElement... elements) {
        for (WebElement element : elements) {
            new WebDriverWait(DriverManager.getDriver(), seconds).until(elementToBeClickable(element));
        }
    }


}
