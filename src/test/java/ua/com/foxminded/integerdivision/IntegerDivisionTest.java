package ua.com.foxminded.integerdivision;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class IntegerDivisionTest {

	IntegerDivision integerDivision = new IntegerDivision();
	List<DivisionStep> divisionSteps = new ArrayList<>();

	@Test
	public void given78945And4_onIntegerDivision_thenGetString() throws CloneNotSupportedException {
		DivisionResult expected = new DivisionResult();

		expected.setDividend(78945);
		expected.setDivider(4);
		expected.setDivision(19736);
		expected.setRemainder(1);

		List<DivisionStep> divisionSteps = new ArrayList<>();

		DivisionStep divisionStep = new DivisionStep(7, 1, 4);
		divisionSteps.add(divisionStep);

		divisionStep = new DivisionStep(38, 9, 36);
		divisionSteps.add(divisionStep);

		divisionStep = new DivisionStep(29, 7, 28);
		divisionSteps.add(divisionStep);

		divisionStep = new DivisionStep(14, 3, 12);
		divisionSteps.add(divisionStep);

		divisionStep = new DivisionStep(25, 6, 24);
		divisionSteps.add(divisionStep);

		expected.setDivisionSteps(divisionSteps);

		DivisionResult actual = integerDivision.divide(78945, 4);

		assertEquals(expected, actual);
	}

	@Test
	public void given12346And12345_onIntegerDivision_thenGetString() {
		DivisionResult expected = new DivisionResult();

		expected.setDividend(12346);
		expected.setDivider(12345);
		expected.setDivision(1);
		expected.setRemainder(1);

		DivisionStep divisionStep = new DivisionStep();
		divisionStep.setPartialDividend(12346);
		divisionStep.setDivisionDigit(1);
		divisionStep.setMultiplication(12345);

		List<DivisionStep> divisionSteps = new ArrayList<>();
		divisionSteps.add(divisionStep);

		expected.setDivisionSteps(divisionSteps);

		DivisionResult actual = integerDivision.divide(12346, 12345);

		assertEquals(expected, actual);
	}

	@Test
	public void given4050225And405_onIntegerDivision_thenGetString() {
		DivisionResult expected = new DivisionResult();

		DivisionStep divisionStep = new DivisionStep(405, 9, 405);
		divisionSteps.add(divisionStep);

		divisionStep = new DivisionStep(0, 0, 0);
		divisionSteps.add(divisionStep);
		divisionSteps.add(divisionStep);
		divisionSteps.add(divisionStep);

		divisionStep = new DivisionStep(225, 5, 225);
		divisionSteps.add(divisionStep);

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
