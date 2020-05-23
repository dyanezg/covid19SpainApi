package com.free.covi19.spain.api.util;
import java.util.Arrays;
import java.util.function.Function;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.free.covi19.spain.api.dto.AfectadosEdadSexoDto;
import com.free.covi19.spain.api.dto.CcaaMascarillasDto;
import com.free.covi19.spain.api.dto.ModeloAcumulativoDto;
import com.free.covi19.spain.api.dto.TestRealizadoDto;
import com.free.covi19.spain.api.email.EmailService;

@Component
public class MapperCsv {

	
	Logger logger = Logger.getLogger("class MapperCsv");	
	
		
	@Autowired
	EmailService emailService;	
	
	private int counter;
	
				

	public Function<String, ModeloAcumulativoDto> mapModeloAcumulativoDto = (line) -> {
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

				if (p[5] != null && p[5].trim().length() > 0) {
					modeloAcumulativoDto.setHospitalizados(Integer.parseInt(p[5]));
				} else {
					modeloAcumulativoDto.setHospitalizados(0);
				}

				if (p[6] != null && p[6].trim().length() > 0) {
					modeloAcumulativoDto.setUci(Integer.parseInt(p[6]));
				} else {
					modeloAcumulativoDto.setUci(0);
				}

				if (p[7] != null && p[7].trim().length() > 0) {
					modeloAcumulativoDto.setFallecidos(Integer.parseInt(p[7]));
				} else {
					modeloAcumulativoDto.setFallecidos(0);
				}
				


			} catch (Exception e) {
				logger.severe("Error al parsear modeloAcumulativoDto: " + Arrays.toString(p));
				emailService.senderEmial("Error al parsear el csv, linea: " + Arrays.toString(p));
				throw e;
			}

		}

		return modeloAcumulativoDto;
	};
	

		
	public  Function<String, TestRealizadoDto> mapTestRealizadoDto = (line) -> {
		//Regex 222,22,333,"24,2",34343
		String[] p = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
		
		TestRealizadoDto testRealizadoDto = new TestRealizadoDto();
		
		try {

			testRealizadoDto.setId(counter++);
			testRealizadoDto.setFecha(p[0]);						
			testRealizadoDto.setCcaa( ComunidadAutonomaEnum.fromCodIni(p[1]).getCcaa());
			
			if (p[3] != null && p[3].trim().length() > 0) {
				testRealizadoDto.setPcr(Integer.parseInt(p[3].replace(".", "")));
			} else {
				testRealizadoDto.setPcr(0);
			}
			
			if (p[5] != null && p[5].trim().length() > 0) {
				testRealizadoDto.setTestAnticuerpos(Integer.parseInt(p[5].replace(".", "")));
			} else {
				testRealizadoDto.setTestAnticuerpos(0);
			}

			if (p[7] != null && p[7].trim().length() > 0) {
				testRealizadoDto.setTotalPruebas(Integer.parseInt(p[7].replace(".", "")));
			} else {
				testRealizadoDto.setTotalPruebas(0);
			}															
						
															
		} catch (Exception e) {
			logger.severe("Error al parsear testRealizadoDto: " + Arrays.toString(p));
			emailService.senderEmial("Error al parsear el csv, linea: " + Arrays.toString(p));
			throw e;
		}
			
		
		return testRealizadoDto;
	};

	
	public  Function<String, CcaaMascarillasDto> mapCcaaMascarillas = (line) -> {
		String[] p = line.split("\\,", -1);
		
		CcaaMascarillasDto ccaaMascarillasDto = new CcaaMascarillasDto();
		
		try {

			if (!"".equals(p[1].trim())) {
				
				ccaaMascarillasDto.setId(counter++);
				ccaaMascarillasDto.setFecha(p[0]);
				ccaaMascarillasDto.setCcaa( ComunidadAutonomaEnum.fromCodIni(p[1]).getCcaa());
				ccaaMascarillasDto.setAcumulado(Integer.parseInt(p[3]));
			}
															
		} catch (Exception e) {
			logger.severe("Error al parsear ccaaMascarillasDto: " + Arrays.toString(p));
			emailService.senderEmial("Error al parsear el csv, linea: " + Arrays.toString(p));
			throw e;
		}
			
		
		return ccaaMascarillasDto;
	};
	
	
	public  Function<String, AfectadosEdadSexoDto> mapAfectadosEdadSexo = (line) -> {
		String[] p = line.split("\\,", -1);
		
		AfectadosEdadSexoDto afectadosEdadSexoDto = new AfectadosEdadSexoDto();
		
		try {

			afectadosEdadSexoDto.setId(counter++);
			afectadosEdadSexoDto.setFecha(p[0]);
			afectadosEdadSexoDto.setRangoDeEdad(RangoEdadEnum.fromCod(p[1].trim()).getCodBbdd());
			afectadosEdadSexoDto.setSexo(SexoEnum.fromCod(p[2].trim().toLowerCase()).getCodBddd());
			afectadosEdadSexoDto.setCasosConfirmados(Integer.parseInt(p[3]));			
			afectadosEdadSexoDto.setHospitalizados(Integer.parseInt(p[4]));		
			afectadosEdadSexoDto.setIngresosUci(Integer.parseInt(p[5]));			
			afectadosEdadSexoDto.setFallecidos(Integer.parseInt(p[6]));

															
		} catch (Exception e) {
			logger.severe("Error al parsear afectadosEdadSexoDto: " + Arrays.toString(p));
			emailService.senderEmial("Error al parsear el csv, linea: " + Arrays.toString(p));
			throw e;
		}
			
		
		return afectadosEdadSexoDto;
	};
	
	

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
	
	
}
