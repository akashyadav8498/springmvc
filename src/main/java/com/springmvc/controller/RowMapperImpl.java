package com.springmvc.controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class RowMapperImpl implements RowMapper<User> {
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User user = new User();

        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        user.setPhone(resultSet.getString("phone"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));

        return user;
    }
}
