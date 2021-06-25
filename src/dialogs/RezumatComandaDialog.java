package dialogs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import listeners.ComandaMathausListener;
import listeners.RezumatListener;
import lite.sfa.test.R;
import model.ArticolComanda;
import model.ListaArticoleComanda;
import model.ListaArticoleComandaGed;
import adapters.AdapterRezumatComanda;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import beans.RezumatComanda;

public class RezumatComandaDialog extends Dialog implements RezumatListener {

	private Context context;
	private List<ArticolComanda> listArticole;
	private ListView listViewComenzi;
	private String canalDistrib;
	private Button btnCancelComanda;
	private Button btnOkComanda;
	private ComandaMathausListener listener;

	public RezumatComandaDialog(Context context, List<ArticolComanda> listArticole, String canal) {
		super(context);
		this.context = context;
		this.listArticole = listArticole;
		this.canalDistrib = canal;

		setContentView(R.layout.rezumat_comanda_dialog);
		setTitle("Rezumat comanda");
		setCancelable(true);

		setupLayout();

	}

	private void setupLayout() {

		listViewComenzi = (ListView) findViewById(R.id.listComenzi);

		AdapterRezumatComanda adapterRezumat = new AdapterRezumatComanda(context, getRezumatComanda());
		adapterRezumat.setRezumatListener(this);
		listViewComenzi.setAdapter(adapterRezumat);

		btnCancelComanda = (Button) findViewById(R.id.btnCancelComanda);
		setListenerBtnCancel();
		btnOkComanda = (Button) findViewById(R.id.btnOkComanda);
		setListenerComandaSalvata();

	}

	private void setListenerBtnCancel() {
		btnCancelComanda.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				dismiss();

			}
		});
	}

	private void setListenerComandaSalvata() {
		btnOkComanda.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (listener != null) {

					if (listViewComenzi.getAdapter().getCount() > 0)
						listener.comandaSalvata();

					dismiss();
				}

			}
		});
	}

	private List<RezumatComanda> getRezumatComanda() {

		Set<String> filiale = getFilialeComanda();

		List<RezumatComanda> listComenzi = new ArrayList<RezumatComanda>();

		for (String filiala : filiale) {

			RezumatComanda rezumat = new RezumatComanda();
			rezumat.setFilialaLivrare(filiala);
			List<ArticolComanda> listArtComanda = new ArrayList<ArticolComanda>();

			for (ArticolComanda articol : listArticole) {
				if (articol.getFilialaSite().equals(filiala)) {
					listArtComanda.add(articol);
				}
			}

			rezumat.setListArticole(listArtComanda);
			listComenzi.add(rezumat);
		}

		return listComenzi;
	}

	private Set<String> getFilialeComanda() {

		Set<String> filiale = new HashSet<String>();
		for (final ArticolComanda articol : listArticole) {
			filiale.add(articol.getFilialaSite());
		}
		return filiale;

	}

	public void setRezumatListener(ComandaMathausListener listener) {
		this.listener = listener;
	}

	public void showDialog() {
		this.show();
	}

	@Override
	public void comandaEliminata(List<String> listArticoleEliminate) {

		List<ArticolComanda> listArticoleComanda;
		if (canalDistrib.equals("10"))
			listArticoleComanda = ListaArticoleComanda.getInstance().getListArticoleComanda();
		else
			listArticoleComanda = ListaArticoleComandaGed.getInstance().getListArticoleComanda();

		Iterator<ArticolComanda> listIterator = listArticoleComanda.iterator();

		while (listIterator.hasNext()) {
			ArticolComanda articol = listIterator.next();

			for (String articolEliminat : listArticoleEliminate) {

				if (articol.getCodArticol().equals(articolEliminat)) {
					listIterator.remove();
					break;
				}

			}

		}

		if (listener != null)
			listener.comandaEliminata();

	}

}
