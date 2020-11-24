package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import listeners.OperatiiArticolListener;
import beans.ArticolCant;
import beans.ArticolDB;
import beans.BeanArticolSimulat;
import beans.BeanArticolStoc;
import beans.BeanGreutateArticol;
import beans.BeanParametruPretGed;
import beans.PretArticolGed;

public interface OperatiiArticol {
	public void getPret(HashMap<String, String> params);

	public void getPretGed(HashMap<String, String> params);

	public void getPretGedJson(HashMap<String, String> params);

	public void getStocDepozit(HashMap<String, String> params);

	public void getFactorConversie(HashMap<String, String> params);

	public void setListener(OperatiiArticolListener listener);

	public void getArticoleDistributie(HashMap<String, String> params);

	public ArrayList<ArticolDB> deserializeArticoleVanzare(String serializedListArticole);

	public PretArticolGed deserializePretGed(Object result);

	public void getArticoleComplementare(List<ArticolComanda> listaArticole);

	public void getArticoleFurnizor(HashMap<String, String> params);

	public void getSinteticeDistributie(HashMap<String, String> params);

	public void getNivel1Distributie(HashMap<String, String> params);

	public String serializeParamPretGed(BeanParametruPretGed param);

	public String serializeArticolePretTransport(List<ArticolComanda> listArticole);
	
	public BeanGreutateArticol deserializeGreutateArticol(Object result);
	
	public Object getDepartBV90(String codArticol);
	
	public void getStocArticole(HashMap<String, String> params);
	
	public String serializeListArtStoc(List<BeanArticolStoc> listArticole);
	
	public String serializeListArtSim(List<BeanArticolSimulat> listArticole);
	
	public List<BeanArticolStoc> derializeListArtStoc(String listArticole);
	
	public void getCodBare(HashMap<String, String> params);
	
	public void getArticoleStatistic(HashMap<String, String> params);
	
	public void getStocCustodie(HashMap<String, String> params);
	
	public void getArticoleCustodie(HashMap<String, String> params);
	
	public void getStocMathaus(HashMap<String, String> params);
	
	public void getInfoPretMathaus(HashMap<String, String> params);
	
	public void getArticoleCant(HashMap<String, String> params);
	
	public ArrayList<ArticolCant> deserializeArticoleCant(String listArticole);

}
