package pages;

import driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
        PageWait.waitForDocumentReadyState();
        webElement.click();
        PageWait.waitForDocumentReadyState();
    }

    protected void moveAndClick(WebElement webElement) {

        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", webElement);

        PageWait.waitForDocumentReadyState();
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(webElement).click().perform();
        PageWait.waitForDocumentReadyState();
    }


    protected void selectDropdown(WebElement webElement, String option) {

        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", webElement);


        PageWait.waitForWebElementToLoad(webElement);
        PageWait.waitForDocumentReadyState();
        Select select = new Select(webElement);
        select.selectByVisibleText(option);
        PageWait.waitForDocumentReadyState();
    }

    protected void enterInput(WebElement webElement, String input) {


        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", webElement);


        PageWait.waitForWebElementToLoad(webElement);
        PageWait.waitForDocumentReadyState();
        webElement.clear();
        webElement.sendKeys(input);
        PageWait.waitForDocumentReadyState();
    }

    protected String read(WebElement webElement) {

        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", webElement);

        PageWait.waitForWebElementToLoad(webElement);
        PageWait.waitForDocumentReadyState();
        return webElement.getText();
    }

    protected String getAttribute(WebElement webElement, String attribute) {
        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", webElement);

        PageWait.waitForWebElementToLoad(webElement);
        PageWait.waitForDocumentReadyState();
        return webElement.getAttribute(attribute);
    }

    protected boolean isElementPresentAndClickable(WebElement webElement) {
        PageWait.waitForDocumentReadyState();
        try {
            PageWait.waitForWebElementToLoad(0, webElement);
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isElementPresent(WebElement webElement) {
        PageWait.waitForDocumentReadyState();
        try {
            Actions actions = new Actions(DriverManager.getDriver());
            actions.moveToElement(webElement).perform();
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public void validateWebElementsAreNotVisible(WebElement... elements) {
        PageWait.waitForDocumentReadyState();
        SoftAssert softAssert = new SoftAssert();

        for (WebElement element : elements) {
            softAssert.assertTrue(!isElementPresentAndClickable(element));
        }
        softAssert.assertAll();
    }

    public void validateWebElementsAreVisible(WebElement... elements) {
        PageWait.waitForDocumentReadyState();
        SoftAssert softAssert = new SoftAssert();

        for (WebElement element : elements) {
            softAssert.assertTrue(isElementPresentAndClickable(element));
        }
        softAssert.assertAll();
    }


}
