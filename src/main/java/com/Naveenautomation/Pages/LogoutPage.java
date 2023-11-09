
package com.Naveenautomation.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class LogoutPage extends TestBase {

	public LogoutPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//h1[text()='Account Logout']")
	WebElement accountLogoutText;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement submitLogout;

	public String getAccountLogoutText() {
		return accountLogoutText.getText();

	}

	public AccountPage clickLogoutAccount() {

		submitLogout.click();
		return new AccountPage();
	}

}
