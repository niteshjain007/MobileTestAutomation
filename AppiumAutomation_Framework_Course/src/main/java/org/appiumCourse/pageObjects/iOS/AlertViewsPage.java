package org.appiumCourse.pageObjects.iOS;

import Utilities.iOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertViewsPage extends iOSActions {
    IOSDriver driver;

    public AlertViewsPage(IOSDriver driver) {
        super(driver); //sends driver to parent class constructor
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Text Entry\"`]")
    private WebElement textEntryButton;

    @iOSXCUITFindBy(iOSClassChain = "**XCUIElementTypeCell")
    private WebElement textEntryField;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement acceptPopUp;

    public void fillTextEntry(String text) {
        textEntryButton.click();
        textEntryField.sendKeys(text);
        acceptPopUp.click();
    }
}
