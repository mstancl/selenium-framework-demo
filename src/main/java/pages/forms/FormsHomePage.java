package pages.forms;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class FormsHomePage extends BasePage {

    public FormsHomePage() {
        super();

    }

    @FindBy(xpath = ".//span[@class='text'][text()='Practice Form']")
    private WebElement practiceForm_button;


    @FindBy(id = "firstName")
    private WebElement firstName_textField;

    @FindBy(id = "lastName")
    private WebElement lastName_textField;

    @FindBy(id = "userEmail")
    private WebElement userEmail_textField;

    @FindBy(id = "userNumber")
    private WebElement userNumber_textField;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress_textField;


    @FindBy(xpath = ".//input[@name='gender'][@value='Other']")
    private WebElement genderOther_radioButton;

    @FindBy(id = "submit")
    private WebElement submit_button;

    @FindBy(id = "closeLargeModal")
    private WebElement close_button;

    @FindBy(xpath = ".//td[text()='Student Name']/following-sibling::td")
    private WebElement studentNameAfterSubmit_label;

    @FindBy(xpath = ".//td[text()='Student Email']/following-sibling::td")
    private WebElement studentEmailAfterSubmit_label;

    @FindBy(xpath = ".//td[text()='Gender']/following-sibling::td")
    private WebElement genderAfterSubmit_label;

    @FindBy(xpath = ".//td[text()='Mobile']/following-sibling::td")
    private WebElement mobileAfterSubmit_label;

    @FindBy(xpath = ".//td[text()='Address']/following-sibling::td")
    private WebElement addressAfterSubmit_label;


    public FormsHomePage clickOnPracticeFormButton() {
        click(practiceForm_button);
        return this;
    }

    public FormsHomePage inputFirstName(String input) {
        enterInput(firstName_textField, input);
        return this;
    }

    public FormsHomePage inputLastName(String input) {
        enterInput(lastName_textField, input);
        return this;
    }

    public FormsHomePage inputUserEmail(String input) {
        enterInput(userEmail_textField, input);
        return this;
    }

    public FormsHomePage inputUserNumber(String input) {
        enterInput(userNumber_textField, input);
        return this;
    }

    public FormsHomePage inputCurrentAddress(String input) {
        enterInput(currentAddress_textField, input);
        return this;
    }

    public FormsHomePage clickOnOtherGenderRadioButton() {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(genderOther_radioButton).click().perform();

        return this;
    }

    public FormsHomePage clickOnSubmitButton() {
        click(submit_button);
        return this;
    }

    public FormsHomePage clickOnCloseButton() {
        click(close_button);
        return this;
    }

    public String getStudentNameAfterSubmit() {
        return read(studentNameAfterSubmit_label);
    }

    public String getStudentEmailAfterSubmit() {
        return read(studentEmailAfterSubmit_label);
    }

    public String getStudentGenderAfterSubmit() {
        return read(genderAfterSubmit_label);
    }

    public String getStudentMobileAfterSubmit() {
        return read(mobileAfterSubmit_label);
    }

    public String getStudentAddressAfterSubmit() {
        return read(addressAfterSubmit_label);
    }


}
