package com.mstancl.regressionSuites.forms;

import com.mstancl.BaseSuite;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.forms.FormsHomePage;
import pages.home.HomePage;
import utils.DateHelpers;

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
                .inputUserNumber("1234567890")
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

        Assert.assertTrue(formsHomePage.getFirstNameBorderColor().isGreen());
        Assert.assertTrue(formsHomePage.getLastNameBorderColor().isGreen());
        Assert.assertTrue(formsHomePage.getEmailBorderColor().isGreen());
        Assert.assertTrue(formsHomePage.getDateOfBirthBorderColor().isGreen());
        Assert.assertTrue(formsHomePage.getGenderMaleRadioButtonBorderColor().isRed());
        Assert.assertTrue(formsHomePage.getGenderFemaleRadioButtonBorderColor().isRed());
        Assert.assertTrue(formsHomePage.getGenderOtherRadioButtonBorderColor().isRed());
        Assert.assertTrue(formsHomePage.getMobileBorderColor().isRed());
        Assert.assertTrue(formsHomePage.getCurrentAddressBorderColor().isGreen());

        formsHomePage
                .inputUserEmail("randomString");

        Assert.assertTrue(formsHomePage.getEmailBorderColor().isGreen());

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
