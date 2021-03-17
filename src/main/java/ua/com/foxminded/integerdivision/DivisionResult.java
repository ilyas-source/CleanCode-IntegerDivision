package ua.com.foxminded.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class DivisionResult {

	private List<DivisionStep> divisionSteps = new ArrayList<>();

	private int dividend;
	private int divider;
	private int division;
	private int remainder;

	public void setDivisionSteps(List<DivisionStep> divisionSteps) {
		this.divisionSteps = divisionSteps;
	}

	public List<DivisionStep> getDivisionSteps() {
		return divisionSteps;
	}

	public int getPartialDividend(int index) {
		return this.divisionSteps.get(index).getPartialDividend();
	}

	public int getDivisionDigit(int index) {
		return this.divisionSteps.get(index).getDivisionDigit();
	}

	public int getMultiplication(int index) {
		return this.divisionSteps.get(index).getMultiplication();
	}

	public int getDividend() {
		return dividend;
	}

	public void setDividend(int dividend) {
		this.dividend = dividend;
	}

	public int getDivider() {
		return divider;
	}

	public void setDivider(int divider) {
		this.divider = divider;
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public int getRemainder() {
		return remainder;
	}

	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public String toString() {
		return divisionSteps.toString() + ", dividend: " + dividend + ", divider: " + divider + ", division: "
				+ division + ", remainder: " + remainder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dividend;
		result = prime * result + divider;
		result = prime * result + division;
		result = prime * result + ((divisionSteps == null) ? 0 : divisionSteps.hashCode());
		result = prime * result + remainder;
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
		DivisionResult other = (DivisionResult) obj;
		if (dividend != other.dividend)
			return false;
		if (divider != other.divider)
			return false;
		if (division != other.division)
			return false;
		if (divisionSteps == null) {
			if (other.divisionSteps != null)
				return false;
		} else if (!divisionSteps.equals(other.divisionSteps))
			return false;
		if (remainder != other.remainder)
			return false;
		return true;
	}
}
