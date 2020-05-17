package com.free.covi19.spain.api.repositoriesJdbc;

import java.util.List;

import com.free.covi19.spain.api.dto.CcaaMascarillasDto;

public interface JdbcCcaaMascarillasRepository {

	public void delelteAll();

	public int[] batchInsert(List<CcaaMascarillasDto> ccaaMascarillasDtoList);
	
}
