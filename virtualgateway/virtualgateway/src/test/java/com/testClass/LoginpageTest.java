package com.testClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginpageTest {
	WebDriver driver;
	public LoginpageTest(WebDriver driver)
	{
		this.driver = driver;
	}
	By signin= By.linkText("Sign in");
	By username= By.xpath("//input[@id='identifierId']");
	//By next= By.xpath("//span[@class='CwaK9']");
	By next= By.xpath("//span[contains(@class,'RveJvd snByac')]");
	By password= By.xpath("//input[contains(@class,'whsOnd zHQkBf')]");
	By unread=By.xpath("//tr[@class='zA zE']");
	By num1=By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/div[2]/div[1]/span/div[1]/span/span[1]/span[2]");
	By num2=By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/div[2]/div[1]/span/div[1]/span/span[2]");
	//By unread=By.xpath("//tr[contains(@class,'zA zE')]");
	public WebElement signin() {
		return driver.findElement(signin);
	}
	public WebElement uname() {
		return driver.findElement(username);
	}
	public WebElement unext() {
		return driver.findElement(next);
	}
	public WebElement password() {
		return driver.findElement(password);
	}
	public List<WebElement> unreadmails() {
		return driver.findElements(unread);
	}
	public WebElement num1() {
		return driver.findElement(num1);
	}
	public WebElement num2() {
		return driver.findElement(num2);
	}
}
