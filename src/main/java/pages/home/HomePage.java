package pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.elements.ElementsHomePage;
import utils.PageWait;

public class HomePage extends BasePage {


    public HomePage() {
        super();
        PageWait.waitForWebElementToLoad(elements_tile, forms_tile, alertsFrameWindows_tile, widgets_tile, interactions_tile, bookStoreApplication_tile);
    }

    @FindBy(xpath = ".//div[@class='card-body']/h5[text()='Elements']")
    private WebElement elements_tile;

    @FindBy(xpath = ".//div[@class='card-body']/h5[text()='Forms']")
    private WebElement forms_tile;

    @FindBy(xpath = ".//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindows_tile;

    @FindBy(xpath = ".//div[@class='card-body']/h5[text()='Elements']")
    private WebElement widgets_tile;

    @FindBy(xpath = ".//div[@class='card-body']/h5[text()='Elements']")
    private WebElement interactions_tile;

    @FindBy(xpath = ".//div[@class='card-body']/h5[text()='Elements']")
    private WebElement bookStoreApplication_tile;




    public ElementsHomePage clickOnElementsTile() {
        click(elements_tile);
        return new ElementsHomePage();
    }


}
