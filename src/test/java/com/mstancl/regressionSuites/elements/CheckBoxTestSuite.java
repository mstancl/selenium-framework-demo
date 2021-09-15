package com.mstancl.regressionSuites.elements;

import com.mstancl.BaseSuite;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.elements.CheckBoxPage;
import pages.elements.TextBoxPage;
import pages.home.HomePage;

public class CheckBoxTestSuite extends BaseSuite {

    @Test(description = "001. Verify Text Box Functionality")
    public void textBox() {

        TextBoxPage textBoxPage = new HomePage()
                .clickOnElementsTile()
                .clickOnTextBoxButton()
                .enterUserName("Tester")
                .enterUserEmail("tester@test.com")
                .enterCurrentAddress("Tester current address street 12")
                .enterPermanentAddress("Tester permanent address street 24")
                .clickOnSubmitButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(textBoxPage.getOutputName(), "Name:Tester");
        softAssert.assertEquals(textBoxPage.getOutputUserEmail(), "Email:tester@test.com");
        softAssert.assertEquals(textBoxPage.getOutputCurrentAddress(), "Current Address :Tester current address street 12");
        softAssert.assertEquals(textBoxPage.getOutputPermanentAddress(), "Permananet Address :Tester permanent address street 24");
        softAssert.assertAll();

    }

    @Test(description = "This test demonstrates 'Check Box' functionality from Elements")
    public void checkBox() {

        CheckBoxPage checkBoxPage = new HomePage()
                .clickOnElementsTile()
                .clickOnCheckBoxButton()
                .clickOnExpandAllButton()
                .clickOnAngularCheckBox()
                .clickOnPrivateCheckBox()
                .clickOnWordCheckBox();

        Assert.assertEquals(checkBoxPage.getResult(),"You have selected :\n" +
                "angular\n" +
                "private\n" +
                "wordFile");

    }


}
