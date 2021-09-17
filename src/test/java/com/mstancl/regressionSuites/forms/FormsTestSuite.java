package com.mstancl.regressionSuites.forms;

import com.mstancl.BaseSuite;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.forms.FormsHomePage;
import pages.home.HomePage;
import utils.DateHelpers;
import utils.RGBModel;

public class FormsTestSuite extends BaseSuite {


    @Test(description = "001. Access the practice form and check mandatory fields")
    public void accessThePracticeFormAndCheckMandatoryFields() {
        FormsHomePage formsHomePage = new HomePage()
                .clickOnFormsTile()
                .clickOnPracticeFormButton();

        Assert.assertEquals(formsHomePage.getSubHeader(), "Student Registration Form");
        Assert.assertEquals(formsHomePage.getDateOfBirth(), DateHelpers.getCurrentDateMMMonthNameYYYY());

        Assert.assertTrue(formsHomePage.getFirstNameBorderColor().isGray());
        Assert.assertTrue(formsHomePage.getLastNameBorderColor().isGray());
        Assert.assertTrue(formsHomePage.getGenderMaleRadioButtonBorderColor().isBlack());
        Assert.assertTrue(formsHomePage.getGenderFemaleRadioButtonBorderColor().isBlack());
        Assert.assertTrue(formsHomePage.getGenderOtherRadioButtonBorderColor().isBlack());
        Assert.assertTrue(formsHomePage.getMobileBorderColor().isGray());

        formsHomePage
                .clickOnSubmitButton();

        Assert.assertTrue(formsHomePage.getFirstNameBorderColor().isRed());
        Assert.assertTrue(formsHomePage.getLastNameBorderColor().isRed());
        Assert.assertTrue(formsHomePage.getGenderMaleRadioButtonBorderColor().isRed());
        Assert.assertTrue(formsHomePage.getGenderFemaleRadioButtonBorderColor().isRed());
        Assert.assertTrue(formsHomePage.getGenderOtherRadioButtonBorderColor().isRed());
        Assert.assertTrue(formsHomePage.getMobileBorderColor().isRed());

        formsHomePage
                .inputFirstName("Mike")
                .inputLastName("Toast")
                .clickOnMaleGenderRadioButton()
                .inputMobileNumber("1234567890")
                .clickOnSubmitButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(formsHomePage.getStudentNameAfterSubmit(), "Mike Toast");
        softAssert.assertEquals(formsHomePage.getStudentGenderAfterSubmit(), "Male");
        softAssert.assertEquals(formsHomePage.getStudentMobileAfterSubmit(), "1234567890");
        softAssert.assertEquals(formsHomePage.getTitleAfterSubmit(), "Thanks for submitting the form");
        softAssert.assertAll();

        formsHomePage.clickOnCloseButton();

        SoftAssert assertAfterClose = new SoftAssert();
        assertAfterClose.assertEquals(formsHomePage.getFirstName(), "");
        assertAfterClose.assertEquals(formsHomePage.getLastName(), "");
        assertAfterClose.assertEquals(formsHomePage.getUserNumber(), "");
        assertAfterClose.assertAll();

    }


