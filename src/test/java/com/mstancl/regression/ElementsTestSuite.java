package com.mstancl.regression;

import com.mstancl.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.elements.TextBoxPage;
import pages.home.HomePage;

public class ElementsTestSuite extends BaseTest {

    @Test(description = "This test demonstrates 'Text Box' functionality from Elements")
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


}
