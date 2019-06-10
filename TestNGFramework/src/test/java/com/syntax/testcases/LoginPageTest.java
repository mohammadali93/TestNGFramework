package com.syntax.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass{

	@Test(enabled=false)
	public void loginToORangeHRM()
	{
		LoginPageWithoutPageFactory login= new LoginPageWithoutPageFactory();
		CommonMethods.sendText(login.username, "Admin");
		CommonMethods.sendText(login.password, "V9YwHwi@0Y");
		CommonMethods.click(login.btnLogin);
	}
	
	@Test
	public void doLogin()
	{
		LoginPage login= new LoginPage();
		CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);
		
		HomePage home = new HomePage();
		boolean isDisplayed= home.dashboardText.isDisplayed();
		
		Assert.assertTrue(isDisplayed);
	}
	@Test
	public void negativeLogin() throws InterruptedException
	{
		LoginPage login= new LoginPage();
		CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username1"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password1"));
		CommonMethods.click(login.loginBtn);
		
		HomePage home = new HomePage();
		boolean isDisplayed= home.Invalid.isDisplayed();
		
		Thread.sleep(6000);
		Assert.assertTrue(isDisplayed);
		System.out.println("Login Failed");
		
	}
}
