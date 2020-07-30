package com.testClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.repository.CRMHomePage;

public class CRMHomepageTest extends TestBase{
	CRMHomepageTest home;
	CRMHomePage crmhome;
	@Test(priority=1)
	public void setup() throws IOException {
		home = new CRMHomepageTest();
		crmhome = new CRMHomePage(driver);
		home.browsersetup();
	}
	@Test(priority=2)
	public void validateTitle() {
		Assert.assertEquals(driver.getTitle(), "CRM");
	}
	@Test(priority=3)
	public void usrnamevalidation() throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertTrue(crmhome.nameOfUser());
	}
	@Test(priority=4)
	public void usernamecheck() {
		Assert.assertEquals(crmhome.getName(), "Manoj Kumar");
	}
	@Test(priority=5)
	public void quit() {
		crmhome.closeDriver();
	}
}
