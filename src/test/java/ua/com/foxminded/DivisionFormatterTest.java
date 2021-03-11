package ua.com.foxminded;

import org.junit.Test;

import junit.framework.TestCase;
import ua.com.foxminded.integerdivision.DivisionFormatter;
import ua.com.foxminded.integerdivision.DivisionResult;

public class DivisionFormatterTest {

	DivisionFormatter formatter = new DivisionFormatter();
	String testString;

	private static final String CR = System.lineSeparator();

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

		String outputString = formatter.format(divisionResult);
		String testString = "_4050225|45" + CR + " 405    |-----" + CR + " ---    |90005" + CR;
		testString += "    _225" + CR + "     225" + CR + "     ---" + CR + "       0";
		TestCase.assertEquals(testString, outputString);
	}
}