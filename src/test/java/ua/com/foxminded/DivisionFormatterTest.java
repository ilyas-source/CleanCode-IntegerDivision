package ua.com.foxminded;

import java.util.ArrayList;
import java.util.Arrays;

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
		int dividend = 4050225;
		int divider = 45;
		DivisionResult divisionResult = new DivisionResult();
		divisionResult.setPartialDividends(new ArrayList<Integer>(Arrays.asList(405, 0, 0, 0, 225)));

		String outputString = formatter.format(divisionResult, dividend, divider);
		String testString = "_4050225|45" + CR + " 405    |-----" + CR + " ---    |90005" + CR;
		testString += "    _225" + CR + "     225" + CR + "     ---" + CR + "       0";
		TestCase.assertEquals(testString, outputString);
	}
}