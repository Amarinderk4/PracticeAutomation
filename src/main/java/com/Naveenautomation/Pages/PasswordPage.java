package com.Naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class PasswordPage extends TestBase {
	
	public PasswordPage () {
		PageFactory.initElements(wd, this);
		
	}
	
	 @FindBy(id="input-password")
	 WebElement passwordinput;
	 
	 @FindBy(id="input-confirm")
	 WebElement confirmPasswordinput;

	 @FindBy(css  = "input[value='Continue']")
	 WebElement contBtn;
 
	 public void enterPassword(String cPassword) {
		 passwordinput.sendKeys(cPassword);
	 }
	 public void enterConfirmPassword(String confirmPassword) {
		 confirmPasswordinput.sendKeys(confirmPassword);
	 }
	 public AccountPage clickContinueBtn() {
		 contBtn.click();
		 return  new AccountPage();
		 
	 }
	 
}

