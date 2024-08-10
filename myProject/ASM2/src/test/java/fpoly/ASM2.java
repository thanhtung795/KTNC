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


public class ASM2 {
	static WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		String url = "http://localhost:8080/fpoly/views/TrangChu";
		driver.get(url);
	}

//	@Ignore
	@Test(priority = 1)
	public void dangNhapTest() {
		driver.findElement(By.name("thongtincanhan")).click();
		driver.findElement(By.name("email")).sendKeys("tungvt@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123");
		chupManHinh();
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);

		// Kiểm tra rằng sau khi đăng nhập thành công, người dùng được chuyển hướng đến
		// trang thông tin cá nhân
		String currentUrl = driver.getCurrentUrl();
//		chupManHinh();
		Assert.assertTrue(currentUrl.contains("TrangChu"),
				"URL hiện tại không chứa 'thongtincanhan'. Đăng nhập không thành công.");

		chupManHinh();
	}
	

//	@Ignore
	@Test(priority = 2)
	public void dangXuatTest() {
		driver.findElement(By.name("thongtincanhan")).click();
		chupManHinh();
		driver.findElement(By.name("btnDangXuat")).click();
		String currentUrl = driver.getCurrentUrl();
//		chupManHinh();
		// Kiểm tra rằng sau khi đăng xuất, người dùng được chuyển hướng đến trang chủ
		// hoặc trang đăng nhập
		Assert.assertTrue(currentUrl.contains("logout"));
		
		chupManHinh();
	}

//	@Ignore
	@Test(priority = 3)
	public void xemideoTest() {
		driver.findElement(By.name("thongtincanhan")).click();
		driver.findElement(By.name("email")).sendKeys("tungvt@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		chupManHinh();
		driver.findElement(By.name("titleVideo")).click();

		String currentUrl = driver.getCurrentUrl();

		// Kiểm tra rằng sau khi đăng xuất, người dùng được chuyển hướng đến trang chủ
		// hoặc trang đăng nhập
		Assert.assertTrue(currentUrl.contains("detail"));
		chupManHinh();
	}

//	@Ignore
	@Test(priority = 4)
	public void timVideoTest() {
		driver.findElement(By.name("search")).sendKeys("I Quit");
		driver.findElement(By.name("search")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("titleVideo")).click();
		chupManHinh();

		String currentUrl = driver.getCurrentUrl();

		// Kiểm tra rằng sau khi đăng xuất, người dùng được chuyển hướng đến trang chủ
		// hoặc trang đăng nhập
//		Assert.assertTrue(currentUrl.contains("search"));
		Assert.assertTrue(currentUrl.contains("detail"));
		chupManHinh();
	}

//	@Ignore
	@Test(priority = 5)
	public void TTCNTest() {

		driver.findElement(By.name("TTCN")).click();
		chupManHinh();
		String currentUrl = driver.getCurrentUrl();

		Assert.assertTrue(currentUrl.contains("hongtincanhan"));

		chupManHinh();
	}

//	@Ignore
	@Test(priority = 6)
	public void videoDaXemTest() {

		driver.findElement(By.name("VideoDaXem")).click();
		chupManHinh();
		String currentUrl = driver.getCurrentUrl();

		Assert.assertTrue(currentUrl.contains("watched"));

		chupManHinh();
	}

//	@Ignore
	@Test(priority = 7)
	public void videoDaThichTest() {

		driver.findElement(By.name("videoDaThich")).click();
		chupManHinh();
		String currentUrl = driver.getCurrentUrl();

		Assert.assertTrue(currentUrl.contains("favorite_video"));

		chupManHinh();
	}

//	@Ignore
	@Test(priority = 8)
	public void quanLyVideoTest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("quanLyVideo"))).click();
		chupManHinh();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("create_update"));
		
		chupManHinh();
	}

//	@Ignore
	@Test(priority = 9)
	public void ThemVideoTest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(By.name("quanLyVideo"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("themVideo"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("videoTitle")))
				.sendKeys("Music Chill & Free - Những bài hát của Đen Vâu hay nhất");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("videoLink")))
				.sendKeys("https://www.youtube.com/watch?v=lgN4mzWYQhU");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("imageDescription"))).sendKeys(
				"Cảm ơn mọi người đã xem. Ủng hộ bằng cách đăng kí kênh\r\n" + "Đăng kí kênh để không bỏ lỡ video nhé");
		chupManHinh();
		driver.findElement(By.id("saveButton")).click();

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("create_update"));

		chupManHinh();
	}

