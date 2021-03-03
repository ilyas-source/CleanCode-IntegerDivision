package ua.com.foxminded.integerdivision;

import java.util.ArrayList;

public class DivisionFormatter {

	public static final String LS = System.lineSeparator();

	public String format(ArrayList<ArrayList<Integer>> divisionArrayList, Integer dividend, Integer divider) {
		StringBuilder result = new StringBuilder();

		Integer partialDividend = divisionArrayList.get(0).get(0);
		Integer divisionDigit = divisionArrayList.get(0).get(1);

		if ((divisionArrayList.size() == 1) && (partialDividend + divisionDigit == 0)) {
			result.append(dividend.toString() + "|" + divider.toString() + LS);
			result = addSpaces(result, getIntegerLength(dividend));
			result.append("|");
			result = addDashes(result, getIntegerLength(divider));
			result.append(LS);
			result = addSpaces(result, getIntegerLength(dividend));
			result.append("|0");
			return result.toString();
		}

		Integer index = getIntegerLength(partialDividend) - 1;

		Integer multiplication = divider * divisionDigit;

		result.append("_" + Integer.toString(dividend) + "|" + Integer.toString(divider) + LS);
		result.append(" " + multiplication.toString());
		result = addSpaces(result, getIntegerLength(dividend) - index - 1);
		result.append("|");
		result = addDashes(result, divisionArrayList.size());
		result.append(LS + " ");
		result = addSpaces(result, index - getIntegerLength(multiplication));
		result = addDashes(result, multiplication.toString().length());
		result = addSpaces(result, getIntegerLength(dividend) - index - 1);
		result.append("|");
		for (int j = 0; j < divisionArrayList.size(); j++) {
			result.append(divisionArrayList.get(j).get(1).toString());
		}
		result.append(LS);
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
				result.append("_" + partialDividend.toString() + LS);
				multiplication = divider * divisionArrayList.get(j).get(1);
				spaces = index + 2 - getIntegerLength(multiplication);
				result = addSpaces(result, spaces);
				result.append(multiplication.toString() + LS);
				result = addSpaces(result, spaces);
				result = addDashes(result, multiplication.toString().length());
				result.append(LS);
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

	private Integer getIntegerLength(Integer sourceInteger) {
		if (sourceInteger == 0) {
			return 0;
		} else {
			return (int) (Math.log10(sourceInteger) + 1);
		}

	}

}
