package com.free.covi19.spain.api.util;

public enum RangoEdadEnum {

	UNO("0-9", "0-9"), 
	DOS("10-19", "10-19"), 
	TRES("20-29", "20-29"), 
	CUATRO("30-39", "30-39"), 
	CINCO("40-49","40-49"),
	SEIS("50-59", "50-59"), 
	SIETE("60-69", "60-69"),
	OCHO("70-79","70-79"), 
	NUEVE("80-89", "80-89"),
	DIEZ("80 y +", "80+"), 
	ONCE("90 y +", "90+"), 
	TOTAL("Total", "TOTAL");
	

	private String cod;
	private String codBbdd;

	private RangoEdadEnum(String cod, String codBbdd) {
		this.cod = cod;
		this.codBbdd = codBbdd;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getCodBbdd() {
		return codBbdd;
	}

	public void setCodBbdd(String codBbdd) {
		this.codBbdd = codBbdd;
	}

	public static RangoEdadEnum fromCod(String cod) {
		for (RangoEdadEnum tipo : RangoEdadEnum.values()) {
			if (tipo.cod.equals(cod)) {
				return tipo;
			}
		}
		return null;
	}

}
