package fpoly;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class Bai1 {
	static WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		String url = "https://caodang.fpt.edu.vn/wp-login.php?redirect_to=https%3A%2F%2Fcaodang.fpt.edu.vn%2Fwp-admin%2F&reauth=1";
		driver.get(url);
	}

//	@Ignore
	@Test(priority = 1)
	public void testCase1() {
		
		driver.findElement(By.name("log")).sendKeys("ps27852");
		driver.findElement(By.name("pwd")).sendKeys("tung12386");
	
		driver.findElement(By.name("pwd")).sendKeys(Keys.ENTER);

		String currentUrl = driver.getCurrentUrl();
//		chupManHinh();
		Assert.assertTrue(currentUrl.contains("TrangChu"),
				"URL hiện tại không chứa 'thongtincanhan'. Đăng nhập không thành công.");

	}
	

//	static void chupManHinh() {
//		// Chụp ảnh màn hình
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//		// Tạo tên file với timestamp để tránh trùng lặp
//		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//		String filePath = "./image_" + timestamp + ".png";
//
//		// Lưu file
//		try {
//			FileUtils.copyFile(scrFile, new File(filePath));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	@AfterTest
	public void teardown() {
		if (driver != null) {
//			try {
//				Thread.sleep(6000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			// Đóng trình duyệt
			driver.quit();
		}
	}
}
