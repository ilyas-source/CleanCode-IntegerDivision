package ua.com.foxminded.integerdivision;

import java.util.ArrayList;

public class DivisionFormatter {

	public static final String CR = System.lineSeparator();

	public String format(ArrayList<Integer> inputArray, int dividend, int divider) {

		if ((inputArray.size() == 1) && (inputArray.get(0) == 0)) {
			return simpleDivision(dividend, divider);
		}

		StringBuilder result = new StringBuilder(createHeader(inputArray, dividend, divider));

		int index = intLength(inputArray.get(0));
		int j = 1;
		while (j < inputArray.size()) {
			int partialDividend = inputArray.get(j);
			int divisionDigit = partialDividend / divider;
			if ((partialDividend < divider) && (index == intLength(dividend) - 1)) {
				result = addChars(result, " ", index + 2 - intLength(partialDividend));
				result.append(String.valueOf(partialDividend));
				break;
			}

			if (partialDividend > 0) {
				result.append(regularIteration(partialDividend, divider, index));
			}
			if (j == inputArray.size() - 1) {
				result.append(addLastRemainder(partialDividend, divider, index));
			} else {
				index++;

			}
			j++;
		}
		return result.toString();
	}

	private String addLastRemainder(int partialDividend, int divider, int index) {
		StringBuilder result = new StringBuilder();
		int divisionDigit = partialDividend / divider;
		int multiplication = divider * divisionDigit;
		int remainder = partialDividend - multiplication;
		int spaces = index + 1 - intLength(remainder);
		if (remainder > 0)
			spaces++;
		result = addChars(result, " ", spaces);
		result.append(remainder);
		return result.toString();
	}

	private String regularIteration(int partialDividend, int divider, int index) {
		StringBuilder result = new StringBuilder();
		int divisionDigit = partialDividend / divider;

		int spaces = index + 1 - intLength(partialDividend);
		result = addChars(result, " ", spaces);
		result.append("_" + partialDividend + CR);
		int multiplication = divider * divisionDigit;
		spaces = index + 2 - intLength(multiplication);
		result = addChars(result, " ", spaces);
		result.append(multiplication + CR);
		result = addChars(result, " ", spaces);
		result = addChars(result, "-", String.valueOf(multiplication).length());
		result.append(CR);
		return result.toString();

	}

	private String createHeader(ArrayList<Integer> inputArray, int dividend, int divider) {
		StringBuilder result = new StringBuilder();

		int divisionDigit = inputArray.get(0) / divider;
		int multiplication = divider * divisionDigit;
		int index = intLength(inputArray.get(0)) - 1;

		result.append("_" + dividend + "|" + divider + CR);
		result.append(" " + multiplication);
		result = addChars(result, " ", intLength(dividend) - index - 1);
		result.append("|");
		result = addChars(result, "-", inputArray.size());
		result.append(CR + " ");
		result = addChars(result, " ", index - intLength(multiplication));
		result = addChars(result, "-", String.valueOf(multiplication).length());
		result = addChars(result, " ", intLength(dividend) - index - 1);
		result.append("|");
		for (int j = 0; j < inputArray.size(); j++) {
			divisionDigit = inputArray.get(j) / divider;
			result.append(String.valueOf(divisionDigit));
		}
		result.append(CR);

		return result.toString();
	}

	private String simpleDivision(int dividend, int divider) {
		StringBuilder result = new StringBuilder();
		result.append(String.valueOf(dividend) + "|" + String.valueOf(divider) + CR);
		result = addChars(result, " ", intLength(dividend));
		result.append("|");
		result = addChars(result, "-", intLength(divider));
		result.append(CR);
		result = addChars(result, " ", intLength(dividend));
		result.append("|0");

		return result.toString();
	}

	private StringBuilder addChars(StringBuilder string, String symbol, int count) {
		StringBuilder result = string;
		for (int i = 0; i < count; i++) {
			result.append(symbol);
		}
		return result;
	}

	private int intLength(int sourceInt) {
		if (sourceInt == 0) {
			return 0;
		} else {
			return (int) (Math.log10(sourceInt) + 1);
		}
	}

}
