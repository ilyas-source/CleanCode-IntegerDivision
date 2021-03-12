package ua.com.foxminded;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.integerdivision.DivisionFormatter;
import ua.com.foxminded.integerdivision.DivisionResult;

public class DivisionFormatterTest {

	private static final String CR = System.lineSeparator();

	DivisionFormatter formatter = new DivisionFormatter();

	@Test
	public void givenDivisionResult_onFormat_thenGetString() {
		DivisionResult divisionResult = new DivisionResult();

		divisionResult.addDivisionStep(405, 9);
		divisionResult.addDivisionStep(0, 0);
		divisionResult.addDivisionStep(0, 0);
		divisionResult.addDivisionStep(0, 0);
		divisionResult.addDivisionStep(225, 5);

		divisionResult.setDividend(4050225);
		divisionResult.setDivider(45);
		divisionResult.setDivision(90005);
		divisionResult.setRemainder(0);

		StringBuilder expected = new StringBuilder();
		expected.append("_4050225|45").append(CR);
		expected.append(" 405    |-----").append(CR);
		expected.append(" ---    |90005").append(CR);
		expected.append("    _225").append(CR);
		expected.append("     225").append(CR);
		expected.append("     ---").append(CR);
		expected.append("       0");

		String actual = formatter.format(divisionResult);

		assertEquals(expected.toString(), actual);
	}

	@Test
	public void givenDivisionResult2_onFormat_thenGetString2() {
		DivisionResult divisionResult = new DivisionResult();

		divisionResult.addDivisionStep(986, 2);
		divisionResult.addDivisionStep(3284, 9);
		divisionResult.addDivisionStep(3233, 9);
		divisionResult.addDivisionStep(2720, 8);

		divisionResult.setDividend(986430);
		divisionResult.setDivider(329);
		divisionResult.setDivision(2998);
		divisionResult.setRemainder(88);

		StringBuilder expected = new StringBuilder();
		expected.append("_986430|329").append(CR);
		expected.append(" 658   |----").append(CR);
		expected.append(" ---   |2998").append(CR);
		expected.append("_3284").append(CR);
		expected.append(" 2961").append(CR);
		expected.append(" ----").append(CR);
		expected.append(" _3233").append(CR);
		expected.append("  2961").append(CR);
		expected.append("  ----").append(CR);
		expected.append("  _2720").append(CR);
		expected.append("   2632").append(CR);
		expected.append("   ----").append(CR);
		expected.append("     88");

		String actual = formatter.format(divisionResult);

		assertEquals(expected.toString(), actual);
	}

	@Test
	public void givenDivisionResult3_onFormat_thenGetString3() {
		DivisionResult divisionResult = new DivisionResult();

		divisionResult.addDivisionStep(1234, 9);
		divisionResult.addDivisionStep(1189, 9);

		divisionResult.setDividend(12349);
		divisionResult.setDivider(124);
		divisionResult.setDivision(99);
		divisionResult.setRemainder(73);

		StringBuilder expected = new StringBuilder();
		expected.append("_12349|124").append(CR);
		expected.append(" 1116 |--").append(CR);
		expected.append(" ---- |99").append(CR);
		expected.append(" _1189").append(CR);
		expected.append("  1116").append(CR);
		expected.append("  ----").append(CR);
		expected.append("    73");

		String actual = formatter.format(divisionResult);

		assertEquals(expected.toString(), actual);
	}
}
