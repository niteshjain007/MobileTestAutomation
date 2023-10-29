package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class A2_AppiumBasicsApp2 {
	
	static AndroidDriver driver;
	
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
		
		A0_UiAutomator2Options options = new A0_UiAutomator2Options();
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),
				options.getSauceLabApkOptions());
		
		A2_AppiumBasicsApp2 obj = new A2_AppiumBasicsApp2 ();
		obj.testSauceLabBasicFlow();
		
		System.out.println("----------Run Finished----------");

	}

}
