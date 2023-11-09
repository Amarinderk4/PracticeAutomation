package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class ForgotPwdLinkPage extends TestBase {

	public ForgotPwdLinkPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//h1[text()='Forgot Your Password?']")
	WebElement accountforgotPwdText;

	
	@FindBy(id="input-email")
	WebElement emailInput;
	
	@FindBy(css = "input[value='Continue']")
	WebElement submitEmailBtn;

	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}
	
	public LoginPage clickForgotLink() {
		submitEmailBtn.click();
		return new LoginPage();
	}
	
}
