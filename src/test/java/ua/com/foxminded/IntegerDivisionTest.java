package ua.com.foxminded;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import ua.com.foxminded.integerdivision.DivisionFormatter;
import ua.com.foxminded.integerdivision.DivisionResult;
import ua.com.foxminded.integerdivision.IntegerDivision;

public class IntegerDivisionTest {

	IntegerDivision integerDivision = new IntegerDivision();
	DivisionFormatter formatter = new DivisionFormatter();
	String testString;

	private static final String CR = System.lineSeparator();

	@Test
	public void given123456And12345_onIntegerDivision_thenGetString() {
		int dividend = 12346;
		int divider = 12345;
		DivisionResult divisionResult = integerDivision.divide(dividend, divider);

		String outputString = formatter.format(divisionResult, dividend, divider);
		String testString = "_12346|12345" + CR + " 12345|-" + CR + " -----|1" + CR;
		TestCase.assertEquals(testString, outputString);
	}

	@Test
	public void given4050225And405_onIntegerDivision_thenGetString() {
		int dividend = 4050225;
		int divider = 45;
		DivisionResult divisionResult = integerDivision.divide(dividend, divider);

		String outputString = formatter.format(divisionResult, dividend, divider);
		String testString = "_4050225|45" + CR + " 405    |-----" + CR + " ---    |90005" + CR;
		testString += "    _225" + CR + "     225" + CR + "     ---" + CR + "       0";
		TestCase.assertEquals(testString, outputString);
	}

	@Test
	public void given78945And4_onIntegerDivision_thenGetString() {
		int dividend = 78945;
		int divider = 4;
		DivisionResult divisionResult = integerDivision.divide(dividend, divider);

		String outputString = formatter.format(divisionResult, dividend, divider);
		String testString = "_78945|4" + CR + " 4    |-----" + CR + " -    |19736";
		testString += CR + "_38" + CR + " 36" + CR + " --" + CR + " _29" + CR + "  28" + CR + "  --";
		testString += CR + "  _14" + CR + "   12" + CR + "   --" + CR + "   _25" + CR + "    24" + CR + "    --" + CR
				+ "     1";
		TestCase.assertEquals(testString, outputString);
	}

	@Test
	public void given234And23456_onIntegerDivision_thenGetString() {
		int dividend = 234;
		int divider = 23456;
		DivisionResult divisionResult = integerDivision.divide(dividend, divider);
		String outputString = formatter.format(divisionResult, dividend, divider);
		String testString = "234|23456" + CR + "   |-----" + CR + "   |0";
		TestCase.assertEquals(testString, outputString);
	}

	@Test
	public void given123And0_onDivide_thenThrowsException() throws ArithmeticException {
		int dividend = 123;
		int divider = 0;
		Throwable thrown = assertThrows(ArithmeticException.class, () -> {
			integerDivision.divide(dividend, divider);
		});
		assertNotNull(thrown.getMessage());
	}

}
