package ua.com.foxminded.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class DivisionResult {
	private List<Integer> partialDividends = new ArrayList<>();

	public List<Integer> getPartialDividends() {
		return partialDividends;
	}

	public void setPartialDividends(List<Integer> partialDividends) {
		this.partialDividends = partialDividends;
	}
}
