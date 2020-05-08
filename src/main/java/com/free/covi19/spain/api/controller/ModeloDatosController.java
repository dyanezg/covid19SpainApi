package com.free.covi19.spain.api.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.free.covi19.spain.api.email.EmailService;
import com.free.covi19.spain.api.service.LoadDataService;

@RestController
@RequestMapping("/api/modeloDatos")
public class ModeloDatosController {

	Logger logger = Logger.getLogger("class ModeloDatosController");

	@Autowired
	LoadDataService lodaDataService;

	@Autowired
	EmailService emailService;

	@Value("${url.acumulativo}")
	private String urlAcumulativo;

	@Value("${url.test.realizados}")
	private String urlTestRealizados;

	@GetMapping("/modeloAcumulativo")
	public String loadModeloAcumulativo() {
		try {			
			String returnValue =  lodaDataService.loadModeloAcumulativo(urlAcumulativo);
			emailService.senderEmial("MODELO ACUMULATIVO IMPORTACION CRON OK");
			return returnValue; 
		} catch (Exception e) {
			emailService.senderEmial(e.getMessage());
			return "ko";
		}
	}

	@GetMapping("/testRealizados")
	public String loadTestRealizados() {
		try {
			String returnValue = lodaDataService.loadTestCovid(urlTestRealizados); 			
			emailService.senderEmial("TEST REALIZADOS IMPORTACION CRON OK");
			return returnValue; 
		} catch (Exception e) {
			emailService.senderEmial(e.getMessage());
			return "ko";
		}
	}


}
