package adapters;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import listeners.RezumatListener;
import lite.sfa.test.R;
import model.ArticolComanda;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import beans.RezumatComanda;

public class AdapterRezumatComanda extends BaseAdapter {

	private List<RezumatComanda> listComenzi;
	private Context context;
	private double valoareArt;
	private double valoareTransport;
	private double valoareTotal;
	private NumberFormat nf = new DecimalFormat("#,##0.00");
	private RezumatListener listener;

	public AdapterRezumatComanda(Context context, List<RezumatComanda> listComenzi) {
		this.context = context;
		this.listComenzi = listComenzi;

	}

	static class ViewHolder {
		TextView textNumeArticole, textCantArticole, textFurnizor, textTotalArt, textTransport, textTotal, textNrComanda;
		ImageButton stergeComandaBtn;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;

		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.row_rezumat_comanda, parent, false);

			viewHolder = new ViewHolder();
			viewHolder.textNumeArticole = (TextView) convertView.findViewById(R.id.textNumeArticole);
			viewHolder.textCantArticole = (TextView) convertView.findViewById(R.id.textCantArticole);
			viewHolder.textFurnizor = (TextView) convertView.findViewById(R.id.textFurnizor);
			viewHolder.textTotalArt = (TextView) convertView.findViewById(R.id.textTotalArt);
			viewHolder.textTransport = (TextView) convertView.findViewById(R.id.textTransport);
			viewHolder.textTotal = (TextView) convertView.findViewById(R.id.textTotal);
			viewHolder.textNrComanda = (TextView) convertView.findViewById(R.id.textNrComanda);
			viewHolder.stergeComandaBtn = (ImageButton) convertView.findViewById(R.id.stergeComandaBtn);
			convertView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		RezumatComanda rezumat = getItem(position);

		viewHolder.textNrComanda.setText("Comanda nr. " + (position + 1));
		viewHolder.textNumeArticole.setText(getNumeArticole(rezumat));
		viewHolder.textCantArticole.setText(getCantArticole(rezumat));
		viewHolder.textFurnizor.setText("Livrare din: " + rezumat.getFilialaLivrare());
		viewHolder.textTransport.setText("Transport: " + nf.format(valoareTransport));
		viewHolder.textTotalArt.setText("Val. articole: " + nf.format(valoareArt));
		viewHolder.textTotal.setText("Total :" + nf.format(valoareTotal));

		setListenerEliminaBtn(viewHolder.stergeComandaBtn, position);

		return convertView;

	}

	private void setListenerEliminaBtn(ImageButton eliminaBtn, final int position) {

		eliminaBtn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				eliminaComanda(position);

			}
		});

	}

	private void eliminaComanda(int position) {

		Iterator<RezumatComanda> listIterator = listComenzi.iterator();
		List<String> listArticole = null;

		int crntPos = 0;
		while (listIterator.hasNext()) {
			RezumatComanda rezumat = listIterator.next();
			if (crntPos == position) {
				listArticole = getArticoleComanda(rezumat);
				listIterator.remove();
				break;
			}

			crntPos++;
		}

		notifyDataSetChanged();

		if (listener != null)
			listener.comandaEliminata(listArticole);

	}

	private List<String> getArticoleComanda(RezumatComanda rezumatComanda) {

		List<String> listArticole = new ArrayList<String>();

		for (ArticolComanda art : rezumatComanda.getListArticole()) {
			listArticole.add(art.getCodArticol());
		}

		return listArticole;

	}

	private String getNumeArticole(RezumatComanda rezumat) {

		StringBuilder str = new StringBuilder();

		valoareArt = 0;
		valoareTransport = 0;
		valoareTotal = 0;

		for (ArticolComanda art : rezumat.getListArticole()) {
			str.append(art.getNumeArticol());
			str.append("\n");

			valoareArt += art.getPret();
			valoareTransport += art.getValTransport();
		}

		valoareTotal = valoareArt + valoareTransport;

		return str.toString();

	}

	private String getCantArticole(RezumatComanda rezumat) {

		StringBuilder str = new StringBuilder();

		for (ArticolComanda art : rezumat.getListArticole()) {
			str.append(art.getCantitate());
			str.append(" ");
			str.append(art.getUm());
			str.append("\n");
		}

		return str.toString();

	}

	public void setRezumatListener(RezumatListener listener) {
		this.listener = listener;
	}

	@Override
	public int getCount() {
		return listComenzi.size();
	}

	@Override
	public RezumatComanda getItem(int position) {
		return listComenzi.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

}
