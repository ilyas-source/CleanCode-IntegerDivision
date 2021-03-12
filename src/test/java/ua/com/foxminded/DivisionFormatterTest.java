package ua.com.foxminded;

import org.junit.Test;

import junit.framework.TestCase;
import ua.com.foxminded.integerdivision.DivisionFormatter;
import ua.com.foxminded.integerdivision.DivisionResult;

public class DivisionFormatterTest {

	private static final String CR = System.lineSeparator();

	DivisionFormatter formatter = new DivisionFormatter();

	@Test
	public void givenArray_onFormat_thenGetString() {
		DivisionResult divisionResult = new DivisionResult();

		divisionResult.addDivisionStep(405, 9);
		divisionResult.addDivisionStep(0, 0);
		divisionResult.addDivisionStep(0, 0);
		divisionResult.addDivisionStep(0, 0);
		divisionResult.addDivisionStep(225, 5);

		divisionResult.setDividend(4050225);
		divisionResult.setDivider(45);
		divisionResult.setDivision(90005);

		StringBuilder expected = new StringBuilder();
		expected.append("_4050225|45").append(CR);
		expected.append(" 405    |-----").append(CR);
		expected.append(" ---    |90005").append(CR);
		expected.append("    _225").append(CR);
		expected.append("     225").append(CR);
		expected.append("     ---").append(CR);
		expected.append("       0");

		String actual = formatter.format(divisionResult);

		TestCase.assertEquals(expected.toString(), actual);
	}
}