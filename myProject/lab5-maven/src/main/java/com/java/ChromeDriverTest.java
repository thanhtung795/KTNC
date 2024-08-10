package com.java;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverTest {
	public static void main(String[] args) {
		ChromeDriverTest main = new ChromeDriverTest();
		main.verifyHomepageTitleChrome();
	}

	@Test
	public void verifyHomepageTitleChrome() {
		WebDriver driver = new ChromeDriver();
		String url = "https://mvnrepository.com/";
		String title_website = "Maven Repository: Search/Browse/Explore";
		String title_expected = "";
		driver.get(url);
		System.out.println(driver.getTitle());
		title_expected = driver.getTitle();
		if (title_expected.contentEquals(title_website)) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
		driver.quit();
	}
}
