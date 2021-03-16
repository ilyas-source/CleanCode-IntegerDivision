package ua.com.foxminded.integerdivision;

public class DivisionFormatter {

	public static final String CR = System.lineSeparator();
	public static final char SPACE = ' ';
	public static final char DASH = '-';

	public String format(DivisionResult divisionResult) {
		int divider = divisionResult.getDivider();
		int partialDividend = divisionResult.getPartialDividend(0);
		int remainder = divisionResult.getRemainder();

		if ((divisionResult.divisionSteps.size() == 1) && (partialDividend == 0)) {
			return createSimpleDivision(divisionResult);
		}

		StringBuilder result = new StringBuilder(createHeader(divisionResult));

		int indent = NumberUtils.getIntLength(partialDividend);

		for (int j = 1; j < divisionResult.divisionSteps.size(); j++) {
			partialDividend = divisionResult.getPartialDividend(j);

			if (partialDividend > 0) {
				result.append(createStep(partialDividend, divider, indent));
			}
			indent++;
		}
		result.append(formatRemainder(remainder, indent));
		return result.toString();
	}

	private String formatRemainder(int remainder, int index) {
		StringBuilder result = new StringBuilder();
		int spaces = index - NumberUtils.getIntLength(remainder);
		if (remainder > 0) {
			spaces++;
		}
		result.append(repeatChar(SPACE, spaces));
		result.append(remainder);
		return result.toString();
	}

	private String createStep(int partialDividend, int divider, int index) {
		StringBuilder result = new StringBuilder();
		int divisionDigit = partialDividend / divider;

		int spaces = index + 1 - NumberUtils.getIntLength(partialDividend);
		result.append(repeatChar(SPACE, spaces));
		result.append("_" + partialDividend + CR);
		int multiplication = divider * divisionDigit;
		spaces = index + 2 - NumberUtils.getIntLength(multiplication);
		result.append(repeatChar(SPACE, spaces));
		result.append(multiplication + CR);
		result.append(repeatChar(SPACE, spaces));
		result.append(repeatChar(DASH, String.valueOf(multiplication).length()));
		result.append(CR);
		return result.toString();

	}

	private String createHeader(DivisionResult divisionResult) {
		StringBuilder result = new StringBuilder();
		int divider = divisionResult.getDivider();
		int dividend = divisionResult.getDividend();
		int division = divisionResult.getDivision();
		int partialDividend = divisionResult.getPartialDividend(0);
		int divisionDigit = divisionResult.getDivisionDigit(0);
		int multiplication = divider * divisionDigit;
		int index = NumberUtils.getIntLength(partialDividend) - 1;

		result.append("_" + dividend + "|" + divider + CR);
		result.append(" " + multiplication);
		result.append(repeatChar(SPACE, NumberUtils.getIntLength(dividend) - index - 1));

		result.append("|");
		result.append(repeatChar(DASH, divisionResult.divisionSteps.size()));

		result.append(CR + " ");
		result.append(repeatChar(SPACE, index - NumberUtils.getIntLength(multiplication)));
		result.append(repeatChar(DASH, String.valueOf(multiplication).length()));
		result.append(repeatChar(SPACE, NumberUtils.getIntLength(dividend) - index - 1));
		result.append("|" + division);

		result.append(CR);

		return result.toString();
	}

	private String createSimpleDivision(DivisionResult divisionResult) {
		StringBuilder result = new StringBuilder();
		int dividend = divisionResult.getDividend();
		int divider = divisionResult.getDivider();

		result.append(dividend + "|" + divider + CR);
		result.append(repeatChar(SPACE, NumberUtils.getIntLength(dividend)));
		result.append("|");
		result.append(repeatChar(DASH, NumberUtils.getIntLength(divider)));
		result.append(CR);
		result.append(repeatChar(SPACE, NumberUtils.getIntLength(dividend)));
		result.append("|0");

		return result.toString();
	}

	private StringBuilder repeatChar(char symbol, int count) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < count; i++) {
			result.append(symbol);
		}
		return result;
	}
}
