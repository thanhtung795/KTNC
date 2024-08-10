package fpoly;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		String url = "http://youtube.com/";

		driver.get(url);

		driver.findElement(By.name("search_query")).sendKeys("Thoi anh nhan nhuong");
		driver.findElement(By.name("search_query")).sendKeys(Keys.ENTER);
	
	}
}
