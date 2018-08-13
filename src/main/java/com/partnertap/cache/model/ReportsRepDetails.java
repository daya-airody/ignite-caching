package com.partnertap.cache.model;

import java.io.Serializable;

public class ReportsRepDetails implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = -5270538604207217095L;
    private String repName;
	private String emailAddress;

	public ReportsRepDetails(String repName, String emailAddress){
		this.repName = repName;
		this.emailAddress = emailAddress;
	}

    public String    getRepName() {
    	return repName;
    }
    public String    getEmailAddress() {
    	return emailAddress;
    }
}
