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
public class BasePage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "menu.home")
	public QAFExtendedWebElement menuHome;

	@FindBy(locator = "menu.trending")
	public QAFExtendedWebElement menuTrending;

	@FindBy(locator = "menu.subscriptions")
	public QAFExtendedWebElement menuSubscriptions;

	@FindBy(locator = "menu.activity")
	public QAFExtendedWebElement menuActivity;

	@FindBy(locator = "menu.library")
	public QAFExtendedWebElement menuLibrary;

	@FindBy(locator = "playback.miniVideo.close")
	public QAFExtendedWebElement closeMiniVideo;

	@FindBy(locator = "search.searchIcon")
	public QAFExtendedWebElement searchIcon;

	@FindBy(locator = "home.update.notNow")
	private QAFExtendedWebElement noUpdate;

	@FindBy(locator = "home.premium.dismiss")
	private QAFExtendedWebElement noRed;

	@FindBy(locator = "home.analytics.dismiss")
	private QAFExtendedWebElement noAnalytics;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public void displayMenu() {
		if (!isMenuDisplayed()) {
			SearchPageMini sp = new SearchPageMini(false);
			sp.closeSearch();

			PlaybackPage pbp = new PlaybackPage();
			pbp.closeVideo();

			menuHome.click();
			validateBase();
		}

	}

	public void validateBase() {
		menuTrending.waitForVisible(ConfigurationManager.getBundle().getLong("custom.timeout"));
		menuTrending.waitForEnabled(ConfigurationManager.getBundle().getLong("custom.timeout"));

	}

	public boolean isMenuDisplayed() {
		try {
			return menuHome.isDisplayed();
		}

		catch (Exception ex) {
			return false;
		}
	}

	public SearchPageMini openSearch() {
		displayMenu();
		searchIcon.click();
		return new SearchPageMini();
	}

	public void dismissPopups() {
		if (noUpdate.isPresent()) {
			noUpdate.click();
		}

		if (noRed.isPresent()) {
			noRed.click();
		}

		if (noAnalytics.isPresent()) {
			noAnalytics.click();
		}
	}

}
