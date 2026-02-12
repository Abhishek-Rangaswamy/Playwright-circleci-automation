package com.orangehrm.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.orangehrm.base.BaseTest;
import com.orangehrm.reports.ExtentManager;
import com.orangehrm.utils.LoadConfigProperties;

public class TestNGSuiteParamListener implements ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		System.out.println("🚀 TestNG Suite Started: " + suite.getName());

		String configFile = suite.getXmlSuite().getParameter("config.file");
		String browser = suite.getXmlSuite().getParameter("browser");
		String headless = suite.getXmlSuite().getParameter("headless");

		LoadConfigProperties.loadProperties(configFile);
		System.out.println("⚙️ Config File Loaded: " + configFile);
		
		ExtentManager.initReport(suite.getName());
		System.out.println("📊 Extent Report Initialized");
		
		BaseTest.initBrowser(browser, Boolean.parseBoolean(headless));
		System.out.println("🌐 Browser Initialized: " + browser + " | Headless: " + headless);
	}
	
    @Override
    public void onFinish(ISuite suite) {
    	LoadConfigProperties.unloadProperties();
        BaseTest.closeBrowser();
        ExtentManager.flushReport();
        System.out.println("🚀 TestNG Suite Finished Successfully: " + suite.getName());
    }

}
