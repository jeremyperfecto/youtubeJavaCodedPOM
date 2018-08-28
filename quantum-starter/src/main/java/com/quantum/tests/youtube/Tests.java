package com.quantum.tests.youtube;

import java.util.Map;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.core.TestBaseProvider;
import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.pages.HomePage;
import com.quantum.pages.SearchPageMini;
import com.quantum.pages.SearchPageResults;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.DriverUtils;

public class Tests extends BaseTest {

	@QAFDataProvider(dataFile = "src/main/resources/data/testData.csv")
	@Test(groups = { "regression" })
	public void searchAndPlay(Map<String, String> data) {
		HomePage homePage = new HomePage();
		
		SearchPageMini sp = homePage.openSearch();
		
		SearchPageResults spr = sp.searchFor(data.get("search"));
		
		spr.selectVideo(data.get("video"));
		
		spr.displayMenu();
	
	}

}
