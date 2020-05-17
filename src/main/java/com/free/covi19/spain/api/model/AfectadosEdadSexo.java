package com.free.covi19.spain.api.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AfectadosEdadSexo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7081309762074531711L;

	@Id
	private Integer id;

	private String fecha;

	@ManyToOne
	@JoinColumn(name = "rango_edad")
	private RangoDeEdad rangoDeEdad;

	@ManyToOne
	@JoinColumn(name = "sexo")
	private Sexo sexo;

	private Integer casosConfirmados;

	private Integer hospitalizados;

	private Integer ingresosUci;

	private String fallecidos;

	private String fechaImportacion;

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

	public RangoDeEdad getRangoDeEdad() {
		return rangoDeEdad;
	}

	public void setRangoDeEdad(RangoDeEdad rangoDeEdad) {
		this.rangoDeEdad = rangoDeEdad;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
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

	public String getFallecidos() {
		return fallecidos;
	}

	public void setFallecidos(String fallecidos) {
		this.fallecidos = fallecidos;
	}

	public String getFechaImportacion() {
		return fechaImportacion;
	}

	public void setFechaImportacion(String fechaImportacion) {
		this.fechaImportacion = fechaImportacion;
	}

}
