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
import com.free.covi19.spain.api.email.EmailService;
import com.free.covi19.spain.api.exception.LoadDataServiceException;
import com.free.covi19.spain.api.repositoriesJdbc.JdbcModeloAcumulativoHistoricoRepository;
import com.free.covi19.spain.api.repositoriesJdbc.JdbcModeloAcumulativoRepository;

@Service
public class LodaDataServiceImpl implements LoadDataService {

	Logger logger = Logger.getLogger("class LodaDataService");
	
	private static int modeloAcumulativoIdCounter = 0;

	@Autowired
	EmailService emailService;
	
	@Autowired
	JdbcModeloAcumulativoRepository jdbcModeloAcumulativoRepository;		

	@Transactional(rollbackOn = { Exception.class })
	public String loadModeloAcumulativo(String url) throws Exception {

		List<ModeloAcumulativoDto> modeloAcumulativoDtoList = new ArrayList<ModeloAcumulativoDto>();

		try {
					

			BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "UTF-8"));
			// skip the header of the csv
			modeloAcumulativoDtoList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			br.close();

			//Remove null values
			modeloAcumulativoDtoList.removeIf(o -> o.getCcaa() == null);
						
			modeloAcumulativoIdCounter=0;
			
			jdbcModeloAcumulativoRepository.delelteAll();
						
			jdbcModeloAcumulativoRepository.batchInsert(modeloAcumulativoDtoList);

		} catch (Exception e) {
			logger.severe("ERROR - loadModeloAcumulativo: " + e.getMessage());
			throw new LoadDataServiceException(e.getMessage());
		}

		return "ok";

	}

	private Function<String, ModeloAcumulativoDto> mapToItem = (line) -> {
		String[] p = line.split("\\,", -1);// a CSV has comma separated lines

		ModeloAcumulativoDto modeloAcumulativoDto = new ModeloAcumulativoDto();

		if (p[0].trim().length() == 2) {

		
			try {				
			
				modeloAcumulativoDto.setId(modeloAcumulativoIdCounter++);
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
			
			} catch (ArrayIndexOutOfBoundsException e) {
				logger.severe("Error al parsear modeloAcumulativoDto: " + modeloAcumulativoDto.toString());
				emailService.senderEmial("Error al parsear del csv, linea: " + modeloAcumulativoDto.toString());
			}
			
		}	
		
		return modeloAcumulativoDto;
	};

}
