package lab4.bai3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VatCalculatorTest {

  @Test
  public void getVatOnAmountTest() {
	  VatCalculator calc = new VatCalculator();
	  double expected = 10;
	  Assert.assertEquals(calc.getVatOnAmount(100), expected);
	  Assert.assertNotEquals(calc.getVatOnAmount(120), expected);
  }
}
