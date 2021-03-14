package ua.com.foxminded.integerdivision;

public class DivisionStep implements Cloneable {

	private int partialDividend;
	private int divisionDigit;

	public int getPartialDividend() {
		return partialDividend;
	}

	public void setPartialDividend(int partialDividend) {
		this.partialDividend = partialDividend;
	}

	public int getDivisionDigit() {
		return divisionDigit;
	}

	public void setDivisionDigit(int divisionDigit) {
		this.divisionDigit = divisionDigit;
	}

	@Override
	public String toString() {
		return "[" + partialDividend + "," + divisionDigit + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
