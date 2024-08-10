package lab1;

import org.junit.Test;
import junit.framework.TestCase;

public class AppTest extends TestCase {

	// Định nghĩa class AppTest, kế thừa từ TestCase của JUnit 4.

	public AppTest(String testName) {
		super(testName);
	}

	// Constructor của class AppTest, nhận tham số testName và gọi constructor của lớp cha TestCase với tham số này.
	// Tham số testName được sử dụng để đặt tên cho test case.

	public void testApp() {
		assertTrue(true);
	}

	// Phương thức test mặc định, luôn luôn thành công vì assertTrue(true) luôn đúng.
	// Mục đích chủ yếu là kiểm tra xem cơ chế kiểm thử có hoạt động hay không.

	@Test
	public void testIsEventNumber2() {
		App demo1 = new App();
		boolean result = demo1.isEvenNumber(2);
		assertTrue(result);
	}

	// Phương thức kiểm thử có annotation @Test để JUnit biết đây là một test case.
	// - Tạo một đối tượng App.
	// - Gọi phương thức isEvenNumber với tham số 2.
	// - Kiểm tra kết quả trả về có đúng là true hay không với assertTrue(result).

	@Test
	public void testIsEventNumber4() {
		App demo1 = new App();
		boolean result = demo1.isEvenNumber(3);
		assertTrue(result);
	}

	// Phương thức kiểm thử thứ hai có annotation @Test.
	// - Tạo một đối tượng App.
	// - Gọi phương thức isEvenNumber với tham số 3.
	// - Kiểm tra kết quả trả về có đúng là true hay không với assertTrue(result).
}
