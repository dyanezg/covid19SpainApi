package com.free.covi19.spain.api.model;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RangoDeEdad {

	private Integer cod;
	
	@Id
	@Column(name="cod_name")
	private String rango;
	
	@OneToMany(mappedBy="rangoDeEdad")
	private List<AfectadosEdadSexo> afectadosEdadSexo;

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public List<AfectadosEdadSexo> getAfectadosEdadSexo() {
		return afectadosEdadSexo;
	}

	public void setAfectadosEdadSexo(List<AfectadosEdadSexo> afectadosEdadSexo) {
		this.afectadosEdadSexo = afectadosEdadSexo;
	}

	
	

}
