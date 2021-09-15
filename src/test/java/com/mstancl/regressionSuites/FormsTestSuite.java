package com.mstancl.regressionSuites;

import com.mstancl.BaseSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.forms.FormsHomePage;
import pages.home.HomePage;

public class FormsTestSuite extends BaseSuite {

    @Test(description = "This test demonstrates 'Practice Form functionality from Elements'")
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



}
