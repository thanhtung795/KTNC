package com.java;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverTest {
	public static void main(String[] args) {
		EdgeDriverTest main = new EdgeDriverTest();
		main.verifyHomepageTitleEdge();
	}

	@Test
	public void verifyHomepageTitleEdge() {
		WebDriver driver = new EdgeDriver();
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
