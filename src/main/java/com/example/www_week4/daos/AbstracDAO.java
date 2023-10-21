package com.example.www_week4.daos;

import com.example.www_week4.entities.Manufacturer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
@Component
public abstract class AbstracDAO<T,ID> {
    private final DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;

    public AbstracDAO(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public  abstract void insert(T entity);


    public abstract T findById(ID id);
    public abstract List<T> findAll();

    public abstract void insert(Manufacturer ngocNhu);
}
