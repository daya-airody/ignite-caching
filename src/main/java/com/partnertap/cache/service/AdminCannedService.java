package com.partnertap.cache.service;

import com.partnertap.cache.model.ReportsRepDetails;
import com.partnertap.cache.model.api.ReportsRepDetailsInterface;
import com.partnertap.cache.persistence.repository.AdminCannedRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import javax.cache.CacheManager;
import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CacheResult;

@Service
public class AdminCannedService {

	private static final Logger logger = LoggerFactory.getLogger(AdminCannedService.class);

	
	@Autowired
	private CacheManager cacheManager;
	
    @Autowired
    private AdminCannedRepository adminReportRepository;
   

	@CacheResult(cacheName = "cannedReports")
	public List<ReportsRepDetails> getAllReps(@CacheKey String managerId) {
        
        try {
            Thread.sleep(5*1000);
        } catch (Exception err) {
            
        }
		
		List<ReportsRepDetails> res = new ArrayList<ReportsRepDetails>(2);
		res.add(new ReportsRepDetails("daya airody", "daya@partnertap.com"));
		res.add(new ReportsRepDetails("vara allamaraju", "vara@partnertap.com"));

		return res;
	}	
    
    @CacheResult(cacheName = "testReports")
    public List<ReportsRepDetailsInterface> getAllRepsFromDB(@CacheKey String managerId) {

        List<ReportsRepDetailsInterface> tmp = adminReportRepository.findAllReps();
        

        return tmp;
    }	
}
