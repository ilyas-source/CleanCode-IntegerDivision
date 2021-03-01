package ua.com.foxminded.integer_division;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the dividend:");
		String dividendString = scanner.nextLine();
		System.out.println("Enter the divider:");
		String dividerString = scanner.nextLine();
		scanner.close();

		int dividend = 0;
		int divider = 1;

		try {
			dividend = Integer.parseInt(dividendString.trim());
			divider = Integer.parseInt(dividerString.trim());
		} catch (NumberFormatException numberFormatException) {
			System.out.println("NumberFormatException: " + numberFormatException.getMessage());
			System.exit(0);
		}

		if (dividend < divider) {
			System.out.println("Dividend is less than divider, terminating.");
			System.exit(0);
		}

		if (divider == 0) {
			System.out.println("Division by zero, terminating.");
			System.exit(0);
		}

		IntegerDivision integerDivision = new IntegerDivision();

		ArrayList<ArrayList<Integer>> divisionArrayList = integerDivision.createDivisionArrayList(dividend, divider);

		StringBuilder outputString = new StringBuilder();
		outputString.append("_" + Integer.toString(dividend) + "|" + Integer.toString(divider) + "\n");
		outputString.append(integerDivision.createString(divisionArrayList, dividend, divider));
		System.out.println(outputString);
	}

}