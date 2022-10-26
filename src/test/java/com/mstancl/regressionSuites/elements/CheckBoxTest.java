package com.mstancl.regressionSuites.elements;

import com.mstancl.BaseSuite;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.elements.CheckBoxPage;
import pages.home.HomePage;

public class CheckBoxTest extends BaseSuite {


    @Test(description = "001. Verify Check Box Screen")
    public void verifyCheckBoxScreen() {

        CheckBoxPage checkBoxPage = new HomePage()
                .clickOnElementsTile()
                .clickOnCheckBoxButton();

        checkBoxPage.validateWebElementsAreVisible(
                checkBoxPage.homeItem_label,
                checkBoxPage.homeItem_checkBox,
                checkBoxPage.homeItemToggle_button
        );

        checkBoxPage
                .clickOnHomeToggleButton()
                .validateWebElementsAreVisible(
                        checkBoxPage.desktopItem_label,
                        checkBoxPage.desktopItem_checkBox,
                        checkBoxPage.desktopItemToggle_button,
                        checkBoxPage.documentsItem_label,
                        checkBoxPage.documentsItem_checkBox,
                        checkBoxPage.documentsItemToggle_button,
                        checkBoxPage.downloadsItem_label,
                        checkBoxPage.downloadsItem_checkBox,
                        checkBoxPage.downloadsItemToggle_button
                );

        checkBoxPage
                .clickOnHomeToggleButton()
                .validateWebElementsAreNotVisible(
                        checkBoxPage.desktopItem_label,
                        checkBoxPage.desktopItem_checkBox,
                        checkBoxPage.desktopItemToggle_button,
                        checkBoxPage.documentsItem_label,
                        checkBoxPage.documentsItem_checkBox,
                        checkBoxPage.documentsItemToggle_button,
                        checkBoxPage.downloadsItem_label,
                        checkBoxPage.downloadsItem_checkBox,
                        checkBoxPage.downloadsItemToggle_button
                );

        checkBoxPage.validateWebElementsAreVisible(
                checkBoxPage.expandAll_button,
                checkBoxPage.collapseAll_button
        );

        checkBoxPage
                .clickOnExpandAllButton();

        checkBoxPage.validateWebElementsAreVisible(
                checkBoxPage.homeItem_label,
                checkBoxPage.homeItem_checkBox,
                checkBoxPage.homeItemToggle_button,

                checkBoxPage.desktopItem_label,
                checkBoxPage.desktopItem_checkBox,
                checkBoxPage.desktopItemToggle_button,

                checkBoxPage.notesItem_label,
                checkBoxPage.notesItem_checkBox,
                checkBoxPage.commandsItem_label,
                checkBoxPage.commandsItem_checkBox,

                checkBoxPage.documentsItem_label,
                checkBoxPage.documentsItem_checkBox,
                checkBoxPage.documentsItemToggle_button,

                checkBoxPage.workspaceItem_label,
                checkBoxPage.workspaceItem_checkBox,
                checkBoxPage.workspaceItemToggle_button,

                checkBoxPage.reactItem_label,
                checkBoxPage.reactItem_checkBox,

                checkBoxPage.angularItem_label,
                checkBoxPage.angularItem_checkBox,

                checkBoxPage.veuItem_label,
                checkBoxPage.veuItem_checkBox,

                checkBoxPage.officeItem_label,
                checkBoxPage.officeItem_checkBox,
                checkBoxPage.officeItemToggle_button,

                checkBoxPage.publicItem_label,
                checkBoxPage.publicItem_checkBox,

                checkBoxPage.privateItem_label,
                checkBoxPage.privateItem_checkBox,

                checkBoxPage.classifiedItem_label,
                checkBoxPage.classifiedItem_checkBox,

                checkBoxPage.generalItem_label,
                checkBoxPage.generalItem_checkBox,

                checkBoxPage.downloadsItem_label,
                checkBoxPage.downloadsItem_checkBox,
                checkBoxPage.downloadsItemToggle_button,

                checkBoxPage.wordFileItem_checkBox,
                checkBoxPage.wordFileItem_checkBox,

                checkBoxPage.excelFileDocItem_label,
                checkBoxPage.excelFileDocItem_checkBox
        );

        checkBoxPage.clickOnCollapseAllButton();
        checkBoxPage.validateWebElementsAreNotVisible(
                checkBoxPage.desktopItem_label,
                checkBoxPage.desktopItem_checkBox,
                checkBoxPage.desktopItemToggle_button,

                checkBoxPage.notesItem_label,
                checkBoxPage.notesItem_checkBox,
                checkBoxPage.commandsItem_label,
                checkBoxPage.commandsItem_checkBox,

                checkBoxPage.documentsItem_label,
                checkBoxPage.documentsItem_checkBox,
                checkBoxPage.documentsItemToggle_button,

                checkBoxPage.workspaceItem_label,
                checkBoxPage.workspaceItem_checkBox,
                checkBoxPage.workspaceItemToggle_button,

                checkBoxPage.reactItem_label,
                checkBoxPage.reactItem_checkBox,

                checkBoxPage.angularItem_label,
                checkBoxPage.angularItem_checkBox,

                checkBoxPage.veuItem_label,
                checkBoxPage.veuItem_checkBox,

                checkBoxPage.officeItem_label,
                checkBoxPage.officeItem_checkBox,
                checkBoxPage.officeItemToggle_button,

                checkBoxPage.publicItem_label,
                checkBoxPage.publicItem_checkBox,

                checkBoxPage.privateItem_label,
                checkBoxPage.privateItem_checkBox,

                checkBoxPage.classifiedItem_label,
                checkBoxPage.classifiedItem_checkBox,

                checkBoxPage.generalItem_label,
                checkBoxPage.generalItem_checkBox,

                checkBoxPage.downloadsItem_label,
                checkBoxPage.downloadsItem_checkBox,
                checkBoxPage.downloadsItemToggle_button,

                checkBoxPage.wordFileItem_checkBox,
                checkBoxPage.wordFileItem_checkBox,

                checkBoxPage.excelFileDocItem_label,
                checkBoxPage.excelFileDocItem_checkBox
        );

        checkBoxPage.validateWebElementsAreVisible(
                checkBoxPage.homeItem_label,
                checkBoxPage.homeItem_checkBox,
                checkBoxPage.homeItemToggle_button
        );

    }


