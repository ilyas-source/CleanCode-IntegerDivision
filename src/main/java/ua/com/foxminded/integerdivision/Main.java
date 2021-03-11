package ua.com.foxminded.integerdivision;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the dividend:");
		int dividend = scanner.nextInt();
		System.out.println("Enter the divider:");
		int divider = scanner.nextInt();

		scanner.close();

		IntegerDivision integerDivision = new IntegerDivision();

		DivisionResult divisionResult = integerDivision.divide(dividend, divider);
		DivisionFormatter formatter = new DivisionFormatter();
		System.out.println(formatter.format(divisionResult));

	}

}