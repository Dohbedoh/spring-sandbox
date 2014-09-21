package com.burdaall.sandbox.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Basic Consumer POJO.
 * 
 * @author Allan BURDAJEWICZ <allan.burdajewicz@gmail.com>
 */
public class Consumer implements Serializable {

    private int id;
    private String name;
    private String description;
    private Date lastUpdDate;
    
    public Consumer() {
    }
    
    public Consumer(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public Consumer(int id, String name, String description, Date lastUpdDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lastUpdDate = lastUpdDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getLastUpdDate() {
        return lastUpdDate == null ? null : new Date(lastUpdDate.getTime());
    }
    
}
