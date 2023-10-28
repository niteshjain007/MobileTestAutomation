package org.appiumCourse;

import TestUtilities.AndroidBaseTest;
import org.appiumCourse.pageObjects.android.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ToastMessageTest extends AndroidBaseTest {

    @Test(groups = {"Smoke"})
    public void SubmitIncompleteForm() {
        formPage.waitForSplashScreen();
        formPage.setCountry("Argentina");
        formPage.submitForm();
        Assert.assertTrue(formPage.isErrorToastDisplayed());
    }

    @Test(dataProvider = "getData")
    public void FillFormWithCorrectCredentials(String country, String name, String gender) {
        formPage.waitForSplashScreen();
        formPage.setCountry(country);
        formPage.setNameField(name);
        formPage.setGender(gender);
        ProductCatalogue productCatalogue = formPage.submitForm();
        productCatalogue.waitForElementToAppear("com.androidsample.generalstore:id/toolbar_title", driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void preSetup() {
        formPage.setActivity();
    }

    @DataProvider
    public Object[][] getData() {
       // you can write code to get data from json 
    	return new Object[][]{{"Argentina", "Leo Messi", "male"}, {"Portugal", "Cristiano Ronaldo", "male"}};
    }
}
