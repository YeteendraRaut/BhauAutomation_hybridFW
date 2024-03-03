package com.selenium.java.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.automation.config.config;

//public class HomePageObjects {
//  By click_on_register_popup=By.xpath("//button[@class=\"pum-close popmake-close\"]");
//  
//  public WebElement Click_on_HomePage_register_popUp() {
//	  return config.driver.findElement(click_on_register_popup);
//  }
//  
//  By click_on_LoginLink=By.xpath("//ul[@id='top-menu']//a[normalize-space()='Login']");
//  
//  public WebElement Click_on_HomePage_LoginLink() {
//	  return config.driver.findElement(click_on_LoginLink);
//  }
//  
//}
public class Homepage_Objects {
	By close_homepage_register_popup = By.xpath("//button[@type='button']");

	public WebElement close_HomePage_popup() {
		return config.driver.findElement(close_homepage_register_popup);

	}

	By click_on_loginLink = By.linkText("Login");

	public WebElement click_on_HomePage_loginLink() {
		return config.driver.findElement(click_on_loginLink);
	}

}
