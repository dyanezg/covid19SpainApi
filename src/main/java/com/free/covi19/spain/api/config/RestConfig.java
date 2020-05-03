package com.free.covi19.spain.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.free.covi19.spain.api.model.ComunidadAutonoma;
import com.free.covi19.spain.api.model.ModeloAcumulativo;
import com.free.covi19.spain.api.model.TestRealizados;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration) {
            	    	
    	HttpMethod httpMethodArray[] = new HttpMethod[]{HttpMethod.PATCH,HttpMethod.DELETE,HttpMethod.POST,HttpMethod.PUT,HttpMethod.OPTIONS,HttpMethod.TRACE};    	    	    	         	       	
        ExposureConfiguration config = repositoryRestConfiguration.getExposureConfiguration();
        config.forDomainType(ComunidadAutonoma.class).withItemExposure((metadata, httpMethods) -> httpMethods.disable(httpMethodArray));
        config.forDomainType(ModeloAcumulativo.class).withItemExposure((metadata, httpMethods) -> httpMethods.disable(httpMethodArray));
        config.forDomainType(TestRealizados.class).withItemExposure((metadata, httpMethods) -> httpMethods.disable(httpMethodArray));
    }
}