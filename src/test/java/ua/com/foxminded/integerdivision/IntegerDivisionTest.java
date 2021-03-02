package ua.com.foxminded.integerdivision;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class IntegerDivisionTest {

	IntegerDivision integerDivision = new IntegerDivision();
	String testString;

	@Test
	public void given123456And12345_onIntegerDivision_thenGetString() {
		Integer dividend = 12346;
		Integer divider = 12345;
		ArrayList<ArrayList<Integer>> divisionArrayList = integerDivision.createDivisionArrayList(dividend, divider);

		StringBuilder outputString = new StringBuilder();
		outputString.append("_" + Integer.toString(dividend) + "|" + Integer.toString(divider) + "\n");
		outputString.append(integerDivision.createString(divisionArrayList, dividend, divider));
		String testString = "_12346|12345\n 12345|-\n -----|1\n";
		TestCase.assertEquals(testString, outputString.toString());
	}

	@Test
	public void given4050225And405_onIntegerDivision_thenGetString() {
		Integer dividend = 4050225;
		Integer divider = 45;
		ArrayList<ArrayList<Integer>> divisionArrayList = integerDivision.createDivisionArrayList(dividend, divider);

		StringBuilder outputString = new StringBuilder();
		outputString.append("_" + Integer.toString(dividend) + "|" + Integer.toString(divider) + "\n");
		outputString.append(integerDivision.createString(divisionArrayList, dividend, divider));
		String testString = "_4050225|45\n 405    |-----\n ---    |90005\n    _225\n     225\n     ---\n       0";
		TestCase.assertEquals(testString, outputString.toString());
	}

	@Test
	public void given78945And4_onIntegerDivision_thenGetString() {
		Integer dividend = 78945;
		Integer divider = 4;
		ArrayList<ArrayList<Integer>> divisionArrayList = integerDivision.createDivisionArrayList(dividend, divider);

		StringBuilder outputString = new StringBuilder();
		outputString.append("_" + Integer.toString(dividend) + "|" + Integer.toString(divider) + "\n");
		outputString.append(integerDivision.createString(divisionArrayList, dividend, divider));
		String testString = "_78945|4\n 4    |-----\n -    |19736\n_38\n 36\n --\n _29\n  28\n  --\n  _14\n   12\n   --\n   _25\n    24\n    --\n     1";
		TestCase.assertEquals(testString, outputString.toString());
	}

	@Test
	public void given234And23456_onIntegerDivision_thenGetString() {
		Integer dividend = 234;
		Integer divider = 23456;
		ArrayList<ArrayList<Integer>> divisionArrayList = integerDivision.createDivisionArrayList(dividend, divider);

		StringBuilder outputString = new StringBuilder();
		outputString.append("_" + Integer.toString(dividend) + "|" + Integer.toString(divider) + "\n");
		outputString.append(integerDivision.createString(divisionArrayList, dividend, divider));
		String testString = "234|23456\n   |-----\n   |0\n";
		TestCase.assertEquals(testString, outputString.toString());
	}

}
