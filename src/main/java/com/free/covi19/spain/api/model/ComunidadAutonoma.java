package com.free.covi19.spain.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ComunidadAutonoma implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4853857993266435626L;

	@Id
	private String ccaa;
	
    private String nombre;     
   
    @OneToMany(mappedBy="comunidadAutonoma")
    private List<ModeloAcumulativo> modeloAcumulativo;
    
    
    @OneToMany(mappedBy="comunidadAutonoma")
    private List<TestRealizados> testRealizados;
    
    
    @OneToMany(mappedBy="comunidadAutonoma")
    private List<CcaaMascarillas> ccaaMascarillas;
    
    
    @OneToMany(mappedBy="comunidadAutonoma")
    private List<Fallecidos> fallecidos;
    
         
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCcaa() {
		return ccaa;
	}

	public void setCcaa(String ccaa) {
		this.ccaa = ccaa;
	}

	public List<ModeloAcumulativo> getModeloAcumulativo() {
		return modeloAcumulativo;
	}

	public void setModeloAcumulativo(List<ModeloAcumulativo> modeloAcumulativo) {
		this.modeloAcumulativo = modeloAcumulativo;
	}


	public List<TestRealizados> getTestRealizados() {
		return testRealizados;
	}

	public void setTestRealizados(List<TestRealizados> testRealizados) {
		this.testRealizados = testRealizados;
	}


				
}
