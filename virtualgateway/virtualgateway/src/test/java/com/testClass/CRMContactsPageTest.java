package com.testClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.repository.CRMContactsPage;
import com.repository.CRMHomePage;
import com.testutil.UtilityTest;

public class CRMContactsPageTest extends TestBase {
	CRMContactsPageTest ct;
	CRMContactsPage contact;
	CRMHomePage hp;
	UtilityTest util;
	String sheetName = "Sheet1";
	
	@Test(priority=1)
	public void setup() throws IOException {
		ct = new CRMContactsPageTest();
		contact= new CRMContactsPage(driver);
		hp= new CRMHomePage(driver);
		util = new UtilityTest();
		ct.browsersetup();
	}
	@Test(priority=2)
	public void validateTitle() {
		Assert.assertEquals(driver.getTitle(), "CRM");
	}
	/*@Test(priority=3)
	public void clickContactlink() {
		System.out.println(contact.clickContact());
	}*/
	
	@Test(priority=3)
	public void clickcontactlink() throws InterruptedException {
		contact.clickContact();
	}
	/*@Test(priority=5)
	public void closdriver() {
		hp.closeDriver();
	}*/
	
	@DataProvider
	public Object[][] getCRMTestData() throws EncryptedDocumentException, IOException{
		Object data[][] = UtilityTest.getTestData(sheetName);
		return data;
	}
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateAddNewContact(String ftn, String ltn, String cmp) throws InterruptedException, EncryptedDocumentException, IOException {
		contact.clickContact();
		contact.clickNew();
		contact.addcontact(ftn, ltn, cmp);
		Thread.sleep(2000);
	}
}
