package com.springmvc.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {

        return "index";

    }

    @RequestMapping("/submit")
    public String home(@RequestParam("action") String action) {

        if ("login".equals(action)) {
            return "login";
        } else {
            return "sign_up";
        }

    }


    @RequestMapping("/signup")
    public String signup(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") int phone,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("action") String action,
            Model m) {

        if ("Signup".equals(action)) {
            ApplicationContext context = new ClassPathXmlApplicationContext("dbconfig.xml");
            UserDao userDao = context.getBean("userDao", UserDao.class);

            userDao.insertUserData(name, email, phone, username, password);

        }
        return "demo";

    }

    @RequestMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("action") String action,
            Model m) {

        if ("Login".equals(action)) {

            m.addAttribute("username", username);
            m.addAttribute("password", password);

        }


        return "message";
    }



}
