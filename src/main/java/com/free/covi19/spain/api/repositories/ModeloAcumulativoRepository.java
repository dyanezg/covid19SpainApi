package com.free.covi19.spain.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.free.covi19.spain.api.model.ModeloAcumulativo;


@RepositoryRestResource(collectionResourceRel = "modeloAcumulativo", path = "modeloAcumulativo")
public interface ModeloAcumulativoRepository  extends CrudRepository<ModeloAcumulativo, Integer> {

	
}
