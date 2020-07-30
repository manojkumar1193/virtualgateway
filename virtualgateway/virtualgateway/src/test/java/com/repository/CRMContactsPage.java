package com.repository;

import java.io.File;
import java.util.List;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.base.TestBase;
import com.testClass.CRMContactsPageTest;

public class CRMContactsPage extends TestBase{
	//WebDriver driver;
	public CRMContactsPage(WebDriver driver) {
		this.driver=driver;
	}
	By contact = By.xpath("//span[@class='item-text']");
	By newButton = By.xpath("//a[@href='/contacts/new']//button[contains(@class,'ui linkedin button')]");
	By ftname = By.xpath("//input[@name='first_name']");
	By ltname = By.xpath("//input[@name='last_name']");
	By comp = By.xpath("//input[@class='search' and @type='text']");
	//By comp = By.xpath("//input[@class='search']");
	By savebtn = By.xpath("//div[@class='item']//button[contains(@class,'ui linkedin button')]");
	
	public void clickContact() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='/contacts']")).click();
	}
	public void clickNew() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(newButton).click();
	}
	public void addcontact(String firstname,String lastname, String company) {
		driver.findElement(ftname).sendKeys(firstname);
		driver.findElement(ltname).sendKeys(lastname);
		driver.findElement(comp).sendKeys(company);
		//driver.findElement(savebtn).click();
	}
}
