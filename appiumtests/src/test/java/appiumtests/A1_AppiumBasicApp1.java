package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class A1_AppiumBasicApp1 {

	static AndroidDriver driver;
	
	
	// App > Activity > Animation > Back to Home Page
	public void testBasicFlow() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();
		Thread.sleep(4000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Activity']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Animation']")).click();
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.navigate().back();

	}
	
	
	// Content > Assets > Read Asset > Copy Given Text > Back to Home Page
	public void testXPath() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Content']")).click();
		Thread.sleep(4000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Assets']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Read Asset']")).click();
		Thread.sleep(4000);
		driver.navigate().back();Thread.sleep(4000);
		driver.navigate().back();Thread.sleep(4000);
		driver.navigate().back();Thread.sleep(4000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Preference']")).click();
		Thread.sleep(4000);
		driver.navigate().back();
		
	}
	
	public void testClassNameLocator() {
		
		System.out.println("----------Element Name----------");
		List<WebElement> list = driver.findElements(By.className("android.widget.TextView"));
		for(WebElement ele : list) {
			if ("API_Demos".equals(ele.getText())) {
				
			} else {
				System.out.println(ele.getText());
			}
		}	
	}
	
	public void testIdAndAccessibilityId() throws InterruptedException {
		
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		Thread.sleep(2000);
		driver.navigate().back();Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("Animation")).click();Thread.sleep(2000);
		driver.navigate().back();Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("App")).click();Thread.sleep(2000);
		driver.navigate().back();Thread.sleep(2000);
		
	}
	
	public void testGetAttribute() throws InterruptedException {
		
		String name = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']"))
				.getAttribute("name");
		System.out.println(name);
		Thread.sleep(2000);
		String getText = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']"))
				.getText();
		System.out.println(getText);
		Thread.sleep(2000);
		String contentDesc = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']"))
				.getAttribute("content-desc");
		System.out.println(contentDesc);
		Thread.sleep(2000);
		String bounds = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']"))
				.getAttribute("bounds");
		System.out.println(bounds);
		
	}
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {


		A0_UiAutomator2Options options = new A0_UiAutomator2Options();
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),
				options.getAPIDemosAPKOptions());
		
		A1_AppiumBasicApp1 obj = new A1_AppiumBasicApp1 ();
		obj.testBasicFlow();
		//obj.testXPath();
		//obj.testClassNameLocator();
		//obj.testIdAndAccessibilityId();
		//obj.testGetAttribute();
		System.out.println("----------Run Finished----------");
	}

}
