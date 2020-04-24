package com.free.covi19.spain.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.free.covi19.spain.api.model.ComunidadAutonoma;


@RepositoryRestResource(collectionResourceRel = "comunidadAutonoma", path = "comunidadAutonoma")
public interface ComunidadAutonomaRepository extends CrudRepository<ComunidadAutonoma, String> {

}
