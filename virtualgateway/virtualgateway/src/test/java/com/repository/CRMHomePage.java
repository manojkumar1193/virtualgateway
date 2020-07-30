package com.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.TestBase;

public class CRMHomePage extends TestBase{
	//WebDriver driver;
	public CRMHomePage(WebDriver driver) {
		this.driver = driver;
	}
	By nameOfUser = By.className("user-display");
	
	public boolean nameOfUser() {
		return driver.findElement(nameOfUser).isDisplayed();
	}
	public String getName() {
		System.out.println("Hello, is this "+driver.findElement(nameOfUser).getText());
		return driver.findElement(nameOfUser).getText();
	}
	public void closeDriver() {
		driver.close();
	}
}
