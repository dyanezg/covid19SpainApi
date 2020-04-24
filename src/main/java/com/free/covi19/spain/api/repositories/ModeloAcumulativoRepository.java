package com.free.covi19.spain.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.free.covi19.spain.api.model.ModeloAcumulativo;


@RepositoryRestResource(collectionResourceRel = "modeloAcumulativo", path = "modeloAcumulativo")
public interface ModeloAcumulativoRepository  extends CrudRepository<ModeloAcumulativo, Integer> {

	
	@Query("select m.id, m.comunidadAutonoma, m.fecha ,m.casos, m.hospitalizados, m.fechaImportacion from ModeloAcumulativo m")
	@RestResource(path = "hospitalizados", rel = "hospitalizados")
	List<ModeloAcumulativoRepository> getHospitalizados();
	
}
