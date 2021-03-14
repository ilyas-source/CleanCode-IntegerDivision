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
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + divisionDigit;
		result = prime * result + partialDividend;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DivisionStep other = (DivisionStep) obj;
		if (divisionDigit != other.divisionDigit)
			return false;
		if (partialDividend != other.partialDividend)
			return false;
		return true;
	}

}
