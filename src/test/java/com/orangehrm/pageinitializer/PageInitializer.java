package com.orangehrm.pageinitializer;

import com.microsoft.playwright.Page;
import com.orangehrm.actions.ActionHelper;
import com.orangehrm.base.PlaywrightManager;
import com.orangehrm.pages.LoginPage;

public class PageInitializer extends PlaywrightManager {
	
	protected Page page;
	
	//Actions
	protected ActionHelper actionHepler;
	
	//Pages
	protected LoginPage loginPage;
	
	public PageInitializer() {
		this.page = PlaywrightManager.getPage();
		this.actionHepler = new ActionHelper(page);
		this.loginPage = new LoginPage(page);
	}
	
}
