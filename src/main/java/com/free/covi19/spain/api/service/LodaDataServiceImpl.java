package com.free.covi19.spain.api.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.free.covi19.spain.api.dto.AfectadosEdadSexoDto;
import com.free.covi19.spain.api.dto.CcaaMascarillasDto;
import com.free.covi19.spain.api.dto.ModeloAcumulativoDto;
import com.free.covi19.spain.api.dto.TestRealizadoDto;
import com.free.covi19.spain.api.email.EmailService;
import com.free.covi19.spain.api.exception.LoadDataServiceException;
import com.free.covi19.spain.api.repositoriesJdbc.JdbcCcaaMascarillasRepository;
import com.free.covi19.spain.api.repositoriesJdbc.JdbcModeloAcumulativoRepository;
import com.free.covi19.spain.api.repositoriesJdbc.JdbcAfectadosEdadSexoRepository;
import com.free.covi19.spain.api.repositoriesJdbc.JdbcTestRealizadosRepository;
import com.free.covi19.spain.api.util.MapperCsv;


@Service
public class LodaDataServiceImpl implements LoadDataService {

	Logger logger = Logger.getLogger("class LodaDataService");	
	
	@Autowired
	JdbcModeloAcumulativoRepository jdbcModeloAcumulativoRepository;

	@Autowired
	JdbcTestRealizadosRepository jdbcTestRealizadosRepository;
	
	@Autowired
	JdbcCcaaMascarillasRepository jdbcCcaaMascarillasRepository;
	
	@Autowired
	JdbcAfectadosEdadSexoRepository jdbcAfectadosEdadSexoRepository;
	
	@Autowired
	EmailService emailService;	
			
	@Autowired
	MapperCsv mapperCsv;
		
	@Transactional(rollbackOn = { Exception.class })
	public String loadModeloAcumulativo(String url) throws Exception {

		List<ModeloAcumulativoDto> modeloAcumulativoDtoList = new ArrayList<ModeloAcumulativoDto>();
		Integer totalInsert = 0;
		mapperCsv.setCounter(0);	

		try {
				
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "UTF-8"));

			modeloAcumulativoDtoList = br.lines().skip(1).map(mapperCsv.mapModeloAcumulativoDto)
					.collect(Collectors.toList());
			br.close();

			modeloAcumulativoDtoList.removeIf(o -> o.getCcaa() == null);

			if (!modeloAcumulativoDtoList.isEmpty()) {
				jdbcModeloAcumulativoRepository.delelteAll();
				jdbcModeloAcumulativoRepository.batchInsert(modeloAcumulativoDtoList);
			}

			totalInsert = modeloAcumulativoDtoList.size();

			if (totalInsert <= 0) {
				logger.severe("ERROR - loadModeloAcumulativo: 0 registros importados");
				throw new LoadDataServiceException("ERROR - loadModeloAcumulativo: 0 registros importados");
			}

		} catch (Exception e) {
			logger.severe("ERROR - loadModeloAcumulativo: " + e.getMessage());
			throw new LoadDataServiceException("ERROR - loadModeloAcumulativo: " + e.getMessage());
		}

		return "ok. Total Insertados: " + totalInsert.toString();

	}
		

	@Transactional(rollbackOn = { Exception.class })
	public String loadTestCovid(String url) throws Exception {

		List<TestRealizadoDto> testRealizadoDtoList = new ArrayList<TestRealizadoDto>();
		Integer totalInsert = 0;
		mapperCsv.setCounter(0);	
		
		try {
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "UTF-8"));

			testRealizadoDtoList = br.lines().skip(1).map(mapperCsv.mapTestRealizadoDto).collect(Collectors.toList());
			br.close();

			testRealizadoDtoList.removeIf(o -> o.getCcaa() == null);

			if (!testRealizadoDtoList.isEmpty()) {
				jdbcTestRealizadosRepository.delelteAll();
				jdbcTestRealizadosRepository.batchInsert(testRealizadoDtoList);
			}

			
			totalInsert = testRealizadoDtoList.size();
			
			if (totalInsert <= 0) {
				logger.severe("ERROR - loadTestCovid: 0 registros importados");
				throw new LoadDataServiceException("ERROR - loadTestCovid: 0 registros importados");
			}

		} catch (Exception e) {
			logger.severe("ERROR - loadTestCovid: " + e.getMessage());
			throw new LoadDataServiceException("ERROR - loadTestCovid: " + e.getMessage());
		}

		return "ok. Total Insertados: " + totalInsert.toString();

	}
	
	
	/**
	 * Nuevo
	 */
	@Transactional(rollbackOn = { Exception.class })
	public String loadCcaaMascarillas(String url) throws Exception {

		List<CcaaMascarillasDto> ccaaMascarillasDtoList = new ArrayList<CcaaMascarillasDto>();
		Integer totalInsert = 0;
		mapperCsv.setCounter(0);	
		
		try {
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "UTF-8"));

			ccaaMascarillasDtoList = br.lines().skip(1).map(mapperCsv.mapCcaaMascarillas).collect(Collectors.toList());
			br.close();

			ccaaMascarillasDtoList.removeIf(o -> o.getCcaa() == null);

			if (!ccaaMascarillasDtoList.isEmpty()) {
				jdbcCcaaMascarillasRepository.delelteAll();
				jdbcCcaaMascarillasRepository.batchInsert(ccaaMascarillasDtoList);
			}

			
			totalInsert = ccaaMascarillasDtoList.size();
			
			if (totalInsert <= 0) {
				logger.severe("ERROR - loadCcaaMascarillas: 0 registros importados");
				throw new LoadDataServiceException("ERROR - loadCcaaMascarillas: 0 registros importados");
			}

		} catch (Exception e) {
			logger.severe("ERROR - loadCcaaMascarillas: " + e.getMessage());
			throw new LoadDataServiceException("ERROR - loadCcaaMascarillas: " + e.getMessage());
		}

		return "ok. Total Insertados: " + totalInsert.toString();

	}
	
	

	@Transactional(rollbackOn = { Exception.class })
	public String loadAfectadosEdadSexo(String url) throws Exception {

		List<AfectadosEdadSexoDto> afectadosEdadSexoDtoList = new ArrayList<AfectadosEdadSexoDto>();
		Integer totalInsert = 0;
		mapperCsv.setCounter(0);	
		
		try {
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "UTF-8"));

			afectadosEdadSexoDtoList = br.lines().skip(1).map(mapperCsv.mapAfectadosEdadSexo).collect(Collectors.toList());
			br.close();


			if (!afectadosEdadSexoDtoList.isEmpty()) {
				jdbcAfectadosEdadSexoRepository.delelteAll();
				jdbcAfectadosEdadSexoRepository.batchInsert(afectadosEdadSexoDtoList);
			}

			
			totalInsert = afectadosEdadSexoDtoList.size();
			
			if (totalInsert <= 0) {
				logger.severe("ERROR - loadAfectadosEdadSexo: 0 registros importados");
				throw new LoadDataServiceException("ERROR - loadAfectadosEdadSexo: 0 registros importados");
			}

		} catch (Exception e) {
			logger.severe("ERROR - loadAfectadosEdadSexo: " + e.getMessage());
			throw new LoadDataServiceException("ERROR - loadAfectadosEdadSexo: " + e.getMessage());
		}

		return "ok. Total Insertados: " + totalInsert.toString();

	}
	
	
}
