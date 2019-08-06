package com.testingfoo.grid;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class SignUpTest {
	
	public AndroidDriver<MobileElement> driver;
	
	@Test
	public void test() throws MalformedURLException, InterruptedException {
		
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
	    
	    driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Sign Up')]")).click();
	    
	    driver.findElement(By.xpath("//android.widget.EditText[contains(@text, 'First Name')]")).sendKeys("Uday");
	    
	    driver.findElement(By.xpath("//android.widget.EditText[contains(@text, 'Last Name')]")).sendKeys("Seshadrri");
	    
	    driver.findElement(By.xpath("//android.widget.EditText[contains(@text, 'Email')]")).sendKeys("testuday3@maildrop.cc");
	    
	    driver.findElement(By.xpath("//android.widget.EditText[contains(@text, 'Phone Number')]")).sendKeys("0422672044");
	    
	    driver.findElement(By.xpath("//android.widget.EditText[contains(@text, 'Password')]")).sendKeys("pass1234");
	    
	    driver.findElement(By.xpath("//android.widget.EditText[contains(@text, 'Confirm Password')]")).sendKeys("pass1234");
	    	    
	    Dimension size = driver.manage().window().getSize();
	    int startx = (int)(size.width * 0.5D);
	    int starty = (int)(size.height * 0.20D);
	    int endy = (int) (size.height * 0.02D);

	    TouchAction<?> action = new TouchAction(driver);
	    action.press(PointOption.point(startx, starty)).moveTo(PointOption.point(startx, endy)).release().perform();
	    
	    driver.findElement(By.xpath("//*[contains(@text, 'Sign-Up with Email')]")).click();
	  
	    Assert.assertTrue(driver.findElement(By.id("com.kfcaus.ordering:id/icon_button_container_ll")).isDisplayed(), "Order Now Button is not displayed");
	    
	    Thread.sleep(5000);
	    
	    driver.quit();
	    
		
	}

}
