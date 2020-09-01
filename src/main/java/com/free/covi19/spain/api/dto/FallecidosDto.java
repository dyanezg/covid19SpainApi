package com.free.covi19.spain.api.dto;

public class FallecidosDto {

	private Integer id;

	private String fecha;

	private String ccaa;

	private Integer num;

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

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "FallecidosDto [id=" + id + ", fecha=" + fecha + ", ccaa=" + ccaa + ", num=" + num + "]";
	}

	
	
	
}
