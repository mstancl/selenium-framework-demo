package pages.forms;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @FindBy(xpath = ".//div[@role='document']")
    private WebElement documentWindow_window;

    @FindBy(id = "closeLargeModal")
    private WebElement close_button;

    @FindBy(xpath = ".//td[text()='Student Name']/following-sibling::td")
    private WebElement studentNameAfterSubmit_label;

    @FindBy(xpath = ".//td[text()='Date of Birth']/following-sibling::td")
    private WebElement dateOfBirthAfterSubmit_label;

    @FindBy(xpath = ".//td[text()='Student Email']/following-sibling::td")
    private WebElement studentEmailAfterSubmit_label;

    @FindBy(xpath = ".//td[text()='Gender']/following-sibling::td")
    private WebElement genderAfterSubmit_label;

    @FindBy(xpath = ".//td[text()='Hobbies']/following-sibling::td")
    private WebElement hobbiesAfterSubmit_label;

    @FindBy(xpath = ".//td[text()='Mobile']/following-sibling::td")
    private WebElement mobileAfterSubmit_label;

    @FindBy(xpath = ".//td[text()='Address']/following-sibling::td")
    private WebElement addressAfterSubmit_label;

    @FindBy(xpath = ".//div[@class='modal-title h4']")
    private WebElement titleAfterSubmit_label;

    @FindBy(id = "subjectsInput")
    private WebElement subjects_textField;

    @FindBy(xpath = ".//div[@class='react-datepicker__month-container']")
    private WebElement datePicker_container;

    @FindBy(xpath = ".//select[@class='react-datepicker__month-select']")
    private WebElement datePickerMonth_select;

    @FindBy(xpath = ".//select[@class='react-datepicker__year-select']")
    private WebElement datePickerYear_select;

    @FindBy(id = "hobbies-checkbox-1")
    private WebElement sportsCheckBoxHobbies_checkbox;

    @FindBy(id = "hobbies-checkbox-2")
    private WebElement readingCheckBoxHobbies_checkbox;

    @FindBy(id = "hobbies-checkbox-3")
    private WebElement musicCheckBoxHobbies_checkbox;


    public FormsHomePage clickOutsideTheSubmitWindow() {
        click(documentWindow_window);
        return this;
    }

    public FormsHomePage clickOnSportsHobbyCheckBox() {
        moveAndClick(sportsCheckBoxHobbies_checkbox);
        return this;
    }

    public FormsHomePage clickOnReadingHobbyCheckBox() {
        moveAndClick(readingCheckBoxHobbies_checkbox);
        return this;
    }

    public FormsHomePage clickOnMusicHobbyCheckBox() {
        moveAndClick(musicCheckBoxHobbies_checkbox);
        return this;
    }

    public FormsHomePage selectMonthInDatePicker(String month) {
        selectDropdown(datePickerMonth_select, month);
        return this;
    }

    public FormsHomePage selectYearInDatePicker(String month) {
        selectDropdown(datePickerYear_select, month);
        return this;
    }

    public FormsHomePage selectDayInDateCalendar(String day) {
        if (day.length() == 1) {
            day = "0" + day;
        }
        click(DriverManager.getDriver().findElement(By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--0" + day + "']")));
        return this;
    }

    public Boolean isDatePickerPresent() {
        return isElementPresentAndClickable(datePicker_container);
    }

    public FormsHomePage clickOnSubjectsField() {
        click(subjects_textField);
        return this;
    }

    public FormsHomePage clickOnSubject(String subjectName) {
        DriverManager.getDriver().findElement(By.xpath(".//div[@id='subjectsContainer']//div[text()='" + subjectName + "']")).click();
        return this;
    }

    public Boolean isSubjectDisplayed(String subjectName) {
        try {
            WebElement webElement = DriverManager.getDriver().findElement(By.xpath(".//div[@id='subjectsContainer']//div[text()='" + subjectName + "']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean isSubjectRegistered(String subjectName) {
        try {
            WebElement webElement = DriverManager.getDriver().findElement(By.xpath(".//div[@class='css-12jo7m5 subjects-auto-complete__multi-value__label'][text()='" + subjectName + "']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean doesCrossNextToSubjectExist(String subjectName) {
        try {
            WebElement webElement = DriverManager.getDriver().findElement(By.xpath(".//div[@class='css-12jo7m5 subjects-auto-complete__multi-value__label'][text()='" + subjectName + "']/following-sibling::div[@class='css-xb97g8 subjects-auto-complete__multi-value__remove']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public FormsHomePage clickCrossNextToSubject(String subjectName) {
        DriverManager.getDriver().findElement(By.xpath(".//div[@class='css-12jo7m5 subjects-auto-complete__multi-value__label'][text()='" + subjectName + "']/following-sibling::div[@class='css-xb97g8 subjects-auto-complete__multi-value__remove']")).click();
        return this;

    }

    public String getSubjects() {
        return getAttribute(subjects_textField, "value");
    }

    public FormsHomePage inputSubjects(String input) {
        enterInput(subjects_textField, input);
        return this;
    }

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

    public FormsHomePage clickOnDateOfBirth() {
        click(dateOfBirth_textField);
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

    public String getFirstName() {
        return read(firstName_textField);
    }

    public FormsHomePage inputLastName(String input) {
        enterInput(lastName_textField, input);
        return this;
    }

    public String getLastName() {
        return read(lastName_textField);
    }

    public FormsHomePage inputUserEmail(String input) {
        enterInput(userEmail_textField, input);
        return this;
    }

    public FormsHomePage inputMobileNumber(String input) {
        enterInput(userNumber_textField, input);
        return this;
    }

    public String getUserNumber() {
        return read(userNumber_textField);
    }

    public FormsHomePage inputCurrentAddress(String input) {
        enterInput(currentAddress_textField, input);
        return this;
    }

    public FormsHomePage clickOnOtherGenderRadioButton() {
        moveAndClick(genderOther_radioButton);
        return this;
    }

    public FormsHomePage clickOnMaleGenderRadioButton() {
        moveAndClick(genderMale_radioButton);
        return this;
    }

    public FormsHomePage clickOnFemaleGenderRadioButton() {
        moveAndClick(genderFemale_radioButton);
        return this;
    }

    public Boolean isMaleGenderRadioPresent() {
        return (isElementPresent(genderMale_radioButton) && isElementPresent(genderMale_label));
    }

    public Boolean isFemaleGenderRadioPresent() {
        return (isElementPresent(genderFemale_radioButton) && isElementPresent(genderFemale_label));
    }

    public Boolean isOtherGenderRadioPresent() {
        return (isElementPresent(genderOther_radioButton) && isElementPresent(genderOther_label));
    }

    public RGBModel getFirstNameBorderColor() {
        return Utilities.parseRGBValuesFromString(firstName_textField.getCssValue("border-color"));
    }

    public RGBModel getLastNameBorderColor() {
        return Utilities.parseRGBValuesFromString(lastName_textField.getCssValue("border-color"));
    }

    public RGBModel getEmailBorderColor() {
        return Utilities.parseRGBValuesFromString(userEmail_textField.getCssValue("border-color"));
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

    public RGBModel getDateOfBirthBorderColor() {
        return Utilities.parseRGBValuesFromString(dateOfBirth_textField.getCssValue("border-color"));
    }

    public RGBModel getCurrentAddressBorderColor() {
        return Utilities.parseRGBValuesFromString(currentAddress_textField.getCssValue("border-color"));
    }

    public FormsHomePage clickOnSubmitButton() {
        click(submit_button);

        int counter = 0;
        // wait while fields are gray. This means they have not been submitted yet. There is no other way
        // timeout if the wait takes longer than the element.wait.timeout property
        while (getFirstNameBorderColor().isGray() && counter < Integer.parseInt(PropertiesManager.getProperty("element.wait.timeout")) * 10) {
            Utilities.sleep(100);
            counter++;
        }
        Utilities.sleep(200); //unfortunately have to sleep since I have no other way how to check if the colors have been changed or not
        return this;
    }
    public FormsHomePage clickOnSubmitButtonAfterSubmit() {
       moveAndClick(submit_button);
        return this;
    }


    public FormsHomePage clickOnCloseButton() {
        click(close_button);
        return this;
    }

    public String getStudentNameAfterSubmit() {
        return read(studentNameAfterSubmit_label);
    }

    public String getDateOfBirthAfterSubmit() {
        return read(dateOfBirthAfterSubmit_label);
    }

    public String getStudentEmailAfterSubmit() {
        return read(studentEmailAfterSubmit_label);
    }

    public String getStudentGenderAfterSubmit() {
        return read(genderAfterSubmit_label);
    }

    public String getHobbiesAfterSubmit() {
        return read(hobbiesAfterSubmit_label);
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
