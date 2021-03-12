package ua.com.foxminded.integerdivision;

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
		divisionResult.setDivision(division);

		if (dividend < divider) {
			divisionResult.addDivisionStep(0, 0);
			return divisionResult;
		}

		int partialDividend = NumberUtils.getNthDigit(dividend, 1);
		if (partialDividend > divider) {
			divisionDigit = partialDividend / divider;
			divisionResult.addDivisionStep(partialDividend, divisionDigit);
			partialDividend = partialDividend - divider * divisionDigit;
			division = divisionDigit;
		}

		int[] dividendDigits = new int[NumberUtils.getIntLength(dividend)];

		for (int i = 1; i < NumberUtils.getIntLength(dividend); i++) {
			dividendDigits[i] = NumberUtils.getNthDigit(dividend, i + 1);
			partialDividend = partialDividend * 10 + dividendDigits[i];

			if (partialDividend > divider) {
				divisionDigit = partialDividend / divider;
				divisionResult.addDivisionStep(partialDividend, divisionDigit);
				partialDividend = partialDividend - divider * divisionDigit;
				division = division * 10 + divisionDigit;
			}

			else {
				if (!divisionResult.divisionSteps.isEmpty()) {
					divisionResult.addDivisionStep(0, 0);
					division = division * 10;
				}
			}

		}

		int steps = divisionResult.divisionSteps.size();
		int lastPartialDividend = divisionResult.getPartialDividend(steps - 1);
		int lastDivisionDigit = divisionResult.getDivisionDigit(steps - 1);
		divisionResult.setDivision(division);
		divisionResult.setRemainder(lastPartialDividend - divider * lastDivisionDigit);

		return divisionResult;
	}
}
