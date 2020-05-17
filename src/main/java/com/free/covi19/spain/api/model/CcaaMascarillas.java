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
public class CcaaMascarillas implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -4930777412296968746L;

	@Id
	private Integer id;
	
	private String fecha;
	
	@ManyToOne	
	@JoinColumn(name="ccaa")
	private ComunidadAutonoma comunidadAutonoma;	
					
	private Integer acumulado;
	
	private String fechaImportacion;
	
	

	public String getFechaImportacion() {
		return fechaImportacion;
	}

	public void setFechaImportacion(String fechaImportacion) {
		this.fechaImportacion = fechaImportacion;
	}

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

	public ComunidadAutonoma getComunidadAutonoma() {
		return comunidadAutonoma;
	}

	public void setComunidadAutonoma(ComunidadAutonoma comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}

	public Integer getAcumulado() {
		return acumulado;
	}

	public void setAcumulado(Integer acumulado) {
		this.acumulado = acumulado;
	}		
	
	
	
	
	
}
