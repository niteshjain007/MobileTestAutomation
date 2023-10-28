package org.appiumCourse.pageObjects.android;

import Utilities.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import java.util.List;

public class CartPage extends AndroidActions {
    AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        super(driver); //sends driver to parent class constructor
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productPrices;
    
    
    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement cartTotalAmount;
    @AndroidFindBy(xpath = "//android.widget.CheckBox")
    
    private WebElement checkBox;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement completePurchaseButton;

    public void checkCartAmount() {
        double calculatedPrice = 0.0;
        for (WebElement price : productPrices) {
            calculatedPrice += getFormattedAmount(price.getText());
        }
        Assert.assertEquals(getTotalAmount(), calculatedPrice);
    }

    public double getTotalAmount() {
        return getFormattedAmount(cartTotalAmount.getText());
    }

    public void acceptTermsAndConditions() {
        checkBox.click();
    }

    public void completePurchase() {
        completePurchaseButton.click();
    }
}
