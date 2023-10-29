package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.google.common.collect.ImmutableList;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class SmartpanelAppTest_1 {
	
	static AppiumDriver driver;
	
	public static void swipe(Point start, Point end, Duration duration) {
		
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1"); //finger1 can be any name, unique id
		Sequence swipe = new Sequence(input, 0);
		swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
		swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
		swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(ImmutableList.of(swipe));
		
	}
	
	/*
	 * If scrollRatio = 0.8 then page will scroll fast
	 * If scrollRatio = 0.2 then page will scroll very less
	 * 
	 * If user want to scroll page in DOWN direction
	 * Then scroll mobile screen starting from Bottom to Top 
	 * 
	 * If user want to scroll page in RIGHT direction
	 * Then scroll mobile screen starting from Right to Left
	 */
	
	
	public static void scroll(String pageDirection, double scrollRatio) {
		
		Duration SCROLL_DUR = Duration.ofMillis(300);
		if (scrollRatio<0 || scrollRatio>1) {
			throw new Error("Scroll Distance Must Be Between 0 And 1");
		}
		
		Dimension size = driver.manage().window().getSize();
		System.out.println("Screen Size = "+size);
		System.out.println("--------------------------");
		
		Point midPoint = new Point((int)(size.width * 0.5),(int)(size.height * 0.5));
		
		int a = (int)(midPoint.x * scrollRatio);
		int b = (int)(midPoint.y * scrollRatio);
		
		int bottom = (int)midPoint.y + b;
		int top = (int)midPoint.y - b;
		int right = (int)midPoint.x + a;
		int left = (int)midPoint.x - a;
		
		System.out.println("Midpoint : "+midPoint);
		
		System.out.println("Midpoint x : "+midPoint.x);
		System.out.println("a : "+a);
		
		System.out.println("Midpoint y : "+midPoint.y);
		System.out.println("b : "+b);
		
		System.out.println("---------------------------");
		System.out.println("Bottom : "+bottom);
		System.out.println("Top : "+top);
		System.out.println("Right : "+right);
		System.out.println("Left : "+left);
		System.out.println("---------------------------");
		
		if (pageDirection == "UP") {	
			//Swipe Top to Bottom, Page Will Go Up
			swipe(new Point(midPoint.x, top),new Point(midPoint.x, bottom),SCROLL_DUR);
		}else if (pageDirection == "DOWN") {
			swipe(new Point(midPoint.x, bottom),new Point(midPoint.x, top),SCROLL_DUR);
		}else if (pageDirection == "LEFT") {
			swipe(new Point(left,midPoint.y),new Point(right,midPoint.y),SCROLL_DUR);			
		}else {
			swipe(new Point(right,midPoint.y),new Point(left,midPoint.y),SCROLL_DUR);			
		}	
	}
	
	
	public void swipeMe() throws InterruptedException {
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='V-Care Smart Panel Adapting Flush System by VitrA']")).click();
		//Thread.sleep(4000);
		//Move Page Towards Right
		scroll("RIGHT", 0.5);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Smarter Data Let Smart Panel make optimum decisions for you.']")).click();
		scroll("RIGHT", 0.5);
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='Sign In']")).click();
		Thread.sleep(4000);
		

	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.out.println("----------Run Started----------");
		
		A0_UiAutomator2Options options = new A0_UiAutomator2Options();
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),
				options.smartpanelAppTest());
		
		SmartpanelAppTest_1 obj = new SmartpanelAppTest_1();
		obj.swipeMe();
		
				
		System.out.println("----------Run Finished----------");	

	}

}
