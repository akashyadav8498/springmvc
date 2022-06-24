package com.springmvc.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class UserDaoImpl implements UserDao {

   private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<User> getUserData() {


        return jdbcTemplate.query("select * from user",new RowMapperImpl());
    }

    public void insertUserData(String name, String email, int phone, String username, String
            password) {

        jdbcTemplate.update("insert into user (name, email, phone, username, password) values(?,?,?,?,?)", name, email, phone, username, password);
    }
}
