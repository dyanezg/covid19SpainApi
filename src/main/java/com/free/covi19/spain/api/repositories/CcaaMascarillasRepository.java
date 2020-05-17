package com.free.covi19.spain.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.free.covi19.spain.api.model.CcaaMascarillas;

@RepositoryRestResource(collectionResourceRel = "ccaaMascarillas", path = "ccaaMascarillas")
public interface CcaaMascarillasRepository extends CrudRepository<CcaaMascarillas, Integer> {

}
