package com.free.covi19.spain.api.dto;

import java.io.Serializable;

public class TestRealizadoDto implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4973138366012900966L;

	private Integer id;
	
	private String fecha;
				
	private String ccaa;	
			
	private Integer pcr;		
	
	private Integer testAnticuerpos;
	
	private Integer totalPruebas;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCcaa() {
		return ccaa;
	}

	public void setCcaa(String ccaa) {
		this.ccaa = ccaa;
	}

	public Integer getPcr() {
		return pcr;
	}

	public void setPcr(Integer pcr) {
		this.pcr = pcr;
	}

	public Integer getTestAnticuerpos() {
		return testAnticuerpos;
	}

	public void setTestAnticuerpos(Integer testAnticuerpos) {
		this.testAnticuerpos = testAnticuerpos;
	}

	public Integer getTotalPruebas() {
		return totalPruebas;
	}

	public void setTotalPruebas(Integer totalPruebas) {
		this.totalPruebas = totalPruebas;
	}

	@Override
	public String toString() {
		return "TestRealizadoDto [id=" + id + ", fecha=" + fecha + ", ccaa=" + ccaa + ", pcr=" + pcr
				+ ", testAnticuerpos=" + testAnticuerpos + ", totalPruebas=" + totalPruebas + "]";
	}

					
	

}
