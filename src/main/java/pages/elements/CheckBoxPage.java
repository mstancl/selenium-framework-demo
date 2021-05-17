package pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.PageWait;

public class CheckBoxPage extends BasePage {

    public CheckBoxPage() {
        super();
        PageWait.waitForWebElementToLoad(expandAll_button);
    }

    @FindBy(xpath = ".//button[@title='Expand all']")
    private WebElement expandAll_button;

    @FindBy(xpath = ".//label[@for='tree-node-angular']/span[@class='rct-checkbox']")
    private WebElement angular_checkBox;

    @FindBy(xpath = ".//label[@for='tree-node-wordFile']/span[@class='rct-checkbox']")
    private WebElement wordFile_checkBox;

    @FindBy(xpath = ".//label[@for='tree-node-private']/span[@class='rct-checkbox']")
    private WebElement private_checkBox;

    @FindBy(id = "result")
    private WebElement result_text;

    public CheckBoxPage clickOnExpandAllButton() {
        click(expandAll_button);
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

    public CheckBoxPage clickOnPrivateCheckBox() {
        click(private_checkBox);
        return this;
    }

    public String getResult() {
        return read(result_text);
    }


}
