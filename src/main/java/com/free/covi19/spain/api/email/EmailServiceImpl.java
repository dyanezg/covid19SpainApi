package com.free.covi19.spain.api.email;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

	Logger logger = Logger.getLogger("class SenderEmail");

	@Autowired
	private JavaMailSender javaMailSender;

	@Async
	public void senderEmial(String text){
				
		   try {
	            SimpleMailMessage message = new SimpleMailMessage();
	            message.setFrom("david.yanez.garcia@freeapicovid19.ga");
	            message.setTo("david.yanez.garcia@freeapicovid19.ga");
	            message.setSubject("MENSAJE API COVID19");
	            message.setText(text);

	            javaMailSender.send(message);
	        } catch (MailException exception) {
	        	logger.severe("ERROR al enviar email"+  exception.getMessage());
	        }

		   logger.info("Emial enviado correctamente");
		   
	}

}
