package pages.forms;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;
import properties.PropertiesManager;
import utils.RGBModel;
import utils.Utilities;

public class FormsHomePage extends BasePage {

    public FormsHomePage() {
        super();
        Assert.assertEquals(read(mainHeader_label), "Forms");
    }

    @FindBy(xpath = ".//div[@class='practice-form-wrapper']/h5")
    private WebElement subHeader_label;

    @FindBy(xpath = ".//div[@class='main-header']")
    private WebElement mainHeader_label;

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

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirth_textField;


    @FindBy(xpath = ".//input[@name='gender'][@value='Male']")
    private WebElement genderMale_radioButton;
    @FindBy(xpath = ".//label[@for='gender-radio-1']")
    private WebElement genderMale_label;

    @FindBy(xpath = ".//input[@name='gender'][@value='Female']")
    private WebElement genderFemale_radioButton;
    @FindBy(xpath = ".//label[@for='gender-radio-2']")
    private WebElement genderFemale_label;

    @FindBy(xpath = ".//input[@name='gender'][@value='Other']")
    private WebElement genderOther_radioButton;
    @FindBy(xpath = ".//label[@for='gender-radio-3']")
    private WebElement genderOther_label;

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

    @FindBy(xpath = ".//div[@class='modal-title h4']")
    private WebElement titleAfterSubmit_label;


    public String getSubHeader() {
        return read(subHeader_label);
    }

    public String getDateOfBirth() {
        return getAttribute(dateOfBirth_textField, "value");
    }

    public FormsHomePage inputDateOfBirth(String input) {
        enterInput(dateOfBirth_textField, input);
        return this;
    }

    public FormsHomePage clickOnPracticeFormButton() {
        click(practiceForm_button);
        return this;
    }

    public FormsHomePage inputFirstName(String input) {
        enterInput(firstName_textField, input);
        return this;
    }

    public String getFirstName(){
        return read(firstName_textField);
    }

    public FormsHomePage inputLastName(String input) {
        enterInput(lastName_textField, input);
        return this;
    }

    public String getLastName(){
        return read(lastName_textField);
    }

    public FormsHomePage inputUserEmail(String input) {
        enterInput(userEmail_textField, input);
        return this;
    }

    public FormsHomePage inputUserNumber(String input) {
        enterInput(userNumber_textField, input);
        return this;
    }
    public String getUserNumber(){
        return read(userNumber_textField);
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

    public FormsHomePage clickOnMaleGenderRadioButton() {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(genderMale_radioButton).click().perform();

        return this;
    }

    public RGBModel getFirstNameBorderColor() {
        return Utilities.parseRGBValuesFromString(firstName_textField.getCssValue("border-color"));
    }

    public RGBModel getLastNameBorderColor() {
        return Utilities.parseRGBValuesFromString(lastName_textField.getCssValue("border-color"));
    }

    public RGBModel getGenderMaleRadioButtonBorderColor() {
        return Utilities.parseRGBValuesFromString(genderMale_label.getCssValue("border-color"));
    }

    public RGBModel getGenderFemaleRadioButtonBorderColor() {
        return Utilities.parseRGBValuesFromString(genderFemale_label.getCssValue("border-color"));
    }

    public RGBModel getGenderOtherRadioButtonBorderColor() {
        return Utilities.parseRGBValuesFromString(genderOther_label.getCssValue("border-color"));
    }

    public RGBModel getMobileBorderColor() {

        return Utilities.parseRGBValuesFromString(userNumber_textField.getCssValue("border-color"));
    }

    public FormsHomePage clickOnSubmitButton() {
        click(submit_button);

        int counter = 0;
        // wait while fields are gray. This means they have not been submitted yet. There is no other way
        // timeout if the wait takes longer than the element.wait.timeout property
        while ((getFirstNameBorderColor().getRed() > 200 && getFirstNameBorderColor().getGreen() > 100 && getFirstNameBorderColor().getBlue() > 100) && counter < Integer.parseInt(PropertiesManager.getProperty("element.wait.timeout")) * 10) {
            Utilities.sleep(100);
            counter++;
        }
        System.out.println(getMobileBorderColor().toString());
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

    public String getTitleAfterSubmit() {
        return read(titleAfterSubmit_label);
    }


}
