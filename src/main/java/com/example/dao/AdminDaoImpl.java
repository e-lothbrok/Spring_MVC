package com.example.dao;


import com.example.pojo.Admin;
import com.example.pojo.AdminRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;


@Component("adminDao")
public class AdminDaoImpl implements AdminDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Admin admin) {
        BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);

        return jdbcTemplate.update("insert into admin (nombre, cargo, fechaCreacion) " +
                "values (:nombre, :cargo, :fechaCreacion)", paramMap) == 1;
    }

    @Override
    public List<Admin> findAll() {

        return jdbcTemplate.query("select * from admin", new AdminRowMapper());
    }

    @Override
    public Admin findById(int id) {
        return jdbcTemplate.queryForObject("select * from admin where id = :id",
                new MapSqlParameterSource("id", id), new AdminRowMapper());
    }

    @Override
    public List<Admin> findByName(String nombre) {
        return jdbcTemplate.query("select * from admin where nombre like :nombre",
                new MapSqlParameterSource("nombre", "%" + nombre + "%"), new AdminRowMapper());
    }

    @Override
    public boolean update(Admin admin) {
        return jdbcTemplate.update("update admin set nombre=:nombre, cargo=:cargo, fechaCreacion=:fechaCreacion where id=:id",
                new BeanPropertySqlParameterSource(admin)) == 1;
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update("delete from admin where id=:id",
                new MapSqlParameterSource("id",id)) == 1;
    }

    @Transactional
    @Override
    public int[] saveAll(List<Admin> adminList) {
        SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(adminList.toArray());

        return jdbcTemplate.batchUpdate("insert into admin (nombre, cargo, fechaCreacion) values (:nombre, :cargo, :fechaCreacion)",
                batchArgs);
    }
}
