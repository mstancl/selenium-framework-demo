package pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;
import utils.PageWait;

public class CheckBoxPage extends BasePage {

    public CheckBoxPage() {
        super();
        PageWait.waitForWebElementToLoad(expandAll_button);

        Assert.assertEquals(read(mainHeader_label), "Check Box");
    }

    @FindBy(xpath = ".//div[@class='main-header']")
    private WebElement mainHeader_label;

    @FindBy(xpath = ".//button[@title='Expand all']")
    public WebElement expandAll_button;

    @FindBy(xpath = ".//button[@title='Collapse all']")
    public WebElement collapseAll_button;

    @FindBy(xpath = ".//label[@for='tree-node-angular']/span[@class='rct-checkbox']/*")
    private WebElement angular_checkBox;

    @FindBy(xpath = ".//label[@for='tree-node-wordFile']/span[@class='rct-checkbox']/*")
    private WebElement wordFile_checkBox;

    @FindBy(xpath = ".//label[@for='tree-node-private']/span[@class='rct-checkbox']/*")
    private WebElement private_checkBox;

    @FindBy(id = "result")
    private WebElement result_text;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Home']")
    public WebElement homeItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Home']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement homeItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Home']/parent::label/preceding-sibling::button[@title='Toggle']")
    public WebElement homeItemToggle_button;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Desktop']")
    public WebElement desktopItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Desktop']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement desktopItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Desktop']/parent::label/preceding-sibling::button[@title='Toggle']")
    public WebElement desktopItemToggle_button;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Notes']")
    public WebElement notesItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Notes']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement notesItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Commands']")
    public WebElement commandsItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Commands']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement commandsItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Documents']")
    public WebElement documentsItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Documents']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement documentsItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Documents']/parent::label/preceding-sibling::button[@title='Toggle']")
    public WebElement documentsItemToggle_button;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='WorkSpace']")
    public WebElement workspaceItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='WorkSpace']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement workspaceItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='WorkSpace']/parent::label/preceding-sibling::button[@title='Toggle']")
    public WebElement workspaceItemToggle_button;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='React']")
    public WebElement reactItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='React']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement reactItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Angular']")
    public WebElement angularItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Angular']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement angularItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Veu']")
    public WebElement veuItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Veu']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement veuItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Office']")
    public WebElement officeItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Office']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement officeItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Office']/parent::label/preceding-sibling::button[@title='Toggle']")
    public WebElement officeItemToggle_button;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Public']")
    public WebElement publicItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Public']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement publicItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Private']")
    public WebElement privateItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Private']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement privateItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Classified']")
    public WebElement classifiedItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Classified']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement classifiedItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='General']")
    public WebElement generalItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='General']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement generalItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Downloads']")
    public WebElement downloadsItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Downloads']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement downloadsItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Downloads']/parent::label/preceding-sibling::button[@title='Toggle']")
    public WebElement downloadsItemToggle_button;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Word File.doc']")
    public WebElement wordFileItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Word File.doc']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement wordFileItem_checkBox;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Excel File.doc']")
    public WebElement excelFileDocItem_label;

    @FindBy(xpath = ".//span[@class='rct-title'][text()='Excel File.doc']/preceding-sibling::span[@class='rct-checkbox']/*")
    public WebElement excelFileDocItem_checkBox;


    public CheckBoxPage clickOnHomeToggleButton() {
        click(homeItemToggle_button);
        return this;
    }

    public CheckBoxPage clickOnDesktopToggleButton() {
        click(desktopItemToggle_button);
        return this;
    }

    public CheckBoxPage clickOnDocumentsToggleButton() {
        click(documentsItemToggle_button);
        return this;
    }

    public CheckBoxPage clickOnWorkSpaceToggleButton() {
        click(workspaceItemToggle_button);
        return this;
    }

    public CheckBoxPage clickOnOfficeToggleButton() {
        click(officeItemToggle_button);
        return this;
    }

    public CheckBoxPage clickOnOfficeCheckBox() {
        click(officeItem_checkBox);
        return this;
    }

    public CheckBoxPage clickOnDownloadsToggleButton() {
        click(downloadsItemToggle_button);
        return this;
    }

    public CheckBoxPage clickOnExpandAllButton() {
        click(expandAll_button);
        return this;
    }

    public CheckBoxPage clickOnCollapseAllButton() {
        click(collapseAll_button);
        return this;
    }

    public CheckBoxPage clickOnAngularCheckBox() {
        click(angular_checkBox);
        return this;
    }

    public CheckBoxPage clickOnWordCheckBox() {
        click(wordFile_checkBox);
        return this;
    }

    public Boolean isWordCheckBoxChecked() {
        return getAttribute(wordFileItem_checkBox, "class").equals("rct-icon rct-icon-check");
    }

    public Boolean isPublicCheckBoxChecked() {
        return getAttribute(publicItem_checkBox, "class").equals("rct-icon rct-icon-check");
    }

    public Boolean isPrivateCheckBoxChecked() {
        return getAttribute(privateItem_checkBox, "class").equals("rct-icon rct-icon-check");
    }

    public Boolean isClassifiedCheckBoxChecked() {
        return getAttribute(classifiedItem_checkBox, "class").equals("rct-icon rct-icon-check");
    }

    public Boolean isGeneralCheckBoxChecked() {
        return getAttribute(generalItem_checkBox, "class").equals("rct-icon rct-icon-check");
    }

    public CheckBoxPage clickOnPrivateCheckBox() {
        click(private_checkBox);
        return this;
    }

    public String getResult() {
        return read(result_text);
    }


}
