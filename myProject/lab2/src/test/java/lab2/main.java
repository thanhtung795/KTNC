package lab2;

import org.junit.runner.*;

public class main {
	public static void main (String[] args) throws Exception {
		JUnitCore runner = new JUnitCore ();
		Result result = runner. run (MathFuncTest.class) ;
		System. out. println ("run tests: " + result.getRunCount ()) ;
		System.out.println ("failed tests: " + result.getFailureCount ()) ;
		System. out.println ("ignored tests: " + result.getIgnoreCount ()) ;
		System. out. println ("success: " + result.wasSuccessful ()) ;
	}
}
