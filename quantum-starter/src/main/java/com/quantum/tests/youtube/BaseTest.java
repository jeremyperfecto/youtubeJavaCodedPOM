package com.quantum.tests.youtube;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.core.TestBaseProvider;
import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.pages.BasePage;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.DriverUtils;

public class BaseTest extends WebDriverTestCase {

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws InterruptedException {
	
		try
		{
		DriverUtils.getAppiumDriver().closeApp();
		}
		catch(Exception ex)
		{
			
		}
		try
		{
		DriverUtils.getAppiumDriver().closeApp();
		}
		catch(Exception ex)
		{
			
		}
		
		DriverUtils.getAppiumDriver().launchApp();
		
		
		BasePage bp = new BasePage();
		bp.dismissPopups();
	
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws InterruptedException {
	
		try
		{
		DriverUtils.getAppiumDriver().closeApp();
		}
		catch(Exception ex)
		{
			
		}
	
	}

}
