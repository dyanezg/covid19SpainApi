package com.free.covi19.spain.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.free.covi19.spain.api.model.AfectadosEdadSexo;


@RepositoryRestResource(collectionResourceRel = "afectadosEdadSexo", path = "afectadosEdadSexo")
public interface AfectadosEdadSexoRepository extends CrudRepository<AfectadosEdadSexo, Integer>{

}
