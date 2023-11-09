package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class WishListpage extends TestBase {

	public WishListpage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement clickContbtn;

	public AccountPage clickContWishBtn() {
		clickContbtn.click();
		return new AccountPage();
	}
}
