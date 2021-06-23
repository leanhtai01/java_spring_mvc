// File: DataConfig.java
// Data configuration
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class DataConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        
        ds.setDriverClassName("org.mariadb.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/sales_mngt_db");
        ds.setUsername("admin");
        ds.setPassword("123");
        
        return ds;
    }
    
    @Bean
    public JdbcTemplate jdbcOperations(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    @Bean
    @RequestScope // one instance for each request (stored proc/function call)
    public SimpleJdbcCall simpleJdbcCall(JdbcOperations jdbcOperations) {
        return new SimpleJdbcCall(jdbcOperations(dataSource()));
    }
}
