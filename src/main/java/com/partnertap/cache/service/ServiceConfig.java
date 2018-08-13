package com.partnertap.cache.service;

import com.partnertap.cache.config.PartnertapCacheConfig;
import com.partnertap.cache.persistence.PersistenceConfig;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;



@Configuration
@ComponentScan(basePackages = {"com.partnertap.cache.service"})
@Import({PartnertapCacheConfig.class, PersistenceConfig.class})
@EnableAutoConfiguration
@EnableAsync
@EnableScheduling
public class ServiceConfig {

}
