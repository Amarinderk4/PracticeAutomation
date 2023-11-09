package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(wd, this);
	}
	@FindBy(xpath = ("//a[text()='Contact Us']"))
	WebElement contactUsLink;
	
	@FindBy(name = "search")
	WebElement searchTextBox;

	@FindBy(xpath = "//div[@id='search']/descendant::button")
	WebElement searchBtn;
	
	
	
	
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement ContactContBtn;
	
	

	public void enterProductNameToSearchField(String productText) {
		searchTextBox.sendKeys(productText);
	}

	public SearchPage clickOnSearchButton() {

		searchBtn.click();
		return new SearchPage();

	}
	
	
	
public SearchPage searchForAProduct(String productText) {
		
	searchTextBox.sendKeys(productText);
	searchBtn.click();
		return new SearchPage();
}


}


