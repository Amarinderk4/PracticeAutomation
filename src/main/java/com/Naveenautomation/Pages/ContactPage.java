package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class ContactPage extends TestBase {

	public ContactPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-name")
	WebElement contactNameInput;

	@FindBy(id = "input-email")
	WebElement contactEmailInput;

	@FindBy(id = "input-enquiry")
	WebElement contactQueryInput;

	@FindBy(css = "div[class='pull-right']>input")
	WebElement submitContactBtn;

	@FindBy(xpath = "//div[@id='content']/descendant::p")
	WebElement contactUsSuccessMsg;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement ContactContBtn;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement registerAccountAlertText;

	public void enterName(String cName) {
		contactNameInput.sendKeys(cName);

	}

	public void enterEmail(String cEmail) {
		contactEmailInput.sendKeys(cEmail);

	}

	public void enterQuery(String query) {
		contactQueryInput.sendKeys(query);

	}

	public void submitContactBtn() {
		submitContactBtn.click();
	}

	public void clickContactContBtn() {
		ContactContBtn.click();
	}

	public String getContactUsSuccessMessage() {
		return contactUsSuccessMsg.getText();
	}
	
	public String getContactExistAlert() {
		return registerAccountAlertText.getText();
	}

	public HomePage clickContactUsSubmitBtn() {
		submitContactBtn.click();
		ContactContBtn.click();
		return new HomePage();

	}

}
