package ua.com.foxminded.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class DivisionResult {
	private List<Integer> partialDividends = new ArrayList<>();
	private List<Integer> divisionDigits = new ArrayList<>();
	private int dividend;
	private int divider;

	public List<Integer> getPartialDividends() {
		return partialDividends;
	}

	public void addPartialDividend(int partialDividend) {
		this.partialDividends.add(partialDividend);
	}

	public void addDivisionDigit(int divisionDigit) {
		this.divisionDigits.add(divisionDigit);
	}

	public void setPartialDividends(List<Integer> partialDividends) {
		this.partialDividends = partialDividends;
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
}
