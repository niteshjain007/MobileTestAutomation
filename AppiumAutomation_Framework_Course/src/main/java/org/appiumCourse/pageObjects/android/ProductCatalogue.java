package org.appiumCourse.pageObjects.android;

import Utilities.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductCatalogue extends AndroidActions {
    AndroidDriver driver;

    public ProductCatalogue(AndroidDriver driver) {
        super(driver); //sends driver to parent class constructor
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCart;
    
    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartButton;

    public void addItemToCartByIndex(int index) {
        addToCart.get(index).click();
    }

    public CartPage goToCart() {
        cartButton.click(); //after this we are landing on another page - Cart page
        waitForElementToAppear("com.androidsample.generalstore:id/toolbar_title", driver);
        return new CartPage(driver);
    }
}
