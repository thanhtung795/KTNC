package lab6bai1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChormPolyTest {
	  WebDriver driver;

	    @BeforeClass
	    public void setup() {
//	        System.setProperty("webdriver.chrome.driver", "D:\\FPT\\KTNC\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	    }

	    @Test
	    public void verifyHomepageTitle() {
	        String url = "http://lms.poly.edu.vn/";
	        String expectedTitle = "FPT Polytechnic"; // Cập nhật giá trị mong đợi

	        driver.get(url);
	        String actualTitle = driver.getTitle();

	        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
	    }

	    @AfterClass
	    public void teardown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
