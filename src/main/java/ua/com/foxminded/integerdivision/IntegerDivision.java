package ua.com.foxminded.integerdivision;

public class IntegerDivision {

	public DivisionResult divide(int dividend, int divider) {

		NumberUtils numberUtils = new NumberUtils();

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

		int divisionDigit = 0;
		int partialDividend = numberUtils.getNthDigit(dividend, 1);

		if (partialDividend > divider) {
			divisionDigit = partialDividend / divider;
			divisionResult.addDivisionStep(partialDividend, divisionDigit);
			partialDividend = partialDividend - divider * divisionDigit;
		}

		int remainder = partialDividend;

		for (int index = 1; index < numberUtils.getIntLength(dividend); index++) {
			partialDividend = partialDividend * 10 + numberUtils.getNthDigit(dividend, index + 1);

			if (partialDividend < divider) {
				if (!divisionResult.divisionSteps.isEmpty()) {
					divisionResult.addDivisionStep(0, 0);
				}
			} else {
				divisionDigit = partialDividend / divider;
				divisionResult.addDivisionStep(partialDividend, divisionDigit);
				partialDividend = partialDividend - divider * divisionDigit;
				remainder = partialDividend;
			}
		}
		int[] dividendDigits = new int[numberUtils.getIntLength(dividend)];
		for (int index = 1; index < numberUtils.getIntLength(dividend); index++) {
			dividendDigits[index] = numberUtils.getNthDigit(dividend, index);
		}
		return divisionResult;

	}

}
