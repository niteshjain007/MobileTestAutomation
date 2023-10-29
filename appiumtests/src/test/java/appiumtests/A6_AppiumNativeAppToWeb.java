package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class A6_AppiumNativeAppToWeb {
	
	static AndroidDriver driver;
	
	public static void nativeToWebToNative() throws InterruptedException {
		
		System.out.println("Current Context: "+driver.getContext());
		System.out.println("Current Handles: "+driver.getContextHandles());
		System.out.println("Go to WebView");
		Thread.sleep(3000);
		driver.findElement(AppiumBy.accessibilityId("Webview"));
		Thread.sleep(5000);
		System.out.println("Current Handles: "+driver.getContextHandles());
		
		//Get all available context - [NATIVE_APP, WEBVİEW_com.wdiodemoapp]
		Set<String> handles = driver.getContextHandles();
		String webContext = new ArrayList<String>(handles).get(0);
		System.out.println("Fetch WebContext: "+webContext);
		
		//Native to WebView
		driver.context(webContext);
		System.out.println("Current Context: "+webContext);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[class='navbar__toggle clean-btn']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[aria-label='Close navigation bar']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[class='buttons_pzb0'] [href='/docs/gettingstarted]")).click();
		Thread.sleep(1000);
		
		//WebView to Native
		driver.context(webContext);
		driver.findElement(AppiumBy.accessibilityId("Login")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("input-email")).sendKeys("abcde@gmail.com");
		Thread.sleep(2000);
		
	}
	
	

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		
		System.out.println("-----------Run Started------------");
		
		//Initialize Driver
		//AppOptions option = new AppOptions;
		//AppFactory.androidLaunchApp(option.getOptions("app3"));
		
		A0_UiAutomator2Options options = new A0_UiAutomator2Options();
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),
				options.getWebdriverIOApkOptions2());
		
		//Android Driver
		A6_AppiumNativeAppToWeb obj = new A6_AppiumNativeAppToWeb();
		
		//method
		obj.nativeToWebToNative();
		
		System.out.println("-----------Run Finished------------");
		

	}

}