    @Test(description = "002. Verify the Check Box Functionality")
    public void verifyCheckBoxFunctionality() {

        CheckBoxPage checkBoxPage = new HomePage()
                .clickOnElementsTile()
                .clickOnCheckBoxButton();

        checkBoxPage.validateWebElementsAreVisible(
                checkBoxPage.homeItem_label,
                checkBoxPage.homeItem_checkBox,
                checkBoxPage.homeItemToggle_button
        );

        checkBoxPage
                .clickOnHomeToggleButton()
                .clickOnDesktopToggleButton()
                .clickOnDocumentsToggleButton()
                .clickOnWorkSpaceToggleButton()
                .clickOnOfficeToggleButton()
                .clickOnDownloadsToggleButton()
                .validateWebElementsAreVisible(
                        checkBoxPage.homeItem_label,
                        checkBoxPage.homeItem_checkBox,
                        checkBoxPage.homeItemToggle_button,

                        checkBoxPage.desktopItem_label,
                        checkBoxPage.desktopItem_checkBox,
                        checkBoxPage.desktopItemToggle_button,

                        checkBoxPage.notesItem_label,
                        checkBoxPage.notesItem_checkBox,
                        checkBoxPage.commandsItem_label,
                        checkBoxPage.commandsItem_checkBox,

                        checkBoxPage.documentsItem_label,
                        checkBoxPage.documentsItem_checkBox,
                        checkBoxPage.documentsItemToggle_button,

                        checkBoxPage.workspaceItem_label,
                        checkBoxPage.workspaceItem_checkBox,
                        checkBoxPage.workspaceItemToggle_button,

                        checkBoxPage.reactItem_label,
                        checkBoxPage.reactItem_checkBox,

                        checkBoxPage.angularItem_label,
                        checkBoxPage.angularItem_checkBox,

                        checkBoxPage.veuItem_label,
                        checkBoxPage.veuItem_checkBox,

                        checkBoxPage.officeItem_label,
                        checkBoxPage.officeItem_checkBox,
                        checkBoxPage.officeItemToggle_button,

                        checkBoxPage.publicItem_label,
                        checkBoxPage.publicItem_checkBox,

                        checkBoxPage.privateItem_label,
                        checkBoxPage.privateItem_checkBox,

                        checkBoxPage.classifiedItem_label,
                        checkBoxPage.classifiedItem_checkBox,

                        checkBoxPage.generalItem_label,
                        checkBoxPage.generalItem_checkBox,

                        checkBoxPage.downloadsItem_label,
                        checkBoxPage.downloadsItem_checkBox,
                        checkBoxPage.downloadsItemToggle_button,

                        checkBoxPage.wordFileItem_label,
                        checkBoxPage.wordFileItem_checkBox,

                        checkBoxPage.excelFileDocItem_label,
                        checkBoxPage.excelFileDocItem_checkBox
                );


        checkBoxPage
                .clickOnWordCheckBox();
        Assert.assertTrue(checkBoxPage.isWordCheckBoxChecked());
        Assert.assertEquals(checkBoxPage.getResult(), "You have selected :\n" +
                "wordFile");

        checkBoxPage
                .clickOnOfficeCheckBox();
        Assert.assertTrue(checkBoxPage.isPublicCheckBoxChecked());
        Assert.assertTrue(checkBoxPage.isPrivateCheckBoxChecked());
        Assert.assertTrue(checkBoxPage.isClassifiedCheckBoxChecked());
        Assert.assertTrue(checkBoxPage.isGeneralCheckBoxChecked());
        Assert.assertEquals(checkBoxPage.getResult(), "You have selected :\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "wordFile");

        checkBoxPage
                .clickOnOfficeCheckBox();
        Assert.assertFalse(checkBoxPage.isPublicCheckBoxChecked());
        Assert.assertFalse(checkBoxPage.isPrivateCheckBoxChecked());
        Assert.assertFalse(checkBoxPage.isClassifiedCheckBoxChecked());
        Assert.assertFalse(checkBoxPage.isGeneralCheckBoxChecked());
        Assert.assertEquals(checkBoxPage.getResult(), "You have selected :\n" +
                "wordFile");


    }


}
