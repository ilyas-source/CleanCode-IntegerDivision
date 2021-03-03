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
		int partialDividend = subInteger(dividend, 0, 0);

		if (partialDividend > divider) {
			divisionDigit = partialDividend / divider;
			iterationArrayList.add(partialDividend);
			iterationArrayList.add(divisionDigit);
			outputArray.add((ArrayList<Integer>) iterationArrayList.clone());
			partialDividend = partialDividend - divider * divisionDigit;

			iterationArrayList.clear();
		}

		int startPosition = 1;
		int remainder = partialDividend;

		for (int index = 1; index < integerLength(dividend); index++) {
			int subInteger = subInteger(dividend, startPosition, index);
			partialDividend = (int) (subInteger + remainder * Math.pow(10, index - startPosition + 1));

			if (partialDividend < divider) {
				if (!outputArray.isEmpty()) {
					iterationArrayList.add(0);
					iterationArrayList.add(0);
					outputArray.add((ArrayList<Integer>) iterationArrayList.clone());
					iterationArrayList.clear();
				}
			} else {
				divisionDigit = partialDividend / divider;
				iterationArrayList.add(partialDividend);
				iterationArrayList.add(divisionDigit);
				outputArray.add((ArrayList<Integer>) iterationArrayList.clone());
				partialDividend = partialDividend - divider * divisionDigit;
				remainder = partialDividend;
				iterationArrayList.clear();
				startPosition = index + 1;
			}
		}

		return outputArray;

	}

	private Integer getNthDigit(Integer sourceInteger, int position) {
		int length = integerLength(sourceInteger);

		return sourceInteger / (int) Math.pow(10, length - position) % 10;
	}

	public Integer subInteger(Integer sourceInteger, Integer startPosition, Integer endPosition) {

		Integer[] digits = new Integer[integerLength(sourceInteger)];
		for (int i = 0; i < integerLength(sourceInteger); i++) {
			digits[i] = getNthDigit(sourceInteger, i + 1);
		}

		Integer result = 0;
		int index = startPosition;
		int count = endPosition - startPosition + 1;
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
