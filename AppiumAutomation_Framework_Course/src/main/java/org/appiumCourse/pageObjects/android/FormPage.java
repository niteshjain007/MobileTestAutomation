package org.appiumCourse.pageObjects.android;

import Utilities.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormPage extends AndroidActions {
    AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
        super(driver); //sends driver to parent class constructor
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;
    
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleOption;
    
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleOption;
    
    
    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement countryField;
    
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;
    
    @AndroidFindBy(xpath = "//android.widget.Toast")
    private List<WebElement> errorToasts;

    public void waitForSplashScreen() {
        waitForElementToAppear("com.androidsample.generalstore:id/toolbar_title", driver);
    }

    public void setNameField(String name) {
        nameField.sendKeys(name);
    }

    public void setGender(String gender) {
        if (gender.toLowerCase().contains("female")) { //bringing in causality?
            femaleOption.click();
        } else maleOption.click();
    }

    public void setCountry(String countryName) {
        countryField.click();
        scrollToText(countryName);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='%s']".formatted(countryName))).click(); //country name is dynamically changed so it isn't extracted into its own web element property
    }

    public ProductCatalogue submitForm() {
        shopButton.click(); // landing on another page after this
        waitForElementToAppear("com.androidsample.generalstore:id/toolbar_title", driver);
        return new ProductCatalogue(driver);
    }

    public boolean isErrorToastDisplayed() {
        return !errorToasts.isEmpty();
    }

    public void setActivity() {
        Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.SplashActivity"); //cannot use main activity to start because permission error is thrown
       // driver.startActivity(activity);
    }
}
