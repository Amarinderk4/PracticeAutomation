package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class EditPage extends TestBase {
	
	public EditPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-firstname")
	WebElement firstNameInput;

	@FindBy(id = "input-lastname")
	WebElement lastNameInput;

	@FindBy(id = "input-email")
	WebElement emailInput;

	@FindBy(id = "input-telephone")
	WebElement telePhoneInput;

	@FindBy(css = "input[value='Continue']")
	WebElement submitBtn;

	
	@FindBy(id="input-company")
	WebElement ComNameInput;
	
//	@FindBy(name = "payment")
//	WebElement PaymentRadioOption;
//	
	@FindBy(id="input-paypal")
	WebElement paypalEmailInput;
	
	@FindBy(css = "div[class='pull-right']>input")
	WebElement affiliateContBtn;
	
	
	
	public void enterComName(String comNameInput) {
		ComNameInput.sendKeys(comNameInput);
	}

	public void enterPaypalEmail(String paypalEmail) {
		paypalEmailInput.sendKeys(paypalEmail);
		
	}
	public void contAffAccount() {
		affiliateContBtn.click();
	}
	

	
  

	public void enterFName(String name) {
		firstNameInput.sendKeys(name);
	}

	public void enterLName(String lname) {
		lastNameInput.sendKeys(lname);
	}

	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	public void enterTelephone(String number) {
		telePhoneInput.sendKeys(number);
	}

	public AccountPage clickSubmitBtn() {
		submitBtn.click();
		return new AccountPage();
	}
	public AccountPage submmitAffAccount() {
		affiliateContBtn.click();
		return new AccountPage();
	}

}


