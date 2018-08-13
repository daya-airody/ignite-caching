package com.partnertap.cache.persistence;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = {"com.partnertap.cache.persistence"})
@EntityScan("com.partnertap.cache.persistence")
@EnableJpaRepositories(basePackages = {"com.partnertap.cache.persistence.repository"})
@EnableAutoConfiguration
@Component
public class PersistenceConfig {

}