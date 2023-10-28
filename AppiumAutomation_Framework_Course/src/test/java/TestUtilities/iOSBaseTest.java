package TestUtilities;

import Utilities.AppiumUtilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.appiumCourse.pageObjects.iOS.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class iOSBaseTest extends AppiumUtilities {
    public IOSDriver driver;
    public AppiumDriverLocalService service;
    public HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void ConfigureAppium() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("/Users/ivansvalina/IdeaProjects/AppiumFramework/src/main/java/Resources/Data.properties");
        properties.load(fileInputStream);
        service = startAppiumService(properties.getProperty("ipAddress"),
                Integer.parseInt(properties.getProperty("port")));

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 14 Pro")
                .setPlatformVersion("16.4")
                .setApp("/Users/ivansvalina/Library/Developer/Xcode/DerivedData/UIKitCatalog-dbkrkodwvxshkvfhhivebdxpigyb/Build/Products/Debug-iphonesimulator/UIKitCatalog.app")
                .setWdaLaunchTimeout(Duration.ofSeconds(20))
                .setCapability("xcodeOrgID", "");
        options.setCapability("xcodeSigningId", "iPhone Developer");
        options.setCapability("udid", "");
        options.setCapability("updateWDABundled", "");

        driver = new IOSDriver(service.getUrl(), options);

        homePage = new HomePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        service.stop();
    }

    public void TouchAndHold(WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) element).getId());
        params.put("duration", 5);
        driver.executeScript("mobile: touchAndHold", params);
    }
}
