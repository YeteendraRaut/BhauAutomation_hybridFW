package com.selenium.automation;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.selenium.automation.config.config;
import com.selenium.automation.resorces.BaseTest;
import com.selenium.automation.utilty.Utility;
import com.selenium.java.pageObject.Homepage_Objects;
import com.selenium.java.pageObject.login_page_Objects;
import com.selenium.java.pageObject.my_accounts_objects;

import expectedValues.expected_Data;


public class application_login_test extends BaseTest {
	Homepage_Objects homepage;
	login_page_Objects login;
	my_accounts_objects my_accounts;

	@BeforeMethod
	public void basicSetup() {
		homepage = new Homepage_Objects();
		login = new login_page_Objects();
		my_accounts = new my_accounts_objects();
	}

	@Test(description = "Verify the URL of the login page.",priority=1)
	public void login_page_url_test() throws IOException {
		test = extent.createTest("TC_1 - Login page URL test");

		test.info("Step_1 - click on home page register popup to close the popup");

		homepage.click_on_HomePage_loginLink().click();

		test.info("Step_2 - Click on login link from home page menu to open log in page");

		String actual_url = config.driver.getCurrentUrl();

		if (actual_url.equals(expected_Data.expected_login_page_url)) {

			System.out.println("login page url test is PASS- Actual Result- " + actual_url + " Expected Result  "
					+ expected_Data.expected_login_page_url);

			test.pass("login page url test is PASS- Actual Result- " + actual_url + " Expected Result "
					+ expected_Data.expected_login_page_url);

		} else {

			System.err.println("login page url test is FAIL- Actual Result- " + actual_url + " Expected Result "
					+ expected_Data.expected_login_page_url);

			test.fail("login page url test is FAIL- Actual Result- " + actual_url + " Expected Result "
					+ expected_Data.expected_login_page_url);

			Utility.TakeScreenshot();
		}

		login.compare_results(expected_Data.expected_login_page_url, actual_url);

	}

	@Test(description = "Verify the page title of the login page",priority = 2)
	public void login_page_tile_test() throws IOException {

		test = extent.createTest("TC_2 - Login page title test");

		test.info("Step_1 - click on home page register popup to close the popup");

		homepage.click_on_HomePage_loginLink().click();

		test.info("Step_2 - Click on login link from home page menu to open log in page");

		String actual_title = config.driver.getTitle();

		if (actual_title.equals(expected_Data.expected_login_page_title)) {

			System.out.println("Login page title test PASS - Actual Result- " + actual_title + "Expected Result - "
					+ expected_Data.expected_login_page_title);

			test.pass("Login page title test PASS - Actual Result- " + actual_title + "Expected Result - "
					+ expected_Data.expected_login_page_title);

		} else {

			System.err.println("Login page title test FAIL - Actual Result- " + actual_title + "Expected Result - "
					+ expected_Data.expected_login_page_title);

			test.fail("Login page title test FAIL - Actual Result- " + actual_title + "Expected Result - "
					+ expected_Data.expected_login_page_title);

			Utility.TakeScreenshot();

		}

		login.compare_results(actual_title, expected_Data.expected_login_page_title);

	}

	@Parameters({ "Valid_userName", "invalid_Password" })
	@Test(description = "log in with valid username and invalid password",priority = 3)
	public void login_with_invalid_password(String valid_username, String invalid_password) throws IOException {

		test = extent.createTest("TC_3 - log in with valid username and invalid password");

		test.info("Step_1 - click on home page register popup to close the popup");

		homepage.click_on_HomePage_loginLink().click();

		test.info("Step_2 - Click on login link from home page menu to open log in page");

		login.enter_userName_or_email().sendKeys(valid_username);

		test.info("Step_3 - enter valid user name into the username or email field " +valid_username);

		login.enter_password_forlogin().sendKeys(invalid_password);

		test.info("Step_4 - enter invalid password into the password " +invalid_password);

		login.login_button_click().click();

		test.info("Step_5- Click on log in button to log in to the application");

		String actual_incorrect_password_msg = login.incorrect_password_message().getText();

		if (actual_incorrect_password_msg.equals(expected_Data.expected_incorrect_password_msg)) {

			System.out.println("Login with invalid password test PASS - Actual Result- " + actual_incorrect_password_msg
					+ "Expected Result - " + expected_Data.expected_incorrect_password_msg);

			test.pass("Login with invalid password test PASS - Actual Result- " + actual_incorrect_password_msg
					+ "Expected Result - " + expected_Data.expected_incorrect_password_msg);
		} else {

			System.err.println("Login with invalid password test FAIL - Actual Result- " + actual_incorrect_password_msg
					+ "Expected Result - " + expected_Data.expected_incorrect_password_msg);

			test.fail("Login with invalid password test FAIL - Actual Result- " + actual_incorrect_password_msg
					+ "Expected Result - " + expected_Data.expected_incorrect_password_msg);

			Utility.TakeScreenshot();
		}

		login.compare_results(actual_incorrect_password_msg, expected_Data.expected_incorrect_password_msg);
	}
	
