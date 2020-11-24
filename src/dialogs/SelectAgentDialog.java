package dialogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import listeners.OperatiiAgentListener;
import listeners.SelectAgentDialogListener;
import lite.sfa.test.R;
import model.Agent;
import model.OperatiiAgent;
import model.UserInfo;
import utils.UtilsUser;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class SelectAgentDialog extends Dialog implements OperatiiAgentListener {

	private ImageButton btnCancel;
	private Context context;
	private OperatiiAgent opAgent;
	private ListView listViewAgenti;
	private SelectAgentDialogListener listener;

	public SelectAgentDialog(Context context) {
		super(context);
		this.context = context;

		setContentView(R.layout.select_agent_dialog);
		setTitle("Selectie agent");
		setCancelable(true);

		setUpLayout();

		opAgent = OperatiiAgent.getInstance();
		opAgent.setOperatiiAgentListener(this);
		opAgent.getListaAgenti(UserInfo.getInstance().getUnitLog(), getUserDepart(), context, false, getTipAgent());

	}

	public void showDialog() {
		this.show();
	}

	private String getUserDepart() {
		if (UserInfo.getInstance().getTipUserSap().equals("SM") || UtilsUser.isSMNou() || UserInfo.getInstance().getTipUserSap().equals("SDCVA")
				|| UserInfo.getInstance().getTipUserSap().equals("CVO") || UtilsUser.isSDIP())
			return "11";
		else if (UserInfo.getInstance().getTipAcces().equals("32"))
			return "10";
		else
			return UserInfo.getInstance().getCodDepart();
	}

	private String getTipAgent() {
		String tipAgent = null;

		if (UtilsUser.isSMNou())
			tipAgent = UtilsUser.getTipSMNou();
		else if (UserInfo.getInstance().getTipUserSap().equals("SDCVA"))
			tipAgent = UserInfo.getInstance().getTipUserSap();
		else if (UserInfo.getInstance().getTipUserSap().equals("CVO"))
			tipAgent = "CVO";
		else if (UtilsUser.isSDIP())
			tipAgent = "SDIP";

		return tipAgent;
	}

	private void setUpLayout() {

		listViewAgenti = (ListView) findViewById(R.id.listViewAgenti);
		setListViewAgentiListener();

		btnCancel = (ImageButton) findViewById(R.id.btnCancel);
		setCancelButtonListener();

	}

	private void setListViewAgentiListener() {

		listViewAgenti.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Agent agent = (Agent) parent.getAdapter().getItem(position);

				if (listener != null)
					listener.agentSelected(agent);

				dismiss();

			}
		});

	}

	private void setCancelButtonListener() {
		btnCancel.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				dismiss();
			}
		});
	}

	@Override
	public void opAgentComplete(ArrayList<HashMap<String, String>> listAgenti) {
		populateListViewAgenti(opAgent.getListObjAgenti());

	}

	public void setAgentDialogListener(SelectAgentDialogListener listener) {
		this.listener = listener;
	}

	private void populateListViewAgenti(List<Agent> listObjAgenti) {
		listObjAgenti.remove(0);
		ArrayAdapter<Agent> adapter = new ArrayAdapter<Agent>(context, android.R.layout.simple_list_item_1, listObjAgenti);
		listViewAgenti.setAdapter(adapter);

	}
}
