package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-email")
	WebElement emailInput;

	@FindBy(id = "input-password")
	WebElement pwdInput;

	@FindBy(css = "input[type='Submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement contRegiterBtn;

	@FindBy(css = ".alert-danger")
	WebElement alertBanner;

	@FindBy(xpath = "//a[text()='Forgotten Password']")
	WebElement forgotPwdLink;

	@FindBy(xpath = "//a[text()='Contact Us']")
	WebElement contactUsLink;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement contactUsBtn;

	@FindBy(css = "class='alert alert-danger alert-dismissible']")
	WebElement emailWarningInput;

	@FindBy(css = "input[value='Continue']")
	WebElement submitEmailBtn;

	@FindBy(css = "div.alert-success")
	WebElement accountForgotPwdSuccessMsg;
//	// Success:An email with a confirmation link has been sent your email address.
	@FindBy(css = "alert-danger")
	WebElement accountAlertBanner;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	WebElement emailPasswordNotMatchingWarning;

	@FindBy(xpath = "//p[text()='Your enquiry has been successfully sent to the store owner!']")
	WebElement contactUsSuccessMsg;

	@FindBy(xpath = "//a[text()='Gift Certificates']")
	WebElement clickGiftCertificates;

	public String clickEmailWarning() {
		return emailWarningInput.getText();
	}

	public ContactPage clickContactUsLink() {
		contactUsLink.click();

		return new ContactPage();
	}

	private void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	public void clickGiftCertificatesLink() {
		clickGiftCertificates.click();
	}

	private void enterPassword(String password) {
		pwdInput.sendKeys(password);
	}

	public AccountPage SubmitLogin(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		loginBtn.click();
		return new AccountPage();
	}

	public RegisterPage submitRegisteraccount() {
		contRegiterBtn.click();
		return new RegisterPage();

	}

	public ContactPage submitContactUsForm() {
		return new ContactPage();
	}

	public String getAlertText() {
		return alertBanner.getText();
	}

	public void enterEmailInput(String email1) {
		emailInput.sendKeys(email1);
	}

	public ForgotPwdLinkPage clickForgotPwdLink() {
		forgotPwdLink.click();
		return new ForgotPwdLinkPage();

	}

	public ForgotPwdLinkPage clicktEmailSubmitBtn(String email) {
		forgotPwdLink.click();
		enterEmailInput(email);
		return new ForgotPwdLinkPage();

	}

	public String getclickForgotPwdLinkText() {
		return accountAlertBanner.getText();

	}

	public String getPasswordChangeSuccessMessage() {
		return accountForgotPwdSuccessMsg.getText();
	}

	public String retrieveEmailPasswordNotMatchingWarningMessageText() {

		return emailPasswordNotMatchingWarning.getText();
	}

}
