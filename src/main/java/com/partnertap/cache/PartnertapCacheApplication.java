package com.partnertap.cache;

import com.partnertap.cache.service.ServiceConfig;
import com.partnertap.cache.config.PartnertapCacheConfig;

import java.text.SimpleDateFormat;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.TimeZone;

@SpringBootApplication
@ComponentScan(basePackages = {"com.partnertap.rest.controller"})
@Import({ServiceConfig.class, PartnertapCacheConfig.class})
public class PartnertapCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartnertapCacheApplication.class, args);
	}

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		//    builder.serializationInclusion(JsonInclude.Include.NON_NULL);
		builder.modules(new JodaModule());
		builder.failOnUnknownProperties(false);
		builder.timeZone(TimeZone.getDefault());
		builder.failOnUnknownProperties(false);
		return builder;
	}	
}
