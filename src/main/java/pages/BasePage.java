package pages;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    protected void click(WebElement webElement) {
        webElement.click();
    }

    protected void enterInput(WebElement webElement, String input) {
        webElement.sendKeys(input);
    }

    protected String read(WebElement element) {
        return element.getText();
    }


}
