package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import listeners.AsyncTaskListener;
import listeners.OperatiiMathausListener;
import lite.sfa.test.AsyncTaskWSCall;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.content.Context;
import android.widget.Toast;
import beans.ArticolMathaus;
import beans.CategorieMathaus;
import enums.EnumOperatiiMathaus;

public class OperatiiMathaus implements AsyncTaskListener {

	Context context;
	OperatiiMathausListener listener;
	EnumOperatiiMathaus numeComanda;

	public OperatiiMathaus(Context context) {
		this.context = context;
	}

	public void getCategorii(HashMap<String, String> params) {
		numeComanda = EnumOperatiiMathaus.GET_CATEGORII;
		AsyncTaskWSCall call = new AsyncTaskWSCall(numeComanda.getNumeComanda(), params, (AsyncTaskListener) this, context);
		call.getCallResultsFromFragment();
	}

	public void getArticole(HashMap<String, String> params) {
		numeComanda = EnumOperatiiMathaus.GET_ARTICOLE;
		AsyncTaskWSCall call = new AsyncTaskWSCall(numeComanda.getNumeComanda(), params, (AsyncTaskListener) this, context);
		call.getCallResultsFromFragment();
	}

	public List<CategorieMathaus> deserializeCategorii(String categorii) {
		CategorieMathaus categorie = null;
		ArrayList<CategorieMathaus> objectsList = new ArrayList<CategorieMathaus>();

		JSONArray jsonObject = null;

		try {

			Object json = new JSONTokener(categorii).nextValue();

			if (json instanceof JSONArray) {
				jsonObject = new JSONArray(categorii);

				for (int i = 0; i < jsonObject.length(); i++) {
					JSONObject catObject = jsonObject.getJSONObject(i);

					categorie = new CategorieMathaus();
					categorie.setCod(catObject.getString("cod"));
					categorie.setNume(catObject.getString("nume"));
					categorie.setCodHybris(catObject.getString("codHybris"));
					categorie.setCodParinte(catObject.getString("codParinte"));

					objectsList.add(categorie);

				}
			}

		} catch (JSONException e) {
			Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
		}

		return objectsList;
	}

	public List<ArticolMathaus> deserializeArticole(String articole) {
		ArticolMathaus articol = null;
		ArrayList<ArticolMathaus> objectsList = new ArrayList<ArticolMathaus>();

		JSONArray jsonObject = null;

		try {

			Object json = new JSONTokener(articole).nextValue();

			if (json instanceof JSONArray) {
				jsonObject = new JSONArray(articole);

				for (int i = 0; i < jsonObject.length(); i++) {
					JSONObject catObject = jsonObject.getJSONObject(i);

					articol = new ArticolMathaus();
					articol.setCod(catObject.getString("cod"));
					articol.setNume(catObject.getString("nume"));
					articol.setDescriere(catObject.getString("descriere"));
					articol.setAdresaImg(catObject.getString("adresaImg"));
					articol.setAdresaImgMare(catObject.getString("adresaImgMare"));
					articol.setSintetic(catObject.getString("sintetic"));
					articol.setNivel1(catObject.getString("nivel1"));
					articol.setUmVanz(catObject.getString("umVanz"));
					articol.setUmVanz10(catObject.getString("umVanz10"));
					articol.setTipAB(catObject.getString("tipAB"));
					articol.setDepart(catObject.getString("depart"));
					articol.setDepartAprob(catObject.getString("departAprob"));
					articol.setUmPalet(catObject.getString("umPalet").equals("1") ? true : false);
					articol.setStoc(catObject.getString("stoc"));
					articol.setCategorie(catObject.getString("categorie"));
					articol.setLungime(Double.valueOf(catObject.getString("lungime")));
					articol.setCatMathaus(catObject.getString("catMathaus"));
					articol.setPretUnitar(catObject.getString("pretUnitar"));

					objectsList.add(articol);

				}
			}

		} catch (JSONException e) {
			Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
		}

		return objectsList;
	}

	@Override
	public void onTaskComplete(String methodName, Object result) {
		if (listener != null) {
			listener.operationComplete(numeComanda, result);
		}
	}

	public void setOperatiiMathausListener(OperatiiMathausListener listener) {
		this.listener = listener;
	}

}
