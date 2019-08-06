package com.testingfoo.grid;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FirstTest {
	
	public AndroidDriver<MobileElement> driver;
	
	@Test
	public void test() throws MalformedURLException {
		
		File file = new File(System.getProperty("user.dir")+"//src//main//resources//com.kfcaus.ordering_2019-06-23.apk");
		
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("platformName", "Android");
	    caps.setCapability("deviceName", "dfa3b957");
	    caps.setCapability("platformVersion", "9");
	    caps.setCapability("automationName", "UiAutomator2");
	    caps.setCapability("app", file.getAbsolutePath());
	    caps.setCapability("noReset", "true");
	    caps.setCapability("autoGrantPermissions", "true");
	    
	    
	    driver=new AndroidDriver<MobileElement>(new URL("http:/0.0.0.0:4723/wd/hub"), caps);
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    driver.findElementByAccessibilityId("open navigation menu").click();

	    driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Log')]")).click();
	    
	    driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Log In')]")).click();
	    
	    driver.findElement(By.xpath("//android.widget.EditText[contains(@text, 'Email')]")).sendKeys("testuday@maildrop.cc");
	    
	    driver.findElement(By.xpath("//android.widget.EditText[contains(@text, 'Password')]")).sendKeys("pass1234");
	    
	    driver.findElement(By.xpath("//*[contains(@text, 'Log In')]")).click();
	  
	    Assert.assertTrue(driver.findElement(By.id("com.kfcaus.ordering:id/icon_button_container_ll")).isDisplayed(), "Order Now Button is not displayed");
	    
	    driver.quit();
	    
		
	}

}
