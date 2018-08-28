/**
 * 
 */
package com.quantum.pages;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.DriverUtils;

/**
 * @author chirag.jayswal
 *
 */
@QAFTestStepProvider
public class SearchPageResults extends BasePage {

	@FindBy(locator = "searchResult.listing")
	private QAFExtendedWebElement resultListing;
	
	

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}
	
	public SearchPageResults()
	{
		validate();
	}
	
	public SearchPageResults(boolean validate)
	{
		if(validate)
		{
			validate();
		}
	}
	
	public void validate()
	{
		resultListing.waitForVisible(ConfigurationManager.getBundle().getLong("custom.timeout"));
		resultListing.waitForEnabled(ConfigurationManager.getBundle().getLong("custom.timeout"));
	
	}
	
	public PlaybackPage selectVideo(String video)
	{
		QAFExtendedWebElement we = driver.findElementByXPath("//*[@text=\""+video+"\"]");
		we.click();
		return new PlaybackPage();
	}

}
