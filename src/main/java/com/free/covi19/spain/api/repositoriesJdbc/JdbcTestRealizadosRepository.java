package com.free.covi19.spain.api.repositoriesJdbc;

import java.util.List;

import com.free.covi19.spain.api.dto.TestRealizadoDto;

public interface JdbcTestRealizadosRepository {

	public void delelteAll();

	public int[] batchInsert(List<TestRealizadoDto> testRealizadoDtoList);

}