	@Parameters({"invalid_username", "invalid_Password"})
	@Test(description = "log in with invalid username and invalid password",priority = 4)
	public void log_in_with_invalid_credentials(String invalid_username,String invalid_password) throws IOException {
		
		test= extent.createTest("TC_4 - Log in with invalid username and invalid password");
		
		test.info("Step_1 - click on register pop up to close register popup");
		
		homepage.click_on_HomePage_loginLink().click();
		
		test.info("Step_2 - Click on login link from home page menu to open log in page");
		
		login.enter_userName_or_email().sendKeys(invalid_username);
		
		test.info("Step_3 - enter invalid user name into the username or email field " +invalid_username);
		
		login.enter_password_forlogin().sendKeys(invalid_password);
		
		test.info("Step_4 - enter invalid password into the password field " +invalid_password);
		
		login.login_button_click().click();
		
		test.info("Step_5 - CLick on the log in button");
		
		String actual_incorrect_password_msg = login.incorrect_password_message().getText();
		
		if (actual_incorrect_password_msg.equals(expected_Data.expected_incorrect_password_msg)) {

			System.out.println("Login with invalid password and invalid username test PASS - Actual Result- "
					+ actual_incorrect_password_msg + "Expected Result - "
					+ expected_Data.expected_incorrect_password_msg);

			test.pass("Login with invalid password and invalid username test PASS - Actual Result- "
					+ actual_incorrect_password_msg + "Expected Result - "
					+ expected_Data.expected_incorrect_password_msg);
		} else {

			System.err.println("Login with invalid username and invalid password test FAIL - Actual Result- "
					+ actual_incorrect_password_msg + "Expected Result - "
					+ expected_Data.expected_incorrect_password_msg);

			test.fail("Login with invalid username and invalid password test FAIL - Actual Result- " + actual_incorrect_password_msg
					+ "Expected Result - " + expected_Data.expected_incorrect_password_msg);

			Utility.TakeScreenshot();

		}
		
		login.compare_results(expected_Data.expected_incorrect_password_msg, actual_incorrect_password_msg);
	}
	
	@Test(description = "log in with blank username and blank password",priority = 5)
	public void login_with_blank_username_and_password() throws IOException {
		
		test= extent.createTest("TC_5 - Log in with blank username and blank password");
		
		test.info("Step_1 - click on register pop up to close register popup");
		
		homepage.click_on_HomePage_loginLink().click();
		
		test.info("Step_2 - Click on login link from home page menu to open log in page");
		
		login.login_button_click().click();
		
		test.info("Step_3 - click on the log in button");
		
		String actual_enter_username_message = login.enter_username_message().getText();
		
		String actual_enter_password_message = login.enter_password_message().getText();

		if (actual_enter_username_message.equals(expected_Data.expected_enter_username_msg)) {

			System.out.println("Login with blank username and blank password test PASS - Actual Result- "
					+ actual_enter_username_message + " - Expected Result - " + expected_Data.expected_enter_username_msg);

			test.pass("Login with blank username and blank password test PASS - Actual Result- "
					+ actual_enter_username_message + " - Expected Result - " + expected_Data.expected_enter_username_msg);
		} else {

			System.err.println("Login with blank username and blank password test FAIL - Actual Result- "
					+ actual_enter_username_message + " - Expected Result - " + expected_Data.expected_enter_username_msg);

			test.fail("Login with blank username and blank password test FAIL - Actual Result- "
					+ actual_enter_password_message + " - Expected Result - " + expected_Data.expected_enter_password_msg);

			Utility.TakeScreenshot();
		}

		if (actual_enter_password_message.equals(expected_Data.expected_enter_password_msg)) {

			System.out.println("Login with blank username and blank password test PASS - Actual Result- "
					+ actual_enter_password_message + " - Expected Result - " + expected_Data.expected_enter_password_msg);

			test.pass("Login with blank username and blank password test PASS - Actual Result- "
					+ actual_enter_password_message + " - Expected Result - " + expected_Data.expected_enter_password_msg);
		} else {

			System.err.println("Login with blank username and blank password test FAIL - Actual Result- "
					+ actual_enter_username_message + "Expected Result - " + expected_Data.expected_enter_username_msg);

			test.fail("Login with blank username and blank password test FAIL - Actual Result- "
					+ actual_enter_password_message + "Expected Result - " + expected_Data.expected_enter_password_msg);

			Utility.TakeScreenshot();
		}

		login.compare_results(expected_Data.expected_enter_username_msg, actual_enter_username_message);

		login.compare_results(expected_Data.expected_enter_password_msg, actual_enter_password_message);
	}
	
	
	@Parameters({ "Valid_userName", "Valid_Password" })
	@Test(description = "Log in with the valid username and valid password",priority = 6)
	public void sign_in_withCredential(String LoginuserName, String LoginPassword) throws IOException {
		test = extent.createTest("TC_6 - Log in with valid username and valid password");

		test.info("Step_1 - click on register pop up to close register popup");

		homepage.click_on_HomePage_loginLink().click();

		test.info("Step_2 - Click on login link from home page menu to open log in page");

		login.enter_userName_or_email().sendKeys(LoginuserName);

		test.info("Step_3 - do not enter username into the username or email field " +LoginuserName);

		login.enter_password_forlogin().sendKeys(LoginPassword);

		test.info("Step_4 - do not enter password into the passord field " +LoginPassword);

		login.login_button_click().click();

		test.info("Step_5 - click on the log in button");

		String actual_myAccount_text = my_accounts.move_to_myAccount().getText();

		if (actual_myAccount_text.equals(expected_Data.expected_my_account_text)) {

			System.out.println("Login with valid username and valid password test PASS - Actual Result- "
					+ actual_myAccount_text + "Expected Result - " + expected_Data.expected_my_account_text);

			test.pass("Login with valid username and valid password test PASS - Actual Result- " + actual_myAccount_text
					+ " - Expected Result - " + expected_Data.expected_my_account_text);

		} else {

			System.err.println("Login with valid username and valid password test FAIL - Actual Result- "
					+ actual_myAccount_text + "Expected Result - " + expected_Data.expected_my_account_text);

			test.fail("Login with valid username and valid password test FAIL - Actual Result- " + actual_myAccount_text
					+ "Expected Result - " + expected_Data.expected_my_account_text);

			Utility.TakeScreenshot();

		}

		login.compare_results(expected_Data.expected_my_account_text, actual_myAccount_text);
	}

}

