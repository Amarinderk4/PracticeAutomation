package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class NewsletterPage extends TestBase {

	public NewsletterPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(xpath = "//h2[text()='Newsletter']")
	WebElement newsletterText;

	@FindBy(xpath = "//a[text()='Subscribe / unsubscribe to newsletter']")
	WebElement subscribeNewsletterPage;

	@FindBy(css = "input[type='radio']:first-of-type")
	WebElement inputsubscribe;

	@FindBy(css = "input[value='Continue']")
	WebElement submitSubcBtn;

	//public AccountPage clickSubmitContBtn(SideBarOptions selectedOption) {
		public AccountPage clickSubmitContBtn() {
		submitSubcBtn.click();
		return new AccountPage();
	}

	public String getNewsletterText() {
		return newsletterText.getText();
	}

}
