package pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;
import utils.PageWait;

public class TextBoxPage extends BasePage {

    @FindBy(xpath = ".//div[@class='main-header']")
    private WebElement mainHeader_label;
    @FindBy(id = "userName")
    private WebElement userName_textBox;
    @FindBy(id = "userEmail")
    private WebElement userEmail_textBox;
    @FindBy(id = "currentAddress")
    private WebElement currentAddress_textBox;
    @FindBy(id = "permanentAddress")
    private WebElement permanentAddress_textBox;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(xpath = ".//div[@id='output']//p[@id='name']")
    private WebElement outputName_text;
    @FindBy(xpath = ".//div[@id='output']//p[@id='email']")
    private WebElement outputEmail_text;
    @FindBy(xpath = ".//div[@id='output']//p[@id='currentAddress']")
    private WebElement outputCurrentAddress_text;
    @FindBy(xpath = ".//div[@id='output']//p[@id='permanentAddress']")
    private WebElement outputPermanentAddress_text;

    public TextBoxPage() {
        super();
        PageWait.waitForWebElementToLoad(userName_textBox,
                userEmail_textBox,
                currentAddress_textBox,
                permanentAddress_textBox,
                submitButton);
        Assert.assertEquals(read(mainHeader_label), "Text Box");

    }

    public String getErrorClassOfUserEmail() {
        return getAttribute(userEmail_textBox, "class");
    }

    public TextBoxPage enterUserName(String input) {
        enterInput(userName_textBox, input);
        return this;
    }

    public TextBoxPage enterUserEmail(String input) {
        enterInput(userEmail_textBox, input);
        return this;
    }

    public TextBoxPage enterCurrentAddress(String input) {
        enterInput(currentAddress_textBox, input);
        return this;
    }

    public TextBoxPage enterPermanentAddress(String input) {
        enterInput(permanentAddress_textBox, input);
        return this;
    }

    public TextBoxPage clickOnSubmitButton() {
        click(submitButton);
        return this;
    }

    public String getOutputName() {
        return read(outputName_text);
    }

    public String getOutputUserEmail() {
        return read(outputEmail_text);
    }

    public String getOutputCurrentAddress() {
        return read(outputCurrentAddress_text);
    }

    public String getOutputPermanentAddress() {
        return read(outputPermanentAddress_text);
    }


}
