package com.free.covi19.spain.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.free.covi19.spain.api.model.Fallecidos;

@RepositoryRestResource(collectionResourceRel = "fallecidos", path = "fallecidos")
public interface FallecidosRepository extends CrudRepository<Fallecidos, Integer>{

}
