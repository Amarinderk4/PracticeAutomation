package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class SearchPage extends TestBase {

	public SearchPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//a[text()='HP LP3065']")
	WebElement validHpProduct;

	public boolean displayHpProduct() {
		return validHpProduct.isDisplayed();

	}
	public HomePage clickSearchBtn() {
		return new HomePage();
	}
}
