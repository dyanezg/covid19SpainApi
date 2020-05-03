package com.free.covi19.spain.api.util;

import java.util.Arrays;
import java.util.Optional;


public enum ComunidadAutonomaEnum {
	
	
	ANDALUCIA("01", "AN"),	
	ARAGON("02", "AR"),		
	ASTURIAS("03","AS"),	
	BALEARES("04","IB"),	
	CANARIAS("05","CN"),	
	CANTABRIA("06","CB"),	
	CASTILLALAMANCHA("08","CM"),	
	CASTILLALEÓN("07","CL"),		
	CATALUNA("09","CT"),
	CEUTA("18","CE"),	
	CVALENCIANA("10","VC"),	
	EXTREMADURA("11","EX"),	
	GALICIA("12","GA"),	
	MADRID("13","MD" ),	
	MELILLA("19","ML"),	
	MURCIA("14","MC" ),	
	NAVARRA("15","NC"),	
	PAÍSVASCO("16","PV"),
	LARIOJA("17","RI"),
	ESPAÑA("00","ES");

	private String codIne;
	private String ccaa;

	private ComunidadAutonomaEnum(String codIne, String ccaa) {
		this.codIne = codIne;
		this.ccaa = ccaa;
	}

	public String getCodIne() {
		return codIne;
	}

	public void setCodIne(String codIne) {
		this.codIne = codIne;
	}

	public String getCcaa() {
		return ccaa;
	}

	public void setCcaa(String ccaa) {
		this.ccaa = ccaa;
	}

	public static ComunidadAutonomaEnum fromCodIni(String codIni) {
		for (ComunidadAutonomaEnum tipo : ComunidadAutonomaEnum.values()) {
			if (tipo.codIne.equals(codIni)) {
				return tipo;
			}
		}
		return null;
	}

	public static ComunidadAutonomaEnum fromCcaa(String ccaa) {
		for (ComunidadAutonomaEnum tipo : ComunidadAutonomaEnum.values()) {
			if (tipo.ccaa.equals(ccaa)) {
				return tipo;
			}
		}
		return null;
	}

	public static Optional<ComunidadAutonomaEnum> from(String codIni) {
		return Arrays.stream(values()).filter(ca -> ca.getCodIne().equals(codIni)).findAny();
	}

}
