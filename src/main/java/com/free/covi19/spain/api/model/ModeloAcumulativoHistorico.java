package com.free.covi19.spain.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ModeloAcumulativoHistorico implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 2535618202587589601L;

	@Id
	private Integer idModeloHistorico;
	    
	private String ccaa;
	
	private String fecha;
	
	private Integer casos;
	
	private Integer hospitalizados;
	
	private Integer uci;
	
	private Integer fallecidos;
	
	private Integer recuperados;
	
	private String fechaImportacion;
	
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


	public String getFechaImportacion() {
		return fechaImportacion;
	}

	public void setFechaImportacion(String fechaImportacion) {
		this.fechaImportacion = fechaImportacion;
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

	public Integer getIdModeloHistorico() {
		return idModeloHistorico;
	}

	public void setIdModeloHistorico(Integer idModeloHistorico) {
		this.idModeloHistorico = idModeloHistorico;
	}

	

	
}
