package com.burdaall.sandbox.dao;

import com.burdaall.sandbox.model.Consumer;

/**
 * Basic Consumer Data Object.
 * 
 * @author Allan BURDAJEWICZ <allan.burdajewicz@gmail.com>
 */
public interface ConsumerDAO {
    
    /**
     * Insret a consumer.
     * 
     * @param consumer The consumer
     * @return The consumer inserted Id
     */
    int insert(Consumer consumer);
    
    /**
     * Delete a consumer by Id.
     * 
     * @param consumerId The consu;er id 
     */
    void deleteById(int consumerId);
    
    /**
     * Get a consumer by Id.
     * 
     * @param consumerId The consumer Id
     * @return The consumer
     */
    Consumer getById(int consumerId);
}
