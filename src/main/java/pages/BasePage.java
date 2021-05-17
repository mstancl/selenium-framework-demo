package pages;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.PageWait;

public class BasePage {

    protected BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    protected void click(WebElement webElement) {
        PageWait.waitForWebElementToLoad(webElement);
        webElement.click();
    }

    protected void enterInput(WebElement webElement, String input) {
        PageWait.waitForWebElementToLoad(webElement);
        webElement.sendKeys(input);
    }

    protected String read(WebElement webElement) {
        PageWait.waitForWebElementToLoad(webElement);
        return webElement.getText();
    }


}
