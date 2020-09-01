package com.free.covi19.spain.api.dto;

public class AfectadosEdadSexoDto {
	
	private Integer id;

	private String fecha;

	private String rangoDeEdad;

	private String sexo;

	private Integer casosConfirmados;

	private Integer hospitalizados;

	private Integer ingresosUci;

	private Integer fallecidos;

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

	public String getRangoDeEdad() {
		return rangoDeEdad;
	}

	public void setRangoDeEdad(String rangoDeEdad) {
		this.rangoDeEdad = rangoDeEdad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getCasosConfirmados() {
		return casosConfirmados;
	}

	public void setCasosConfirmados(Integer casosConfirmados) {
		this.casosConfirmados = casosConfirmados;
	}

	public Integer getHospitalizados() {
		return hospitalizados;
	}

	public void setHospitalizados(Integer hospitalizados) {
		this.hospitalizados = hospitalizados;
	}

	public Integer getIngresosUci() {
		return ingresosUci;
	}

	public void setIngresosUci(Integer ingresosUci) {
		this.ingresosUci = ingresosUci;
	}	

	public Integer getFallecidos() {
		return fallecidos;
	}

	public void setFallecidos(Integer fallecidos) {
		this.fallecidos = fallecidos;
	}

	
}
