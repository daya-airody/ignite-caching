package com.partnertap.cache.config;

import java.net.URL;
import java.util.List;

import javax.cache.Caching;
import javax.cache.configuration.Configuration;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.CacheWriteSynchronizationMode;
import org.apache.ignite.cache.spring.SpringCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.partnertap.cache.model.ReportsRepDetails;


@EnableCaching
@ComponentScan(basePackages = {"com.partnertap.cache"})
public class PartnertapCacheConfig {
    private static final Logger logger = LoggerFactory.getLogger(PartnertapCacheConfig.class);

/*    
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("cannedReports")));
        return cacheManager;
    }
 */
    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            Configuration<Object, Object> cacheConfiguration = createCacheConfiguration();
            
            if (cm.getCache("users") == null) 
                cm.createCache("users", cacheConfiguration);
            if (cm.getCache("cannedReports") == null)
                cm.createCache("cannedReports", createCustomCacheConfiguration());
            if (cm.getCache("testReports") == null)
                cm.createCache("testReports", cacheConfiguration);            
        };
    }    
    
    private Configuration<Object, Object> createCacheConfiguration() {
        return new CacheConfiguration<Object,Object>()
                .setCacheMode(CacheMode.PARTITIONED)
                .setAtomicityMode(CacheAtomicityMode.ATOMIC)
                .setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    }
      
    private Configuration<String, List<ReportsRepDetails>> createCustomCacheConfiguration() {
        return new CacheConfiguration<String,List<ReportsRepDetails>>()
                .setCacheMode(CacheMode.PARTITIONED)
                .setAtomicityMode(CacheAtomicityMode.ATOMIC)
                .setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    }    
    
}
