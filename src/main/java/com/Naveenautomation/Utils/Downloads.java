package com.Naveenautomation.Utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Naveenautomation.Base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Downloads extends TestBase {


	@BeforeMethod
	public void setup() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();

		Map<String, Object> pref = new HashMap<>();
		String value = System.getProperty("java.io.tmpdir");
		String downloadPath = System.getProperty("java.io.tmpdir");
		String val = System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator
				+ "downloadFiles";
		pref.put("download.default.directory", "C:\\Users\\Owner\\Downloads");

		option.setExperimentalOption("prefs", pref);

		wd = new ChromeDriver(option);

		wd.get("https://demoqa.com/upload-download");

		wd.manage().window().maximize();

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
   
	
	@Test
	public void validateUserCanDownloadFile() {
		wd.findElement(By.id("downloadButton")).click();

		Assert.assertTrue(isFileAvailable("sampleFile.jpeg", 60), "Downloaded document is not found");
	}

	@AfterMethod
	public void tearDown() {

		wd.close();
	}

	public boolean isFileAvailable(String fileName, int secondsToDownload) {
		try {
			Thread.sleep(secondsToDownload);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * String home = System.getProperty("user.home"); home = home + "/Downloads/";
		 */
	
		File folder = new File("C:\\Users\\kaura\\Downloads");
		
		// List the files on that folder
		File[] listOfFiles = folder.listFiles();
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				if (listOfFile.getName().contains(fileName)) {
					System.out.println(listOfFile.getName());
					listOfFile.delete();
					return true;
				}
			}
		}
		return false;
	}

}
