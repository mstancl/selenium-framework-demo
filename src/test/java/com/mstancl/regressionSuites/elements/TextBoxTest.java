package com.mstancl.regressionSuites.elements;

import com.mstancl.BaseSuite;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.elements.TextBoxPage;
import pages.home.HomePage;

public class TextBoxTest extends BaseSuite {

    @Test(description = "001. Verify Text Box Functionality")
    public void verifyTextBoxFunctionality() {

        TextBoxPage textBoxPage = new HomePage()
                .clickOnElementsTile()
                .clickOnTextBoxButton();

        textBoxPage
                .enterUserEmail("incorrectEmail")
                .clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getErrorClassOfUserEmail(), "mr-sm-2 field-error form-control");
        Assert.assertTrue(textBoxPage.getUserEmailBorderColor().isRed());

        textBoxPage
                .enterUserEmail("incorrectEmail@")
                .clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getErrorClassOfUserEmail(), "mr-sm-2 field-error form-control");
        Assert.assertTrue(textBoxPage.getUserEmailBorderColor().isRed());

        textBoxPage
                .enterUserEmail("incorrectEmail@domain")
                .clickOnSubmitButton();

        Assert.assertEquals(textBoxPage.getErrorClassOfUserEmail(), "mr-sm-2 field-error form-control");
        Assert.assertTrue(textBoxPage.getUserEmailBorderColor().isRed());

        textBoxPage
                .enterUserName("Tester")
                .enterUserEmail("correctEmail@domain.com")
                .enterCurrentAddress("Tester current address street 12")
                .enterPermanentAddress("Tester permanent address street 24")
                .clickOnSubmitButton();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(textBoxPage.getOutputName(), "Name:Tester");
        softAssert.assertEquals(textBoxPage.getOutputUserEmail(), "Email:correctEmail@domain.com");
        softAssert.assertEquals(textBoxPage.getErrorClassOfUserEmail(), "mr-sm-2 form-control");
        softAssert.assertEquals(textBoxPage.getOutputCurrentAddress(), "Current Address :Tester current address street 12");
        softAssert.assertEquals(textBoxPage.getOutputPermanentAddress(), "Permananet Address :Tester permanent address street 24");
        softAssert.assertAll();

    }

}
