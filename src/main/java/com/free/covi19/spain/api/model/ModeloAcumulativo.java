package com.free.covi19.spain.api.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ModeloAcumulativo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1882728410547803327L;

	@Id
	private Integer id;
	    
	@ManyToOne	
	@JoinColumn(name="ccaa")
	private ComunidadAutonoma comunidadAutonoma;	
	
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
	

	public ComunidadAutonoma getComunidadAutonoma() {
		return comunidadAutonoma;
	}

	public void setComunidadAutonoma(ComunidadAutonoma comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
