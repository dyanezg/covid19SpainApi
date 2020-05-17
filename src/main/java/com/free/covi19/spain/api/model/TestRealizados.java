package com.free.covi19.spain.api.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TestRealizados {
	
	@Id
	private Integer id;
	
	private String fecha;
	
	@ManyToOne	
	@JoinColumn(name="ccaa")
	private ComunidadAutonoma comunidadAutonoma;	
			
	private Integer pcr;		
	
	private Integer testAnticuerpos;
	
	private Integer totalPruebas;

	private String fechaImportacion;	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getFechaImportacion() {
		return fechaImportacion;
	}

	public void setFechaImportacion(String fechaImportacion) {
		this.fechaImportacion = fechaImportacion;
	}
	
	
				
	
	    
}
