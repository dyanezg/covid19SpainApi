package com.free.covi19.spain.api.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.free.covi19.spain.api.dto.ModeloAcumulativoDto;
import com.free.covi19.spain.api.dto.TestRealizadoDto;
import com.free.covi19.spain.api.email.EmailService;
import com.free.covi19.spain.api.exception.LoadDataServiceException;
import com.free.covi19.spain.api.repositoriesJdbc.JdbcModeloAcumulativoRepository;
import com.free.covi19.spain.api.repositoriesJdbc.JdbcTestRealizadosRepository;
import com.free.covi19.spain.api.util.ComunidadAutonomaEnum;


@Service
public class LodaDataServiceImpl implements LoadDataService {

	Logger logger = Logger.getLogger("class LodaDataService");	
	
	@Autowired
	JdbcModeloAcumulativoRepository jdbcModeloAcumulativoRepository;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	JdbcTestRealizadosRepository jdbcTestRealizadosRepository;
	
	
	static int counter=0;
		

	@Transactional(rollbackOn = { Exception.class })
	public String loadModeloAcumulativo(String url) throws Exception {

		List<ModeloAcumulativoDto> modeloAcumulativoDtoList = new ArrayList<ModeloAcumulativoDto>();
		counter=0;
		
		try {
								
			BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "UTF-8"));

			modeloAcumulativoDtoList = br.lines().skip(1).map(mapModeloAcumulativoDto).collect(Collectors.toList());
			br.close();


			modeloAcumulativoDtoList.removeIf(o -> o.getCcaa() == null);						
			
			jdbcModeloAcumulativoRepository.delelteAll();
						
			jdbcModeloAcumulativoRepository.batchInsert(modeloAcumulativoDtoList);

		} catch (Exception e) {
			logger.severe("ERROR - loadModeloAcumulativo: " + e.getMessage());
			throw new LoadDataServiceException(e.getMessage());
		}

		return "ok";

	}
	
		

	@Transactional(rollbackOn = { Exception.class })
	public String loadTestCovid(String url) throws Exception {

		List<TestRealizadoDto> testRealizadoDtoList = new ArrayList<TestRealizadoDto>();		
		counter=0;
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "UTF-8"));

			testRealizadoDtoList = br.lines().skip(1).map(mapTestRealizadoDto).collect(Collectors.toList());
			br.close();

			testRealizadoDtoList.removeIf(o -> o.getCcaa() == null);						
			
			jdbcTestRealizadosRepository.delelteAll();
														
			jdbcTestRealizadosRepository.batchInsert(testRealizadoDtoList);

		} catch (Exception e) {
			logger.severe("ERROR - loadTestCovid: " + e.getMessage());
			throw new LoadDataServiceException(e.getMessage());
		}

		return "ok";
	}
	

	private Function<String, ModeloAcumulativoDto> mapModeloAcumulativoDto = (line) -> {
		String[] p = line.split("\\,", -1);
		
		ModeloAcumulativoDto modeloAcumulativoDto = new ModeloAcumulativoDto();

		if (p[0].trim().length() == 2) {

			try {

				modeloAcumulativoDto.setId(counter++);
				modeloAcumulativoDto.setCcaa(p[0]);
				modeloAcumulativoDto.setFecha(p[1]);

				if (p[2] != null && p[2].trim().length() > 0) {
					modeloAcumulativoDto.setCasos(Integer.parseInt(p[2]));
				} else {
					modeloAcumulativoDto.setCasos(0);
				}

				if (p[3] != null && p[3].trim().length() > 0) {
					modeloAcumulativoDto.setHospitalizados(Integer.parseInt(p[3]));
				} else {
					modeloAcumulativoDto.setHospitalizados(0);
				}

				if (p[4] != null && p[4].trim().length() > 0) {
					modeloAcumulativoDto.setUci(Integer.parseInt(p[4]));
				} else {
					modeloAcumulativoDto.setUci(0);
				}

				if (p[5] != null && p[5].trim().length() > 0) {
					modeloAcumulativoDto.setFallecidos(Integer.parseInt(p[5]));
				} else {
					modeloAcumulativoDto.setFallecidos(0);
				}

				if (p[6] != null && p[6].trim().length() > 0) {
					modeloAcumulativoDto.setRecuperados(Integer.parseInt(p[6]));
				} else {
					modeloAcumulativoDto.setRecuperados(0);
				}

			} catch (Exception e) {
				logger.severe("Error al parsear modeloAcumulativoDto: " + modeloAcumulativoDto.toString());
				emailService.senderEmial("Error al parsear el csv, linea: " + modeloAcumulativoDto.toString());
			}

		}

		return modeloAcumulativoDto;
	};
	
	
	private  Function<String, TestRealizadoDto> mapTestRealizadoDto = (line) -> {
		String[] p = line.split("\\,", -1);
		
		TestRealizadoDto testRealizadoDto = new TestRealizadoDto();
		
		try {

			testRealizadoDto.setId(counter++);
			testRealizadoDto.setFecha(p[0]);
			testRealizadoDto.setCcaa( ComunidadAutonomaEnum.fromCodIni(p[1]).getCcaa());
			testRealizadoDto.setPcr(Integer.parseInt(p[3]));
			testRealizadoDto.setTestAnticuerpos(Integer.parseInt(p[5]));			
			testRealizadoDto.setTotalPruebas(Integer.parseInt(p[7]));			
															
		} catch (Exception e) {
			logger.severe("Error al parsear testRealizadoDto: " + testRealizadoDto.toString());
			emailService.senderEmial("Error al parsear el csv, linea: " + testRealizadoDto.toString());
		}
			
		
		return testRealizadoDto;
	};

	
}
