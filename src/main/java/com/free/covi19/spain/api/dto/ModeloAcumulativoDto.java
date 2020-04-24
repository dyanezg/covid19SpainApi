package com.free.covi19.spain.api.dto;

import java.io.Serializable;

public class ModeloAcumulativoDto implements Serializable {

	private static final long serialVersionUID = -1116366925994987098L;

	public Integer id;

	private String ccaa;

	private String fecha;

	private Integer casos;

	private Integer hospitalizados;

	private Integer uci;

	private Integer fallecidos;

	private Integer recuperados;

	public ModeloAcumulativoDto(String ccaa, String fecha, Integer casos, Integer hospitalizados, Integer uci,
			Integer fallecidos, Integer recuperados) {
		this.ccaa = ccaa;
		this.fecha = fecha;
		this.casos = casos;
		this.hospitalizados = hospitalizados;
		this.uci = uci;
		this.fallecidos = fallecidos;
		this.recuperados = recuperados;
	}

	public ModeloAcumulativoDto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCcaa() {
		return ccaa;
	}

	public void setCcaa(String ccaa) {
		this.ccaa = ccaa;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getCasos() {
		return casos;
	}

	public void setCasos(Integer casos) {
		this.casos = casos;
	}

	public Integer getHospitalizados() {
		return hospitalizados;
	}

	public void setHospitalizados(Integer hospitalizados) {
		this.hospitalizados = hospitalizados;
	}

	public Integer getUci() {
		return uci;
	}

	public void setUci(Integer uci) {
		this.uci = uci;
	}

	public Integer getFallecidos() {
		return fallecidos;
	}

	public void setFallecidos(Integer fallecidos) {
		this.fallecidos = fallecidos;
	}

	public Integer getRecuperados() {
		return recuperados;
	}

	public void setRecuperados(Integer recuperados) {
		this.recuperados = recuperados;
	}

	@Override
	public String toString() {
		return "ModeloAcumulativoDto [id=" + id + ", ccaa=" + ccaa + ", fecha=" + fecha + ", casos=" + casos
				+ ", hospitalizados=" + hospitalizados + ", uci=" + uci + ", fallecidos=" + fallecidos
				+ ", recuperados=" + recuperados + "]";
	}
	
	
	

}
