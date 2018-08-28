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
public class SearchPageMini extends BasePage {

	@FindBy(locator = "search.searchBox")
	private QAFExtendedWebElement searchBox;
	
	@FindBy(locator = "search.searchBack")
	private QAFExtendedWebElement searchBack;
	
	@FindBy(locator = "search.searchSuggestion")
	private QAFExtendedWebElement searchSuggestion;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}
	
	public SearchPageMini()
	{
		validate();
	}
	
	public SearchPageMini(boolean validate)
	{
		if(validate)
		{
			validate();
		}
	}
	
	public void validate()
	{
		searchBox.waitForVisible(ConfigurationManager.getBundle().getLong("custom.timeout"));
		searchBox.waitForEnabled(ConfigurationManager.getBundle().getLong("custom.timeout"));
	
	}
	
	public boolean isSearchOpen()
	{
		try
		{
			return searchBack.isDisplayed();
		}
		catch(Exception ex)
		{
			return false;
		}
		
	}
	
	public void closeSearch()
	{
		if(isSearchOpen())
		{
		searchBack.click();
		}
		
	}
	
	public SearchPageResults searchFor(String value)
	{
		searchBox.sendKeys(value);
		searchSuggestion.click();
		return new SearchPageResults();
	}
	
	

}