//	@Ignore
	@Test(priority = 10)
	public void updateVideoTest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Mở trang quản lý video
		wait.until(ExpectedConditions.elementToBeClickable(By.name("quanLyVideo"))).click();

		// Chọn video để cập nhật
		WebElement updateButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@name='videoId'][@value='1']/following-sibling::button")));
		updateButton.click();

		// Cập nhật mô tả video
		WebElement imageDescription = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("imageDescription")));
		imageDescription.clear(); // Xóa nội dung hiện tại trong trường
		imageDescription.sendKeys(
				"Cảm ơn mọi người đã xem. Ủng hộ bằng cách đăng kí kênh. Đăng kí kênh để không bỏ lỡ video nhé");

		// Lưu thay đổi
		WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("saveVideo")));
		chupManHinh();
		saveButton.click();
		// Chờ hộp thoại alert xuất hiện
		wait.until(ExpectedConditions.alertIsPresent());

		// Chuyển sang alert và bấm OK
		Alert alert = driver.switchTo().alert();
		alert.accept();
		// Xác nhận rằng trang đã chuyển hướng sau khi cập nhật
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("update_video"));
		
		chupManHinh();
	}

//	@Ignore
	@Test(priority = 11)
	public void thongKeTest() {

		driver.findElement(By.name("thongKe")).click();
		
		String currentUrl = driver.getCurrentUrl();

		Assert.assertTrue(currentUrl.contains("thongke"));

		chupManHinh();
	}

//	@Ignore
	@Test(priority = 11)
	public void thongKeDanhSachThichTest() {

		driver.findElement(By.name("thongKe")).click();
		driver.findElement(By.id("user-likes-tab")).click();
		driver.findElement(By.id("videoTitleInput")).sendKeys("I Quit My Job as a Data Scientist");
		chupManHinh();

		String currentUrl = driver.getCurrentUrl();

		Assert.assertTrue(currentUrl.contains("thongke"));

		chupManHinh();
	}

//	@Ignore
	@Test(priority = 12)
	public void thongKeDanhShareTest() {

		driver.findElement(By.name("thongKe")).click();
		driver.findElement(By.id("user-shared-tab")).click();
		driver.findElement(By.id("shareInput")).sendKeys("q");
		chupManHinh();
		String currentUrl = driver.getCurrentUrl();

		Assert.assertTrue(currentUrl.contains("thongke"));

		chupManHinh();
	}

//	@Ignore
	@Test(priority = 12)
	public void trangChuTest() {

		driver.findElement(By.name("TrangChu")).click();

		String currentUrl = driver.getCurrentUrl();

		Assert.assertTrue(currentUrl.contains("TrangChu"));

		chupManHinh();
	}

//	@Ignore
	@Test(priority = 13)
	public void dangKyTest() {
		
		driver.findElement(By.name("thongtincanhan")).click();
		driver.findElement(By.name("btnDangXuat")).click();
		driver.findElement(By.name("thongtincanhan")).click();
		driver.findElement(By.name("btnDangKy")).click();

		driver.findElement(By.name("fullname")).sendKeys("Phan Huy Hoang");
		driver.findElement(By.name("email")).sendKeys("phanhuyhoang2@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.name("repassword")).sendKeys("123");
		chupManHinh();
		driver.findElement(By.name("btnDangKyTk")).click();

		String curretUri = driver.getCurrentUrl();

		Assert.assertTrue(curretUri.contains("signup"));

		chupManHinh();
	}

//	@Ignore
	@Test(priority = 14)
	public void quenMatKhauTest() throws Exception {
		driver.findElement(By.name("btnDangXuat")).click();
		driver.findElement(By.name("thongtincanhan")).click();
		driver.findElement(By.name("forgotPassword")).click();

		driver.findElement(By.name("email")).sendKeys("vothanhtung795@gmail.com");
		driver.findElement(By.name("guiMail")).click();
		chupManHinh();
		String curretUri = driver.getCurrentUrl();
		Assert.assertTrue(curretUri.contains("forgotPassword"));
		
		chupManHinh();

	}

	static void chupManHinh() {
		// Chụp ảnh màn hình
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Tạo tên file với timestamp để tránh trùng lặp
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String filePath = "./image_" + timestamp + ".png";

		// Lưu file
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void teardown() {
		if (driver != null) {
			try {
//				// Chụp ảnh màn hình
//				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//				// Tạo tên file với timestamp để tránh trùng lặp
//				String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//				String filePath = "./image_" + timestamp + ".png";
//
//				// Lưu file
//				FileUtils.copyFile(scrFile, new File(filePath));
//
//				// Đợi 3 giây
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Đóng trình duyệt
			driver.quit();
		}
	}
}
