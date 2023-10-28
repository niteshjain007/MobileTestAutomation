package org.appiumCourse;

import TestUtilities.AndroidBaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.appiumCourse.pageObjects.android.CartPage;
import org.appiumCourse.pageObjects.android.ProductCatalogue;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AndroidPracticeTestCase extends AndroidBaseTest {
    @Test(groups = {"Smoke"})
    public void PurchaseItems() {
        formPage.waitForSplashScreen();

        formPage.setCountry("China");
        formPage.setNameField("gfg");
        formPage.setGender("male");
        ProductCatalogue productCatalogue = formPage.submitForm();

        productCatalogue.addItemToCartByIndex(0);
        productCatalogue.addItemToCartByIndex(0); //after adding the first element only one has the tag "ADD TO CART"
        CartPage cartPage = productCatalogue.goToCart();

        cartPage.checkCartAmount();
        cartPage.acceptTermsAndConditions();
        cartPage.completePurchase();
    }
}
