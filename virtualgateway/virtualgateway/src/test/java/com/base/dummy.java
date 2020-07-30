package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dummy {

	public static void main(String[] args) throws IOException, InterruptedException {
			System.setProperty("webdriver.gecko.driver", "H://Chromeselenium//geckodriver.exe");
			 WebDriver driver = new FirefoxDriver();
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
			System.out.println(driver.findElements(By.tagName("iframe")).size());
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='main-nav']//a[@href='/contacts']")).click();
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//a[@href='/contacts/new']//button[contains(@class,'ui linkedin button')]")).click();
			driver.findElement(By.xpath("//a[@href='/contacts/new']/button")).click();
			//driver.findElement(By.xpath("//a[@href='/contacts/new']descendant::button")).click();
			driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("tom");
			driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("cruize");
			driver.findElement(By.xpath("//input[@class='search' and @type='text']")).sendKeys("CTS");
			//}
			
		}

	}

