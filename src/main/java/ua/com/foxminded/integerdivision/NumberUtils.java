package ua.com.foxminded.integerdivision;

public class NumberUtils {

	public Integer getNthDigit(int sourceInt, int position) {
		int length = getIntLength(sourceInt);

		return sourceInt / (int) Math.pow(10, length - position) % 10;
	}

	public int getSubInt(int sourceInt, int startPosition, int endPosition) {

		int[] digits = new int[getIntLength(sourceInt)];
		for (int i = 0; i < getIntLength(sourceInt); i++) {
			digits[i] = getNthDigit(sourceInt, i + 1);
		}

		int result = 0;
		int index = startPosition;
		int count = endPosition - startPosition + 1;
		for (int i = count - 1; i >= 0; i--) {
			result = (int) (result + digits[index] * Math.pow(10, i));
			index++;
		}
		return result;
	}

	public int getIntLength(int sourceInt) {
		if (sourceInt == 0) {
			return 0;
		} else {
			return (int) (Math.log10(sourceInt) + 1);
		}
	}

}
