package ua.com.foxminded.integerdivision;

import java.util.ArrayList;

public class DivisionFormatter {

	public static final String CR = System.lineSeparator();

	public String format(ArrayList<Integer> divisionArrayList, Integer dividend, Integer divider) {
		StringBuilder result = new StringBuilder();

		Integer partialDividend = divisionArrayList.get(0);
		Integer divisionDigit = partialDividend / divider;

		if ((divisionArrayList.size() == 1) && (partialDividend + divisionDigit == 0)) {
			result.append(dividend.toString() + "|" + divider.toString() + CR);
			result = addSymbols(result, " ", integerLength(dividend));
			result.append("|");
			result = addSymbols(result, "-", integerLength(divider));
			result.append(CR);
			result = addSymbols(result, " ", integerLength(dividend));
			result.append("|0");
			return result.toString();
		}

		Integer index = integerLength(partialDividend) - 1;

		Integer multiplication = divider * divisionDigit;

		result.append("_" + Integer.toString(dividend) + "|" + Integer.toString(divider) + CR);
		result.append(" " + multiplication.toString());
		result = addSymbols(result, " ", integerLength(dividend) - index - 1);
		result.append("|");
		result = addSymbols(result, "-", divisionArrayList.size());
		result.append(CR + " ");
		result = addSymbols(result, " ", index - integerLength(multiplication));
		result = addSymbols(result, "-", multiplication.toString().length());
		result = addSymbols(result, " ", integerLength(dividend) - index - 1);
		result.append("|");
		for (int j = 0; j < divisionArrayList.size(); j++) {
			divisionDigit = divisionArrayList.get(j) / divider;
			result.append(divisionDigit.toString());
		}
		result.append(CR);
		index++;

		int j = 1;
		while (j < divisionArrayList.size()) {
			partialDividend = divisionArrayList.get(j);
			divisionDigit = partialDividend / divider;

			if ((partialDividend < divider) && (index == integerLength(dividend) - 1)) {
				result = addSymbols(result, " ", index + 2 - integerLength(partialDividend));
				result.append(partialDividend.toString());
				break;
			}

			if (partialDividend + divisionDigit > 0) {

				int spaces = index + 1 - integerLength(partialDividend);
				result = addSymbols(result, " ", spaces);
				result.append("_" + partialDividend.toString() + CR);
				multiplication = divider * divisionDigit;
				spaces = index + 2 - integerLength(multiplication);
				result = addSymbols(result, " ", spaces);
				result.append(multiplication.toString() + CR);
				result = addSymbols(result, " ", spaces);
				result = addSymbols(result, "-", multiplication.toString().length());
				result.append(CR);
			}
			if (j == divisionArrayList.size() - 1) {

				partialDividend = divisionArrayList.get(j);
				Integer remainder = 0;
				remainder = partialDividend - multiplication;
				int spaces = index + 1 - integerLength(remainder);
				if (remainder > 0)
					spaces++;
				result = addSymbols(result, " ", spaces);
				result.append(remainder.toString());
			} else {
				index++;

			}
			j++;
		}
		return result.toString();
	}

	private StringBuilder addSymbols(StringBuilder string, String symbol, int count) {
		StringBuilder result = string;
		for (int i = 0; i < count; i++) {
			result.append(symbol);
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
