package ua.com.foxminded.integerdivision;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class IntegerDivisionTest {

	IntegerDivision integerDivision = new IntegerDivision();
	DivisionFormatter formatter = new DivisionFormatter();
	String testString;

	private static final String LS = System.lineSeparator();

	@Test
	public void given123456And12345_onIntegerDivision_thenGetString() {
		Integer dividend = 12346;
		Integer divider = 12345;
		ArrayList<ArrayList<Integer>> divisionArrayList = integerDivision.divide(dividend, divider);

		String outputString = formatter.format(divisionArrayList, dividend, divider);
		String testString = "_12346|12345" + LS + " 12345|-" + LS + " -----|1" + LS;
		TestCase.assertEquals(testString, outputString);
	}

	@Test
	public void given4050225And405_onIntegerDivision_thenGetString() {
		Integer dividend = 4050225;
		Integer divider = 45;
		ArrayList<ArrayList<Integer>> divisionArrayList = integerDivision.divide(dividend, divider);

		String outputString = formatter.format(divisionArrayList, dividend, divider);
		String testString = "_4050225|45" + LS + " 405    |-----" + LS + " ---    |90005" + LS;
		testString += "    _225" + LS + "     225" + LS + "     ---" + LS + "       0";
		TestCase.assertEquals(testString, outputString);
	}

	@Test
	public void given78945And4_onIntegerDivision_thenGetString() {
		Integer dividend = 78945;
		Integer divider = 4;
		ArrayList<ArrayList<Integer>> divisionArrayList = integerDivision.divide(dividend, divider);

		String outputString = formatter.format(divisionArrayList, dividend, divider);
		String testString = "_78945|4" + LS + " 4    |-----" + LS + " -    |19736";
		testString += LS + "_38" + LS + " 36" + LS + " --" + LS + " _29" + LS + "  28" + LS + "  --";
		testString += LS + "  _14" + LS + "   12" + LS + "   --" + LS + "   _25" + LS + "    24" + LS + "    --" + LS
				+ "     1";
		TestCase.assertEquals(testString, outputString);
	}

	@Test
	public void given234And23456_onIntegerDivision_thenGetString() {
		Integer dividend = 234;
		Integer divider = 23456;
		ArrayList<ArrayList<Integer>> divisionArrayList = integerDivision.divide(dividend, divider);
		String outputString = formatter.format(divisionArrayList, dividend, divider);
		String testString = "234|23456" + LS + "   |-----" + LS + "   |0";
		TestCase.assertEquals(testString, outputString);
	}

}
