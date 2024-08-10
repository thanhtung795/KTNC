package com.java;

import org.testng.annotations.Test;

public class groupExamples {
	@Test(groups = "Regression")
	public void testCaseOne() {
		System.out.println("I'm in test case 1 - And in Regression Group");
	}

	@Test(groups = "Regression")
	public void testCaseTwo() {
		System.out.println("I'm in test case 2 - And in Regression Group");
	}

	@Test(groups = "Smoke Test")
	public void testCaseThree() {
		System.out.println("I'm in test case 3 - And in Smoke Test");
	}

	@Test(groups = "Regression")
	public void testCaseFour() {
		System.out.println("I'm in test case 4 - And in Regression Group");
	}
}
