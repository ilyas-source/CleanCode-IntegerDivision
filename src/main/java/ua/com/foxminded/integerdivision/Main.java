package ua.com.foxminded.integerdivision;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dividend = 0;
		int divider = 1;

		try {
			System.out.println("Enter the dividend:");
			dividend = scanner.nextInt();
			System.out.println("Enter the divider:");
			divider = scanner.nextInt();
		} catch (InputMismatchException inputMismatchException) {
			System.out.println("Input mismatch, terminating.");
			System.exit(0);
		}

		scanner.close();

		IntegerDivision integerDivision = new IntegerDivision();

		ArrayList<ArrayList<Integer>> divisionArrayList = integerDivision.createDivisionArrayList(dividend, divider);

		StringBuilder outputString = new StringBuilder();
		outputString.append("_" + Integer.toString(dividend) + "|" + Integer.toString(divider) + "\n");
		outputString.append(integerDivision.createString(divisionArrayList, dividend, divider));
		System.out.println(outputString);
	}

}