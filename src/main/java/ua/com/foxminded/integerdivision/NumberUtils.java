package ua.com.foxminded.integerdivision;

public class NumberUtils {

	public static int getNthDigit(int sourceInt, int position) {
		int length = getIntLength(sourceInt);

		return sourceInt / (int) Math.pow(10, length - position) % 10;
	}

	public static int getIntLength(int sourceInt) {
		if (sourceInt == 0) {
			return 0;
		} else {
			return (int) (Math.log10(sourceInt) + 1);
		}
	}

}
