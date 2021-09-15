package pages;

import driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utils.PageWait;

public class BasePage {

    protected BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    protected void click(WebElement webElement) {

        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", webElement);

        PageWait.waitForWebElementToLoad(webElement);
        webElement.click();
    }

    protected void enterInput(WebElement webElement, String input) {


        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", webElement);

        PageWait.waitForWebElementToLoad(webElement);

        webElement.clear();
        webElement.sendKeys(input);
    }

    protected String read(WebElement webElement) {

        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", webElement);

        PageWait.waitForWebElementToLoad(webElement);
        return webElement.getText();
    }

    protected String getAttribute(WebElement webElement, String attribute) {
        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", webElement);

        PageWait.waitForWebElementToLoad(webElement);
        return webElement.getAttribute(attribute);
    }

    protected boolean isElementPresent(WebElement webElement) {
        try {
            PageWait.waitForWebElementToLoad(0, webElement);
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public void validateWebElementsAreNotVisible(WebElement... elements) {
        SoftAssert softAssert = new SoftAssert();

        for (WebElement element : elements) {
            softAssert.assertTrue(!isElementPresent(element));
        }
        softAssert.assertAll();
    }

    public void validateWebElementsAreVisible(WebElement... elements) {
        SoftAssert softAssert = new SoftAssert();

        for (WebElement element : elements) {
            softAssert.assertTrue(isElementPresent(element));
        }
        softAssert.assertAll();
    }
}
