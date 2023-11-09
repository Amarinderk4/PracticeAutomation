package com.Naveenautomation.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Naveenautomation.Base.TestBase;

public class Utils extends TestBase{
	
	
	public static void takeFailedTestScreenShot(String testMethodName) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		File screenShotfFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		// -time at which it was taken.

		try {
			FileUtils.copyFile(screenShotfFile,
					new File("./FailedTestCasesScreenShot\\" + "_" + testMethodName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {

			System.out.println("................................The IO Exception is ...... " + e);
			e.printStackTrace();
		}
	}

		public static void sleep(long miliseconds) {
			try {
				Thread.sleep(miliseconds);
			} catch (InterruptedException e) {
				e.printStackTrace();
	
			}
			
		}
		
		public static String generateRandomString(int charCnt) {
			return RandomStringUtils.randomAlphabetic(charCnt);
		}
		public static String generateRandomAlphanumeric(int charCnt) {
			return RandomStringUtils.randomAlphanumeric(charCnt);
		}
			public static String generateRandomNumber(int cnt) {
				return RandomStringUtils.randomNumeric(cnt);
			}
			public static String getCurrentDateTimeStamp() {
		   return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 
			}
		}
	


