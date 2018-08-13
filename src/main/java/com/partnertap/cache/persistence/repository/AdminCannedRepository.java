package com.partnertap.cache.persistence.repository;

import com.partnertap.cache.model.api.ReportsRepDetailsInterface;
import com.partnertap.cache.persistence.entity.Profile;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminCannedRepository extends JpaRepository<Profile, String> {

	@Query(value = "select concat(first_name,' ',last_name) as repName, email_address as emailAddress \n" + 
	        "from test_profile  \n" + 
	        "order by repName",		   
		   nativeQuery = true)
	List<ReportsRepDetailsInterface> findAllReps();
	
}
