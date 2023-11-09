package com.Naveenautomation.Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import com.Naveenautomation.Browsers.Browser;
import com.Naveenautomation.Environment.Environment;
import com.Naveenautomation.Utils.WebdriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver wd;

	private final Browser DEFAULT_BROWSER = Browser.CHROME;
	private final Environment URL = Environment.PROD;
	private static final boolean RUN_ON_GRID = false;

	
	public static Logger logger;
	public WebdriverEvents events;
	public EventFiringWebDriver e_driver;

	@BeforeClass
	public void loggerSetUp() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
	}

	public void intialization() {
		
		switch (DEFAULT_BROWSER) {
		case CHROME:
			wd = WebDriverManager.chromedriver().create();
			break;
		case EDGE:
			wd = WebDriverManager.edgedriver().create();
			break;
		case FIREFOX:
			wd = WebDriverManager.firefoxdriver().create();
			break;
		default:
			throw new IllegalArgumentException();
			
		}	
			if(RUN_ON_GRID) {
				try {
					wd=new RemoteWebDriver(new URL ("http://172.16.1.180:4444"),getOptions());
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			} else {

				switch (DEFAULT_BROWSER) {
				case CHROME:
					wd = WebDriverManager.chromedriver().create();
					break;
				case EDGE:
					wd = WebDriverManager.edgedriver().create();
					break;
				case FIREFOX:
					wd = WebDriverManager.firefoxdriver().create();
					break;
				default:
					System.out.println("Not a valid browser name");
					break;
				}
			}

		
		e_driver = new EventFiringWebDriver(wd); // wrapping the web driver to e_driver

		events = new WebdriverEvents();

		e_driver.register(events); // events which needs to be captured

		wd = e_driver;// whatever values u find from these 2 above events give it back to
						// webdriver.Assigning back the values to webDriver

		wd.get(URL.getUrl());

		wd.manage().window().maximize();

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	public MutableCapabilities getOptions() {
		return new ManageOptions().getOption(DEFAULT_BROWSER);
		
	}
	public void tearDown() {
		wd.quit();
	}

	
}