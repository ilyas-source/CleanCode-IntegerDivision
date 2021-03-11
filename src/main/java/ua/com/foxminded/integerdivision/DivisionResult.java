package ua.com.foxminded.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class DivisionResult {

	List<DivisionStep> divisionSteps = new ArrayList<>();
	private int dividend;
	private int divider;
	private int division;

	public void setDivisionSteps(List<DivisionStep> divisionSteps) {
		this.divisionSteps = divisionSteps;
	}

	public void addDivisionStep(int partialDividend, int divisionDigit) {
		DivisionStep d = new DivisionStep();
		d.setPartialDividend(partialDividend);
		d.setDivisionDigit(divisionDigit);
		this.divisionSteps.add(d);
	}

	public int getPartialDividend(int index) {
		return this.divisionSteps.get(index).getPartialDividend();
	}

	public int getDivisionDigit(int index) {
		return this.divisionSteps.get(index).getDivisionDigit();
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

	@Override
	public String toString() {
		return divisionSteps.toString() + ", dividend: " + dividend + ", divider: " + divider;
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}
}
