package com.Naveenautomation.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Naveenautomation.Base.TestBase;
import com.Naveenautomation.Pages.AccountPage;
import com.Naveenautomation.Pages.ContactPage;
import com.Naveenautomation.Pages.HomePage;
import com.Naveenautomation.Pages.LoginPage;
import com.Naveenautomation.Pages.LogoutPage;
import com.Naveenautomation.Pages.SearchPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	LogoutPage logoutPage;
	ContactPage contactPage;
	HomePage homePage;
	SearchPage searchPage;

	@BeforeMethod
	public void launch() {
		intialization();
		loginPage = new LoginPage();

	}

	@Test
	public void validateUserCanLogoutAccount() {
		accountPage = loginPage.SubmitLogin("Amarinderk4@gmail.com", "shop1234");
		logoutPage = accountPage.clickLogoutBtn();
		Assert.assertEquals(logoutPage.getAccountLogoutText(), "Account Logout", "user not able to logout");

	}

	@Test
	public void validateSeachFieldWithValidProductName() {
		searchPage = homePage.searchForAProduct("HP");
		Assert.assertTrue(searchPage.displayHpProduct(), "no valid product name");
	}

	@Test
	public void validateUserCanContactUsWithQuery() {
		contactPage = loginPage.clickContactUsLink();
		contactPage.enterName("gagan");
		contactPage.enterEmail("gagan54@gmail.com");
		contactPage.enterQuery("This is for the contact information.I am anot able to access it");
		 homePage=contactPage.clickContactUsSubmitBtn();
	//Assert.assertEquals(contactPage.getContactUsSuccessMessage()," Your enquiry has been successfully sent to the store owner!","not contact us");

	}
	@Test
	public void validateWarningMsgForExistingaccount() {
		contactPage = loginPage.clickContactUsLink();
		contactPage.enterName("Amarinder");
		contactPage.enterEmail("Amaringer11234@gmail.com");
		contactPage.enterQuery("This is for the contact information.I am anot able to access it");
		contactPage.clickContactUsSubmitBtn();
		Assert.assertEquals(contactPage.getContactExistAlert(),"Warning: E-Mail Address is already registered!","Account created");
	}

	@AfterMethod
	public void quitBrowser() {
		 tearDown();
	}

}
