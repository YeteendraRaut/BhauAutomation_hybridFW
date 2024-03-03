package com.selenium.java.pageObject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.automation.config.config;

public class product_Details_page_Objects {
	public WebElement Actual_blue_suit_with_tie_price() {
		return config.driver.findElement(By.xpath("//p[@class='price']//ins"));
	}

	public WebElement suite_name() {
		return config.driver.findElement(By.xpath("//h2[text()='Blue_suit_with_tie']"));
	}

	public WebElement ring_name() {
		return config.driver.findElement(By.xpath("//h2[text()='MasterGuy Ring']"));

	}

	public WebElement ring_price() {
		return config.driver.findElement(By.xpath("//p[@class='price']//ins"));
	}
	
	public WebElement shoe_name() {
		return config.driver.findElement(By.xpath("//h2[text()='Shoes for Men']"));
		
	}
	
	public WebElement shoe_price() {
		return config.driver.findElement(By.xpath("//p[@class='price']//ins"));
	}
	
	public WebElement bracelate_name() {
		return config.driver.findElement(By.xpath("//h2[text()='Silver Bracelet for Men']"));
	}
	
	public WebElement bracelate_price() {
		return config.driver.findElement(By.xpath("//p[@class='price']//ins"));
	}
	
	public WebElement watch_name() {
		return config.driver.findElement(By.xpath("//h2[text()='Stylish-Rolex']"));
	}
	
	public WebElement watch_price() {
		return config.driver.findElement(By.xpath("//p[@class='price']//ins"));
	}

	public String actual_url() {
		return config.driver.getCurrentUrl();

	}
	
	public void compare_results(String Actual, String Expected) {

		assertTrue(Actual.equals(Expected), "Missmatch in the expected vs actual result");

	}

}
