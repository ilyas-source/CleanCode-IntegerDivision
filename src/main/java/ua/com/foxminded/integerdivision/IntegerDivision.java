package ua.com.foxminded.integerdivision;

public class IntegerDivision {

	public DivisionResult divide(int dividend, int divider) {

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
		int partialDividend = getNthDigit(dividend, 1);

		if (partialDividend > divider) {
			divisionDigit = partialDividend / divider;
			divisionResult.addDivisionStep(partialDividend, divisionDigit);
			partialDividend = partialDividend - divider * divisionDigit;
		}

		int remainder = partialDividend;

		for (int index = 1; index < getIntLength(dividend); index++) {
			partialDividend = partialDividend * 10 + getNthDigit(dividend, index + 1);

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
		int[] dividendDigits = new int[getIntLength(dividend)];
		for (int index = 1; index < getIntLength(dividend); index++) {
			dividendDigits[index] = getNthDigit(dividend, index);
		}
		return divisionResult;

	}

	private Integer getNthDigit(int sourceInt, int position) {
		int length = getIntLength(sourceInt);

		return sourceInt / (int) Math.pow(10, length - position) % 10;
	}

	public int getSubInt(int sourceInt, int startPosition, int endPosition) {

		int[] digits = new int[getIntLength(sourceInt)];
		for (int i = 0; i < getIntLength(sourceInt); i++) {
			digits[i] = getNthDigit(sourceInt, i + 1);
		}

		int result = 0;
		int index = startPosition;
		int count = endPosition - startPosition + 1;
		for (int i = count - 1; i >= 0; i--) {
			result = (int) (result + digits[index] * Math.pow(10, i));
			index++;
		}
		return result;
	}

	public int getIntLength(int sourceInt) {
		if (sourceInt == 0) {
			return 0;
		} else {
			return (int) (Math.log10(sourceInt) + 1);
		}
	}

}
