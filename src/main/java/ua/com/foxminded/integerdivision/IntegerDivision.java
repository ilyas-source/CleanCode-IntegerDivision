package ua.com.foxminded.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivision {

	public DivisionResult divide(int dividend, int divider) {
		if (divider == 0) {
			throw new ArithmeticException("Division by zero");
		}

		int divisionDigit = 0;
		int division = 0;

		DivisionResult divisionResult = new DivisionResult();
		dividend = Math.abs(dividend);
		divisionResult.setDividend(dividend);
		divisionResult.setDivider(divider);

		List<DivisionStep> divisionSteps = new ArrayList<>();

		if (dividend < divider) {
			DivisionStep divisionStep = new DivisionStep(0, 0, 0);
			divisionSteps.add(divisionStep);
			divisionResult.setDivisionSteps(divisionSteps);
			return divisionResult;
		}

		int partialDividend = NumberUtils.getNthDigit(dividend, 1);
		if (partialDividend > divider) {
			divisionDigit = partialDividend / divider;
			DivisionStep divisionStep = new DivisionStep(partialDividend, divisionDigit, divider * divisionDigit);
			divisionSteps.add(divisionStep);
			partialDividend = partialDividend - divider * divisionDigit;
			division = divisionDigit;
		}

		int[] dividendDigits = new int[NumberUtils.getIntLength(dividend)];

		for (int i = 1; i < NumberUtils.getIntLength(dividend); i++) {
			dividendDigits[i] = NumberUtils.getNthDigit(dividend, i + 1);
			partialDividend = partialDividend * 10 + dividendDigits[i];

			if (partialDividend > divider) {
				divisionDigit = partialDividend / divider;
				DivisionStep divisionStep = new DivisionStep(partialDividend, divisionDigit, divider * divisionDigit);
				divisionSteps.add(divisionStep);
				partialDividend = partialDividend - divider * divisionDigit;
				division = division * 10 + divisionDigit;
			} else {
				if (!divisionSteps.isEmpty()) {
					DivisionStep divisionStep = new DivisionStep(0, 0, 0);
					divisionSteps.add(divisionStep);
					division = division * 10;
				}
			}

		}

		divisionResult.setDivisionSteps(divisionSteps);
		// int steps = divisionResult.divisionSteps.size();
		int steps = divisionResult.getDivisionSteps().size();
		int lastPartialDividend = divisionResult.getPartialDividend(steps - 1);
		int lastDivisionDigit = divisionResult.getDivisionDigit(steps - 1);
		divisionResult.setDivision(division);
		divisionResult.setRemainder(lastPartialDividend - divider * lastDivisionDigit);

		return divisionResult;
	}
}
