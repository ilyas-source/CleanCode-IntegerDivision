package ua.com.foxminded.integerdivision;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DivisionFormatterTest {

	private static final String CR = System.lineSeparator();

	DivisionFormatter formatter = new DivisionFormatter();

	@Test
	public void given234And23456_onFormat_thenGetSimpleDivisionString() {
		DivisionResult divisionResult = new DivisionResult();
		List<DivisionStep> divisionSteps = new ArrayList<>();

		divisionResult.setDividend(234);
		divisionResult.setDivider(23456);
		divisionResult.setDivision(0);
		divisionResult.setRemainder(0);

		DivisionStep divisionStep = new DivisionStep(234, 0, 234);
		divisionSteps.add(divisionStep);

		divisionResult.setDivisionSteps(divisionSteps);

		StringBuilder expected = new StringBuilder();
		expected.append("_234|23456").append(CR);
		expected.append(" 234|-").append(CR);
		expected.append(" ---|0").append(CR);
		expected.append("   0");

		String actual = formatter.format(divisionResult);

		assertEquals(expected.toString(), actual);

	}

	@Test
	public void given4050225And45_onFormat_thenGetString() {
		DivisionResult divisionResult = new DivisionResult();
		List<DivisionStep> divisionSteps = new ArrayList<>();

		DivisionStep divisionStep = new DivisionStep(405, 9, 405);
		divisionSteps.add(divisionStep);

		divisionStep = new DivisionStep(0, 0, 0);
		divisionSteps.add(divisionStep);
		divisionSteps.add(divisionStep);
		divisionSteps.add(divisionStep);

		divisionStep = new DivisionStep(225, 5, 225);
		divisionSteps.add(divisionStep);

		divisionResult.setDivisionSteps(divisionSteps);

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
	public void given986430And329_onFormat_thenGetString() throws CloneNotSupportedException {
		DivisionResult divisionResult = new DivisionResult();
		List<DivisionStep> divisionSteps = new ArrayList<>();

		DivisionStep divisionStep = new DivisionStep(986, 2, 658);
		divisionSteps.add(divisionStep);

		divisionStep = new DivisionStep(3284, 9, 2961);
		divisionSteps.add(divisionStep);

		divisionStep = new DivisionStep(3233, 9, 2961);
		divisionSteps.add(divisionStep);

		divisionStep = new DivisionStep(2720, 8, 2632);
		divisionSteps.add(divisionStep);

		divisionResult.setDivisionSteps(divisionSteps);

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
	public void given12349And124_onFormat_thenGetString() throws CloneNotSupportedException {
		DivisionResult divisionResult = new DivisionResult();
		List<DivisionStep> divisionSteps = new ArrayList<>();

		DivisionStep divisionStep = new DivisionStep(1234, 9, 1116);
		divisionSteps.add(divisionStep);

		divisionStep = new DivisionStep(1189, 9, 1116);
		divisionSteps.add(divisionStep);

		divisionResult.setDivisionSteps(divisionSteps);

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
