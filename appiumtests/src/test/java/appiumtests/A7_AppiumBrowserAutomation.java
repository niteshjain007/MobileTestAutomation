package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class A7_AppiumBrowserAutomation {
	
	static AppiumDriver driver;
	
	public static void testLogin() throws Exception {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(4000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		//String att = driver.findElement(By.xpath("//button[@type='submit']")).getAttribute("type");
		//System.out.println(att);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']")).click();
	}

	public static void main(String[] args) throws Exception {
		
		System.out.println("----------Run Started----------");
		
		A0_UiAutomator2Options options = new A0_UiAutomator2Options();
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),
				options.getChromeOptions());
		
		testLogin();
		
		System.out.println("----------Run Finished----------");	
		
	}

}