    @Test(description = "002. Form field validations - text fields")
    public void formFieldValidationsTextFields() {
        FormsHomePage formsHomePage = new HomePage()
                .clickOnFormsTile()
                .clickOnPracticeFormButton();

        formsHomePage
                .inputFirstName("Dummy")
                .inputLastName("Tester")
                .clickOnSubmitButton();

        RGBModel firstNameBorderColor = formsHomePage.getFirstNameBorderColor();
        RGBModel lastNameBorderColor = formsHomePage.getLastNameBorderColor();
        RGBModel emailBorderColor = formsHomePage.getEmailBorderColor();
        RGBModel dateOfBirthBorderColor = formsHomePage.getDateOfBirthBorderColor();
        RGBModel genderMaleRadioButtonBorderColor = formsHomePage.getGenderMaleRadioButtonBorderColor();
        RGBModel genderFemaleRadioButtonBorderColor = formsHomePage.getGenderFemaleRadioButtonBorderColor();
        RGBModel genderOtherRadioButtonBorderColor = formsHomePage.getGenderOtherRadioButtonBorderColor();
        RGBModel mobileBorderColor = formsHomePage.getMobileBorderColor();
        RGBModel currentAddressBorderColor = formsHomePage.getCurrentAddressBorderColor();

        Assert.assertTrue(firstNameBorderColor.isGreen(), "The color was incorrect! " + firstNameBorderColor.toString());
        Assert.assertTrue(lastNameBorderColor.isGreen(), "The color was incorrect! " + lastNameBorderColor.toString());
        Assert.assertTrue(emailBorderColor.isGreen(), "The color was incorrect! " + emailBorderColor.toString());
        Assert.assertTrue(dateOfBirthBorderColor.isGreen(), "The color was incorrect! " + dateOfBirthBorderColor.toString());
        Assert.assertTrue(genderMaleRadioButtonBorderColor.isRed(), "The color was incorrect! " + genderMaleRadioButtonBorderColor.toString());
        Assert.assertTrue(genderFemaleRadioButtonBorderColor.isRed(), "The color was incorrect! " + genderFemaleRadioButtonBorderColor.toString());
        Assert.assertTrue(genderOtherRadioButtonBorderColor.isRed(), "The color was incorrect! " + genderOtherRadioButtonBorderColor.toString());
        Assert.assertTrue(mobileBorderColor.isRed(), "The color was incorrect! " + mobileBorderColor.toString());
        Assert.assertTrue(currentAddressBorderColor.isGreen(), "The color was incorrect! " + currentAddressBorderColor.toString());

        formsHomePage
                .inputUserEmail("randomString")
                .clickOnSubmitButton();
        RGBModel emailBorderIncorrect = formsHomePage.getEmailBorderColor();
        Assert.assertTrue(emailBorderIncorrect.isRed(), "The color was incorrect! " + emailBorderIncorrect.toString());

        formsHomePage
                .inputUserEmail("randomString@domain.com")
                .clickOnSubmitButton();
        RGBModel emailBorderCorrect = formsHomePage.getEmailBorderColor();
        Assert.assertTrue(emailBorderCorrect.isGreen(), "The color was incorrect! " + emailBorderCorrect.toString());

        formsHomePage
                .inputMobileNumber("123456789")
                .clickOnSubmitButton();
        RGBModel mobileBorderIncorrect = formsHomePage.getMobileBorderColor();
        Assert.assertTrue(mobileBorderIncorrect.isRed(), "The color was incorrect! " + mobileBorderIncorrect.toString());

        formsHomePage
                .inputMobileNumber("1234567890")
                .clickOnSubmitButton();
        RGBModel mobileBorderCorrect = formsHomePage.getMobileBorderColor();
        Assert.assertTrue(mobileBorderCorrect.isGreen(), "The color was incorrect! " + mobileBorderCorrect.toString());

        String subjectsValue = formsHomePage
                .inputSubjects("testing")
                .clickOnSubmitButton()
                .getSubjects();

        Assert.assertEquals(subjectsValue, "", "Subjects field is not empty! Found : [" + subjectsValue + "]");


        formsHomePage
                .inputSubjects("a");

        Assert.assertTrue(formsHomePage.isSubjectDisplayed("Maths"));
        Assert.assertTrue(formsHomePage.isSubjectDisplayed("Accounting"));
        Assert.assertTrue(formsHomePage.isSubjectDisplayed("Arts"));
        Assert.assertTrue(formsHomePage.isSubjectDisplayed("Social Studies"));

        formsHomePage
                .clickOnSubject("Maths");

        Assert.assertTrue(formsHomePage.isSubjectRegistered("Maths"));
        Assert.assertTrue(formsHomePage.doesCrossNextToSubjectExist("Maths"));

        formsHomePage
                .inputSubjects("arts");

        formsHomePage
                .clickOnSubject("Arts");
        Assert.assertTrue(formsHomePage.isSubjectRegistered("Arts"));
        Assert.assertTrue(formsHomePage.doesCrossNextToSubjectExist("Arts"));


    }













/*
    @Test(description = "001. Access the practice form and check mandatory fields")
    public void practiceForm(){
        FormsHomePage formsHomePage = new HomePage()
                .clickOnFormsTile()
                .clickOnPracticeFormButton()
                .inputFirstName("Dummy")
                .inputLastName("Tester")
                .clickOnOtherGenderRadioButton()
                .inputUserEmail("dummy@tester.com")
                .inputUserNumber("1234567890")
                .inputCurrentAddress("Tester Town 12, Dummy republic")
                .clickOnSubmitButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(formsHomePage.getStudentNameAfterSubmit(), "Dummy Tester");
        softAssert.assertEquals(formsHomePage.getStudentEmailAfterSubmit(), "dummy@tester.com");
        softAssert.assertEquals(formsHomePage.getStudentGenderAfterSubmit(), "Other");
        softAssert.assertEquals(formsHomePage.getStudentMobileAfterSubmit(), "1234567890");
        softAssert.assertEquals(formsHomePage.getStudentAddressAfterSubmit(), "Tester Town 12, Dummy republic");
        softAssert.assertAll();



    }
*/


}
