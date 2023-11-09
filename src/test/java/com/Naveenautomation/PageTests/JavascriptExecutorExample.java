package com.Naveenautomation.PageTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorExample {
	 WebDriver wd;
	 JavascriptExecutor jse;
	 RemoteWebDriver rwd;
	 
	 public void setUp() {
		 wd=WebDriverManager.chromedriver().create();
		 wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		 wd.manage().window().maximize();
		 wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 jse=(JavascriptExecutor) wd;
	 }
	 
	 
     @Test
	 public void sendKeysUsingJavascrExec() {
		 jse.executeScript("arguments[0].value='amarinderk4@gmail.com'" ,wd.findElement(By.id("input-email")));
		  
	 }
@Test
public void clickUsingJavascriptExecutor() {
	jse.executeScript("arguments[0].value='Amarinderk4@gmail.com':" ,wd.findElement(By.id("input-email")));
	jse.executeScript("arguments[0].value='shop1234':" ,wd.findElement(By.id("input-password")));
	jse.executeScript("agruments[0].click()", wd.findElement(By.cssSelector("input[type='submit']")));
	
}
@Test
public void scrollUsingjavaScritExecutor() {
	jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	
}
//jsExecutor.executeScript("arguments[0].value='testuser'", userNameTxt); 
}
