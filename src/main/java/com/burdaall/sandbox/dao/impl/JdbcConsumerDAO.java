package com.burdaall.sandbox.dao.impl;

import com.burdaall.sandbox.dao.ConsumerDAO;
import com.burdaall.sandbox.dao.JdbcDAO;
import com.burdaall.sandbox.model.Consumer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

/**
 * Basic Consumer Data Object.
 * 
 * @author Allan BURDAJEWICZ <allan.burdajewicz@gmail.com>
 */
public class JdbcConsumerDAO extends JdbcDAO implements ConsumerDAO {

    @Override
    public int insert(Consumer consumer) {
        
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("consumer_name", consumer.getName());
        paramSource.addValue("consumer_desc", consumer.getDescription());
        
        String sqlQuery = ""
                + "INSRET INTO consumer"
                + "(consumer_id"
                + ", consumer_name"
                + ", consumer_desc"
                + ", last_upd_date) "
                + "VALUES ("
                + "SELECT nextVal FROM consumer_seq"
                + ", :consumer_name"
                + ", :consumer_desc"
                + ", sysdate"
                + ")";
        getNamedParameterJdbcTemplate().update(sqlQuery, paramSource);
               
        sqlQuery = "SELECT currVal FROM consumer_seq";
        return getNamedParameterJdbcTemplate().queryForInt(sqlQuery, 
                new MapSqlParameterSource());
    }

    @Override
    public void deleteById(int consumerId) {
        
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("consumer_id", consumerId, Types.NUMERIC);
        
        String sqlQuery = 
                "DELETE FROM consumer WHERE consumer_id = :consumer_id";
        getNamedParameterJdbcTemplate().update(sqlQuery, paramSource);
    }

    @Override
    public Consumer getById(int consumerId) {
        
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("consumer_id", consumerId, Types.NUMERIC);
        
        String sqlQuery = ""
                + "SELECT "
                + " consumer_id,"
                + " consumer_name,"
                + " consumer_description,"
                + " last_upd_date "
                + "FROM consumer "
                + "WHERE consumer_id = :consumer_id";
        return getNamedParameterJdbcTemplate().queryForObject(sqlQuery, 
                paramSource, new ConsumerRowMapper());
    }
    
    private class ConsumerRowMapper implements RowMapper<Consumer> {
        
        @Override
        public Consumer mapRow(ResultSet rs, int i) throws SQLException {
            return new Consumer(
                    rs.getInt("consumer_id"),
                    rs.getString("consumer_name"),
                    rs.getString("consumer_description"),
                    rs.getTimestamp("last_upd_date"));
        }
    }
}
