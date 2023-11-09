package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class RegisterPage extends TestBase {

	public RegisterPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-firstname")
	WebElement registerFirstName;

	@FindBy(id = "input-lastname")
	WebElement registerLasttName;

	@FindBy(id = "input-email")
	WebElement registerEmail;

	@FindBy(id = "input-telephone")
	WebElement registerTelephone;

	@FindBy(id = "input-password")
	WebElement registerpassword;

	@FindBy(id = "input-confirm")
	WebElement registerConfirmPwd;

	@FindBy(name = "agree")
	WebElement registerCheckBox;

	@FindBy(css = "input[type='submit']")
	WebElement continueRegisterAccount;

	@FindBy(xpath = "//div[@id='content']/descendant::p")
	WebElement AccountCreatedText;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alreadyRegisterAccount;

	public void enterRegNameInput(String rFirstname) {
		registerFirstName.sendKeys(rFirstname);

	}

	public void enterRegLastNameInput(String rLastname) {
		registerLasttName.sendKeys(rLastname);
	}

	public void enterRegEmail(String rEmail) {
		registerEmail.sendKeys(rEmail);
	}

	public void enterRegTelephone(String rNumber) {
		registerTelephone.sendKeys(rNumber);

	}

	public void enterRegPassword(String rPassword) {
		registerpassword.sendKeys(rPassword);
	}

	public void enterRegConfirmPassword(String cConfirmPassword) {
		registerConfirmPwd.sendKeys(cConfirmPassword);
	}

	public void selectAgreeOption() {
		registerCheckBox.click();
	}

	public String getResisteraccountCreated() {
		return AccountCreatedText.getText();
	}

	public String getAlreadyRegisterAlert() {
		return alreadyRegisterAccount.getText();
	}

	public AccountPage clickRegisterAccount() {
		registerCheckBox.click();
		continueRegisterAccount.click();
		return new AccountPage();

	}
}