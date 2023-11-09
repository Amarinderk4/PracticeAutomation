package com.Naveenautomation.PageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Naveenautomation.Base.TestBase;
import com.Naveenautomation.Pages.AccountPage;
import com.Naveenautomation.Pages.ContactPage;
import com.Naveenautomation.Pages.ForgotPwdLinkPage;
import com.Naveenautomation.Pages.LoginPage;
import com.Naveenautomation.Pages.SearchPage;
import com.Naveenautomation.Utils.ExcelUtils;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	ForgotPwdLinkPage forgotPage;
	ContactPage contactPage;
	SearchPage searchPage;

	@BeforeMethod
	public void launch() {
		intialization();
		loginPage = new LoginPage();

	}

	@Test
	public void validateUserCanLoginWithValidCredentials() {
		accountPage = loginPage.SubmitLogin("Amarinderk4@gmail.com", "shop1234");
		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "User not logged in");
	}

	@Test
	public void validateUserCanNotLoginWithInValidCredentials() {
		loginPage.SubmitLogin("Amarinderk4@gmail.com", "shop12364");
		Assert.assertEquals(loginPage.getAlertText(), "Warning: No match for E-Mail Address and/or Password.",
				"User logged in");
	}

	@Test
	public void validateUserCannotLoginProvidingEmail() {
		loginPage.SubmitLogin(" ", "shop1234");
		Assert.assertEquals(loginPage.clickEmailWarning(), "Warning: No match for E-Mail Address and/or Password.",
				"user logged in");
	}

	@Test
	public void validateUserCannotLoginWithoutProvidingCredentials() {
		loginPage.SubmitLogin(" "," ");
		Assert.assertEquals(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText(),
				"emailPasswordNoMatchWarning", "user can logged in");
	}

//	@Test(dataProvider = "UserCredentials")
//	public void validateUserCanLoginWithMultiplaCredentials(String username, String password) {
//		accountPage = loginPage.SubmitLogin(username, password);
//		Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "User not logged in");
//
//	}

	public Object[][] getDataFromExcelSheet() throws Exception {
		logger.info("reading data");
		String fileName = "C:\\Users\\kaura\\OneDrive\\Desktop\\Login.xlsx";
		String sheetName = "Sheet1";
		int rowCount = ExcelUtils.getRowCount(fileName, sheetName);
		int cellCount = ExcelUtils.getCellCount(fileName, sheetName, rowCount);
		// String cellValue=ExcelUtils.getCellData(fileName, sheetName, rowCount,
		// cellCount);
		String[][] virtualSheet = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				virtualSheet[i - 1][j] = ExcelUtils.getCellData(fileName, sheetName, i, j);

			}

		}
		return virtualSheet;

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
}
