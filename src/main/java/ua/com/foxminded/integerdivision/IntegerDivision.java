package ua.com.foxminded.integerdivision;

import java.util.ArrayList;

public class IntegerDivision {
	public ArrayList<ArrayList<Integer>> createDivisionArrayList(Integer dividend, Integer divider) {

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

		Integer divisionDigit = 0;
		Integer partialDividend = subInteger(dividend, 0, 1);
		Integer index = 1;
		Integer additionalDigitsCount = 1;

		if (partialDividend > divider) {
			divisionDigit = partialDividend / divider;
			iterationArrayList.add(partialDividend);
			iterationArrayList.add(divisionDigit);
			outputArray.add((ArrayList<Integer>) iterationArrayList.clone());
			partialDividend = partialDividend - divider * divisionDigit;

			iterationArrayList.clear();
		}

		while (index < getIntegerLength(dividend)) {
			while (partialDividend < divider) {
				Integer subInteger = subInteger(dividend, index, additionalDigitsCount);
				Integer tempDividend = (int) (partialDividend * Math.pow(10, additionalDigitsCount) + subInteger);
				if (tempDividend < divider) {
					if (index + additionalDigitsCount == getIntegerLength(dividend)) {
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

	public String createString(ArrayList<ArrayList<Integer>> divisionArrayList, Integer dividend, Integer divider) {
		StringBuilder result = new StringBuilder();

		Integer partialDividend = divisionArrayList.get(0).get(0);
		Integer divisionDigit = divisionArrayList.get(0).get(1);

		if ((divisionArrayList.size() == 1) && (partialDividend + divisionDigit == 0)) {
			result.append(dividend.toString() + "|" + divider.toString() + "\n");
			result = addSpaces(result, getIntegerLength(dividend));
			result.append("|");
			result = addDashes(result, getIntegerLength(divider));
			result.append("\n");
			result = addSpaces(result, getIntegerLength(dividend));
			result.append("|0");
			return result.toString();
		}

		Integer index = getIntegerLength(partialDividend) - 1;

		Integer multiplication = divider * divisionDigit;

		result.append("_" + Integer.toString(dividend) + "|" + Integer.toString(divider) + "\n");
		result.append(" " + multiplication.toString());
		result = addSpaces(result, getIntegerLength(dividend) - index - 1);
		result.append("|");
		result = addDashes(result, divisionArrayList.size());
		result.append("\n ");
		result = addSpaces(result, index - getIntegerLength(multiplication));
		result = addDashes(result, multiplication.toString().length());
		result = addSpaces(result, getIntegerLength(dividend) - index - 1);
		result.append("|");
		for (int j = 0; j < divisionArrayList.size(); j++) {
			result.append(divisionArrayList.get(j).get(1).toString());
		}
		result.append("\n");
		index++;

		int j = 1;
		while (j < divisionArrayList.size()) {
			partialDividend = divisionArrayList.get(j).get(0);
			divisionDigit = divisionArrayList.get(j).get(1);

			if ((partialDividend < divider) && (index == getIntegerLength(dividend) - 1)) {
				result = addSpaces(result, index + 2 - getIntegerLength(partialDividend));
				result.append(partialDividend.toString());
				break;
			}

			if (partialDividend + divisionDigit > 0) {

				int spaces = index + 1 - getIntegerLength(partialDividend);
				result = addSpaces(result, spaces);
				result.append("_" + partialDividend.toString() + "\n");
				multiplication = divider * divisionArrayList.get(j).get(1);
				spaces = index + 2 - getIntegerLength(multiplication);
				result = addSpaces(result, spaces);
				result.append(multiplication.toString() + "\n");
				result = addSpaces(result, spaces);
				result = addDashes(result, multiplication.toString().length());
				result.append("\n");
			}
			if (j == divisionArrayList.size() - 1) {

				partialDividend = divisionArrayList.get(j).get(0);
				Integer remainder = 0;
				remainder = partialDividend - multiplication;
				int spaces = index + 1 - getIntegerLength(remainder);
				if (remainder > 0)
					spaces++;
				result = addSpaces(result, spaces);
				result.append(remainder.toString());
			} else {
				index++;

			}
			j++;
		}
		return result.toString();
	}

	private StringBuilder addSpaces(StringBuilder string, int count) {
		StringBuilder result = string;
		for (int i = 0; i < count; i++) {
			result.append(" ");
		}
		return result;
	}

	private StringBuilder addDashes(StringBuilder string, int count) {
		StringBuilder result = string;
		for (int i = 0; i < count; i++) {
			result.append("-");
		}
		return result;
	}

	private Integer getNthDigit(Integer sourceInteger, int position) {
		int length = getIntegerLength(sourceInteger);

		return sourceInteger / (int) Math.pow(10, length - position) % 10;
	}

	private Integer subInteger(Integer sourceInteger, Integer startPosition, Integer count) {
		Integer[] digits = new Integer[getIntegerLength(sourceInteger)];
		for (int i = 0; i < getIntegerLength(sourceInteger); i++) {
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

	private Integer getIntegerLength(Integer sourceInteger) {
		if (sourceInteger == 0) {
			return 0;
		} else {
			return (int) (Math.log10(sourceInteger) + 1);
		}

	}

}