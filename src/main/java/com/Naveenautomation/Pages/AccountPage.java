package com.Naveenautomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naveenautomation.Base.TestBase;

public class AccountPage extends TestBase {

	public AccountPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#content>h2:first-of-type")
	WebElement myAccountText;

	@FindBy(css = "div.alert-success")
	WebElement acccountInfoUpdateSuccessMessage;// edit account

	// Success: Your account has been successfully updated.

	@FindBy(xpath = "//a[text()='Edit your account information']")
	WebElement editYourInfoLink;

	@FindBy(xpath = "//a[text()='Change your password']")
	WebElement accountPassword;

	@FindBy(xpath = "//a[text()='Subscribe / unsubscribe to newsletter']")
	WebElement subscribePage;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement registerAccount;

	@FindBy(xpath = "//a[text()='Custom Affiliate Tracking Code']")
	WebElement clickCustomTrackCodeLink;

	@FindBy(xpath = "//a[text()='Modify your wish list']")
	WebElement wishListLink;

	@FindBy(css = "div[class='list-group']>a:nth-of-type(10)")
	WebElement returnBtn;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement accountLogout;

	@FindBy(css = "input[type='submit']")
	WebElement affiliateContBtn;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement submitLogout;

	@FindBy(css = "div.alert-success ")
	WebElement accountChangePasswordSuccessMessage;

	@FindBy(css = "div.alert-success ")
	WebElement accountNewsletterSuccessMessage;

	@FindBy(xpath = "//p[text()='Your wish list is empty.']")
	WebElement accountWishListMessage;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement accountNewsletterSubmitBtn;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement clickContWishBtn;

	@FindBy(xpath = "//h2[text()='Account Downloads']')")
	WebElement accountDownloadText;

	@FindBy(css = "div[id='content']>h1")
	WebElement YourTransactionText;

	@FindBy(css = "div[class='list-group']>a:nth-of-type(9)")
	WebElement rewardsPointLink;

	@FindBy(xpath = "//a[text()='Edit your affiliate information']")
	WebElement affiliateAccountEditLink;

	@FindBy(xpath = "//a[text()='View your order history']")
	WebElement orderHistoryLink;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement submitRewardBtn1;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueOrderBtn;

	@FindBy(css = "div[class='pull-right']>a")
	WebElement recurringContBtn;

	@FindBy(css = "div[class='list-group']>a:nth-of-type(11)")
	WebElement clickTranscontBtn;

	@FindBy(css = "ul[class='list-unstyled']>li:nth-of-type(6)>a")
	WebElement recurringPaymentLink;

	@FindBy(xpath = "//td[text()='You do not have any reward points!']")
	WebElement pointsEarnMessage;

	@FindBy(css = "div[class='list-group']>a:nth-of-type(7)")
	WebElement clickDownloadLink;

	@FindBy(css = "div[class='list-group']>a:nth-of-type(11)")
	WebElement clikTransactionLInk;

	@FindBy(css = "div[class='alert alert-success alert-dismissible']")
	WebElement affilaiteSuccessMsg;

	public void selectSideBarOptions(SideBarOptions selectedOption) {

		List<WebElement> sideNavigationBar = wd.findElements(By.cssSelector("div.list-group>a"));
		for (int i = 0; i < sideNavigationBar.size(); i++) {
			if (sideNavigationBar.get(i).getText().equals(selectedOption.getsideNavigationBarOptions())) {
				sideNavigationBar.get(i).click();
				break;
			}
		}

	}

	
	public NewsletterPage clickNewsletterPage() {
		return new NewsletterPage();

	}

	public DownloadPage clickDownloadLink(SideBarOptions selectedOption) {
		selectSideBarOptions(selectedOption);
		return new DownloadPage();
	}

	public String getMyAccountText() {
		return myAccountText.getText();
	}

	public EditPage clickEditInfoLink() {
		editYourInfoLink.click();
		return new EditPage();
	}

	public TrackingPage clickCustomTrackingCodeLink() {
		clickCustomTrackCodeLink.click();
		return new TrackingPage();

	}

	public EditPage clickregisterAffiliateAccountLink() {
		affiliateAccountEditLink.click();
		return new EditPage();
	}

	public String getSuccessMessage() {
		return acccountInfoUpdateSuccessMessage.getText();
	}

	public RecurringpaymentPage clickRecurringPaymentLink(SideBarOptions selectedOption) {
		selectSideBarOptions(selectedOption);
		return new RecurringpaymentPage();
	}

	public PasswordPage clickChangePasswordLink() {
		accountPassword.click();
		return new PasswordPage();
	}

	public String getPasswordSuccessMessage() {
		return accountChangePasswordSuccessMessage.getText();

	}

	public NewsletterPage clickSubscribeBtn() {
		subscribePage.click();
		return new NewsletterPage();

	}

	public WishListpage clickWishListLink() {
		wishListLink.click();
		return new WishListpage();
	}

	public ReturnsPage clickReturnsBtn() {
		returnBtn.click();
		return new ReturnsPage();

	}

	public RewardPage clickRewardpointsLink() {

		rewardsPointLink.click();
		return new RewardPage();

	}

	public void clickOrderHistory() {
		orderHistoryLink.click();
	}

	public OrderHistoryPage clickOrderHistoryLink() {
		orderHistoryLink.click();
		return new OrderHistoryPage();
	}

	public String getNewsletterSubscSuccessMessage() {
		return accountNewsletterSuccessMessage.getText();
	}

	public String getWishListMessage() {
		return accountWishListMessage.getText();
	}

	public String getRewardpointsSuccessMessage() {
		return pointsEarnMessage.getText();
	}

	public LogoutPage clickLogoutBtn() {
		List<WebElement> listOfElements = wd.findElements(By.cssSelector("#column-right>div>a"));
		for (int i = 0; i < listOfElements.size(); i++) {
			if (listOfElements.get(i).getText().equals("Logout")) {
				listOfElements.get(i).click();
				break;

			}
		}
		return new LogoutPage();

	}

	public LogoutPage getAccountLogoutSuccessMessage() {
		accountLogout.click();
		return new LogoutPage();
	}

	public RegisterPage getRegisterAccountMsg() {
		registerAccount.click();
		return new RegisterPage();
	}

	public String downloadsTextMsg() {
		return accountDownloadText.getText();
	}

	public String getAffiliateText() {
		return affilaiteSuccessMsg.getText();

	}

}
