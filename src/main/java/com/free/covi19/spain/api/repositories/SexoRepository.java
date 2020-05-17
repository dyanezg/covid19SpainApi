package com.free.covi19.spain.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.free.covi19.spain.api.model.Sexo;


@RepositoryRestResource(collectionResourceRel = "sexo", path = "sexo")
public interface SexoRepository extends CrudRepository<Sexo, String> {
	
}
