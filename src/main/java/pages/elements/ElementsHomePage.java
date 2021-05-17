package pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.PageWait;

public class ElementsHomePage extends BasePage {


    public ElementsHomePage() {
        super();
        PageWait.waitForWebElementToLoad(textBox_button,
                checkBox_button,
                radioButton_button,
                webTables_button,
                buttons_button,
                links_button,
                brokenLinksImages_button,
                uploadAndDownload_button,
                dynamicProperties_button);
    }

    @FindBy(xpath = ".//span[@class='text'][text()='Text Box']")
    private WebElement textBox_button;

    @FindBy(xpath = ".//span[@class='text'][text()='Check Box']")
    private WebElement checkBox_button;

    @FindBy(xpath = ".//span[@class='text'][text()='Radio Button']")
    private WebElement radioButton_button;

    @FindBy(xpath = ".//span[@class='text'][text()='Web Tables']")
    private WebElement webTables_button;

    @FindBy(xpath = ".//span[@class='text'][text()='Buttons']")
    private WebElement buttons_button;

    @FindBy(xpath = ".//span[@class='text'][text()='Links']")
    private WebElement links_button;

    @FindBy(xpath = ".//span[@class='text'][text()='Broken Links - Images']")
    private WebElement brokenLinksImages_button;

    @FindBy(xpath = ".//span[@class='text'][text()='Upload and Download']")
    private WebElement uploadAndDownload_button;

    @FindBy(xpath = ".//span[@class='text'][text()='Dynamic Properties']")
    private WebElement dynamicProperties_button;


    public TextBoxPage clickOnTextBoxButton() {
        click(textBox_button);
        return new TextBoxPage();
    }

    public ElementsHomePage clickOnCheckBoxButton() {
        click(checkBox_button);
        return new ElementsHomePage();
    }

    public ElementsHomePage clickOnRadioButtonButton() {
        click(textBox_button);
        return new ElementsHomePage();
    }

    public ElementsHomePage clickOnWebTablesButton() {
        click(webTables_button);
        return new ElementsHomePage();
    }

    public ElementsHomePage clickOnButtonsButton() {
        click(buttons_button);
        return new ElementsHomePage();
    }

    public ElementsHomePage clickOnLinksButton() {
        click(links_button);
        return new ElementsHomePage();
    }

    public ElementsHomePage clickOnBrokenLinksImagesButton() {
        click(brokenLinksImages_button);
        return new ElementsHomePage();
    }

    public ElementsHomePage clickOnUploadAndDownloadButton() {
        click(uploadAndDownload_button);
        return new ElementsHomePage();
    }

    public ElementsHomePage clickOnDynamicPropertiesButton() {
        click(dynamicProperties_button);
        return new ElementsHomePage();
    }


}
