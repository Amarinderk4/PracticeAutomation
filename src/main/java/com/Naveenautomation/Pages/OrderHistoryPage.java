package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class OrderHistoryPage extends TestBase{
	
	public OrderHistoryPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueOrderBtn;
	
	@FindBy(xpath = "//p[text()='You have not made any previous orders!']")
	WebElement orderHistorySuccessMessage;
	
	@FindBy(css = "div[id='content']>h1")
	WebElement orderHistoryText;
	
	
	public String getOrderHistoryText() {
		return orderHistorySuccessMessage.getText();
			
		}
	public String getOrderHistoryTextMsg() {
		return orderHistoryText.getText();
	}
	public AccountPage clickOrderHistorySubmitBtn() {
		continueOrderBtn.click();
		return new AccountPage();
	}
	
}
