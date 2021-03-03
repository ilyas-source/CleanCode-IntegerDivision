package ua.com.foxminded.integerdivision;

import java.util.ArrayList;

public class IntegerDivision {

	public ArrayList<ArrayList<Integer>> divide(Integer dividend, Integer divider) {

		ArrayList<Integer> iterationArrayList = new ArrayList<>();
		ArrayList<ArrayList<Integer>> outputArray = new ArrayList<ArrayList<Integer>>();
		dividend = Math.abs(dividend);

		if (dividend < divider) {
			iterationArrayList.add(0);
			iterationArrayList.add(0);
			outputArray.add((ArrayList<Integer>) iterationArrayList.clone());
			return outputArray;
		}

		if (divider == 0) {
			System.out.println("Division by zero, terminating.");
			System.exit(0);
		}

		int divisionDigit = 0;
		int partialDividend = subInteger(dividend, 0, 1);
		int index = 1;
		int additionalDigitsCount = 1;

		if (partialDividend > divider) {
			divisionDigit = partialDividend / divider;
			iterationArrayList.add(partialDividend);
			iterationArrayList.add(divisionDigit);
			outputArray.add((ArrayList<Integer>) iterationArrayList.clone());
			partialDividend = partialDividend - divider * divisionDigit;

			iterationArrayList.clear();
		}

		while (index < integerLength(dividend)) {
			while (partialDividend < divider) {
				Integer subInteger = subInteger(dividend, index, additionalDigitsCount);
				Integer tempDividend = (int) (partialDividend * Math.pow(10, additionalDigitsCount) + subInteger);
				if (tempDividend < divider) {
					if (index + additionalDigitsCount == integerLength(dividend)) {
						partialDividend = (int) (partialDividend * Math.pow(10, additionalDigitsCount) + subInteger);
						break;
					}
					if (!outputArray.isEmpty()) {

						iterationArrayList.add(0);
						iterationArrayList.add(0);
						outputArray.add((ArrayList<Integer>) iterationArrayList.clone());
						iterationArrayList.clear();
					}

					additionalDigitsCount++;
				} else {
					partialDividend = tempDividend;
					index += additionalDigitsCount;
					additionalDigitsCount = 1;
				}
			}

			divisionDigit = partialDividend / divider;
			iterationArrayList.add(partialDividend);
			iterationArrayList.add(divisionDigit);
			outputArray.add((ArrayList<Integer>) iterationArrayList.clone());
			partialDividend = partialDividend - divider * divisionDigit;
			iterationArrayList.clear();
		}
		return outputArray;

	}

	private Integer getNthDigit(Integer sourceInteger, int position) {
		int length = integerLength(sourceInteger);

		return sourceInteger / (int) Math.pow(10, length - position) % 10;
	}

	private Integer subInteger(Integer sourceInteger, Integer startPosition, Integer count) {
		Integer[] digits = new Integer[integerLength(sourceInteger)];
		for (int i = 0; i < integerLength(sourceInteger); i++) {
			digits[i] = getNthDigit(sourceInteger, i + 1);
		}
		Integer result = 0;
		int index = startPosition;
		for (int i = count - 1; i >= 0; i--) {
			result = (int) (result + digits[index] * Math.pow(10, i));
			index++;
		}
		return result;

	}

	private Integer integerLength(Integer sourceInteger) {
		if (sourceInteger == 0) {
			return 0;
		} else {
			return (int) (Math.log10(sourceInteger) + 1);
		}

	}

}
