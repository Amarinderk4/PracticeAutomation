package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class TrackingPage extends TestBase {

	public TrackingPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-code")
	WebElement trackingCodeInput;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement submitTrackCode;

	public void enterTrackingCode(String code) {
		trackingCodeInput.sendKeys(code);
	}

	public AccountPage clicksubmitTrackingCode() {
		submitTrackCode.click();
		return new AccountPage();
	}

}