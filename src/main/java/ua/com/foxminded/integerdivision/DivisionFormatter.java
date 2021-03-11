package ua.com.foxminded.integerdivision;

public class DivisionFormatter {

	public static final String CR = System.lineSeparator();
	public static final char SPACE = " ".charAt(0);
	public static final char DASH = "-".charAt(0);

	NumberUtils numberUtils = new NumberUtils();

	public String format(DivisionResult divisionResult) {

		int divider = divisionResult.getDivider();
		int partialDividend = divisionResult.getPartialDividend(0);

		if ((divisionResult.divisionSteps.size() == 1) && (partialDividend == 0)) {
			return createSimpleDivision(divisionResult);
		}

		StringBuilder result = new StringBuilder(createHeader(divisionResult));

		int index = numberUtils.getIntLength(partialDividend);

		for (int j = 1; j < divisionResult.divisionSteps.size(); j++) {
			partialDividend = divisionResult.getPartialDividend(j);

			if (partialDividend > 0) {
				result.append(createRegularIteration(partialDividend, divider, index));
			}
			if (j == divisionResult.divisionSteps.size() - 1) {
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
		int spaces = index + 1 - numberUtils.getIntLength(remainder);
		if (remainder > 0)
			spaces++;
		result.append(repeatChar(SPACE, spaces));
		result.append(remainder);
		return result.toString();
	}

	private String createRegularIteration(int partialDividend, int divider, int index) {
		StringBuilder result = new StringBuilder();
		int divisionDigit = partialDividend / divider;

		int spaces = index + 1 - numberUtils.getIntLength(partialDividend);
		result.append(repeatChar(SPACE, spaces));
		result.append("_" + partialDividend + CR);
		int multiplication = divider * divisionDigit;
		spaces = index + 2 - numberUtils.getIntLength(multiplication);
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
		int index = numberUtils.getIntLength(partialDividend) - 1;

		result.append("_" + dividend + "|" + divider + CR);
		result.append(" " + multiplication);
		result.append(repeatChar(SPACE, numberUtils.getIntLength(dividend) - index - 1));

		result.append("|");
		result.append(repeatChar(DASH, divisionResult.divisionSteps.size()));

		result.append(CR + " ");
		result.append(repeatChar(SPACE, index - numberUtils.getIntLength(multiplication)));
		result.append(repeatChar(DASH, String.valueOf(multiplication).length()));
		result.append(repeatChar(SPACE, numberUtils.getIntLength(dividend) - index - 1));
		result.append("|" + division);

		result.append(CR);

		return result.toString();
	}

	private String createSimpleDivision(DivisionResult divisionResult) {
		StringBuilder result = new StringBuilder();
		int dividend = divisionResult.getDividend();
		int divider = divisionResult.getDivider();

		result.append(String.valueOf(dividend) + "|" + String.valueOf(divider) + CR);
		result.append(repeatChar(SPACE, numberUtils.getIntLength(dividend)));
		result.append("|");
		result.append(repeatChar(DASH, numberUtils.getIntLength(divider)));
		result.append(CR);
		result.append(repeatChar(SPACE, numberUtils.getIntLength(dividend)));
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
