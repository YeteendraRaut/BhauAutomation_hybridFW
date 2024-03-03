package com.selenium.automation.utilty;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.selenium.automation.config.config;



public class Utility {

	public static String TakeScreenshot() throws IOException  {
	TakesScreenshot ts=(TakesScreenshot)config.driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	Calendar cal= Calendar.getInstance();
	Date time = cal.getTime();
	String currentTimeStamp=time.toString();
	String systemTime = currentTimeStamp.replace(":", "_");
	String CurrentSystemTime= systemTime.replace(" ", "_");
	String dest=System.getProperty("user.dir")+"/All-Screenshots/Script_Status_" + CurrentSystemTime + ".png";
	
	File destination = new File(dest);
	
	FileUtils.copyFile(source,destination);
	return dest;
}
}