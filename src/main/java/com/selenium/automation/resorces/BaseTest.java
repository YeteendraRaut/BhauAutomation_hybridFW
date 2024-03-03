package com.selenium.automation.resorces;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.selenium.automation.config.config;
import com.selenium.java.pageObject.Homepage_Objects;
public class BaseTest {
  
	String browsername;
	
    Properties prop;
    String run_url;
    Homepage_Objects homepage;

    public static ExtentHtmlReporter htmlReport;
    
    public static ExtentReports extent;
    
    public static ExtentTest test;
    
	@BeforeSuite
	public void Beforesuit() {
	  System.out.println("Welcome To automation framework..!!");
	  
	  htmlReport= new ExtentHtmlReporter(System.getProperty("user.dir")+"/All-Reports/AutomationReport-html");
	  extent =new ExtentReports();
	  extent.attachReporter(htmlReport);
	  extent.setSystemInfo("Project_Name","Automation_Selenium_project");
	  extent.setSystemInfo("Host_Name", "bhauautomationlab.com");
	  extent.setSystemInfo("UserName","Yeteendra");
	  
	}
	
	@BeforeMethod
	public void launch_application() throws IOException {
		
		load_testData_File();
		browsername= prop.getProperty("Browser_Name");
		run_url=prop.getProperty("Platform_url");
		//browsername= "firefox";
		if(browsername.equalsIgnoreCase("chrome")) {
		config.driver=new ChromeDriver();
		//config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		config.driver.get(run_url);
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			config.driver=new FirefoxDriver();
			//config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			config.driver.get(run_url);
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			config.driver=new EdgeDriver();
			//config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			config.driver.get(run_url);
		
		}
		close_popup();
	}
	public void	load_testData_File() throws IOException {
		
	 prop =new Properties();
	 
	 FileInputStream inputStream=new FileInputStream(System.getProperty("user.dir")+"/TestData.File/Global_TestData.Properties");
	 prop.load(inputStream);
	}
	public void close_popup() {
		config.driver.findElement(By.xpath("//button[@type='button']")).click();

	}

	@AfterMethod
	public void tearDown() {
		config.driver.quit();
	}

	@AfterSuite
	public void flush() {
		extent.flush();
	}

	
}
