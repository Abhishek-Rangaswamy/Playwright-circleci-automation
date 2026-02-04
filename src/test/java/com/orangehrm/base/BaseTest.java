package com.orangehrm.base;

import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.orangehrm.utils.LoadConfigProperties;

public class BaseTest {

	protected static Playwright playwright;
	protected static BrowserType browserType;
	protected static Browser browser;
	protected static BrowserContext browserContext;
	protected static Page page;

	public static void initBrowser(String browserName, boolean headless) {

		int slowMoProp = Integer.parseInt(LoadConfigProperties.getProperty("slow_mo"));

		playwright = Playwright.create();

		switch (browserName.toLowerCase()) {

			case "chrome": {
				browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless)
						.setArgs(Arrays.asList("--start-maximized")).setSlowMo(slowMoProp));
				break; // Added break to prevent fall-through
			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + browserName); // Fixed typo
		}

		browserContext = browser.newContext();
		page = browserContext.newPage();
		PlaywrightManager.setPage(page);
	}

	public static void closeBrowser() {
		page.waitForTimeout(5000);
		browserContext.close();
		page.close();
		browser.close();
		playwright.close();
	}

}
