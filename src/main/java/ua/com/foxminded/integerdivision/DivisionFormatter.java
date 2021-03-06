package ua.com.foxminded.integerdivision;

public class DivisionFormatter {

	public static final String CR = System.lineSeparator();
	public static final char SPACE = ' ';
	public static final char DASH = '-';

	public String format(DivisionResult divisionResult) {
		int divider = divisionResult.getDivider();
		int partialDividend = divisionResult.getPartialDividend(0);
		int remainder = divisionResult.getRemainder();
		StringBuilder result = new StringBuilder(createHeader(divisionResult));

		int indent = NumberUtils.getIntLength(partialDividend);

		for (int j = 1; j < divisionResult.getDivisionSteps().size(); j++) {
			partialDividend = divisionResult.getPartialDividend(j);

			if (partialDividend > 0) {
				result.append(createStep(divisionResult.getDivisionSteps().get(j), divider, indent));
			}
			indent++;
		}
		result.append(formatRemainder(remainder, indent));
		return result.toString();
	}

	private String createStep(DivisionStep divisionStep, int divider, int indent) {
		StringBuilder result = new StringBuilder();
		int partialDividend = divisionStep.getPartialDividend();
		int multiplication = divisionStep.getMultiplication();

		int spaces = indent + 1 - NumberUtils.getIntLength(partialDividend);
		result.append(repeatChar(SPACE, spaces));
		result.append("_" + partialDividend + CR);
		spaces = indent + 2 - NumberUtils.getIntLength(multiplication);
		result.append(repeatChar(SPACE, spaces));
		result.append(multiplication + CR);
		result.append(repeatChar(SPACE, spaces));
		result.append(repeatChar(DASH, String.valueOf(multiplication).length()));
		result.append(CR);
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

	private String createHeader(DivisionResult divisionResult) {
		StringBuilder result = new StringBuilder();
		int divider = divisionResult.getDivider();
		int dividend = divisionResult.getDividend();
		int division = divisionResult.getDivision();
		int partialDividend = divisionResult.getPartialDividend(0);
		int multiplication = divisionResult.getMultiplication(0);
		int index = NumberUtils.getIntLength(partialDividend) - 1;

		result.append("_" + dividend + "|" + divider + CR);
		result.append(" " + multiplication);
		result.append(repeatChar(SPACE, NumberUtils.getIntLength(dividend) - index - 1));

		result.append("|");
		result.append(repeatChar(DASH, divisionResult.getDivisionSteps().size()));

		result.append(CR + " ");
		result.append(repeatChar(SPACE, index - NumberUtils.getIntLength(multiplication)));
		result.append(repeatChar(DASH, String.valueOf(multiplication).length()));
		result.append(repeatChar(SPACE, NumberUtils.getIntLength(dividend) - index - 1));
		result.append("|" + division);

		result.append(CR);

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
