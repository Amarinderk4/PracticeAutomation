package com.Naveenautomation.PageTests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Naveenautomation.Base.TestBase;
import com.Naveenautomation.Pages.AccountPage;
import com.Naveenautomation.Pages.DownloadPage;
import com.Naveenautomation.Pages.EditPage;
import com.Naveenautomation.Pages.LoginPage;
import com.Naveenautomation.Pages.NewsletterPage;
import com.Naveenautomation.Pages.OrderHistoryPage;
import com.Naveenautomation.Pages.PasswordPage;
import com.Naveenautomation.Pages.RecurringpaymentPage;
import com.Naveenautomation.Pages.RegisterPage;
import com.Naveenautomation.Pages.ReturnsPage;
import com.Naveenautomation.Pages.RewardPage;
import com.Naveenautomation.Pages.SideBarOptions;
import com.Naveenautomation.Pages.TrackingPage;
import com.Naveenautomation.Pages.WishListpage;

public class AccountPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	EditPage editPage;
	PasswordPage passwordPage;
	NewsletterPage newsletterPage;
	RewardPage rewardPage;
	ReturnsPage returnPage;
	RecurringpaymentPage recurringPaymentPage;
	DownloadPage downloadPage;
	OrderHistoryPage orderHistoryPage;
	WishListpage wishListPage;
	RegisterPage registerpage;
	TrackingPage trackingPage;

	@BeforeMethod
	public void launch() {
		intialization();
		loginPage = new LoginPage();

	}

	@Test
	public void validateUserCanUpdatePersonalInfo() {
		accountPage = loginPage.SubmitLogin("Amarinderk4@gmail.com", "shop1234");
		editPage = accountPage.clickEditInfoLink();
		editPage.enterFName("Aman");
        accountPage = editPage.clickSubmitBtn();
		Assert.assertEquals(accountPage.getSuccessMessage(), "Success: Your account has been successfully updated.",
				"Info not updated");
	}

	@Test
	public void validateUserCanChangepassword() {
		accountPage = loginPage.SubmitLogin("amarinderk4@gmail.com", "shop1234");
		passwordPage = accountPage.clickChangePasswordLink();
		passwordPage.enterPassword("shop1234");
		passwordPage.enterConfirmPassword("shop1234");
		accountPage = passwordPage.clickContinueBtn();
		Assert.assertEquals(accountPage.getPasswordSuccessMessage(),
				"Success: Your password has been successfully updated.", "Password not changed");
	}

	@Test
	public void validateUserCanRegisterNewAccount() {
		registerpage = loginPage.submitRegisteraccount();
		registerpage.enterRegNameInput("Ramann");
		registerpage.enterRegLastNameInput("Kaur");
		registerpage.enterRegEmail("amrit76@gmail.com");
		registerpage.enterRegTelephone("9678893222");
		registerpage.enterRegPassword("123412");
		registerpage.enterRegConfirmPassword("123412");
		accountPage = registerpage.clickRegisterAccount();
		Assert.assertEquals(registerpage.getResisteraccountCreated(),
				"Congratulations! Your new account has been successfully created!", "user not able to register");
	}

	@Test
	public void ValidateUserForExisingAccount() {
		registerpage = loginPage.submitRegisteraccount();
		registerpage.enterRegNameInput("Ramann");
		registerpage.enterRegLastNameInput("Kaur");
		registerpage.enterRegEmail("amrit98@gmail.com");
		registerpage.enterRegTelephone("9678893223");
		registerpage.enterRegPassword("123414");
		registerpage.enterRegConfirmPassword("123414");
		accountPage = registerpage.clickRegisterAccount();
		Assert.assertEquals(registerpage.getAlreadyRegisterAlert(), "Warning: E-Mail Address is already registered!",
				"user  able to register");
	}

	@Test
	public void validateUserCanSubscribeNewsletter() {
		accountPage = loginPage.SubmitLogin("amarinderk4@gmail.com", "shop1234");
		newsletterPage = accountPage.clickSubscribeBtn();
		accountPage = newsletterPage.clickSubmitContBtn();
		Assert.assertEquals(accountPage.getNewsletterSubscSuccessMessage(),
				"Success: Your newsletter subscription has been successfully updated!", "Subscription not updated");

	}

	@Test
	public void validateUserCanEarnRewardPoints() {
		accountPage = loginPage.SubmitLogin("amarinderk4@gmail.com", "shop1234");
		rewardPage = accountPage.clickRewardpointsLink();
		accountPage = rewardPage.clickSubmitRewardBtn();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "User not earn reward points");
	}

	@Test
	public void validateProductReturns() {
		accountPage = loginPage.SubmitLogin("amarinderk4@gmail.com", "shop1234");
		returnPage = accountPage.clickReturnsBtn();
		accountPage = returnPage.clickReturnLink();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "User not earn points");
	}

	@Test
	public void validateUsercanUpdateWishList() {
		accountPage = loginPage.SubmitLogin("amarinderk4@gmail.com", "shop1234");
		wishListPage = accountPage.clickWishListLink();
		accountPage = wishListPage.clickContWishBtn();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "User can add product to wish list");
	}

	@Test
	public void validateRecurringPayments() {
		accountPage = loginPage.SubmitLogin("amarinderk4@gmail.com", "shop1234");
		accountPage.clickRecurringPaymentLink(SideBarOptions.RECURRING_PAYMENTS);
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "User not return recurring payments");
	}

	@Test
	public void validateUserCanDownloadOrders() {
		accountPage = loginPage.SubmitLogin("kaur.amarender@gmail.com", "shop1234");
		accountPage.clickDownloadLink(SideBarOptions.DOWNLOADS);
		Assert.assertEquals(accountPage.getMyAccountText(), "Account Downloads",
				"You are not able to download orders.");
	}

	@Test
	public void validateUserCanViewOderHistory() {
		accountPage = loginPage.SubmitLogin("amarinderk4@gmail.com", "shop1234");
		orderHistoryPage = accountPage.clickOrderHistoryLink();
		accountPage = orderHistoryPage.clickOrderHistorySubmitBtn();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "User not able to view order history");
	}

	@Test
	public void validateUserCanCustomTrackingCode() {
		accountPage = loginPage.SubmitLogin("amarinderk4@gmail.com", "shop1234");
		trackingPage = accountPage.clickCustomTrackingCodeLink();
		trackingPage.enterTrackingCode("ATRUFD123");
		accountPage = trackingPage.clicksubmitTrackingCode();
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "User not able to Customize Tracking code");
	}

	@Test
	public void validateUserCanUpdateAffiliateAccount() {
		accountPage = loginPage.SubmitLogin("amarinderk4@gmail.com", "shop1234");
		editPage = accountPage.clickregisterAffiliateAccountLink();
		editPage.enterComName("Aman");
		editPage.enterPaypalEmail("Amarinderk4@gmail.com");
		accountPage = editPage.submmitAffAccount();
		Assert.assertEquals(accountPage.getAffiliateText(), "Success: Your account has been successfully updated.",
				"user not able to register Affiliate account");

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}