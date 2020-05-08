package com.free.covi19.spain.api.config;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.free.covi19.spain.api.email.EmailService;
import com.free.covi19.spain.api.service.LoadDataService;

@Component
public class SchedulerLoadData {

	Logger logger = Logger.getLogger("class SchedulerLoadData");

	@Value("${url.acumulativo}")
	private String urlAcumulativo;

	@Value("${url.test.realizados}")
	private String urlTestRealizados;

	@Autowired
	EmailService emailService;

	@Autowired
	LoadDataService lodaDataService;

	//@Scheduled(cron = "0 0 */8 * * *", zone = "Europe/Madrid")
	public void loadScheduleModeloAcumulativo() throws Exception {

		try {
			logger.info("INICIO - loadScheduleModeloAcumulativo");
			lodaDataService.loadModeloAcumulativo(urlAcumulativo);
			emailService.senderEmial("MODELO ACUMULATIVO IMPORTACION AUTOMATICA OK");
			logger.info("FIN - loadScheduleModeloAcumulativo");
		} catch (Exception e) {
			emailService.senderEmial(e.getMessage());
		}

	}

	//@Scheduled(cron = "0 0 */7 * * *", zone = "Europe/Madrid")
	public void loadScheduleTestRealizados() throws Exception {

		try {
			logger.info("INICIO - loadScheduleTestRealizados");
			lodaDataService.loadTestCovid(urlTestRealizados);
			emailService.senderEmial("TEST REALIZADOS IMPORTACION AUTOMATICA OK");
			logger.info("FIN - loadScheduleTestRealizados");
		} catch (Exception e) {
			emailService.senderEmial(e.getMessage());
		}

	}

}
