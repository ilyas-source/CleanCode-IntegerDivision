package ua.com.foxminded.integerdivision;

public class DivisionStep {

	private int partialDividend;
	private int divisionDigit;
	private int multiplication;

	public DivisionStep(int partialDividend, int divisionDigit, int multiplication) {
		this.setPartialDividend(partialDividend);
		this.setDivisionDigit(divisionDigit);
		this.setMultiplication(multiplication);

	}

	public DivisionStep() {
		// TODO Auto-generated constructor stub
	}

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
		return "[PD:" + partialDividend + ", DD:" + divisionDigit + ", M:" + multiplication + "]";
	}

	public int getMultiplication() {
		return multiplication;
	}

	public void setMultiplication(int multiplication) {
		this.multiplication = multiplication;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + divisionDigit;
		result = prime * result + multiplication;
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
		if (multiplication != other.multiplication)
			return false;
		if (partialDividend != other.partialDividend)
			return false;
		return true;
	}

}
