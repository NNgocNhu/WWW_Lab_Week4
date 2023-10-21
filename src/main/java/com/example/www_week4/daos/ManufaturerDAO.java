package com.example.www_week4.daos;
import com.example.www_week4.entities.Manufacturer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
@Component
public class ManufaturerDAO extends AbstracDAO<Manufacturer,Long> {


    public ManufaturerDAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void insert(Manufacturer entity) {
        String sql = "insert into manufacturer value(?,?,?)";
        jdbcTemplate.update(sql,entity.getId(), entity.getName(),entity.getEmail());
    }

    @Override
    public Manufacturer findById(Long id) {
        String sql = "select * from manufacturer where id=?";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(Manufacturer.class),
                id);
    }

    @Override
    public List<Manufacturer> findAll() {
        String sql = "select * from manufacturer";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Manufacturer.class));
    }
}
