package com.partnertap.cache.model.api;

import java.io.Serializable;

//@JsonIgnoreProperties(ignoreUnknown = true)
//@AutoProperty
public interface ReportsRepDetailsInterface extends Serializable {

    public String    getRepName();
    public String    getEmailAddress();

}
