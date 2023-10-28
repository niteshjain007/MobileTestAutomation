package org.appiumCourse.pageObjects.iOS;

import Utilities.iOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends iOSActions {
    IOSDriver driver;

    public HomePage(IOSDriver driver) {
        super(driver); //sends driver to parent class constructor
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "Alert Views")
    private WebElement alertViews;

    public AlertViewsPage selectAlertViews() {
        alertViews.click();
        return new AlertViewsPage(driver);
    }
}
