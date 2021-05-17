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

    public CheckBoxPage clickOnCheckBoxButton() {
        click(checkBox_button);
        return new CheckBoxPage();
    }

    public RadioButtonPage clickOnRadioButtonButton() {
        click(textBox_button);
        return new RadioButtonPage();
    }

    public WebTablesPage clickOnWebTablesButton() {
        click(webTables_button);
        return new WebTablesPage();
    }

    public ButtonsPage clickOnButtonsButton() {
        click(buttons_button);
        return new ButtonsPage();
    }

    public LinksPage clickOnLinksButton() {
        click(links_button);
        return new LinksPage();
    }

    public BrokenLinksImages clickOnBrokenLinksImagesButton() {
        click(brokenLinksImages_button);
        return new BrokenLinksImages();
    }

    public UploadAndDownloadPage clickOnUploadAndDownloadButton() {
        click(uploadAndDownload_button);
        return new UploadAndDownloadPage();
    }

    public DynamicPropertiesPage clickOnDynamicPropertiesButton() {
        click(dynamicProperties_button);
        return new DynamicPropertiesPage();
    }


}
