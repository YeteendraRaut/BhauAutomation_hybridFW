package com.selenium.automation;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.automation.config.config;
import com.selenium.automation.resorces.BaseTest;
import com.selenium.automation.utilty.Utility;
import com.selenium.java.pageObject.Homepage_Objects;
import com.selenium.java.pageObject.login_page_Objects;
import com.selenium.java.pageObject.my_accounts_objects;
import com.selenium.java.pageObject.shopPage_Objects;

import expectedValues.expected_Data;

public class Shop_page_test extends BaseTest {
		Homepage_Objects homepage;
		login_page_Objects login;
		my_accounts_objects MyAccount;
		shopPage_Objects shopPage;

		@BeforeMethod
		public void shopPage_setup() {
			homepage = new Homepage_Objects();
			MyAccount = new my_accounts_objects();
			login = new login_page_Objects();
			shopPage = new shopPage_Objects();
		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the URL of the shop page.", priority = 1)
		public void shop_page_url_test(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_1 - Shop page URL test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String actual_shop_page_url = shopPage.actual_url();

			if (actual_shop_page_url.equals(expected_Data.expected_shop_Page_url)) {

				System.out.println("shop page url test is PASS- Actual Result- " + actual_shop_page_url
						+ " - Expected Result - " + expected_Data.expected_shop_Page_url);

				test.pass("shop page url test is PASS- Actual Result- " + actual_shop_page_url + " - Expected Result - "
						+ expected_Data.expected_shop_Page_url);

			} else {

				System.out.println("shop page url test is FAIL- Actual Result- " + actual_shop_page_url
						+ " - Expected Result - " + expected_Data.expected_shop_Page_url);

				test.fail("shop page url test is PASS- Actual Result- " + actual_shop_page_url + " - Expected Result - "
						+ expected_Data.expected_shop_Page_url);

				Utility.TakeScreenshot();

			}

			shopPage.compare_results(expected_Data.expected_shop_Page_url, actual_shop_page_url);

		}

//		@Parameters({ "username", "password" })
//		@Test(description = "Verify the page title of the shop page", priority = 2)
//		public void shop_page_title_test(String LoginuserName, String LoginPassword) throws IOException {
//
//			test = extent.createTest("TC_2 - Shop page title test");
//
//			test.info("Step_1 - click on home page register popup to close the popup");
//
//			homepage.click_on_HomePage_loginLink().click();
//
//			test.info("Step_2 - Click on the login link on the home page");
//
//			login.enter_userName_or_email().sendKeys(LoginuserName);
//
//			test.info("Step_3 - Enter username into username or email field " + LoginuserName);
//
//			login.enter_password_forlogin().sendKeys(LoginPassword);
//
//			test.info("Step_4 - Enter password into password field " + LoginPassword);
//
//			login.login_button_click().click();
//
//			test.info("Step_5 - Click on the log in button");
//
//			MyAccount.hover_myAccountMenu();
//
//			test.info("Step_6 - Hover on my account menu");
//
//			MyAccount.click_on_shop().click();
//
//			test.info("Step_7 - Click on the shop from my account menu");
//
//			String actual_page_title = config.driver.getTitle();
//
//			Object expected_Data;
//			if (actual_page_title.equals(expected_Data.expected_shop_page_title)) {
//
//				System.out.println("shop page title test is PASS- Actual Result- " + actual_page_title
//						+ " - Expected Result - " + expected_Data.expected_shop_page_title);
//
//				test.pass("shop page title test is PASS- Actual Result- " + actual_page_title + " - Expected Result - "
//						+ expected_Data.expected_shop_page_title);
//
//			} else {
//
//				System.err.println("shop page title test is FAIL- Actual Result- " + actual_page_title
//						+ " - Expected Result - " + expected_Data.expected_shop_page_title);
//
//				test.fail("shop page title test is FAIL- Actual Result- " + actual_page_title + " Expected Result - "
//						+ expected_Data.expected_shop_page_title);
//
//				Utility.TakeScreenshot();
//			}
//
//			shopPage.compare_results(expected_Data.expected_shop_page_title, actual_page_title);
//		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the options visible in sorting drop down", priority = 3)
		public void drop_down_test(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_3 - Shop page sorting drop down test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			shopPage.sorting_dropdown().click();

			test.info("Step_8  - Click on the order by (sorting) drop down");

			Select dropdown = new Select(shopPage.sorting_dropdown());

			List<WebElement> options = dropdown.getOptions();

			if (options.size() == 6) {

				System.out.println("shop page order by drop down size test is PASS- Actual Result- " + options.size()
						+ " Expected Result - " + " 6");

				test.pass("shop page order by drop down size test is PASS- Actual Result- " + options.size()
						+ " Expected Result - " + " 6");
			} else {
				System.err.println("shop page order by drop down size test is FAIL- Actual Result- " + options.size()
						+ " Expected Result - " + " 6");

				test.fail("shop page order by drop down size test is PASS- Actual Result- " + options.size()
						+ " Expected Result - " + " 6");

				Utility.TakeScreenshot();
			}

			if (options.get(0).getText().equals("Default sorting")) {

				System.out.println("Shop page order by option test is PASS - Actual Result - " + options.get(0).getText()
						+ "Expected Result - " + "Default sorting");

				test.pass("Shop page order by option test is PASS - Actual Result - " + options.get(0).getText()
						+ "Expected Result - " + "Default sorting");
			} else {

				System.err.println("Shop page order by option test is FAIL - Actual Result - " + options.get(0).getText()
						+ " - Expected Result - " + "Default sorting");

				test.fail("Shop page order by option test is FAIL - Actual Result - " + options.get(0).getText()
						+ " - Expected Result - " + "Default sorting");

				Utility.TakeScreenshot();
			}

			shopPage.compare_results(options.get(0).getText(), "Default sorting");

			if (options.get(1).getText().equals("Sort by popularity")) {

				System.out.println("Shop page order by option test is PASS - Actual Result - " + options.get(1).getText()
						+ " - Expected Result - " + "Sort by popularity");

				test.pass("Shop page order by option test is PASS - Actual Result - " + options.get(1).getText()
						+ "Expected Result - " + "Sort by popularity");
			} else {

				System.err.println("Shop page order by option test is FAIL - Actual Result - " + options.get(1).getText()
						+ "Expected Result - " + "Sort by popularity");

				test.fail("Shop page order by option test is FAIL - Actual Result - " + options.get(1).getText()
						+ " - Expected Result - " + "Sort by popularity");

				Utility.TakeScreenshot();
			}

			shopPage.compare_results(options.get(1).getText(), "Sort by popularity");

			if (options.get(2).getText().equals("Sort by average rating")) {

				System.out.println("Shop page order by option test is PASS - Actual Result - " + options.get(2).getText()
						+ " - Expected Result - " + "Sort by average rating");

				test.pass("Shop page order by option test is PASS - Actual Result - " + options.get(2).getText()
						+ " - Expected Result - " + "Sort by average rating");
			} else {

				System.err.println("Shop page order by option test is FAIL - Actual Result - " + options.get(2).getText()
						+ " - Expected Result - " + "Sort by average rating");

				test.fail("Shop page order by option test is FAIL - Actual Result - " + options.get(2).getText()
						+ " - Expected Result - " + "Sort by average rating");

				Utility.TakeScreenshot();
			}

			shopPage.compare_results(options.get(2).getText(), "Sort by average rating");

			if (options.get(3).getText().equals("Sort by latest")) {

				System.out.println("Shop page order by option test is PASS - Actual Result - " + options.get(3).getText()
						+ " - Expected Result - " + "Sort by latest");

				test.pass("Shop page order by option test is PASS - Actual Result - " + options.get(3).getText()
						+ " - Expected Result - " + "Sort by latest");
			} else {

				System.err.println("Shop page order by option test is FAIL - Actual Result - " + options.get(3).getText()
						+ " - Expected Result - " + "Sort by latest");

				test.fail("Shop page order by option test is FAIL - Actual Result - " + options.get(3).getText()
						+ " - Expected Result - " + "Sort by latest");

				Utility.TakeScreenshot();
			}

			shopPage.compare_results(options.get(3).getText(), "Sort by latest");

			if (options.get(4).getText().equals("Sort by price: low to high")) {

				System.out.println("Shop page order by option test is PASS - Actual Result - " + options.get(4).getText()
						+ " - Expected Result - " + "Sort by price: low to high");

				test.pass("Shop page order by option test is PASS - Actual Result - " + options.get(4).getText()
						+ " - Expected Result - " + "Sort by price: low to high");
			} else {

				System.err.println("Shop page order by option test is FAIL - Actual Result - " + options.get(4).getText()
						+ " - Expected Result - " + "Sort by price: low to high");

				test.fail("Shop page order by option test is FAIL - Actual Result - " + options.get(4).getText()
						+ " - Expected Result - " + "Sort by price: low to high");

				Utility.TakeScreenshot();
			}

			shopPage.compare_results(options.get(4).getText(), "Sort by price: low to high");

			if (options.get(5).getText().equals("Sort by price: high to low")) {

				System.out.println("Shop page order by option test is PASS - Actual Result - " + options.get(5).getText()
						+ " - Expected Result - " + "Sort by price: high to low");

				test.pass("Shop page order by option test is PASS - Actual Result - " + options.get(5).getText()
						+ " - Expected Result - " + "Sort by price: high to low");
			} else {

				System.err.println("Shop page order by option test is FAIL - Actual Result - " + options.get(5).getText()
						+ " - Expected Result - " + "Sort by price: high to low");

				test.fail("Shop page order by option test is FAIL - Actual Result - " + options.get(5).getText()
						+ " - Expected Result - " + "Sort by price: high to low");

				Utility.TakeScreenshot();
			}

			shopPage.compare_results(options.get(5).getText(), "Sort by price: high to low");

		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the original price of blue suite tie", priority = 4)
		public void blue_suite_original_price_test(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_4 - Blue suite with tie original price test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String price = shopPage.blue_suite_tie_price().getText();
			String[] split_price = price.split(" ");
			if (split_price.length >= 2) {
				String actual_price = split_price[0];

				if (actual_price.equals(expected_Data.expected_suite_original_price)) {

					System.out.println("blue suite original price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_suite_original_price);

					test.pass("blue suite original price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_suite_original_price);

				} else {

					System.err.println("blue suite original price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_suite_original_price);

					test.fail("blue suite original price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_suite_original_price);

					Utility.TakeScreenshot();
				}

				shopPage.compare_results(expected_Data.expected_suite_original_price, actual_price);
			}

		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the discounted price of blue suite tie", priority = 5)
		public void blue_suite_discounted_price_test(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_5 - Blue suite with tie discount price test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String price = shopPage.blue_suite_tie_price().getText();
			String[] split_price = price.split(" ");
			if (split_price.length >= 2) {
				String actual_price = split_price[1];

				if (actual_price.equals(expected_Data.expected_suite_price)) {

					System.out.println("blue suite discounted price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_suite_price);

					test.pass("blue suite discounted price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_suite_price);

				} else {

					System.err.println("blue suite discounted price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_suite_price);

					test.fail("blue suite discounted price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_suite_price);

					Utility.TakeScreenshot();
				}

				shopPage.compare_results(expected_Data.expected_suite_price, actual_price);
			}

		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the name of the blue suite tie", priority = 6)
		public void blue_suite_name_test(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_6 - Blue suite with tie name test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String actual_suite_name = shopPage.blue_suite_Name().getText();

			if (actual_suite_name.equals(expected_Data.expected_suite_name)) {

				System.out.println("blue suite name test is PASS - Actual Result - " + actual_suite_name
						+ " - Expected Result - " + expected_Data.expected_suite_name);

				test.pass("blue suite name test is PASS - Actual Result - " + actual_suite_name + " - Expected Result - "
						+ expected_Data.expected_suite_name);

			} else {

				System.err.println("blue suite name test is FAIL - Actual Result - " + actual_suite_name
						+ " - Expected Result - " + expected_Data.expected_suite_name);

				test.fail("blue suite name test is FAIL - Actual Result - " + actual_suite_name + " - Expected Result - "
						+ expected_Data.expected_suite_name);

				Utility.TakeScreenshot();
			}

			shopPage.compare_results(expected_Data.expected_suite_name, actual_suite_name);
		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the original price of the ring", priority = 7)

		public void ring_original_price_test(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_7 - ring original price test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String price = shopPage.master_guy_ring_price().getText();
			String[] split_price = price.split(" ");
			if (split_price.length >= 2) {
				String actual_price = split_price[0];

				if (actual_price.equals(expected_Data.expected_ring_original_price)) {

					System.out.println("ring original price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_ring_original_price);

					test.pass("ring suite discounted price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_ring_original_price);

				} else {

					System.err.println("ring original price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_ring_original_price);

					test.fail("ring original price test is FAIL - Actual Result - " + actual_price + " - Expected Result - "
							+ expected_Data.expected_ring_original_price);

					Utility.TakeScreenshot();
				}

				shopPage.compare_results(expected_Data.expected_ring_original_price, actual_price);
			}

		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the discounted price of the ring", priority = 8)
		public void ring_discounted_price_test(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_8- ring discounted price test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String price = shopPage.master_guy_ring_price().getText();
			String[] split_price = price.split(" ");
			if (split_price.length >= 2) {
				String actual_price = split_price[1];

				if (actual_price.equals(expected_Data.expected_ring_price)) {

					System.out.println("ring discounted price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_ring_price);

					test.pass("ring  discounted price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_ring_price);

				} else {

					System.err.println("ring original price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_ring_price);

					test.fail("ring original price test is FAIL - Actual Result - " + actual_price + " - Expected Result - "
							+ expected_Data.expected_ring_price);

					Utility.TakeScreenshot();
				}

				shopPage.compare_results(expected_Data.expected_ring_price, actual_price);
			}
		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the name of the ring", priority = 9)

		public void ring_name_test(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_9 - ring name test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String actual_ring_name = shopPage.master_guy_ring_name().getText();

			if (actual_ring_name.equals(expected_Data.expected_ring_name)) {

				System.out.println("ring name test is PASS - Actual Result - " + actual_ring_name + " - Expected Result - "
						+ expected_Data.expected_ring_name);

				test.pass("ring original name test is PASS - Actual Result - " + actual_ring_name + " - Expected Result - "
						+ expected_Data.expected_ring_name);
			} else {

				System.err.println("ring name test is FAIL - Actual Result - " + actual_ring_name + " - Expected Result - "
						+ expected_Data.expected_ring_name);

				test.fail("ring name test is FAIL - Actual Result - " + actual_ring_name + " - Expected Result - "
						+ expected_Data.expected_ring_name);

				Utility.TakeScreenshot();
			}

			shopPage.compare_results(expected_Data.expected_ring_name, actual_ring_name);

		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the original of price of the shoes", priority = 10)

		public void shoes_original_price_test(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_10- shoes original price test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String price = shopPage.shoes_price_test().getText();
			String[] split_price = price.split(" ");
			if (split_price.length >= 2) {
				String actual_price = split_price[0];

				if (actual_price.equals(expected_Data.expected_shoes_original_price)) {

					System.out.println("shoes original price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_shoes_original_price);

					test.pass("shoes  original price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_shoes_original_price);

				} else {

					System.err.println("shoes original price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_shoes_original_price);

					test.fail("shoes original price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_shoes_original_price);

					Utility.TakeScreenshot();
				}

				shopPage.compare_results(expected_Data.expected_shoes_original_price, actual_price);
			}
		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the discounted price of the shoes", priority = 11)

		public void discounted_price_of_the_shoes(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_11- shoes discounted price test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String price = shopPage.shoes_price_test().getText();
			String[] split_price = price.split(" ");
			if (split_price.length >= 2) {
				String actual_price = split_price[1];

				if (actual_price.equals(expected_Data.expected_shoe_price)) {

					System.out.println("shoes discounted price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_shoe_price);

					test.pass("shoes discounted price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_shoe_price);

				} else {

					System.err.println("shoes discounted price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_shoe_price);

					test.fail("shoes discounted price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_shoe_price);

					Utility.TakeScreenshot();
				}

				shopPage.compare_results(expected_Data.expected_shoe_price, actual_price);
			}
		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the name of the shoes", priority = 12)

		public void shoes_name_test(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_12- shoes name test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String actual_shoes_name = shopPage.shoes_for_men_name().getText();

			if (actual_shoes_name.equals(expected_Data.expected_shoe_name)) {

				System.out.println("Shoes name test PASS - Actual Result - " + actual_shoes_name
						+ " - Expected Shoes Name -" + expected_Data.expected_shoe_name);

				test.pass("Shoes name test PASS - Actual Result - " + actual_shoes_name + " - Expected Shoes Name -"
						+ expected_Data.expected_shoe_name);
			} else {

				System.err.println("Shoes name test FAIL - Actual Result - " + actual_shoes_name
						+ " - Expected Shoes Name -" + expected_Data.expected_shoe_name);

				test.fail("Shoes name test FAIL - Actual Result - " + actual_shoes_name + " - Expected Shoes Name -"
						+ expected_Data.expected_shoe_name);

				Utility.TakeScreenshot();
			}

			shopPage.compare_results(expected_Data.expected_shoe_name, actual_shoes_name);
		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the original price of the bracelet", priority = 13)

		public void bracelet_original_price_test(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_13- bracelet original price test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String price = shopPage.bracelet_price().getText();
			String[] split_price = price.split(" ");
			if (split_price.length >= 2) {
				String actual_price = split_price[0];

				if (actual_price.equals(expected_Data.expected_bracelet_original_price)) {

					System.out.println("bracelet original price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_bracelet_original_price);

					test.pass("bracelet original price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_bracelet_original_price);

				} else {

					System.err.println("bracelet original price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_bracelet_original_price);

					test.fail("bracelet discounted price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_bracelet_original_price);

					Utility.TakeScreenshot();
				}

				shopPage.compare_results(expected_Data.expected_bracelet_original_price, actual_price);
			}

		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the discounted price of the bracelet", priority = 14)

		public void bracelet_discounted_price_test(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_14- bracelet original price test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String price = shopPage.bracelet_price().getText();
			String[] split_price = price.split(" ");
			if (split_price.length >= 2) {
				String actual_price = split_price[1];

				if (actual_price.equals(expected_Data.expected_bracelete_price)) {

					System.out.println("bracelet discounted price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_bracelete_price);

					test.pass("bracelet discounted price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_bracelete_price);

				} else {

					System.err.println("bracelet discounted price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_bracelete_price);

					test.fail("bracelet discounted price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_bracelete_price);

					Utility.TakeScreenshot();
				}

				shopPage.compare_results(expected_Data.expected_bracelete_price, actual_price);
			}
		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the name of the bracelet", priority = 15)

		public void bravelet_name_test(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_15- bracelet name test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String actual_bracelet_name = shopPage.silver_bracelete_name().getText();

			if (actual_bracelet_name.equals(expected_Data.expected_bracelet_name)) {

				System.out.println("bracelet name test is PASS - Actual Result - " + actual_bracelet_name
						+ " - Expected Result - " + expected_Data.expected_bracelet_name);

				test.pass("bracelet name test is PASS - Actual Result - " + actual_bracelet_name + " - Expected Result - "
						+ expected_Data.expected_bracelet_name);

			} else {

				System.err.println("bracelet name test is FAIL - Actual Result - " + actual_bracelet_name
						+ " - Expected Result - " + expected_Data.expected_bracelet_name);

				test.fail("bracelet name test is FAIL - Actual Result - " + actual_bracelet_name + " - Expected Result - "
						+ expected_Data.expected_bracelet_name);

				Utility.TakeScreenshot();
			}

			shopPage.compare_results(expected_Data.expected_bracelet_name, actual_bracelet_name);

		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the original price of the watch", priority = 16)
		public void original_watch_price_test(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_16- watch original price test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String price = shopPage.watch_price().getText();
			String[] split_price = price.split(" ");
			if (split_price.length >= 2) {
				String actual_price = split_price[0];

				if (actual_price.equals(expected_Data.expected_watch_original_price)) {

					System.out.println("watch original price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_watch_original_price);

					test.pass("watch original price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_watch_original_price);

				} else {

					System.err.println("watch original price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_watch_original_price);

					test.fail("watch discounted price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_watch_original_price);

					Utility.TakeScreenshot();
				}

				shopPage.compare_results(expected_Data.expected_watch_original_price, actual_price);
			}

		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the discounted price of the watch", priority = 17)

		public void discounted_watch_price(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_17- watch discounted price test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String price = shopPage.watch_price().getText();
			String[] split_price = price.split(" ");
			if (split_price.length >= 2) {
				String actual_price = split_price[1];

				if (actual_price.equals(expected_Data.expected_watch_price)) {

					System.out.println("watch discounted price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_watch_price);

					test.pass("watch discounted price test is PASS - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_watch_price);

				} else {

					System.err.println("watch discounted price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_watch_price);

					test.fail("watch discounted price test is FAIL - Actual Result - " + actual_price
							+ " - Expected Result - " + expected_Data.expected_watch_price);

					Utility.TakeScreenshot();
				}

				shopPage.compare_results(expected_Data.expected_watch_price, actual_price);
			}

		}

		@Parameters({ "username", "password" })
		@Test(description = "Verify the name of the watch", priority = 18)

		public void watch_name_test(String LoginuserName, String LoginPassword) throws IOException {

			test = extent.createTest("TC_18- watch name test");

			test.info("Step_1 - click on home page register popup to close the popup");

			homepage.click_on_HomePage_loginLink().click();

			test.info("Step_2 - Click on the login link on the home page");

			login.enter_userName_or_email().sendKeys(LoginuserName);

			test.info("Step_3 - Enter username into username or email field " + LoginuserName);

			login.enter_password_forlogin().sendKeys(LoginPassword);

			test.info("Step_4 - Enter password into password field " + LoginPassword);

			login.login_button_click().click();

			test.info("Step_5 - Click on the log in button");

			MyAccount.hover_myAccountMenu();

			test.info("Step_6 - Hover on my account menu");

			MyAccount.click_on_shop().click();

			test.info("Step_7 - Click on the shop from my account menu");

			String actual_watch_name = shopPage.rolex_watch().getText();

			if (actual_watch_name.equals(expected_Data.expected_watch_name)) {

				System.out.println("Rolex watch name test PASS - Actual Result - " + actual_watch_name
						+ " - Expected Results -" + expected_Data.expected_watch_name);

				test.pass("Rolex watch name test PASS - Actual Result - " + actual_watch_name + " - Expected Results -"
						+ expected_Data.expected_watch_name);
			} else {

				System.out.println("Rolex watch name test FAIL - Actual Result - " + actual_watch_name
						+ " - Expected Results -" + expected_Data.expected_watch_name);

				test.fail("Rolex watch name test PASS - Actual Result - " + actual_watch_name + " - Expected Results -"
						+ expected_Data.expected_watch_name);

				Utility.TakeScreenshot();
			}

			shopPage.compare_results(expected_Data.expected_watch_name, actual_watch_name);

		}
	}


