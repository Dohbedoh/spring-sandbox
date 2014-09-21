package com.burdaall.sandbox.dao;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Abstract JDBC Dao.
 * 
 * @author Allan BURDAJEWICZ <allan.burdajewicz@gmail.com>
 */
public abstract class JdbcDAO {
    
    private DataSource dataSource;
    private NamedParameterJdbcTemplate npJdbcTemplate;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.npJdbcTemplate  = new NamedParameterJdbcTemplate(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return npJdbcTemplate;
    }
}
