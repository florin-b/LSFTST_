package patterns;

import java.util.Comparator;

import beans.StocMathaus;

public class StocMathausComparator implements Comparator<StocMathaus>{

	@Override
	public int compare(StocMathaus stoc1, StocMathaus stoc2) {
		return (int)(stoc2.getCantitate() - stoc1.getCantitate());
	}

}
