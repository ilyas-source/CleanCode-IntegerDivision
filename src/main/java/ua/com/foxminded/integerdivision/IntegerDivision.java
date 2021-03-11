package ua.com.foxminded.integerdivision;

public class IntegerDivision {

	public DivisionResult divide(int dividend, int divider) {

		NumberUtils numberUtils = new NumberUtils();
		int divisionDigit = 0;

		if (divider == 0) {
			throw new ArithmeticException("Division by zero");
		}

		DivisionResult divisionResult = new DivisionResult();
		int division = dividend / divider;
		dividend = Math.abs(dividend);
		divisionResult.setDividend(dividend);
		divisionResult.setDivider(divider);
		divisionResult.setDivision(division);

		if (dividend < divider) {
			divisionResult.addDivisionStep(0, 0);
			return divisionResult;
		}

		int partialDividend = numberUtils.getNthDigit(dividend, 1);
		if (partialDividend > divider) {
			divisionDigit = partialDividend / divider;
			divisionResult.addDivisionStep(partialDividend, divisionDigit);
			partialDividend = partialDividend - divider * divisionDigit;
		}

		int[] dividendDigits = new int[numberUtils.getIntLength(dividend)];

		for (int i = 1; i < numberUtils.getIntLength(dividend); i++) {
			dividendDigits[i] = numberUtils.getNthDigit(dividend, i + 1);
			partialDividend = partialDividend * 10 + dividendDigits[i];

			if (partialDividend > divider) {
				divisionDigit = partialDividend / divider;
				divisionResult.addDivisionStep(partialDividend, divisionDigit);
				partialDividend = partialDividend - divider * divisionDigit;
			}

			else {
				if (!divisionResult.divisionSteps.isEmpty()) {
					divisionResult.addDivisionStep(0, 0);
				}
			}

		}

		return divisionResult;
	}
}
