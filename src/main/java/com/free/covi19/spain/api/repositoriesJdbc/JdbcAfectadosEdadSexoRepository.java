package com.free.covi19.spain.api.repositoriesJdbc;

import java.util.List;

import com.free.covi19.spain.api.dto.AfectadosEdadSexoDto;

public interface JdbcAfectadosEdadSexoRepository {

	
	public void delelteAll();

	public int[] batchInsert(List<AfectadosEdadSexoDto> afectadosRangoDeEdadDtoList);
}
