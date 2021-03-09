package ua.com.foxminded.integerdivision;

import java.util.List;

public class DivisionFormatter {

	public static final String CR = System.lineSeparator();
	IntegerDivision integerDivision = new IntegerDivision();

	public String format(DivisionResult divisionResult) {

		int divider = divisionResult.getDivider();
		int dividend = divisionResult.getDividend();
		int partialDividend = divisionResult.getPartialDividends().get(0);

		if ((divisionResult.getPartialDividends().size() == 1) && (partialDividend == 0)) {
			return createSimpleDivision(dividend, divider);
		}

		StringBuilder result = new StringBuilder(createHeader(divisionResult));

		int index = integerDivision.getIntLength(partialDividend);

		for (int j = 1; j < divisionResult.getPartialDividends().size(); j++) {
			partialDividend = divisionResult.getPartialDividends().get(j);
			if ((partialDividend < divider) && (index == integerDivision.getIntLength(dividend) - 1)) {
				result = addChars(result, " ", index + 2 - integerDivision.getIntLength(partialDividend));
				result.append(String.valueOf(partialDividend));
				break;
			}

			if (partialDividend > 0) {
				result.append(createRegularIteration(partialDividend, divider, index));
			}
			if (j == divisionResult.getPartialDividends().size() - 1) {
				result.append(createLastRemainderString(partialDividend, divider, index));
			} else {
				index++;
			}
		}
		return result.toString();
	}

	private String createLastRemainderString(int partialDividend, int divider, int index) {
		StringBuilder result = new StringBuilder();
		int divisionDigit = partialDividend / divider;
		int multiplication = divider * divisionDigit;
		int remainder = partialDividend - multiplication;
		int spaces = index + 1 - integerDivision.getIntLength(remainder);
		if (remainder > 0)
			spaces++;
		result = addChars(result, " ", spaces);
		result.append(remainder);
		return result.toString();
	}

	private String createRegularIteration(int partialDividend, int divider, int index) {
		StringBuilder result = new StringBuilder();
		int divisionDigit = partialDividend / divider;

		int spaces = index + 1 - integerDivision.getIntLength(partialDividend);
		result = addChars(result, " ", spaces);
		result.append("_" + partialDividend + CR);
		int multiplication = divider * divisionDigit;
		spaces = index + 2 - integerDivision.getIntLength(multiplication);
		result = addChars(result, " ", spaces);
		result.append(multiplication + CR);
		result = addChars(result, " ", spaces);
		result = addChars(result, "-", String.valueOf(multiplication).length());
		result.append(CR);
		return result.toString();

	}

	private String createHeader(DivisionResult divisionResult) {
		StringBuilder result = new StringBuilder();

		int divisionDigit = divisionResult.getPartialDividends().get(0) / divisionResult.getDivider();
		int multiplication = divisionResult.getDivider() * divisionDigit;
		int index = integerDivision.getIntLength(divisionResult.getPartialDividends().get(0)) - 1;

		result.append("_" + divisionResult.getDividend() + "|" + divisionResult.getDivider() + CR);
		result.append(" " + multiplication);
		result = addChars(result, " ", integerDivision.getIntLength(divisionResult.getDividend()) - index - 1);
		result.append("|");
		result = addChars(result, "-", divisionResult.getPartialDividends().size());
		result.append(CR + " ");
		result = addChars(result, " ", index - integerDivision.getIntLength(multiplication));
		result = addChars(result, "-", String.valueOf(multiplication).length());
		result = addChars(result, " ", integerDivision.getIntLength(divisionResult.getDividend()) - index - 1);
		result.append("|");
		for (int j = 0; j < divisionResult.getPartialDividends().size(); j++) {
			divisionDigit = divisionResult.getPartialDividends().get(j) / divisionResult.getDivider();
			result.append(String.valueOf(divisionDigit));
		}
		result.append(CR);

		return result.toString();
	}

	private String createSimpleDivision(int dividend, int divider) {
		StringBuilder result = new StringBuilder();
		result.append(String.valueOf(dividend) + "|" + String.valueOf(divider) + CR);
		result = addChars(result, " ", integerDivision.getIntLength(dividend));
		result.append("|");
		result = addChars(result, "-", integerDivision.getIntLength(divider));
		result.append(CR);
		result = addChars(result, " ", integerDivision.getIntLength(dividend));
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
}
