package com.orangehrm.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.orangehrm.base.BaseTest;
import com.orangehrm.utils.LoadConfigProperties;

public class TestNGSuiteParamListener implements ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		System.out.println("🚀 TestNG Suite Started: " + suite.getName());

		String configFile = suite.getXmlSuite().getParameter("config.file");
		String browser = suite.getXmlSuite().getParameter("browser");
		String headless = suite.getXmlSuite().getParameter("headless");

		if (configFile == null)
			configFile = "config-qa";
		if (browser == null)
			browser = "chrome";
		if (headless == null)
			headless = "false";

		LoadConfigProperties.loadProperties(configFile);
		System.out.println("⚙️ Config File Loaded: " + configFile);
		
		BaseTest.initBrowser(browser, Boolean.parseBoolean(headless));
	}
	
    @Override
    public void onFinish(ISuite suite) {
        BaseTest.closeBrowser();
        System.out.println("🚀 TestNG Suite Finished Successfully: " + suite.getName());
    }

}
