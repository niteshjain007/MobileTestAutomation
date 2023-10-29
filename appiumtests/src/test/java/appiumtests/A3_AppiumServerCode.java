package appiumtests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class A3_AppiumServerCode {
	
	
	static AppiumDriverLocalService server;
	static AndroidDriver driver;
	
	static void setInstance() {
		
		String nodeJSMainPath = "C:\\Users\\njain\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
		String nodeExePath = "C:\\Program Files\\nodejs\\node.exe";
		String logFilePath = "C:\\Users\\njain\\eclipse-workspace\\appiumtests-main\\src\\test\\resources\\logs\\log1.txt";
		
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder
		
				.withAppiumJS(new File (nodeJSMainPath))
				.usingDriverExecutable(new File(nodeExePath))
				.usingPort(4723)
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
				.withLogFile(new File(logFilePath))
				.withIPAddress("127.0.0.1");
		server = AppiumDriverLocalService.buildService(builder);
	}
	
	static AppiumDriverLocalService getInstance() {
		
		if (server==null) {
			setInstance();
		}
		return server;
		
	}
	
	public static void startAppiumServer() {	
		getInstance().start();
		System.out.println("----------Starting Appium Server----------");
		System.out.println("URL : " + server.getUrl());
		System.out.println("is Server Running : " + server.isRunning());
	}
	
	public static void stopAppiumServer() {
		
		if (server!=null) {
			getInstance().stop();
		}
		System.out.println("----------Stopped Appium Server----------");

	}
	
	
	public void testSauceLabBasicFlow() throws InterruptedException {
		
		Thread.sleep(1000L);
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\'test-standard_user\']/android.widget.TextView")).click();
		Thread.sleep(1000L);
		
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\'test-LOGIN\']")).click();
		Thread.sleep(1000L);

		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\'test-Menu\']/android.view.ViewGroup/android.widget.ImageView")).click();
		Thread.sleep(1000L);

		driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\'test-Price\'])[1]")).click();
		Thread.sleep(1000L);

		driver.navigate().back();
	
	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		A3_AppiumServerCode.startAppiumServer();
		
		A0_UiAutomator2Options options = new A0_UiAutomator2Options();
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),
				options.getSauceLabApkOptions());
		
		A3_AppiumServerCode obj = new A3_AppiumServerCode ();
		obj.testSauceLabBasicFlow();
		
		A3_AppiumServerCode.stopAppiumServer();
		
		System.out.println("----------Run Finished----------");

	}
}
