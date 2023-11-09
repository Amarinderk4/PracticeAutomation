package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class ReturnsPage extends TestBase {
	
	public ReturnsPage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement returnContBtn;
	
	public AccountPage clickReturnLink() {
		returnContBtn.click();
		return new AccountPage();
	}
	

}
