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

        Assert.assertTrue(formsHomePage.getFirstNameBorderColor().getRed() > 200 && formsHomePage.getFirstNameBorderColor().getBlue() > 200 && formsHomePage.getFirstNameBorderColor().getGreen() > 200);
        Assert.assertTrue(formsHomePage.getLastNameBorderColor().getRed() > 200 && formsHomePage.getLastNameBorderColor().getBlue() > 200 && formsHomePage.getLastNameBorderColor().getGreen() > 200);
        Assert.assertTrue(formsHomePage.getGenderMaleRadioButtonBorderColor().getRed() < 50 && formsHomePage.getGenderMaleRadioButtonBorderColor().getBlue() < 50 && formsHomePage.getGenderMaleRadioButtonBorderColor().getGreen() < 50, formsHomePage.getGenderMaleRadioButtonBorderColor().toString());
        Assert.assertTrue(formsHomePage.getGenderFemaleRadioButtonBorderColor().getRed() < 50 && formsHomePage.getGenderFemaleRadioButtonBorderColor().getBlue() < 50 && formsHomePage.getGenderFemaleRadioButtonBorderColor().getGreen() < 50);
        Assert.assertTrue(formsHomePage.getGenderOtherRadioButtonBorderColor().getRed() < 50 && formsHomePage.getGenderOtherRadioButtonBorderColor().getBlue() < 50 && formsHomePage.getGenderOtherRadioButtonBorderColor().getGreen() < 50);
        Assert.assertTrue(formsHomePage.getMobileBorderColor().getRed() > 200 && formsHomePage.getMobileBorderColor().getBlue() > 200 && formsHomePage.getMobileBorderColor().getGreen() > 200);

        formsHomePage
                .clickOnSubmitButton();

        Assert.assertTrue(formsHomePage.getFirstNameBorderColor().getRed() > 200 && formsHomePage.getFirstNameBorderColor().getBlue() < 100 && formsHomePage.getFirstNameBorderColor().getGreen() < 100);
        Assert.assertTrue(formsHomePage.getLastNameBorderColor().getRed() > 200 && formsHomePage.getLastNameBorderColor().getBlue() < 100 && formsHomePage.getLastNameBorderColor().getGreen() < 100);
        Assert.assertTrue(formsHomePage.getGenderMaleRadioButtonBorderColor().getRed() > 200 && formsHomePage.getGenderMaleRadioButtonBorderColor().getBlue() < 100 && formsHomePage.getGenderMaleRadioButtonBorderColor().getGreen() < 100);
        Assert.assertTrue(formsHomePage.getGenderFemaleRadioButtonBorderColor().getRed() > 200 && formsHomePage.getGenderFemaleRadioButtonBorderColor().getBlue() < 100 && formsHomePage.getGenderFemaleRadioButtonBorderColor().getGreen() < 100);
        Assert.assertTrue(formsHomePage.getGenderOtherRadioButtonBorderColor().getRed() > 200 && formsHomePage.getGenderOtherRadioButtonBorderColor().getBlue() < 100 && formsHomePage.getGenderOtherRadioButtonBorderColor().getGreen() < 100);
        Assert.assertTrue(formsHomePage.getMobileBorderColor().getRed() > 200 && formsHomePage.getMobileBorderColor().getBlue() < 100 && formsHomePage.getMobileBorderColor().getGreen() < 100);

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
