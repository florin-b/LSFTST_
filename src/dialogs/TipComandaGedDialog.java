package dialogs;

import java.util.HashMap;
import java.util.List;

import listeners.ComenziDAOListener;
import listeners.TipCmdGedListener;
import lite.sfa.test.R;
import model.ComenziDAO;
import model.UserInfo;
import adapters.ComandaAMOBAdapter;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import beans.ComandaAmobAfis;
import enums.EnumComenziDAO;
import enums.TipCmdGed;

public class TipComandaGedDialog extends Dialog implements ComenziDAOListener {

	private TipCmdGedListener listener;
	private Context context;
	private TipCmdGed tipComanda = TipCmdGed.COMANDA_NOUA;
	private ComenziDAO comandaDAO;
	private Spinner spinnerComenziAmob;
	private String idComanda;

	public TipComandaGedDialog(Context context) {
		super(context);
		this.context = context;

	}

	public void showDialog() {
		setUpLayout();

		comandaDAO = ComenziDAO.getInstance(context);
		comandaDAO.setComenziDAOListener(TipComandaGedDialog.this);

		this.show();

	}

	private void setUpLayout() {
		setContentView(R.layout.tipcomandageddialog);
		setTitle("Selectati tipul de comanda");
		setCancelable(true);

		final RadioButton radioNoua = (RadioButton) findViewById(R.id.radioNoua);
		final RadioButton radioAmob = (RadioButton) findViewById(R.id.radioAmob);

		spinnerComenziAmob = (Spinner) findViewById(R.id.spinComenziAmob);
		setSpinnerAmobListener();

		Button btnOkTipCmd = (Button) findViewById(R.id.btnOkTipCmd);
		btnOkTipCmd.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				if (radioNoua.isChecked())
					tipComanda = TipCmdGed.COMANDA_NOUA;
				else if (radioAmob.isChecked()) {
					tipComanda = TipCmdGed.COMANDA_AMOB;
					if (idComanda.equals("-1"))
						return;

				}

				if (listener != null)
					listener.tipComandaSelected(tipComanda, idComanda);

				dismiss();

			}
		});

		radioNoua.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				spinnerComenziAmob.setVisibility(View.INVISIBLE);

			}

		});

		radioAmob.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				spinnerComenziAmob.setVisibility(View.VISIBLE);
				getComenziAMOB();

			}

		});

	}

	private void setSpinnerAmobListener() {
		spinnerComenziAmob.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				ComandaAmobAfis comanda = (ComandaAmobAfis) parent.getAdapter().getItem(position);
				idComanda = comanda.getId();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
	}

	private void getComenziAMOB() {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("codAgent", UserInfo.getInstance().getCod());
		comandaDAO.getComenziAmob(params);

	}

	public void setTipCmdGedListener(TipCmdGedListener listener) {
		this.listener = listener;
	}

	private void populateListComenzi(List<ComandaAmobAfis> listComenzi) {

		ComandaAmobAfis comanda = new ComandaAmobAfis();
		comanda.setNumeClient("Selectati o comanda");
		comanda.setIdAmob("-1");
		comanda.setId("-1");
		comanda.setDataCreare(" ");
		comanda.setValoare(" ");
		comanda.setMoneda(" ");

		listComenzi.add(0, comanda);

		ComandaAMOBAdapter comenziAdapter = new ComandaAMOBAdapter(context, listComenzi);
		spinnerComenziAmob.setAdapter(comenziAdapter);
	}

	@Override
	public void operationComenziComplete(EnumComenziDAO methodName, Object result) {
		populateListComenzi(comandaDAO.deserializeComenziAmobAfis((String) result));

	}

}
