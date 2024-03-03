package com.selenium.java.pageObject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.automation.config.config;

public class shopPage_Objects {

	By blue_suite_tie_price = By.xpath("(//span[@class='price'])[1]");

	public WebElement blue_suite_tie_price() {
		return config.driver.findElement(blue_suite_tie_price);
	}
	

	By blue_suite_tie_name = By.xpath("//h2[text()='Blue_suit_with_tie']");

	public WebElement blue_suite_Name() {
		return config.driver.findElement(blue_suite_tie_name);
	}

	By guy_ring = By.xpath("//h2[text()='MasterGuy Ring']");

	public WebElement master_guy_ring_name() {
		return config.driver.findElement(guy_ring);
	}
	
	By ring_price = By.xpath("(//span[@class='price'])[2]");
	
	public WebElement master_guy_ring_price() {
		return config.driver.findElement(ring_price);
	}

	By mens_shoes = By.xpath("//h2[text()='Shoes for Men']");

	public WebElement shoes_for_men_name() {
		return config.driver.findElement(mens_shoes);
	}
	
	By mens_shoes_price = By.xpath("(//span[@class='price'])[3]");
	
	public WebElement shoes_price_test() {
		return config.driver.findElement(mens_shoes_price);
		
	}

	By bracelete = By.xpath("//h2[text()='Silver Bracelet for Men']");

	public WebElement silver_bracelete_name() {
		return config.driver.findElement(bracelete);
	}
	
	By men_bracelet_price = By.xpath("(//span[@class='price'])[4]");
	public WebElement bracelet_price () {
		return config.driver.findElement( men_bracelet_price);
	}

	By Rolex_watch = By.xpath("//h2[text()='Stylish-Rolex']");

	public WebElement rolex_watch() {
		return config.driver.findElement(Rolex_watch);
	}
	
	By rolex_watch_price = By.xpath("(//span[@class='price'])[5]");
	
	public WebElement watch_price() {
		
		return config.driver.findElement(rolex_watch_price);
	}

	public String actual_url() {
		return config.driver.getCurrentUrl();

	}
	
	By sorting_dropdown = By.xpath("//select[@class='orderby']");
	
	public WebElement sorting_dropdown() {
		return config.driver.findElement(sorting_dropdown);
	}

	public void compare_results(String expectedShopUrl, String actual_url) {
		assertTrue(actual_url.equals(expectedShopUrl), "Missmatch in the expected vs actual result");

	}

}
