package com.SEII.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import javax.validation.Valid;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.SEII.models.LogDetailsRequestModel;
import com.SEII.models.LogRestResponseModel;

//Link Postman https://www.getpostman.com/collections/e09ba8c350ed5cf225db
@RestController
class ELKController {
	private static final Logger LOG = Logger.getLogger(ELKController.class.getName());

	@Autowired
	RestTemplate restTemplete;

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/elk")
	public String helloWorld() {
		String response = "Welcome to JavaInUse" + new Date();
		LOG.log(Level.INFO, response);
		return response;
	}
	
	@PostMapping(path="/info",consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
	 			,produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<LogRestResponseModel> info(@Valid @RequestBody LogDetailsRequestModel logDetails) {
		LogRestResponseModel response=new LogRestResponseModel();
		HttpStatus code=null;
		
		try {
			LOG.log(Level.INFO, "App: "+logDetails.getNombreAplicacion()+" Mensaje: "+ logDetails.getMensaje());
			response.setCodigo(200);
			response.setDescripcion("Log agregado correctamente");
			code=HttpStatus.OK;
		}catch(RuntimeException e) {
			LOG.log(Level.ERROR, "App: "+logDetails.getNombreAplicacion()+" No pudo escribir en log error: "+e.getMessage());
			response.setCodigo(500);
			response.setDescripcion("Log generado con errores correctamente");
			code=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<LogRestResponseModel>(response,code) ;
		
	}
	

	@RequestMapping(value = "/exception")
	public String exception() {
		String response = "";
		try {
			throw new Exception("Exception has occured....");
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String stackTrace = sw.toString();
			LOG.error("Exception - " + stackTrace);
			response = stackTrace;
		}

		return response;
	}
}