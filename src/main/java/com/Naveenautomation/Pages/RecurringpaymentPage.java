package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class RecurringpaymentPage extends TestBase {
	
	public RecurringpaymentPage() {
		PageFactory.initElements(wd, this);
	}

	
	@FindBy(css="div[class='pull-right']>a")
	WebElement recurringContBtn;
	
	
	public AccountPage clickReturnLink() {
		recurringContBtn.click();
		return new AccountPage();
	}
}
