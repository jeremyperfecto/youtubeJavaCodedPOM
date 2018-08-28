/**
 * 
 */
package com.quantum.pages;

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
public class HomePage extends BasePage {

	
	
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}
	
	public HomePage()
	{
		DeviceUtils.switchToContext("NATIVE_APP");
		validate();
	}
	
	public HomePage(boolean validate)
	{
		DeviceUtils.switchToContext("NATIVE_APP");
		if(validate)
		{
		validate();
		}
	}
	
	public void validate()
	{
		menuTrending.waitForVisible(ConfigurationManager.getBundle().getLong("custom.timeout"));
		menuTrending.waitForEnabled(ConfigurationManager.getBundle().getLong("custom.timeout"));
	
	}

}
