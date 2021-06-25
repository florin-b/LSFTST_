package enums;

public enum EnumOperatiiMathaus {

	GET_CATEGORII("getCategoriiMathaus"), GET_ARTICOLE("getArticoleCategorieMathaus"), CAUTA_ARTICOLE("cautaArticoleMathaus");
	
	private String numeComanda;

	EnumOperatiiMathaus(String numeComanda) {
		this.numeComanda = numeComanda;
	}

	public String getNumeComanda() {
		return numeComanda;
	}

}
