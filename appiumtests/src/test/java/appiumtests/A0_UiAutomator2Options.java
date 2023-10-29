package appiumtests;

import java.io.File;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

/*
 * As per Java-Client 8
 * Appium 2
 * 
 * adb device
 * adb shell getprop ro.build.version.release
 * adb shell dumpsys window windows | grep mFocusedApp
 * 
 */

public class A0_UiAutomator2Options {	
	
	public UiAutomator2Options getAPIDemosAPKOptions(){
		
		System.out.println("----------Started: Api Demo Apk----------");
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("builds/ApiDemos-debug.apk").getFile());
		String apkPath = file.getAbsolutePath();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options
			.setPlatformName("Android")
			.setPlatformVersion("11.0")
			
			//.setAutomationName("UiAutomator2")
			//.setDeviceName("emulator-5554")
			.setDeviceName("Android")
			
			.setAppPackage("io.appium.android.apis")
			.setAppActivity(".ApiDemos")
			
			.setApp(apkPath)
			.setNoReset(false);
		
		return options;
		
	}
	
	public UiAutomator2Options getSauceLabApkOptions(){
		
		System.out.println("----------Started: Sauce Lab Demo Apk----------");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("builds/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk").getFile());
		String apkPath = file.getAbsolutePath();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options
			.setPlatformName("Android")
			.setPlatformVersion("11.0")
			
			.setAutomationName("UiAutomator2")
			//.setDeviceName("emulator-5554")
			.setDeviceName("Android")
		
			.setAppPackage("com.swaglabsmobileapp")
			.setAppActivity(".MainActivity")
			
			.setApp(apkPath)
			.setNoReset(false);
		
		return options;
		
	}
	
	public UiAutomator2Options getWebdriverIOApkOptions(){
		
		System.out.println("----------Started: WebdriverIO Demo Apk----------");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("builds/Android-NativeDemoApp-0.4.0.apk").getFile());
		String apkPath = file.getAbsolutePath();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options
			.setPlatformName("Android")
			.setPlatformVersion("11.0")		
			
			.setAutomationName("UiAutomator2")
			//.setDeviceName("R68R9042DXV")
			.setDeviceName("emulator-5554")
			
			.setAppPackage("com.wdiodemoapp")
			.setAppActivity(".MainActivity")
			
			.setApp(apkPath)
			.setNoReset(false);
		
		return options;
		
	}
	
	
	public UiAutomator2Options getChromeOptions(){
		
		System.out.println("----------Started: Chrome Browser----------");
		
		UiAutomator2Options options = new UiAutomator2Options();
		options
			.setPlatformName("Android")
			.setPlatformVersion("11.0")
			
			.setAutomationName("UiAutomator2")
			//.setDeviceName("R68R9042DXV")
			.setDeviceName("emulator-5554")
			
			.noReset()
			
			.withBrowserName("Chrome");
			
		return options;
		
	}
	
	public UiAutomator2Options getWebdriverIOApkOptions2(){
		
		System.out.println("----------Started: WebdriverIO Demo Apk----------");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("builds/Android-NativeDemoApp-0.4.0.apk").getFile());
		String apkPath = file.getAbsolutePath();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options
			.setPlatformName("Android")
			.setPlatformVersion("11.0")
			
			.setAutomationName("UiAutomator2")
			//.setDeviceName("R68R9042DXV")
			.setDeviceName("emulator-5554")
			.setAppPackage("com.wdiodemoapp")
			.setAppActivity(".MainActivity")
			
			.setApp(apkPath)
			.setNoReset(false);
		
		return options;
		
	}
	
	
	public UiAutomator2Options smartpanelAppTest(){
		
		System.out.println("----------Started: Smartpanel Mobile Application----------");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("builds/smartpanel.apk").getFile());
		String apkPath = file.getAbsolutePath();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options
			.setPlatformName("Android")
			.setPlatformVersion("11.0")		
			
			.setAutomationName("UiAutomator2")
		//	.setDeviceName("R68R9042DXV")
			.setDeviceName("emulator-5554")
			
			.setAppPackage("com.vcsp")
			.setAppActivity("com.vitra.vitra_smart_panel_application.MainActivity")
			
			.setApp(apkPath)
			.setNoReset(false);
		
		return options;
		
	}
	
	
	
	
	
	
	
	
	


}
