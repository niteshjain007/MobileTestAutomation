package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.Immutable;

import io.appium.java_client.android.AndroidDriver;

public class A4_AppiumLongPress {
	
	static AndroidDriver driver;
	
	public static void longPress(WebElement ele) {
		
		Point location = ele.getLocation();
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger"); //finger can be any name, unique id
		Sequence sequence = new Sequence(input, 0);
		sequence.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x, location.y));
		sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		sequence.addAction(input.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), location.x, location.y));
		sequence.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(ImmutableList.of(sequence));
		
	}
	
	public static void testlongPress() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'Views\']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'Expandable Lists\']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'1. Custom Adapter\']")).click();
		
		WebElement dogNames = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ExpandableListView/android.widget.TextView[2]"));
		longPress(dogNames);
		Thread.sleep(3000);
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().back();
		
		
	}
	

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		System.out.println("----------Run Started----------");
		
		A0_UiAutomator2Options options = new A0_UiAutomator2Options();
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),
				options.getAPIDemosAPKOptions());
		
		testlongPress();
		
		System.out.println("----------Run Finished----------");		
			
	}

}
