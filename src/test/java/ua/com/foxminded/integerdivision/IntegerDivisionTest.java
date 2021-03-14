package ua.com.foxminded.integerdivision;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class IntegerDivisionTest {

	IntegerDivision integerDivision = new IntegerDivision();
	String testString;

	@Test
	public void given12346And12345_onIntegerDivision_thenGetString() throws CloneNotSupportedException {
		DivisionResult expected = new DivisionResult();

		expected.setDividend(12346);
		expected.setDivider(12345);
		expected.setDivision(1);
		expected.setRemainder(1);

		DivisionStep divisionStep = new DivisionStep();
		divisionStep.setPartialDividend(12346);
		divisionStep.setDivisionDigit(1);

		List<DivisionStep> divisionSteps = new ArrayList<>();
		divisionSteps.add(divisionStep);

		expected.setDivisionSteps(divisionSteps);

		DivisionResult actual = integerDivision.divide(12346, 12345);

		assertEquals(expected, actual);
	}

	@Test
	public void given4050225And405_onIntegerDivision_thenGetString() throws CloneNotSupportedException {
		DivisionResult expected = new DivisionResult();

		DivisionStep divisionStep = new DivisionStep();
		List<DivisionStep> divisionSteps = new ArrayList<>();
		divisionStep.setPartialDividend(405);
		divisionStep.setDivisionDigit(9);
		divisionSteps.add((DivisionStep) divisionStep.clone());

		divisionStep.setPartialDividend(0);
		divisionStep.setDivisionDigit(0);
		divisionSteps.add((DivisionStep) divisionStep.clone());
		divisionSteps.add((DivisionStep) divisionStep.clone());
		divisionSteps.add((DivisionStep) divisionStep.clone());

		divisionStep.setPartialDividend(225);
		divisionStep.setDivisionDigit(5);
		divisionSteps.add((DivisionStep) divisionStep.clone());

		expected.setDivisionSteps(divisionSteps);

		expected.setDividend(4050225);
		expected.setDivider(45);
		expected.setDivision(90005);
		expected.setRemainder(0);

		DivisionResult actual = integerDivision.divide(4050225, 45);

		assertEquals(expected, actual);
	}

	@Test
	public void given234And23456_onIntegerDivision_thenGetString() throws CloneNotSupportedException {
		DivisionResult expected = new DivisionResult();

		expected.setDividend(234);
		expected.setDivider(23456);
		expected.setDivision(0);
		expected.setRemainder(0);

		DivisionStep divisionStep = new DivisionStep();
		divisionStep.setPartialDividend(0);
		divisionStep.setDivisionDigit(0);

		List<DivisionStep> divisionSteps = new ArrayList<>();
		divisionSteps.add(divisionStep);

		expected.setDivisionSteps(divisionSteps);

		DivisionResult actual = integerDivision.divide(234, 23456);

		System.out.println(expected);
		System.out.println(actual);

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
