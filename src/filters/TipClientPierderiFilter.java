package filters;

import java.util.ArrayList;


import beans.PierdereTipClient;

public class TipClientPierderiFilter {

	public ArrayList<PierdereTipClient> getPierderiTipClient(ArrayList<PierdereTipClient> listPierderi, String codTipClient) {
		ArrayList<PierdereTipClient> newListPierderi = new ArrayList<PierdereTipClient>();

		for (PierdereTipClient p : listPierderi) {
			if (p.getCodTipClient().equals(codTipClient))
				newListPierderi.add(p);

		}

		return newListPierderi;

	}

}
