package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class RewardPage extends TestBase {

	public RewardPage() {
		PageFactory.initElements(wd, this);
	}

	
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement submitRewardBtn;
	
	
	public AccountPage clickSubmitRewardBtn() {
		
		submitRewardBtn.click();
		return new AccountPage();

	}

}
