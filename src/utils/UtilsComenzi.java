package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.ArticolComanda;
import model.DateLivrare;
import model.InfoStrings;
import android.widget.Spinner;
import enums.TipCmdDistrib;

public class UtilsComenzi {

	public static String getStareComanda(int codStare) {
		String numeStare = "";

		switch (codStare) {

		case 1:
			numeStare = "Masina alocata";
			break;

		case 2:
			numeStare = "Borderou tiparit";
			break;

		case 3:
			numeStare = "Inceput incarcare";
			break;

		case 4:
			numeStare = "Terminat incarcare";
			break;

		case 6:
			numeStare = "Plecat in cursa";
			break;

		default:
			break;
		}

		return numeStare;
	}

	public static boolean isComandaGed(String unitLog, String codClient) {
		String distribUL = InfoStrings.getDistribUnitLog(unitLog);

		if (InfoStrings.getClientGenericGed(distribUL, "PF").equals(codClient) || InfoStrings.getClientGenericGed(distribUL, "PJ").equals(codClient)
				|| InfoStrings.getClientGenericGedWood(distribUL, "PF").equals(codClient)
				|| InfoStrings.getClientGenericGedWood(distribUL, "PJ").equals(codClient)
				|| InfoStrings.getClientGenericGedWood_faraFact(distribUL, "PF").equals(codClient)
				|| InfoStrings.getClientGenericGed_CONSGED_faraFactura(distribUL, "PF").equals(codClient)
				|| InfoStrings.getClientCVO_cuFact_faraCnp(distribUL, "").equals(codClient)
				|| InfoStrings.getClientGed_FaraFactura(distribUL).equals(codClient))

			return true;
		else
			return false;
	}

	public static String[] tipPlataGed(boolean isRestrictie) {
		if (isRestrictie)
			return new String[] { "E - Plata in numerar in filiala", "BRD - Card BRD", "ING - Card ING", "UNI - Card Unicredit", "CBTR - Card Transilvania",
					"CGRB - Card Garanti Bonus", "CRFZ - Card Raiffeisen", "CCTL - Card Cetelem", "CAVJ - Card Avantaj", "INS - Card online",
					"E1 - Numerar sofer" };
		else
			return new String[] { "E1 - Numerar sofer", "B - Bilet la ordin", "C - Cec", "E - Plata in numerar in filiala", "O - Ordin de plata",
					"BRD - Card BRD", "ING - Card ING", "UNI - Card Unicredit", "CBTR - Card Transilvania", "CGRB - Card Garanti Bonus",
					"CRFZ - Card Raiffeisen", "CCTL - Card Cetelem", "CAVJ - Card Avantaj", "INS - Card online" };

	}

	public static void setDefaultPlataMethod(Spinner spinnerPlata) {

		for (int ii = 0; ii < spinnerPlata.getAdapter().getCount(); ii++) {
			if (spinnerPlata.getAdapter().getItem(ii).toString().toUpperCase().contains("E1")) {
				spinnerPlata.setSelection(ii);
				break;
			}
		}

	}

	public static boolean isLivrareCustodie() {
		return DateLivrare.getInstance().getTipComandaDistrib() == TipCmdDistrib.LIVRARE_CUSTODIE;
	}

	public static boolean isComandaInstPublica() {
		return DateLivrare.getInstance().getTipPersClient() != null && DateLivrare.getInstance().getTipPersClient().toUpperCase().equals("IP");
	}

	public static boolean isComandaExpirata(List<ArticolComanda> listArticole) {
		boolean isExpirata = false;

		Date dateCrt = new Date();

		try {

			for (ArticolComanda articol : listArticole) {
				if (articol.getDataExpPret().startsWith("00"))
					continue;

				Date dateArt = new SimpleDateFormat("yyyy-MM-dd").parse(articol.getDataExpPret());

				if (dateArt.compareTo(dateCrt) < 0) {
					isExpirata = true;
					break;
				}

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return isExpirata;
	}

	public static String getFilialaGed(String filiala) {
		return filiala.substring(0, 2) + "2" + filiala.substring(3, 4);
	}

}
