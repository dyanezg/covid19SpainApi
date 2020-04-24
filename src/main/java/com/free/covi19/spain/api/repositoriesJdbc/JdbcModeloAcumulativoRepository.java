package com.free.covi19.spain.api.repositoriesJdbc;

import java.util.List;

import com.free.covi19.spain.api.dto.ModeloAcumulativoDto;


public interface JdbcModeloAcumulativoRepository {
	
    public void delelteAll();
	
	public int[] batchInsert(List<ModeloAcumulativoDto> modeloAcumulativoDtoList);

}
