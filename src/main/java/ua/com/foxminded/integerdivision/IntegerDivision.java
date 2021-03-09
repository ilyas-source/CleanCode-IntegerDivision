package ua.com.foxminded.integerdivision;

import java.util.ArrayList;

public class IntegerDivision {

	public ArrayList<Integer> divide(int dividend, int divider) throws ArithmeticException {

		if (divider == 0) {
			throw new ArithmeticException("Division by zero.");
		}

		ArrayList<Integer> outputArray = new ArrayList<>();
		dividend = Math.abs(dividend);

		if (dividend < divider) {
			outputArray.add(0);
			return outputArray;
		}

		int divisionDigit = 0;
		int partialDividend = subInt(dividend, 0, 0);

		if (partialDividend > divider) {
			divisionDigit = partialDividend / divider;
			outputArray.add(partialDividend);
			partialDividend = partialDividend - divider * divisionDigit;
		}

		int startPosition = 1;
		int remainder = partialDividend;

		for (int index = 1; index < getIntLength(dividend); index++) {
			int subInt = subInt(dividend, startPosition, index);
			partialDividend = (int) (subInt + remainder * Math.pow(10, index - startPosition + 1));

			if (partialDividend < divider) {
				if (!outputArray.isEmpty()) {
					outputArray.add(0);
				}
			} else {
				divisionDigit = partialDividend / divider;
				outputArray.add(partialDividend);
				partialDividend = partialDividend - divider * divisionDigit;
				remainder = partialDividend;
				startPosition = index + 1;
			}
		}
		return outputArray;

	}

	private Integer getNthDigit(int sourceInt, int position) {
		int length = getIntLength(sourceInt);

		return sourceInt / (int) Math.pow(10, length - position) % 10;
	}

	public int subInt(int sourceInt, int startPosition, int endPosition) {

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

	private int getIntLength(int sourceInt) {
		if (sourceInt == 0) {
			return 0;
		} else {
			return (int) (Math.log10(sourceInt) + 1);
		}
	}

}
