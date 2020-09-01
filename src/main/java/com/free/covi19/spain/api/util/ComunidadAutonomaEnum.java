package com.free.covi19.spain.api.util;

import java.util.Arrays;
import java.util.Optional;


public enum ComunidadAutonomaEnum {
	
	// Andalucía	Aragón	Asturias	Baleares	Canarias	Cantabria	Castilla La Mancha	Castilla y León	Cataluña	Ceuta	C. Valenciana	Extremadura	Galicia	
	// Madrid	Melilla	Murcia	Navarra	País Vasco	La Rioja	España

	
	ANDALUCIA("01", "AN","01"),	
	ARAGON("02", "AR","02"),		
	ASTURIAS("03","AS","03"),	
	BALEARES("04","IB","04"),	
	CANARIAS("05","CN","05"),	
	CANTABRIA("06","CB","06"),	
	CASTILLALAMANCHA("08","CM","07"),	
	CASTILLALEÓN("07","CL","08"),		
	CATALUNA("09","CT","09"),
	CEUTA("18","CE","10"),	
	CVALENCIANA("10","VC","11"),	
	EXTREMADURA("11","EX","12"),	
	GALICIA("12","GA","13"),	
	MADRID("13","MD","14"),	
	MELILLA("19","ML","15"),	
	MURCIA("14","MC","16"),	
	NAVARRA("15","NC","17"),	
	PAÍSVASCO("16","PV","18"),
	LARIOJA("17","RI","19"),
	ESPAÑA("00","ES","20");

	private String codIne;
	private String ccaa;
	private String codCell;

	private ComunidadAutonomaEnum(String codIne, String ccaa, String codCell) {
		this.codIne = codIne;
		this.ccaa = ccaa;
		this.codCell = codCell;
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

	
	
	public String getCodCell() {
		return codCell;
	}

	public void setCodCell(String codCell) {
		this.codCell = codCell;
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

	
	public static ComunidadAutonomaEnum fromCodCell(String codCell) {
		for (ComunidadAutonomaEnum tipo : ComunidadAutonomaEnum.values()) {
			if (tipo.ccaa.equals(codCell)) {
				return tipo;
			}
		}
		return null;
	}
	
	public static Optional<ComunidadAutonomaEnum> from(String codIni) {
		return Arrays.stream(values()).filter(ca -> ca.getCodIne().equals(codIni)).findAny();
	}

}
