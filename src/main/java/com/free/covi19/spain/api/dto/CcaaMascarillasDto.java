package com.free.covi19.spain.api.dto;

public class CcaaMascarillasDto {

	
	private Integer id;
	
	private String fecha;

	private String ccaa;

	private Integer acumulado;

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

	public Integer getAcumulado() {
		return acumulado;
	}

	public void setAcumulado(Integer acumulado) {
		this.acumulado = acumulado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CcaaMascarillasDto [id=" + id + ", fecha=" + fecha + ", ccaa=" + ccaa + ", acumulado=" + acumulado
				+ "]";
	}

	
	
}
