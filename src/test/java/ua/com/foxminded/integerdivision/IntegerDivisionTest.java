package ua.com.foxminded.integerdivision;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class IntegerDivisionTest {

	IntegerDivision integerDivision = new IntegerDivision();
	String testString;

	private static final String CR = System.lineSeparator();

	@Test
	public void given12346And12345_onIntegerDivision_thenGetString() {
		int dividend = 12346;
		int divider = 12345;
		DivisionResult divisionResult = integerDivision.divide(dividend, divider);

		String expected = "[[12346,1]], dividend: 12346, divider: 12345, division: 1, remainder: 1";

		String actual = divisionResult.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void given4050225And405_onIntegerDivision_thenGetString() {
		int dividend = 4050225;
		int divider = 45;
		String expected = "[[405,9], [0,0], [0,0], [0,0], [225,5]], dividend: 4050225, divider: 45, division: 90005, remainder: 0";

		DivisionResult divisionResult = integerDivision.divide(dividend, divider);
		String actual = divisionResult.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void given78945And4_onIntegerDivision_thenGetString() {
		int dividend = 78945;
		int divider = 4;
		String expected = "[[7,1], [38,9], [29,7], [14,3], [25,6]],";
		expected += " dividend: 78945, divider: 4, division: 19736, remainder: 1";

		DivisionResult divisionResult = integerDivision.divide(dividend, divider);
		String actual = divisionResult.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void given234And23456_onIntegerDivision_thenGetString() {
		int dividend = 234;
		int divider = 23456;
		String expected = "[[0,0]], dividend: 234, divider: 23456, division: 0, remainder: 0";

		DivisionResult divisionResult = integerDivision.divide(dividend, divider);
		String actual = divisionResult.toString();

		assertEquals(expected, actual);
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
