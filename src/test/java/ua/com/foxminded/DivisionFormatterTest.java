package ua.com.foxminded;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import ua.com.foxminded.integerdivision.DivisionFormatter;
import ua.com.foxminded.integerdivision.DivisionResult;
import ua.com.foxminded.integerdivision.DivisionStep;

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

		System.out.println(divisionResult.toString());

		String outputString = formatter.format(divisionResult);
		String testString = "_4050225|45" + CR + " 405    |-----" + CR + " ---    |90005" + CR;
		testString += "    _225" + CR + "     225" + CR + "     ---" + CR + "       0";
		System.out.println(testString);
		System.out.println(outputString);
		TestCase.assertEquals(testString, outputString);
	}
}