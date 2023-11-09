package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class DownloadPage extends TestBase{
	
	public DownloadPage() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css = "div[id='content']>h2")
	WebElement accountDownloadText;
	
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement downloadContBtn;
	
	public AccountPage clickDownloadcontBtn() {
		downloadContBtn.click();
		return new AccountPage();
		
	}

	public  String downloadsTextMsg() {
		return accountDownloadText.getText();
		
	}

}
