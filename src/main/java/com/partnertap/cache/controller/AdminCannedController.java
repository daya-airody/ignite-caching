package com.partnertap.cache.controller;

import com.partnertap.cache.service.AdminCannedService;
import com.partnertap.cache.model.ReportsRepDetails;
import com.partnertap.cache.model.api.ReportsRepDetailsInterface;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/canned", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminCannedController {

	private final static Logger logger = LoggerFactory.getLogger(AdminCannedController.class);

	@Autowired
	private AdminCannedService reportsService;
    
	@RequestMapping(value = "/samplerepslist", method = RequestMethod.GET)
	public List<ReportsRepDetails> getSampleReps(
			@RequestParam(value = "managerId") String managerId ) {
		logger.info("Retrieving All Reps for  managerId {}",
					managerId);

		long startTime = System.currentTimeMillis();
		List<ReportsRepDetails> allReps = reportsService.getAllReps(managerId);
        long endTime = System.currentTimeMillis();
        logger.info("getAllReps: time taken {}", (endTime - startTime));        
        
        for (ReportsRepDetails repDetail : allReps) {
            logger.info("email-> {}", repDetail.getEmailAddress());
        }
        
		return Optional.ofNullable(allReps).orElseThrow(ResourceNotFoundException::new);
	}
	
    @RequestMapping(value = "/allrepslist", method = RequestMethod.GET)
    public List<ReportsRepDetailsInterface> getAllReps(
            @RequestParam(value = "managerId") String managerId ) {
        logger.info("Retrieving All Reps for  managerId {}",
                    managerId);

        long startTime = System.currentTimeMillis();
        List<ReportsRepDetailsInterface> allReps = reportsService.getAllRepsFromDB(managerId);
        long endTime = System.currentTimeMillis();
        logger.info("getAllReps: time taken {}", (endTime - startTime));   
       
        
        for (ReportsRepDetailsInterface repDetail : allReps) {
            logger.info("email-> {}", repDetail.getEmailAddress());
        }
        
        return Optional.ofNullable(allReps).orElseThrow(ResourceNotFoundException::new);
    }	
}
