package com.base;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.testClass.LoginpageTest;

public class ApplicationTest {
	@Test
	public void gmail() throws InterruptedException {
		int sum=0;
		int count=0;
		System.setProperty("webdriver.gecko.driver", "H:\\Chromeselenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.navigate().to("https://www.gmail.com/");
		LoginpageTest a = new LoginpageTest(driver);
		a.signin().click();
		WebDriverWait d  = new WebDriverWait(driver,5);
		Thread.sleep(3000);
		Set<String> ids = driver.getWindowHandles();
		System.out.println(ids);
		Iterator<String> it = ids.iterator();
		String parentid = it.next();
		System.out.println(driver.getTitle());
		String childid = it.next();
		driver.switchTo().window(childid);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		a.uname().sendKeys("manoj63sd@gmail.com");
		//Thread.sleep(3000);
		a.unext().click();
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		a.password().sendKeys("mannoj11.v");
		a.unext().click();
		Thread.sleep(5000);
		a.password().sendKeys("mannoj11.v");
		a.unext().click();
		Thread.sleep(3000);
		System.out.println("before while loop");
		//System.out.println(driver.findElements(By.xpath("//tr[contains(@class,'zA zE')]")).size());
		wh1:
		while(driver.findElement(By.id(":lb")).isEnabled()) {
			int each = a.unreadmails().size();
			count = count + each;
			System.out.println(a.num1().getText()+"has "+each+" unread mails");
			System.out.println("Cumulative count is "+count);
			sum = a.unreadmails().size() + sum;
			driver.findElement(By.id(":lb")).click();
			Thread.sleep(3000);
			String s1;
			String s2;
			if (a.num1().getText().equals(a.num2().getText())) {
				s1 = a.num1().getText();
				s2 = a.num2().getText();
				System.out.println(s1+" "+s2);
				int each1 = a.unreadmails().size();
				System.out.println("last page "+each1);
				int last = sum + a.unreadmails().size();
				last= last - 1;
				System.out.println("The no. of unread mails are " + last);
				break wh1;
			}
		}
	}
}
