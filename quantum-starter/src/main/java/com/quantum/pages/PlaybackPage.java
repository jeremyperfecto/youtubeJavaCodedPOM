/**
 * 
 */
package com.quantum.pages;

import java.util.HashMap;
import java.util.Map;

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
public class PlaybackPage extends BasePage {

	@FindBy(locator = "playback.miniVideo.close")
	private QAFExtendedWebElement closeMiniVideo;
	
	@FindBy(locator ="playback.videoWindowLarge")
	private QAFExtendedWebElement largerVideoPanel;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}
	
	public PlaybackPage(boolean validate)
	{
		if(validate)
		{
			validate();
		}
	}
	
	public PlaybackPage()
	{
		validate();
	}
	
	public void validate()
	{
		
	}
	
	public void closeVideo()
	{
		if(isVideoOpen())
		{
		Map<String, Object> params24 = new HashMap<>();
		params24.put("start", "706,294");
		params24.put("end", "561,2560");
		params24.put("duration", "2");
		Object result24 = driver.executeScript("mobile:touch:swipe", params24);
	
		closeMiniVideo.click();
		}
	}
	
	public boolean isVideoOpen()
	{
		try
		{
			return largerVideoPanel.isDisplayed();
		}
		catch(Exception ex)
		{
			return false;
		}
		
	}

}
