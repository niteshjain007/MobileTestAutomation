package TestUtilities;

import Utilities.AppiumUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.appiumCourse.pageObjects.android.FormPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class AndroidBaseTest extends AppiumUtilities {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public FormPage formPage;


    @BeforeClass(alwaysRun = true)
    public void ConfigureAppium() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/Resources/Data.properties");
        properties.load(fileInputStream);
        service = startAppiumService(properties.getProperty("ipAddress"),
                Integer.parseInt(properties.getProperty("port"))); //ipAddress and port are saved in the global properties file Data.properties

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName(properties.getProperty("AndroidDeviceName"))
                .setPlatformName("Android")
                .setPlatformVersion("11")
                .setApp("src/test/java/Resources/General-Store.apk")
                .autoGrantPermissions()
                .setAutomationName("UIAutomator2");

        driver = new AndroidDriver(service.getUrl(), options);
        formPage = new FormPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
