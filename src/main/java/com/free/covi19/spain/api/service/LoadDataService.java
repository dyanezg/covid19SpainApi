package com.free.covi19.spain.api.service;

public interface LoadDataService {
	
	public String loadModeloAcumulativo(String url) throws Exception;
	
	public String loadTestCovid(String url) throws Exception;
	
	public String loadAfectadosEdadSexo(String url) throws Exception;
	
	public String loadCcaaMascarillas(String url) throws Exception;

	public String loadFallecidos(String url) throws Exception;
	
}
