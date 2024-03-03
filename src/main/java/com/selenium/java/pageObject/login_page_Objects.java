package com.selenium.java.pageObject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.selenium.automation.config.config;

public class login_page_Objects {
	
//  By set_username= By.xpath("//input[@id='username-1762']");
//   public WebElement SetUsername_Or_EmailName() {
//	  
//	   return config.driver.findElement(set_username);
//   }
//   
//   By set_password= By.xpath("//input[@id='user_password-1762']");
//   public WebElement  SetPassword() {
//	   return config.driver.findElement(set_password);
//   }
//   
//   By loginButton=By.id("um-submit-btn");
//   public WebElement ClickOnLoginButton() {
//	   return config.driver.findElement(loginButton);
//	   
//   }
//   By Get_my_acccount_Text=By.linkText("My Account");
//   public WebElement Get_My_Account_text_After_Login() {
//	   return config.driver.findElement(Get_my_acccount_Text);
//	   
//   }
//}

	By enter_user_name_or_email = By.xpath("//input[@id='username-1762']");

	public WebElement enter_userName_or_email() {
		return config.driver.findElement(enter_user_name_or_email);
	}

	By enter_password = By.xpath("//input[@id='user_password-1762']");

	public WebElement enter_password_forlogin() {
		return config.driver.findElement(enter_password);
	}

	By click_on_login_button = By.xpath("//input[@id='um-submit-btn']");

	public WebElement login_button_click() {
		return config.driver.findElement(click_on_login_button);
	}

	public void compare_results(String expected_login_page_Url, String actual_url) {
		assertTrue(actual_url.equals(expected_login_page_Url), "Missmatch in the expected vs actual result");

	}
	
	By incorrect_password_msg = By.xpath("//div[@id='um-error-for-user_password-1762']");
	public WebElement incorrect_password_message() {
		return config.driver.findElement(incorrect_password_msg);
	}
	
	By enter_username_msg = By.xpath("//div[@id='um-error-for-username-1762']");
	public WebElement enter_username_message() {
		return config.driver.findElement(enter_username_msg);
	}
	
	By enter_password_msg = By.xpath("//div[@id='um-error-for-user_password-1762']");
	public WebElement enter_password_message() {
		return config.driver.findElement(enter_password_msg);
	}
}
