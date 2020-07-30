package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public static WebDriver driver;
	public void browsersetup() throws IOException {
		System.setProperty("webdriver.gecko.driver", "H://Chromeselenium//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/test/java/com/property"
				+ "/property1.properties");
			prop.load(ip);
		driver.get(prop.getProperty("url"));
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Log In']")));
		login.click();
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		
	}
}
