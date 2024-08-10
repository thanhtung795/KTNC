package lab5bai1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class edgePoly {
	  WebDriver driver;

	    @BeforeClass
	    public void setup() {
//	        System.setProperty("webdriver.chrome.driver", "D:\\FPT\\KTNC\\chromedriver-win64\\chromedriver.exe");
	        driver = new EdgeDriver();
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
