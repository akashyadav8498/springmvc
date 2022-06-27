package com.springmvc.controller;

import java.util.List;

public interface UserDao {
    public List<User> getUserData();
    public void insertUserData(String name, String email, int phone, String username, String
            password);


}
