package com.free.covi19.spain.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.free.covi19.spain.api.model.ModeloAcumulativo;
import com.free.covi19.spain.api.model.TestRealizados;


@RepositoryRestResource(collectionResourceRel = "testRealizados", path = "testRealizados")
public interface TestRealizadosRepository  extends CrudRepository<TestRealizados, Integer> {

	
}
