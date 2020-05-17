package com.free.covi19.spain.api.util;

public enum SexoEnum {

	HOMBRES("hombres", "hombres"), 
	MUJERES("mujeres", "mujeres"), 
	AMBOS("ambos", "ambos");

	private String cod;
	private String codBddd;		
	
	private SexoEnum(String cod, String codBddd) {
		this.cod = cod;
		this.codBddd = codBddd;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getCodBddd() {
		return codBddd;
	}
	public void setCodBddd(String codBddd) {
		this.codBddd = codBddd;
	}

	
	public static SexoEnum fromCod(String cod) {
		for (SexoEnum tipo : SexoEnum.values()) {
			if (tipo.cod.equals(cod)) {
				return tipo;
			}
		}
		return null;
	}

}
