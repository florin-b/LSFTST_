package patterns;

import java.util.Comparator;

import beans.FacturaNeincasataLite;

public class FactNeincOrdComparator implements Comparator<FacturaNeincasataLite> {

	@Override
	public int compare(FacturaNeincasataLite fact1, FacturaNeincasataLite fact2) {
		return fact1.getOrdineSelectie() - fact2.getOrdineSelectie();

	}

}
