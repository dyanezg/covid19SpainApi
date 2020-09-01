package com.free.covi19.spain.api.repositoriesJdbc;

import java.util.List;

import com.free.covi19.spain.api.dto.FallecidosDto;

public interface JdbcFallecidosRepository {

	public void delelteAll();

	public int[] batchInsert(List<FallecidosDto> fallecidosDtoDtoList);
	
}
