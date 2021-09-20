package utils;

import driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.PropertiesManager;

import java.util.Objects;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

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

    public static void waitForWebElementToBeDisplayed(int seconds, WebElement... elements) {
        for (WebElement element : elements) {
            new WebDriverWait(DriverManager.getDriver(), seconds).until(visibilityOf(element));
        }
    }

    public static void waitForDocumentReadyState() {
        new WebDriverWait(DriverManager.getDriver(), 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) Objects.requireNonNull(wd)).executeScript("return document.readyState").equals("complete"));
    }

}
