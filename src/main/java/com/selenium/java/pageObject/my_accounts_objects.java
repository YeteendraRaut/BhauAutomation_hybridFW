package com.selenium.java.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import com.selenium.automation.config.config;

public class 	my_accounts_objects  {

	By hover_at_myaccount = By.linkText("My Account");

	public WebElement move_to_myAccount() {
		return config.driver.findElement(hover_at_myaccount);
	}

	By click_on_shop = By.linkText("Shop");

	public WebElement click_on_shop() {
		return config.driver.findElement(click_on_shop);
	}
	
	public void hover_myAccountMenu() {
		WebElement hover_myAccouny_Menu=config.driver.findElement(By.linkText("My Account"));
		Actions act = new Actions(config.driver);
		act.moveToElement(hover_myAccouny_Menu).build().perform();
	}


}

