package fpoly;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testSauce {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        String url = "https://www.saucedemo.com/";
        driver.get(url);
    }

    @Test
    public void testCase1() {
        // Đăng nhập vào trang web
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        String uri = driver.getCurrentUrl();

        assertEquals(uri, "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testCase2() {
        // Đăng nhập vào trang web
        driver.findElement(By.name("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();

        // Thêm kiểm tra trạng thái đăng nhập thất bại
        WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testCase3() {
        // Đăng nhập vào trang web
        driver.findElement(By.name("user-name")).sendKeys("problem_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        String uri = driver.getCurrentUrl();

        assertEquals(uri, "https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void testCase4() {
        // Đăng nhập vào trang web
        driver.findElement(By.name("user-name")).sendKeys("performance_glitch_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        String uri = driver.getCurrentUrl();

        assertEquals(uri, "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testCase5() {
        // Đăng nhập vào trang web
        driver.findElement(By.name("user-name")).sendKeys("error_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();

        String uri = driver.getCurrentUrl();

        assertEquals(uri, "https://www.saucedemo.com/inventory.html");

    }
    @Test
    public void testCase6() {
        // Đăng nhập vào trang web
        driver.findElement(By.name("user-name")).sendKeys("visual_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        String uri = driver.getCurrentUrl();

        assertEquals(uri, "https://www.saucedemo.com/inventory.html");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            try {
                // Chụp ảnh màn hình
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                // Tạo tên file với timestamp để tránh trùng lặp
                String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                String filePath = "./image_" + timestamp + ".png";

                // Lưu file
                FileUtils.copyFile(scrFile, new File(filePath));

                // Đợi 3 giây
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Đóng trình duyệt
            driver.quit();
        }
    }
}
